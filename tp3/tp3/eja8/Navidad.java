package tp3.eja8;
import tp3.ejercicio1.*;
import java.util.*;
public class Navidad {
	GeneralTree<Integer> abeto;
	
	public String esAbetoNavidenio() {
		String resultado = "";
		if(abeto != null && !abeto.isEmpty()) {
			if(recorrer(abeto))
				resultado = "es abeto";
				else
					resultado = "no es abeto";
		}
		return resultado;
	}
	//el algoritmo no contempla el caso de que la raiz sea una hoja pero me da paja implementarlo a pesar de la simplicidad que me toma casi el mismo tiempo que escribir este puto el que lo lee :)
	private boolean recorrer(GeneralTree<Integer> tree) {
		boolean resultado = true;
		int cantidad = 0;
		Iterator <GeneralTree<Integer>> it = tree.getChildren().iterator();
		while (it.hasNext() && resultado){
			GeneralTree<Integer> actual = it.next();
			if(actual.isLeaf())
				cantidad++;
			else
				resultado = recorrer(actual);
		}
		if(resultado)
			if(cantidad < 3)
				resultado = false;
		return resultado;
	}
}
