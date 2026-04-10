package tp2.ej9;
import tp2.utils.*;
import java.util.*;
public class ParcialArboles {
	
	private BinaryTree<Integer[]> recorrer(BinaryTree<Integer> tree, int n, int p) {
		BinaryTree<Integer[]> a = new BinaryTree<Integer[]>();
		Integer[] array = new Integer[2];
		array[0] = tree.getData() + n;
		array[1] = tree.getData() - p; 
		if(tree.hasLeftChild())
			a.addLeftChild(recorrer(tree.getLeftChild(),array[0],tree.getData())); // paso el arbol, la suma, y el dato del padre
		if(tree.hasRightChild())
			a.addRightChild(recorrer(tree.getRightChild(),array[0],tree.getData()));
		a.setData(array);
		return a;
	}
	
	public BinaryTree<Integer[]> sumAndDif(BinaryTree<Integer> tree){
		BinaryTree<Integer[]> a = new BinaryTree<Integer[]>();
		if(tree == null || tree.isEmpty())
			a = null;
		else
			a = recorrer(tree,0,0);
		return a;
	}
}
