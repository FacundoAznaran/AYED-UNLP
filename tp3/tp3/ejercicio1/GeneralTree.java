package tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	
	public int nivel(T dato){
		int n = -1;
		if(dato.equals(this.data)) 
			n = 0;
		else {
			boolean ok = false;
			List<GeneralTree<T>> hijos = this.children;
			Iterator<GeneralTree<T>> it = hijos.iterator();
			while(!ok && it.hasNext()) {
				int resultado = it.next().nivel(dato);
				if(resultado != -1) {
					ok = true;
					n = resultado + 1;
				}
			}
		}
		return n;
	}

	public int ancho(){
		int max = 0;
		int cant = 0;
		Queue<GeneralTree<T>> cola = new LinkedList<GeneralTree<T>>();
		cola.add(this);
		cola.add(null);
		while(!cola.isEmpty()) {
			GeneralTree<T> actual = cola.poll();
			if(actual != null) {
				cant++;
				for(GeneralTree<T> hijo: actual.getChildren()) {
					cola.add(hijo);
				}
			}
			else {
				if(max < cant)
					max = cant;
				cant = 0;
				if(!cola.isEmpty()) {
					cola.add(null);
				}
			}
		}
		return max;
	}
	
	public int altura() {
		int h = 0;
		if(!this.isLeaf()) { 
			for(GeneralTree<T>Hijo: this.getChildren()) {
				int actual = 1 + Hijo.altura();
				if(actual > h){
					h = actual;
				}
			}
		}
		return h;	
	}
	
	private boolean descendiente(T b) {
		boolean ok = false;
		if(this.data.equals(b)) {
			ok = true;
		} else {
			Iterator<GeneralTree<T>> it = this.children.iterator();
			while(!ok && it.hasNext()) {
				ok = it.next().descendiente(b);
			}
		}
		return ok;
	}

	public boolean esAncestro(T a, T b) {
		boolean ok = false;
		if(this.data.equals(a)) {
			ok = descendiente(b);
		} else {
			Iterator<GeneralTree<T>> it = this.children.iterator();
			while(!ok && it.hasNext())
				ok = it.next().esAncestro(a, b);
		}
		return ok;
	}
}