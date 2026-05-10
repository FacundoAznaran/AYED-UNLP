package parciales.caminoPartidadAlternada;
import parciales.utils.*;
import java.util.*;
public class ParcialesArboles {
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer>tree){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty())
			recorrer(tree,resultado,new LinkedList<Integer>(),tree.getData() % 2 == 0);
		return resultado;
	}
	
	private static void recorrer(GeneralTree<Integer> tree, List<Integer> resultado, LinkedList<Integer> caminoActual,boolean esPar) {
		caminoActual.add(tree.getData());
		if(tree.isLeaf()) {
			if(resultado.size() < caminoActual.size()) {
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		} else {
			for(GeneralTree<Integer> hijo: tree.getChildren()) {
				if(esPar != (hijo.getData() % 2 == 0)) {
					recorrer(hijo,resultado,caminoActual,hijo.getData() % 2 == 0);
				}
			}
		}
		caminoActual.remove(caminoActual.size() - 1);
		return;
	}
}
