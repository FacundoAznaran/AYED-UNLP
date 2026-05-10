package parciales.profundamenteInferior;
import java.util.*;
import parciales.utils.*;
public class parcialArboles {
	public boolean esInferiorProfundo(GeneralTree<Integer> tree1, GeneralTree<Integer> tree2) {
		boolean resultado = true;
		if(tree1 != null && !tree1.isEmpty())
			if(tree2 != null && !tree2.isEmpty() && tree1.getData() < tree2.getData())
				resultado = recorrer(tree1,tree2);
			else
				resultado = false;
		return resultado;
	}
	
	private boolean recorrer(GeneralTree<Integer> tree1, GeneralTree<Integer> tree2) {
		boolean resultado = true;
		if(!tree1.isLeaf()) {
			if(tree2.isLeaf()) {
				resultado = false;
			} else {
				int sum1 = 0;
				int sum2 = 0;
				for(GeneralTree<Integer> hijo: tree1.getChildren())
					sum1 += hijo.getData();
				for(GeneralTree<Integer> hijo: tree2.getChildren())
					sum2 += hijo.getData();
				if(sum1 < sum2) {
					Iterator<GeneralTree<Integer>> it1 = tree1.getChildren().iterator();
					Iterator<GeneralTree<Integer>> it2 = tree2.getChildren().iterator();
					while(it1.hasNext() && it2.hasNext() && resultado) {
						GeneralTree<Integer> dato1 = it1.next();
						GeneralTree<Integer> dato2 = it2.next();
						if(dato1.getData() < dato2.getData()) {
							resultado = recorrer(dato1,dato2);
						} else {
							resultado = false;
						}
					}
				} else {
					resultado = false;
				}
			}
		}
		return resultado;
	}
}
