package tp3.ej2;
import java.util.*;
import tp3.ejercicio1.*;
public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer>a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		if(a != null && !a.isEmpty()) {
			recorridoPreOrden(resultado,a,n);
		}
		return resultado;
	}
	
	static private void recorridoPreOrden(List<Integer> resultado,GeneralTree<Integer>a ,Integer n){
		if(a.getData() > n && (a.getData()%2) != 0) 
			resultado.add(a.getData());
		/*
		 version simplificada
		 for(GeneralTree<Integer> hijo: a.getChildren)
		 	recorridoPreOrden(resultado,hijo,n);z
		 */
		if(a.hasChildren()) {
			List<GeneralTree<Integer>> hijos = a.getChildren();
			Iterator<GeneralTree<Integer>> it = hijos.iterator();
			while(it.hasNext()) 
				recorridoPreOrden(resultado,it.next(),n);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer>a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		if(a != null && !a.isEmpty())
				recorridoInOrden(resultado,a,n);
		return resultado;
	}
	
	static private void recorridoInOrden(List<Integer>resultado ,GeneralTree<Integer>a,Integer n) {
		Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
		if(it.hasNext())
			recorridoInOrden(resultado,it.next(),n);
		if(a.getData() > n && (a.getData()%2) != 0)
			resultado.add(a.getData());
		while(it.hasNext())
			recorridoInOrden(resultado,it.next(),n);
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer>a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		if(a != null && !a.isEmpty())
				recorridoPostOrden(resultado,a,n);
		return resultado;
	}
	
	static private void recorridoPostOrden(List<Integer> resultado,GeneralTree<Integer>a,Integer n) {
		for(GeneralTree<Integer> hijo: a.getChildren()) {
			recorridoPostOrden(resultado,hijo,n);
		}
		if(a.getData() > n && (a.getData()%2) != 0)
			resultado.add(a.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer>a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> cola = new LinkedList<GeneralTree<Integer>>();
		if(a != null && !a.isEmpty()) {
			cola.add(a);
			while(!cola.isEmpty()) {
				GeneralTree<Integer> actual = cola.poll();
				if(actual.getData() > n && (actual.getData()%2)!=0)
					resultado.add(actual.getData());
				for(GeneralTree<Integer>hijo: actual.getChildren())
					cola.add(hijo);
			}
		}
		return resultado;
	}
	
	
}
