package parciales.esCreciente;
import parciales.utils.*;
import parciales.utils.Queue;

import java.util.*;
public class ParcialArboles {
	
	public GeneralTree<Integer> esCreciente(GeneralTree<Integer> tree){
		 Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		 cola.enqueue(tree);
		 cola.enqueue(null);
		 GeneralTree<Integer> maximo = tree;
		 boolean esCreciente = true;
		 int nivel = 0;
		 int cantidadDeNodos = 0;
		 while(!cola.isEmpty() && esCreciente){
		 	GeneralTree<Integer> actual = cola.dequeue();
		 	if(actual != null && esCreciente){
		 		cantidadDeNodos++;
		 		if (cantidadDeNodos > nivel + 1) {
		 	        esCreciente = false;
		 	        maximo = null;
		 	    }
		 		int cantidadDeHijos = actual.getChildren().size();
		 		for(GeneralTree<Integer> hijo: actual.getChildren()){
		 			cola.enqueue(hijo);
		 		}
		 		if(cantidadDeHijos > maximo.getChildren().size())
		 			maximo = actual;
		 	
		 	} else {
		 		if(cantidadDeNodos != nivel + 1){
		 			esCreciente = false;
		 			maximo = null;
		 		}
		 		if(!cola.isEmpty() && esCreciente){
		 			cola.enqueue(null);
		 			nivel++;
		 			cantidadDeNodos = 0;
		 		}
		 	}
	}
		 return maximo;
	}
	
	
	
}
