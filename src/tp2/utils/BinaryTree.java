package tp2.utils;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
			if(this.isEmpty())
				return 0;
			if(this.isLeaf())
				return 1;
			else {
				int cant = 0;
				
				if(this.hasLeftChild())
					cant += this.getLeftChild().contarHojas();
				if(this.hasRightChild())
					cant += this.getRightChild().contarHojas();
				return cant;
			}
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> nuevo = new BinaryTree<T>();
    	if(this.isEmpty())
    		return null;
    	nuevo.setData(this.getData());
 	   	if(!this.isLeaf()) { // si no es una hoja avanza
 	   		if(this.hasLeftChild())
 	   			nuevo.addRightChild(this.getLeftChild().espejo());//invierte el orden de los hijos avanzando por el arbol
 	   		if(this.hasRightChild())
 	   			nuevo.addLeftChild(this.getRightChild().espejo());//invierte el orden de los hijos avanzando por el arbol
 	   	}
    	return nuevo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		int i = 1;
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>(); 
		cola.add(this);
		cola.add(null);
		while(!cola.isEmpty()) {
			ab = cola.poll();
			if(ab != null) {
				if(n <= i && i <= m) 
					System.out.println(ab.getData());
				if(ab.hasLeftChild())
					cola.add(ab.getLeftChild());
				if(ab.hasRightChild())
					cola.add(ab.getRightChild());
				
			}
			else {
				i++;
				if(!cola.isEmpty() && i <= m) {
					cola.add(null);
			}
			}
		}
   }
		
}

