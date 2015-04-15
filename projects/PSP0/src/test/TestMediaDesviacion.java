package test;

import java.text.DecimalFormat;
import java.util.LinkedList;

import fuente.Operar;
import junit.framework.TestCase;

public class TestMediaDesviacion extends TestCase {

	Operar operar = new Operar();
	DecimalFormat df = new DecimalFormat("#.0#");
	
	public void testMedia(){
		LinkedList list = new LinkedList();
		list.add("186");
		list.add("699");
		list.add("132");
		list.add("272");
		list.add("291");
		list.add("331");
		list.add("199");
		list.add("1890");
		list.add("788");
		list.add("1601");
		assertTrue(operar.media(list)==638.9);
	}
	
	public void testDesviacionEstandar(){
		LinkedList list = new LinkedList();
		list.add("186");
		list.add("699");
		list.add("132");
		list.add("272");
		list.add("291");
		list.add("331");
		list.add("199");
		list.add("1890");
		list.add("788");
		list.add("1601");
		assertTrue((operar.desviacionEstandar(list))==625.6339806770231);
	}
	
}