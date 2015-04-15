package edu.uniandes.ecos.modelo.Data.Logica;

import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosProyecto;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Clase LogicaEjercicio1_RecorrerPrograma recorre todas las carpetas del programa para encontrar clases
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class LogicaEjercicio1_RecorrerPrograma {
    /**
     * obtenerProyectos
     * @param ruta:String
     * @return proyectos:ArrayList(DataEjercicio1_DatosProyecto)
     */
    public static ArrayList<DataEjercicio1_DatosProyecto> obtenerProyectos(String ruta){
        ArrayList<DataEjercicio1_DatosProyecto> proyectos = new ArrayList<DataEjercicio1_DatosProyecto>();
        File directorio = new File(ruta);
        File listaProyectos[] = directorio.listFiles();
        for(int i = 0; i<listaProyectos.length; i++){
            String nombreProyecto = listaProyectos[i].getName();
            HashMap<String,String> rutaArchivosJava = new HashMap<String,String>();
            LogicaEjercicio1_RecorrerPrograma.obtenerArchivosJava(listaProyectos[i].getPath(), rutaArchivosJava);
            DataEjercicio1_DatosProyecto datosProyecto = new DataEjercicio1_DatosProyecto(nombreProyecto, rutaArchivosJava);
            proyectos.add(datosProyecto);
        }
        return proyectos;
    }
    /**
     * obtenerArchivosJava
     * @param ruta:String
     * @param rutaArchivosJava:HashMap(String,String)
     */
    private static void obtenerArchivosJava(String ruta, HashMap<String,String> rutaArchivosJava){
        File directorio = new File(ruta);
        File listaDirectorios[] = directorio.listFiles();
        for(int i = 0; i<listaDirectorios.length; i++){
            if(listaDirectorios[i].isDirectory())
                obtenerArchivosJava(listaDirectorios[i].getAbsolutePath(), rutaArchivosJava);
            else{
                if(listaDirectorios[i].getName().contains(".java"))
                    rutaArchivosJava.put(listaDirectorios[i].getName(),listaDirectorios[i].getAbsolutePath());
            }
        }
    }
}
