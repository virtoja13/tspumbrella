/*
*Clase principal para ralizar la integral 
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.integral;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class PrincipalIntegral extends HttpServlet {
    
    /**
     * 
     * @param req: HttpServletRequest
     * @param resp: HttpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resultado(req, resp);
    }
     
    /**
     * Metodo que ordena y visualiza el resultado del programa Integral.
     * @param req: HttpServletRequest
     * @param resp: HttpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    private void resultado(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        DecimalFormat df = new DecimalFormat("#0.00000");
        PrintWriter out = resp.getWriter();
        ArrayList<Data> listaValores = new ArrayList<Data>();
        //TEST1
        HallarValores valores1 = new HallarValores();
        listaValores.add(valores1.valorConErrorAceptable(HallarValores.datos1()));
        //TEST2
        HallarValores valores2 = new HallarValores();
        listaValores.add(valores2.valorConErrorAceptable(HallarValores.datos2()));
        //TEST3
        HallarValores valores3 = new HallarValores();
        listaValores.add(valores3.valorConErrorAceptable(HallarValores.datos3()));
        
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th colspan=2>TEST</th>");
        out.println("<th>Actual Value</th>");
        out.println("</tr>");
        out.println("<tr align='center'>");
        out.println("<td>x</td>");
        out.println("<td>dof</td>");
        out.println("<td>p</td>");
        out.println("</tr>");
        int i = 1;
        for(Data dato : listaValores){
            out.println("<tr align='center'>");
            out.println("<td>0 to x="+dato.getX()+"</td>");
            out.println("<td>"+dato.getDof()+"</td>");
            out.println("<td>"+df.format(dato.getP())+"</td>");
            out.println("</tr>");
            i++;
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        resp.getWriter().print(out);
    }
     
    /**
     * Metodo Main de la clase PrincipalIntegral
     * @param args: String[]
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalIntegral()),"/*");
        server.start();
        server.join();
    }
    
}