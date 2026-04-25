package tp3.ej6;
import tp3.ejercicio1.*;

public class RedDeAguaPotable {

	private GeneralTree<Character> arbol;


	public double minimoCaudal(double caudal) {
		return calcularMinimo(caudal,arbol);
	}

	private double calcularMinimo(double caudal, GeneralTree<Character> tree) {
		double min;
		if(tree.isLeaf()) {
			min = caudal;
		} else {
			min = Double.MAX_VALUE;
			int cant = tree.getChildren().size();
			for(GeneralTree<Character> hijo: tree.getChildren()) {
				double actual = calcularMinimo((caudal/cant),hijo);
				if(actual < min)
					min = actual;
			}
		}
		return min;
	}
}
