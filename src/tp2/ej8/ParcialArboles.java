package tp2.ej8;
import java.util.*;
import tp2.utils.*;
public class ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> tree1,BinaryTree<Integer> tree2) {
		boolean ok = true; // doy por hecho que es prefijo 
		if(tree1 == null || tree1.isEmpty())
			ok = true;
		else
			if(tree2 == null || tree2.isEmpty())
				ok = false;
			else {
				if(tree1.getData().equals(tree2.getData())) {
					// mientras se siga considerando prefijo, evaluo si tree2 tiene hijos de los mismos lados que tree1
					if(tree1.hasLeftChild() && !tree2.hasLeftChild())
						ok = false;
					if(ok && tree1.hasRightChild() && !tree2.hasRightChild())
						ok = false;
					// una vez pasa el filtro llamo recursivamente para ver si comparten el mismo dato
					if(ok && tree1.hasLeftChild())
						ok = esPrefijo(tree1.getLeftChild(),tree2.getLeftChild());
					if(ok && tree1.hasRightChild())
						ok = esPrefijo(tree1.getRightChild(),tree2.getRightChild());
				}
				else
					ok = false;
			}
		return ok;
	}
}
