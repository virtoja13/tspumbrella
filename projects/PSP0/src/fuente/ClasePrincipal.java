package fuente;
import java.text.DecimalFormat;
import java.util.LinkedList;


public class ClasePrincipal {
	
	public static void main(String args[]){
		DecimalFormat df = new DecimalFormat("#.0#");
		//LISTA 1
		LinkedList listaEntrada1 = new LinkedList();
		listaEntrada1.add("160");
		listaEntrada1.add("591");
		listaEntrada1.add("114");
		listaEntrada1.add("229");
		listaEntrada1.add("230");
		listaEntrada1.add("270");
		listaEntrada1.add("128");
		listaEntrada1.add("1657");
		listaEntrada1.add("624");
		listaEntrada1.add("1503");
		//LISTA 2
		LinkedList listaEntrada2 = new LinkedList();
		listaEntrada2.add("15.0");
		listaEntrada2.add("69.9");
		listaEntrada2.add("6.5");
		listaEntrada2.add("22.4");
		listaEntrada2.add("28.4");
		listaEntrada2.add("65.9");
		listaEntrada2.add("19.4");
		listaEntrada2.add("198.7");
		listaEntrada2.add("38.8");
		listaEntrada2.add("138.2");
		Operar operar = new Operar();
		System.out.println("Calculo de la media para la lista de entrada 1, es igual a: "+df.format(operar.media(listaEntrada1)));
		System.out.println("Calculo de la desviación estandar para la lista de entrada 1, es igual a: "+df.format(operar.desviacionEstandar(listaEntrada1)));
		System.out.println();
		System.out.println("Calculo de la media para la lista de entrada 2, es igual a: "+df.format(operar.media(listaEntrada2)));
		System.out.println("Calculo de la desviación estandar para la lista de entrada 2, es igual a: "+df.format(operar.desviacionEstandar(listaEntrada2)));
	}

}