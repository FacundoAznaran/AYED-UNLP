package tp3.ej7;
import java.util.*;
import tp3.ejercicio1.*;
public class Caminos {
	private GeneralTree<Integer> a;
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> lista = new LinkedList<Integer>();
		if(a != null && !a.isEmpty()) {
			lista = buscarCamino(a);
		}
		return lista;
	}
	
	private List<Integer> buscarCamino(GeneralTree<Integer> tree){
		List<Integer> caminoActual = new LinkedList<Integer>();
		if(tree.isLeaf()) {
			caminoActual.add(0,tree.getData());
		} else {
			for(GeneralTree<Integer>hijo: tree.getChildren()) {
				List<Integer> camino = buscarCamino(hijo);
				if(camino.size() > caminoActual.size())
					caminoActual = camino;
			}
			caminoActual.add(0,tree.getData());
		}
		return caminoActual;
	}
}
