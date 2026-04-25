package tp3.ej10;
import java.util.*;
import tp3.ejercicio1.*;
public class ParcialArboles {
	public static List<Integer> resolver(GeneralTree<Integer> tree){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty()) {
			buscarCaminoSumaMaxima(tree,0,0,Integer.MIN_VALUE,resultado,new LinkedList<Integer>());
		}
		return resultado;
	}
	
	private static int buscarCaminoSumaMaxima(GeneralTree<Integer>tree,int nivel, int sumaActual,int sumaMax,List<Integer>resultado,List<Integer>actual){
		sumaActual += nivel*tree.getData();
		if(tree.getData() != 0)
			actual.add(tree.getData());
		if(tree.isLeaf()) {
			if(sumaMax < sumaActual) {
				sumaMax = sumaActual;
				resultado.clear();
				resultado.addAll(actual);
			}
		} else {
			for(GeneralTree<Integer>hijo: tree.getChildren())
				sumaMax = buscarCaminoSumaMaxima(hijo,nivel+1,sumaActual,sumaMax,resultado,actual);
		}
		if(tree.getData() != 0)
			actual.remove(actual.size()-1);
		return sumaMax;
	}
}
