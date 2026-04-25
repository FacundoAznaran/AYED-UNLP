package tp3.ej9;
import tp3.ejercicio1.*;
import java.util.*;
public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> tree) {
		boolean resultado = false;
		if(tree != null && !tree.isEmpty() && !tree.isLeaf()) {
			resultado = recorrer(tree);
		}
		return resultado;
	}
	/*este metodo es correcto pero ineficiente
	private static boolean recorrer(GeneralTree<Integer> tree) {
		boolean resultado = true;
		int min = Integer.MAX_VALUE;
		Iterator<GeneralTree<Integer>> it = tree.getChildren().iterator();
		while(it.hasNext() && resultado) {
			GeneralTree<Integer>actual = it.next();
			min = Math.min(min, actual.getData());
			if(actual.hasChildren())
				resultado = recorrer(actual);
		}
		if(min != tree.getData())
			resultado = false;
		return resultado;
	} */
	// este metodo de aqui es mejor porque no tiene que recorrer los hijos de los hijos
	private static boolean recorrer(GeneralTree<Integer> tree) {
		boolean resultado = true;
		int min = Integer.MAX_VALUE;
		Iterator<GeneralTree<Integer>> it = tree.getChildren().iterator();
		for(GeneralTree<Integer>hijo: tree.getChildren())
			min = Math.min(min, hijo.getData());
		
		if(min != tree.getData())
			resultado = false;
		
		while(it.hasNext() && resultado) {
			GeneralTree<Integer>actual = it.next();
			if(actual.hasChildren())
				resultado = recorrer(actual);
		}
		return resultado;
	}
}
