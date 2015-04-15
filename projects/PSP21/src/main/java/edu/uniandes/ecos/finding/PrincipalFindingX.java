/*
*Clase principal para hallar X
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.finding;

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

public class PrincipalFindingX extends HttpServlet {
    
    /**
     * Metodo doGet del servlet
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
     * Metodo que ordena y visualiza el resultado del hallar la x
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
        listaValores.add(valores1.hallarX(HallarValores.datos1(), HallarValores.P1));
        //TEST2
        HallarValores valores2 = new HallarValores();
        listaValores.add(valores2.hallarX(HallarValores.datos2(), HallarValores.P2));
        //TEST3
        HallarValores valores3 = new HallarValores();
        listaValores.add(valores3.hallarX(HallarValores.datos3(), HallarValores.P3));
        
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th colspan=2>TEST</th>");
        out.println("<th>Actual Value</th>");
        out.println("</tr>");
        out.println("<tr align='center'>");
        out.println("<td>p</td>");
        out.println("<td>dof</td>");
        out.println("<td>x</td>");
        out.println("</tr>");
        int i = 1;
        for(Data dato : listaValores){
            out.println("<tr align='center'>");
            out.println("<td>"+dato.getDof()+"</td>");
            out.println("<td>"+df.format(dato.getP())+"</td>");
            out.println("<td>0 to x="+dato.getX()+"</td>");
            out.println("</tr>");
            i++;
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        resp.getWriter().print(out);
    }
     
    /**
     * Metodo Main de la clase PrincipalFindingX
     * @param args: String[]
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalFindingX()),"/*");
        server.start();
        server.join();
    }
    
}