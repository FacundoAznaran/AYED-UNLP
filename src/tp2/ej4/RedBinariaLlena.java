package tp2.ej4;
import tp2.utils.*;
import java.util.*;
public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	private int max = -1;
	private void preOrden(BinaryTree<Integer> ab, int suma) {
		suma += ab.getData();
		if(ab.isLeaf()) {
			if(suma > max)
				max = suma;
			return;
		}
		if(ab.hasLeftChild())
			preOrden(ab.getLeftChild(), suma);
		if(ab.hasRightChild())
			preOrden(ab.getRightChild(), suma);
	}
	
	private int posOrden(BinaryTree<Integer> ab) {
		if(ab.isLeaf())
			return ab.getData();
		int iz = 0;
		int de = 0;
		if(ab.hasLeftChild())
			iz = posOrden(ab.getLeftChild());
		if(ab.hasRightChild())
			de = posOrden(ab.getRightChild());
		
		if(iz > de)
			return iz + ab.getData();
		else
			return de + ab.getData();
	}
	
	public int retardoReenvio() {
		if(this.arbol == null)
			return 0;
		if(this.arbol.isEmpty())
			return 0;
		preOrden(this.arbol,0);
		return max;
	}

	

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}


	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
	
	
}
