package parciales.tema2_2024;
import parciales.utils.*;
import parciales.utils.Queue;

import java.util.*;
public class ParcialArboles {
	private GeneralTree<Integer> tree;
	
	public LinkedList<Integer> nivel(int num){
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		if(tree == null || tree.isEmpty()) return resultado;
		
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(tree);
		cola.enqueue(null);
		boolean encontre = false;
		boolean nivelCumple = true;
		while(!encontre && !cola.isEmpty()) {
			GeneralTree<Integer> actual = cola.dequeue();
			if(actual != null) {
				if(actual.getChildren().size() < num)
					nivelCumple = false;
				resultado.add(actual.getData());
				for(GeneralTree<Integer> hijo: actual.getChildren()) {
					cola.enqueue(hijo);
				}
			} else {
				if(nivelCumple) {
					encontre = true;
				} else {
					resultado.clear();
					nivelCumple = true;
					if(!cola.isEmpty())
						cola.enqueue(null);
				}
			}
		}
		return resultado;
	}
}
