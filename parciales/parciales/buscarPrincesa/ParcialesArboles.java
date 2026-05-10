package parciales.buscarPrincesa;
import parciales.utils.*;
import java.util.*;
public class ParcialesArboles {
	public static List<String> princesaAccesible(GeneralTree<String> tree){
		List<String> resultado = new LinkedList<String>();
		if(tree != null && !tree.isEmpty()) {
			if(tree.getData() != "dragon")
				recorrer(tree,resultado);
		}
		return resultado;
	}
	
	private static boolean recorrer(GeneralTree<String> tree, List<String>resultado) {
		boolean encontre = false;
		resultado.add(tree.getData());
		if(tree.isLeaf()) {
			if(tree.getData() == "princesa")
				encontre = true;
		} else {
			Iterator<GeneralTree<String>> it = tree.getChildren().iterator();
			while(!encontre && it.hasNext()) {
				GeneralTree<String> actual = it.next();
				if(actual.getData() != "dragon") {
					encontre = recorrer(actual,resultado);
				}
			}
		}
		if(!encontre)
			resultado.remove(resultado.size() - 1);
		return encontre;
	}
}
