package tp2.ej3;
import tp2.utils.*;
import java.util.*;
public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public void recorridoInOrden(BinaryTree<Integer>ab, ArrayList<Integer> arreglo) {
		if(ab == null || ab.isEmpty()) return;
		if(ab.hasLeftChild())
			recorridoInOrden(ab.getLeftChild(), arreglo);
		if(ab.getData() % 2 == 0)
			arreglo.add(ab.getData());
		if(ab.hasRightChild())
			recorridoInOrden(ab.getRightChild(), arreglo);
		
	}
	
	public void recorridoPostOrden(BinaryTree<Integer>ab, ArrayList<Integer> arreglo) {
		if(ab == null || ab.isEmpty()) return;
		if(ab.hasLeftChild()) 
			recorridoPostOrden(ab.getLeftChild(), arreglo);
		if(ab.hasRightChild())
			recorridoPostOrden(ab.getRightChild(), arreglo);
		if(ab.getData() % 2 == 0) 
			arreglo.add(ab.getData());
	}
	
	public ArrayList<Integer> numerosPares(){
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		if(this.getArbol() == null)
			return arreglo;
		if(this.getArbol().isEmpty())
			return arreglo;
		recorridoInOrden(this.getArbol(),arreglo);
		return arreglo;
	}
}
