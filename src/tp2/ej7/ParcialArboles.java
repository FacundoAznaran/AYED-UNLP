package tp2.ej7;
import tp2.utils.*;
import java.util.*;
public class ParcialArboles {
	private BinaryTree<Integer> tree;
	
	private int evaluar(BinaryTree<Integer> tree) {
		int cant = 0;
		if(tree.hasLeftChild()) {
			if(!tree.hasRightChild())
				cant++;
			cant += evaluar(tree.getLeftChild());
		}
		if(tree.hasRightChild()) {
			if(!tree.hasLeftChild())
				cant++;
			cant += evaluar(tree.getRightChild());
		}
		return cant;
	}
	
	private boolean buscar(BinaryTree<Integer> tree, int n) {
		int r = -1;
		int l = -1;
		boolean ok = false;
		if(tree.getData() == n) {
			if(tree.hasLeftChild()) {
				l = evaluar(tree.getLeftChild());
				if(tree.hasRightChild())
					r = evaluar(tree.getRightChild());
			}
			ok = l>r;
		}
		else {
			if(tree.hasLeftChild())
				ok = buscar(tree.getLeftChild(),n);
			if(!ok)
				if(tree.hasRightChild())
					ok = buscar(tree.getRightChild(),n);
		}
		return ok;
	}
	
	public boolean isLeftTree(int n) {
		boolean ok;
		if(this.tree == null || this.tree.isEmpty())
			return false;
		else
			ok = buscar(this.tree,n);
		return ok;
	}
	
}
