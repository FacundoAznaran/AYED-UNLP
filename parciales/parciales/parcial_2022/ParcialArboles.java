package parciales.parcial_2022;
import parciales.utils.*;
import java.util.*;
public class ParcialArboles {
	public List<Integer> resolver(BinaryTree<Integer> tree,int min){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty()) {
			recorrer(tree,min,0,resultado);
		}
		return resultado;
	}
	
	private boolean recorrer(BinaryTree<Integer> tree, int min, int cantidad, List<Integer> resultado) {
		boolean encontre = false;
		if(tree.getData() % 2 == 0)
			cantidad++;
		resultado.add(tree.getData());
		if(tree.isLeaf()) {
			if(cantidad >= min) {
				encontre = true;
			}
		} else {
			if(tree.hasLeftChild())
				encontre = recorrer(tree.getLeftChild(),min,cantidad,resultado);
			if(!encontre && tree.hasRightChild())
				encontre = recorrer(tree.getRightChild(),min,cantidad,resultado);
		}
		if(!encontre)
			resultado.remove(resultado.size() - 1);
		return encontre;
	}
}
