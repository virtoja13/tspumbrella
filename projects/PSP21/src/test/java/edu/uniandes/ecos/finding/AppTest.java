/*
*Clase para realizar las pruebas unitarias del programa
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.finding;

import java.text.DecimalFormat;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

public class AppTest extends TestCase{
    
    DecimalFormat df = new DecimalFormat("#.00000");
 
    public void testDatos1(){
        HallarValores valores1 = new HallarValores();
        Data data = valores1.hallarX(HallarValores.datos1(), HallarValores.P1);
        assertTrue(Double.compare(data.getP(), HallarValores.P1) == 0);
    }
    
    public void testDatos2(){
        HallarValores valores2 = new HallarValores();
        Data data = valores2.hallarX(HallarValores.datos2(), HallarValores.P2);
        assertTrue( Double.compare(data.getP(), HallarValores.P2) == 0);
    }
    
    public void testDatos3(){
        HallarValores valores3 = new HallarValores();
        Data data = valores3.hallarX(HallarValores.datos3(), HallarValores.P3);
        assertTrue(Double.compare(data.getP(), HallarValores.P3) == 0);
    }
    
}