package parciales.tema1_2024;
import java.util.*;
import parciales.utils.*;
public class ParcialArboles {
	private GeneralTree<Integer> tree;
	
	public List<Integer> camino(int num){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty()) {
			if(tree.isLeaf() || tree.getChildren().size() >= num)
				recorrer(tree,num,resultado);
		}
		return resultado;
	}
	
	private boolean recorrer(GeneralTree<Integer> tree, int num, List<Integer> resultado) {
		boolean encontre = false;
		resultado.add(tree.getData());
		if(tree.isLeaf()) {
			encontre = true;
		} else {
			Iterator<GeneralTree<Integer>> it = tree.getChildren().iterator();
			while(!encontre && it.hasNext()) {
				GeneralTree<Integer> actual = it.next();
				if(!actual.isLeaf() && actual.getChildren().size() >= num) {
					encontre = recorrer(actual,num,resultado);
				} else {
					if(actual.isLeaf())
						encontre = recorrer(actual,num,resultado);
				}
			}
			if(!encontre)
				resultado.remove(resultado.size() - 1);
		}
		return encontre;
	}
}
