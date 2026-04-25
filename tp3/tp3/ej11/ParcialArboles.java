package tp3.ej11;
import java.util.*;
import tp3.ejercicio1.*;
public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer>tree) {
		boolean resultado = true;
		Queue<GeneralTree<Integer>> cola = new LinkedList<GeneralTree<Integer>>();
		cola.add(tree);
		cola.add(null);
		int actual = 0;
		int contador = 0;
		while(!cola.isEmpty() && resultado) {
			GeneralTree<Integer> nodo = cola.poll();
			if(nodo != null) {
				contador++;
				for(GeneralTree<Integer>hijo: nodo.getChildren())
					cola.add(hijo);
			} else {
				if(contador != ++actual)
					resultado = false;
				contador = 0;
				if(!cola.isEmpty())
					cola.add(null);
			}
			
		}
		return resultado;
	}
}
