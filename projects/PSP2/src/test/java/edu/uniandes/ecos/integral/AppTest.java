/*
*Clase para realizar las pruebas unitarias del programa
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.integral;

import java.text.DecimalFormat;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

public class AppTest extends TestCase{
    
    DecimalFormat df = new DecimalFormat("#0.00000");
 
    public void testDatos1(){
        HallarValores  valores = new HallarValores();
        Data data = valores.valorConErrorAceptable(HallarValores.datos1());
        assertTrue( df.format(data.getP()).equals("0,35006") );
    }
    
    public void testDatos2(){
        HallarValores valores = new HallarValores();
        Data data = valores.valorConErrorAceptable(HallarValores.datos2());
        assertTrue( df.format(data.getP()).equals("0,36757") );
    }
    
    public void testDatos3(){
        HallarValores valores = new HallarValores();
        Data data = valores.valorConErrorAceptable(HallarValores.datos3());
        assertTrue( df.format(data.getP()).equals("0,49500") );
    }
    
}
