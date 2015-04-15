package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosClase;
import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosProyecto;
import edu.uniandes.ecos.modelo.Integrador;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/*
*Clase controlador del modelo
*@author: UMBRELLA
*@version: 1.0
*/
public class ControladorWeb extends HttpServlet{

    Integrador integrador = new Integrador();
    //Si local = true entonces se apuntara al servidor local, en caso contrario apuntara a http://tspumbrella.herokuapp.com
    private static boolean local = false;
    
    /**
     * Metodo Main de la clase ControladorWeb
     * @param args: String[]
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new ControladorWeb()),"/*");
        server.start();
        server.join();
    }
    
    /**
     * Metodo doGet del servlet
     * @param req: HttpServletRequest
     * @param resp: HttpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String opcion = req.getParameter("opcion");
        if(opcion!=null && opcion.equals("1"))
            ejercicio1(req, resp);
        else if(opcion!=null && opcion.equals("2"))
            ejercicio2(resp);
        else
            paginaPrincipal(resp);
    }
    
    private String obtenerHTML(String url, HttpServletResponse resp)throws ServletException, IOException {
        String html = "";
        try{
            FileInputStream archivoHTML = new FileInputStream(url);
            DataInputStream entrada = new DataInputStream(archivoHTML);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            while ((strLinea = buffer.readLine()) != null)   {
                html += strLinea;
            }
            entrada.close();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return html;
    }
    
    private void paginaPrincipal(HttpServletResponse resp) {
        try{
            String html = obtenerHTML("src/main/java/edu/uniandes/ecos/vista/VistaBase.html", resp);
            if(local)
                html = html.replaceAll("http://tspumbrella.herokuapp.com", "http://localhost:8080");
            PrintWriter out = resp.getWriter();
            out.print(html);
            resp.getWriter().print(out);
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void paginaError(Exception e, HttpServletResponse resp) throws ServletException, IOException{
        String html = obtenerHTML("src/main/java/edu/uniandes/ecos/vista/error.html", resp);
        if(local)
                html = html.replaceAll("http://tspumbrella.herokuapp.com", "http://localhost:8080");
        html = html.replace("MesajeError", e!=null ? e.getStackTrace().toString() : "Error null pointer");
        PrintWriter out = resp.getWriter();
        out.println(html);
        resp.getWriter().print(out);
    }
    
    private void ejercicio1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ArrayList<DataEjercicio1_DatosProyecto> listaProyectos = integrador.ejercicio1();
            String html = obtenerHTML("src/main/java/edu/uniandes/ecos/vista/VistaEjercicio1.html", resp);
            if(local)
                html = html.replaceAll("http://tspumbrella.herokuapp.com", "http://localhost:8080");
            String htmlDinamico = "";
               
            for(DataEjercicio1_DatosProyecto proyecto: listaProyectos){
                int i = 0;
                htmlDinamico += "<tr align='center'>";
                htmlDinamico += "<td>"+proyecto.getNombreProyecto()+"</td>";
                for(DataEjercicio1_DatosClase datosClase: proyecto.getDatosClase()){
                    if(i>0){
                        htmlDinamico += "<tr align='center'>";
                        htmlDinamico += "<td></td>";
                    }
                    htmlDinamico += "<td>"+datosClase.getNombreClase()+"</td>";
                    htmlDinamico += "<td>"+datosClase.getNumeroLineas()+"</td>";
                    htmlDinamico += "<td>"+datosClase.getNumeroMetodos()+"</td>";
                    htmlDinamico += "</tr>";
                    i++;
                }
            }
            html = html.replace("<tr id='reemplazo'></tr>", htmlDinamico);
            
            PrintWriter out = resp.getWriter();
            out.println(html);
            resp.getWriter().print(out);
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            paginaError(e, resp);
        }
    }
    
    private void ejercicio2(HttpServletResponse resp) throws ServletException, IOException {
        try{
            String html = obtenerHTML("src/main/java/edu/uniandes/ecos/vista/VistaEjercicio2.html", resp);
            if(local)
                html = html.replaceAll("http://tspumbrella.herokuapp.com", "http://localhost:8080");
            PrintWriter out = resp.getWriter();
            out.print(html);
            resp.getWriter().print(out);
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            paginaError(e, resp);
        }
    }
    
}