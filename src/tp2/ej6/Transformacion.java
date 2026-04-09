package tp2.ej6;
import tp2.utils.*;
import java.util.*;
public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	private int recorrido(BinaryTree<Integer> tree){
		int valor= tree.getData();
		if(tree.isLeaf()) {
			tree.setData(0);
		}
		else {
			if(tree.hasLeftChild())
				valor += recorrido(tree.getLeftChild());
			if(tree.hasRightChild())
				valor += recorrido(tree.getRightChild());
			tree.setData(valor);
		}
		return valor;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> tree = this.arbol;
		if(!(this.arbol == null) && !this.arbol.isEmpty()) {
			recorrido(tree);
		}
		return tree;
	}
}
