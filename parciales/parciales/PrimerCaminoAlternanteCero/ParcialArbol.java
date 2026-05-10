package parciales.PrimerCaminoAlternanteCero;
import java.util.*;
import parciales.utils.*;
public class ParcialArbol {
	
	public static List<Integer> PrimerCaminoAlternanteCeroNoCero(GeneralTree<Integer> tree){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty()) {
			buscarCamino(tree,resultado,tree.getData() % 10 == 0);
		}
		return resultado;
	}
	
	private static boolean buscarCamino(GeneralTree<Integer> tree, List<Integer> resultado, boolean terminaEnCero) {
		boolean encontre = false;
		resultado.add(tree.getData());
		if(tree.isLeaf())
			encontre = true;
		else {
			List<GeneralTree<Integer>> hijos = tree.getChildren();
			Iterator<GeneralTree<Integer>> it = hijos.iterator();
			while(it.hasNext() && !encontre) {
				GeneralTree<Integer> actual = it.next();
				boolean terminaEnCeroHijo = (actual.getData() % 10) == 0;
				if(terminaEnCero != terminaEnCeroHijo) {
					encontre = buscarCamino(actual,resultado,terminaEnCeroHijo);
				}
			}
			if(!encontre)
				resultado.remove(resultado.size() - 1);
		}
		return encontre;
	}
}
