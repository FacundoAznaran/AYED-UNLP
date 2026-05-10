package parciales.camino;
import parciales.utils.*;
import java.util.*;
public class ParcialArboles {
		public List<Integer> camino(GeneralTree<Integer> tree, int num){
			List<Integer> resultado = new LinkedList<Integer>();
			if(tree != null && !tree.isEmpty() && tree.getChildren().size() >= num)
				recorrer(tree,num,resultado);
			if(tree.isLeaf())
				resultado.add(tree.getData());
			return resultado;
		}
		
		private boolean recorrer(GeneralTree<Integer> tree, int num, List<Integer> resultado) {
			boolean encontre = false;
			resultado.add(tree.getData());
			if(tree.isLeaf()) {
				encontre = true;
			} else {
				Iterator <GeneralTree<Integer>> it = tree.getChildren().iterator();
				while(it.hasNext() && !encontre) {
					GeneralTree<Integer> actual = it.next();
					if(actual.getChildren().size() >= num || actual.isLeaf())
						encontre = recorrer(actual,num,resultado);
				}
				if(!encontre)
					resultado.remove(resultado.size() - 1);
				
			}
			return encontre;
		}
}
