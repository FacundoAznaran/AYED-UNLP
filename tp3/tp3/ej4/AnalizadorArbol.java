package tp3.ej4;
import tp3.ejercicio1.*;
import java.util.*;
public class AnalizadorArbol {
		public double devolverMaximoPromedio(GeneralTree<AreaEmpresa>tree) {
			double max = 0;
			int cant = 0;
			int sum = 0;
			Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<GeneralTree<AreaEmpresa>>();
			cola.add(tree);
			cola.add(null);
			while(!cola.isEmpty()) {
				GeneralTree<AreaEmpresa> actual = cola.poll();
				if(actual != null) {
					cant++;
					sum += actual.getData().getN();
					for(GeneralTree<AreaEmpresa> hijo: actual.getChildren())
						cola.add(hijo);
				}
				else {
					if(max < (double)sum/cant)
						max = (double)sum/cant;
					cant = 0;
					sum = 0;
					if(!cola.isEmpty())
						cola.add(null);
				}
			}
			return max;
		}
}
