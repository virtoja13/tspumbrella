/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JAVIER
 */
public class RecorrerPrograma {
    
    public static ArrayList<DatosProyecto> obtenerProyectos(String ruta){
        ArrayList<DatosProyecto> proyectos = new ArrayList<DatosProyecto>();
        File directorio = new File(ruta);
        File listaProyectos[] = directorio.listFiles();
        for(int i = 0; i<listaProyectos.length; i++){
            String nombreProyecto = listaProyectos[i].getName();
            HashMap<String,String> rutaArchivosJava = new HashMap<String,String>();
            RecorrerPrograma.obtenerArchivosJava(listaProyectos[i].getPath(), rutaArchivosJava);
            DatosProyecto datosProyecto = new DatosProyecto(nombreProyecto, rutaArchivosJava);
            proyectos.add(datosProyecto);
        }
        return proyectos;
    }
    
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
