/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo.Data.Logica;

import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosClase;
import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosProyecto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase LogicaEjercicio1_Contador cuenta las lineas de un proyecto
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class LogicaEjercicio1_Contador {
    public ArrayList<DataEjercicio1_DatosProyecto> conteoArchivos(String ruta){
        ArrayList<DataEjercicio1_DatosProyecto> proyectos = LogicaEjercicio1_RecorrerPrograma.obtenerProyectos(ruta);
        try {
            for(int i = 0; i < proyectos.size(); i++){
                ArrayList<DataEjercicio1_DatosClase> listaDatosClase = new ArrayList<DataEjercicio1_DatosClase>();
                Iterator iterator = proyectos.get(i).getRutaArchivosJava().entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry entry = (Map.Entry) iterator.next();
                    long numeroLineas = 0;
                    int numeroMetodos = 0;
                    FileReader fr = new FileReader((String)entry.getValue());
                    BufferedReader bf = new BufferedReader(fr);
                    String linea = bf.readLine();
                    while(linea!=null) {
                        //Numero de lineas en la clase
                        if(!linea.trim().equals(""))
                            numeroLineas++;
                        //Numero de metodos de la clase
                        if((linea.contains("public")||linea.contains("private")||linea.contains("protected"))&& linea.contains("(") && linea.contains(")") && linea.contains("{"))
                            numeroMetodos++;
                        linea = bf.readLine();
                    }
                    DataEjercicio1_DatosClase datosClase = new DataEjercicio1_DatosClase((String) entry.getKey(), numeroLineas, numeroMetodos);
                    listaDatosClase.add(datosClase);
                    proyectos.get(i).setDatosClase(listaDatosClase);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogicaEjercicio1_Contador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(LogicaEjercicio1_Contador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyectos;
    }
}
