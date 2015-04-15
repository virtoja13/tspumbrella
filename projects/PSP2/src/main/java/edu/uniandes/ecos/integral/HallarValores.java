/*
*Clase para realizar las distintas operaciones que se realizan parar hallar la regresion y la correlacion
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.integral;

import java.util.ArrayList;

public class HallarValores {
    
    private static final double E = 0.00001;//Error aceptable
    
    /**
     * Retorna datos de entrada con los que se evalua la regla de Simpson
     * @return Data 
     */
    public static Data datos1(){
        return new Data(1.1,9,10);
    }
    
    /**
     * Retorna datos de entrada con los que se evalua la regla de Simpson
     * @return Data 
     */
    public static Data datos2(){
        return  new Data(1.1812,10,10);
    }
    
    /**
     * Retorna datos de entrada con los que se evalua la regla de Simpson
     * @return Data 
     */
    public static Data datos3(){
        return new Data(2.750,30,10);
    }
    
    /**
     * Realizar cuantas veces sea neceraio el metodo reglaSimpson hasta que el resultado cumpla con el error aceptable
     * @param data: Data
     * @return Data
     */
    public Data valorConErrorAceptable(Data data){
        int multiplicar = 2;
        data = reglaSimpson(data);
        Data dataTemp = data;
        do{
            dataTemp.setNumSeg(dataTemp.getNumSeg()*multiplicar);
            dataTemp = reglaSimpson(dataTemp);
            multiplicar++;
        }
        while(Math.abs(data.getP()-dataTemp.getP())>E);
        return dataTemp;
    }
    
    /**
     * Metodo que implemente la regla de Simpson.
     * @param data: Data
     * @return 
     */
    public Data reglaSimpson(Data data){
        double W = data.getX()/data.getNumSeg();
        double sumImpares = 0.0;
        double sumPares = 0.0;
        ArrayList<Double> segmentos = encontrarValoresSumatoria(data.getNumSeg(), data.getX());
        //Sumatoria impares
        for(int i=0; i<segmentos.size(); i=i+2){
            sumImpares += 4*tDistribution(data.getDof(), segmentos.get(i));
        }
        //Sumatoria pares
        for(int i=1; i<segmentos.size()-1; i=i+2){
            sumPares += 2*tDistribution(data.getDof(),segmentos.get(i));
        }
        
        double parteInicio = tDistribution(data.getDof(), 0);
        double parteFin = tDistribution(data.getDof(), data.getX());
        data.setP((W/3) * (parteInicio + sumImpares + sumPares + parteFin));
        return data;
    }
    
    /**
     * Retornar una lista con los segmentos que utilizara la regla de Simpson
     * @param numSeg: int
     * @param x: double
     * @return ArrayList<Double>
     */
    public ArrayList<Double> encontrarValoresSumatoria(int numSeg, double x){
        ArrayList<Double> listaDouble = new ArrayList<Double>();
        double intervalo = x/numSeg;
        double seg = intervalo;
        while(seg<x){
            listaDouble.add(seg);
            seg=seg+intervalo;
        }
        return listaDouble;
    }
    
    /**
     * Metodo que implementa la funcion t Distribution.
     * @param dof: double
     * @param x: double
     * @return double
     */
    public double tDistribution(double dof, double x){
        double comprobacion = (dof+1)/2;
        double parte1 = 0.0;
        if(comprobacion % 1 == 0)
            parte1 = gammaFunction((dof+1)/2);
        else 
            parte1 = gammaFunctionFraccionario((dof+1),2);
        double parte2_1 = Math.pow(dof*Math.PI,0.5);
        comprobacion = dof/2;
        double parte2_2 = 0.0;
        if(comprobacion % 1 == 0)
            parte2_2 = gammaFunction((dof)/2);
        else
            parte2_2 = gammaFunctionFraccionario(dof,2);
        double parte2 = parte2_1* parte2_2;
        double parte3 = Math.pow((1+((x*x)/dof)),-(dof+1)/2);
        double total = (parte1 / parte2) * parte3;
        return total;
    }
    
    /**
     * Metodo que implementa la funcion gamma para numeros enteros
     * @param valorX: double
     * @return 
     */
    public double gammaFunction(double valorX){
        if(valorX == 1)
            return 1;
        else 
            return (valorX-1)*gammaFunction(valorX-1); 
    }
    
    /**
     * Metodo que implementa la funcion gamma par fraccionarios
     * @param numerador: double
     * @param denominador: double
     * @return double
     */
    public double gammaFunctionFraccionario(double numerador, double denominador){
        if(numerador == 1 && denominador == 2)
            return Math.sqrt(Math.PI);
        else 
            return ((numerador-denominador)/denominador)*gammaFunctionFraccionario(numerador-denominador,denominador); 
    }
    
}