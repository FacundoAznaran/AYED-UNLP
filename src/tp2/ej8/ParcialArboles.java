package tp2.ej8;
import java.util.*;
import tp2.utils.*;
public class ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> tree1,BinaryTree<Integer> tree2) {
		boolean ok;
		if(tree1 == null || tree1.isEmpty())
			ok = true;
		else
			if(tree2 == null || tree2.isEmpty())
				ok = false;
			else
				ok = recorrer(tree1,tree2);
		return ok;
	}
}
