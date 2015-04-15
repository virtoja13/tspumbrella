package edu.uniandes.ecos.modelo.Data;
/**
 * Clase DataEjercicio1_DatosClase parametriza los datos de la clase del programa
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class DataEjercicio1_DatosClase {
    private String NombreClase;
    private long numeroLineas;
    private int numeroMetodos;
    
    /**
     * DataEjercicio1_DatosClase
     * @param NombreClase:String
     * @param numeroLineas:long
     * @param numeroMetodos:int 
     */
    public DataEjercicio1_DatosClase(String NombreClase, long numeroLineas, int numeroMetodos) {
        this.NombreClase = NombreClase;
        this.numeroLineas = numeroLineas;
        this.numeroMetodos = numeroMetodos;
    }
    public String getNombreClase() {
        return NombreClase;
    }

    public long getNumeroLineas() {
        return numeroLineas;
    }

    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    public void setNombreClase(String NombreClase) {
        this.NombreClase = NombreClase;
    }

    public void setNumeroLineas(long numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }
}
