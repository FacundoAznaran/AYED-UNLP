package parciales.encontrarTodosLosCaminos;
import java.util.*;
import parciales.utils.*;
public class ParcialArboles {
	public List<LinkedList<Character>> caminosPares(GeneralTree<Character> tree){
		List<LinkedList<Character>>resultado = new LinkedList<LinkedList<Character>>();
		if(tree != null && !tree.isEmpty()){
			recorrer(tree,resultado,new LinkedList<Character>());
		}
		return resultado;
	}

	private void recorrer(GeneralTree<Character> tree, List<LinkedList<Character>> resultado, LinkedList<Character> ListaActual){
		ListaActual.add(tree.getData());
		if(tree.isLeaf()){
			if(ListaActual.size() % 2 == 0)
				resultado.add(new LinkedList(ListaActual));
		} else {
			for(GeneralTree<Character> hijo: tree.getChildren()){
				recorrer(hijo,resultado,ListaActual);
			}
		}
		ListaActual.remove(ListaActual.size() - 1);
		return;
	}
}
