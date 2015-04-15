/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;

/**
 *
 * @author JAVIER
 */
public class DatosClase {
    
    private String NombreClase;
    private long numeroLineas;
    private int numeroMetodos;

    public DatosClase(String NombreClase, long numeroLineas, int numeroMetodos) {
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