package parciales.caminoSignoAlternante;
import java.util.*;
import parciales.utils.*;
public class ParcialArboles {
	
	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> tree){
		List<Integer> resultado = new LinkedList<Integer>();
		if(tree != null && !tree.isEmpty()) {
			recorrer(tree,resultado,new LinkedList<Integer>(),0, Integer.MIN_VALUE,tree.getData() >= 0);
		}
		return resultado;
	}
	
	private static int recorrer(GeneralTree<Integer> tree, List<Integer> resultado, LinkedList<Integer> CaminoActual, int sumaActual, int sumaMaxima,boolean positivo) {
		sumaActual += tree.getData();
		CaminoActual.add(tree.getData());
		if(tree.isLeaf()) {
			if(sumaActual > sumaMaxima) {
				sumaMaxima = sumaActual;
				resultado.clear();
				resultado.addAll(CaminoActual);
			}
		} else {
			for(GeneralTree<Integer> hijo: tree.getChildren()) {
				boolean hijoPositivo = hijo.getData() >= 0;
				if(positivo != hijoPositivo) {
					sumaMaxima = recorrer(hijo,resultado,CaminoActual,sumaActual,sumaMaxima,hijoPositivo);
				}
			}
		}
		CaminoActual.remove(CaminoActual.size() - 1);
		return sumaMaxima;
	}
}
