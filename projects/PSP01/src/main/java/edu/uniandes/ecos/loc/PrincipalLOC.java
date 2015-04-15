/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author JAVIER
 */
public class PrincipalLOC extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        mostrarLineas(req, resp);
    }
    
    private void mostrarLineas(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Contador contador = new Contador();
        ArrayList<DatosProyecto> listaProyectos = contador.conteoArchivos("projects");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Nombre Proyecto</th>");
        out.println("<th>Nombre Clase</th>");
        out.println("<th>Numero Lineas</th>");
        out.println("<th>Numero Metodos</th>");
        out.println("</tr>");
        for(DatosProyecto proyecto: listaProyectos){
            int i = 0;
            out.println("<tr align='center'>");
            out.println("<td>"+proyecto.getNombreProyecto()+"</td>");
            for(DatosClase datosClase: proyecto.getDatosClase()){
                if(i>0){
                    out.println("<tr align='center'>");
                    out.println("<td></td>");
                }
                out.println("<td>"+datosClase.getNombreClase()+"</td>");
                out.println("<td>"+datosClase.getNumeroLineas()+"</td>");
                out.println("<td>"+datosClase.getNumeroMetodos()+"</td>");
                out.println("</tr>");
                i++;
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        resp.getWriter().print(out);
    }
    
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalLOC()),"/*");
        server.start();
        server.join();
    }     
}

//Error de cast con iterator si hacer next