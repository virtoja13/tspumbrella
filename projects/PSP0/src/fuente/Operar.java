package fuente;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Operar {

	public double media(LinkedList lista){
		double resultado = 0;
		double suma = 0;
		for(int i = 0; i<lista.size(); i++){
			suma = Double.sum(suma, Double.parseDouble((String)lista.get(i)));
		}
		return resultado = suma / lista.size(); 
	}
	
	public double desviacionEstandar(LinkedList lista){
		double resultado = 0;
		double media = media(lista);
		double suma = 0;
		for(int i = 0; i<lista.size(); i++){
			double operacionParcial = (Double.parseDouble((String)lista.get(i)) - media) * (Double.parseDouble((String)lista.get(i)) - media);
			suma = suma + operacionParcial;
		}
		suma = suma / (lista.size() - 1);
		return resultado = Math.sqrt(suma);
	}
	
}