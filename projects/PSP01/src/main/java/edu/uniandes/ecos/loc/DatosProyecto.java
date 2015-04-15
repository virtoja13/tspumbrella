/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JAVIER
 */
public class DatosProyecto {
    
    private String nombreProyecto;
    
    private HashMap<String,String> rutaArchivosJava;
    
    private ArrayList<DatosClase> datosClase;

    public DatosProyecto(String nombreProyecto, HashMap<String,String> rutaArchivosJava) {
        this.nombreProyecto = nombreProyecto;
        this.rutaArchivosJava = rutaArchivosJava;
    }

    public HashMap<String, String> getRutaArchivosJava() {
        return rutaArchivosJava;
    }

    public void setRutaArchivosJava(HashMap<String, String> rutaArchivosJava) {
        this.rutaArchivosJava = rutaArchivosJava;
    }
    
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public ArrayList<DatosClase> getDatosClase() {
        return datosClase;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setDatosClase(ArrayList<DatosClase> datosClase) {
        this.datosClase = datosClase;
    }
    
}