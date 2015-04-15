package edu.uniandes.ecos.modelo.Data;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Clase DataEjercicio1_DatosProyecto parametriza los datos del programa
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class DataEjercicio1_DatosProyecto {
    private String nombreProyecto;
    
    private HashMap<String,String> rutaArchivosJava;
    
    private ArrayList<DataEjercicio1_DatosClase> datosClase;
    /**
     * DataEjercicio1_DatosProyecto
     * @param nombreProyecto:String
     * @param rutaArchivosJava:HashMap(String,String)
     */
    public DataEjercicio1_DatosProyecto(String nombreProyecto, HashMap<String,String> rutaArchivosJava) {
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

    public ArrayList<DataEjercicio1_DatosClase> getDatosClase() {
        return datosClase;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setDatosClase(ArrayList<DataEjercicio1_DatosClase> datosClase) {
        this.datosClase = datosClase;
    }
}
