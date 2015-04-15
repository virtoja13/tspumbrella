/*
*Clase que contiene los datos para realizar las operaciones
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.finding;

public class Data {
     
    private double x;
    private int dof;
    private int numSeg;
    private double p;

    /**
     * Metodo constructor del objeto Data
     * @param dof: int
     * @param numSeg : numSeg
     */
    public Data(int dof, int numSeg){
        this.dof = dof;
        this.numSeg = numSeg;
    }

    /**
     * @return double
     */
    public double getX(){
        return x;
    }

    /**
     * @return double
     */
    public double getDof(){
        return dof;
    }

    /**
     * @return int
     */
    public int getNumSeg() {
        return numSeg;
    }

    /**
     * @return double
     */
    public double getP() {
        return p;
    }
    
    /**
     * @param x: double
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * @param dof: int
     */
    public void setDof(int dof){
        this.dof = dof;
    }

    /**
     * @param numSeg: int
     */
    public void setNumSeg(int numSeg) {
        this.numSeg = numSeg;
    }

    /**
     * @param p: double
     */
    public void setP(double p) {
        this.p = p;
    }

}