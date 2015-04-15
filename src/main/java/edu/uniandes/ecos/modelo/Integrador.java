package edu.uniandes.ecos.modelo;

import edu.uniandes.ecos.modelo.Data.DataEjercicio1_DatosProyecto;
import edu.uniandes.ecos.modelo.Data.Logica.LogicaEjercicio1_Contador;
import java.util.ArrayList;

/**
 *
 * @author JAVIER
 */
public class Integrador {
    
    public ArrayList<DataEjercicio1_DatosProyecto> ejercicio1() throws Exception{
        try{
            LogicaEjercicio1_Contador contador = new LogicaEjercicio1_Contador();
            ArrayList<DataEjercicio1_DatosProyecto> listaProyectos = contador.conteoArchivos("projects");
            return listaProyectos;
        }
        catch(Exception e){
            throw new Exception("Error en el metodo ejercicio1 del integrado, detalle: " + e.getMessage());
        }
    }
    
}
