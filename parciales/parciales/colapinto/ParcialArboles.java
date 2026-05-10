package parciales.colapinto;
import parciales.utils.*;
import java.util.*;
public class ParcialArboles {
	public List<Compuesto> mejorEstrategia(GeneralTree<Compuesto> tree){
		List<Compuesto> resultado = new LinkedList<Compuesto>();
		double min = Double.MAX_VALUE;
		if(tree != null && !tree.isEmpty()) {
			for(GeneralTree<Compuesto> hijo: tree.getChildren()) {
				min = recorrer(hijo,resultado,min,0,new LinkedList<Compuesto>());
			}
		}
		return resultado;
	}
	
	private double recorrer(GeneralTree<Compuesto> tree, List<Compuesto> resultado, double min,double suma,LinkedList<Compuesto> actual) {
		double valor = tree.getData().getVueltas();
		actual.add(tree.getData());
		if(tree.getData().getCompuesto().equals("soft")) 
			valor *= 0;
		else 
		if(tree.getData().getCompuesto().equals("med")) 
			valor *= 0.4;
		else 
			valor *= 0.7;
		suma += valor;
		if(tree.isLeaf()) {
			if(suma < min) {
				resultado.clear();
				resultado.addAll(actual);
				min = suma;
			}
		} else {
			for(GeneralTree<Compuesto> hijo: tree.getChildren()) {
				min = recorrer(hijo,resultado,min,suma+10,actual);
			}
		}
		actual.remove(actual.size() - 1);
		return min;
	}
}

