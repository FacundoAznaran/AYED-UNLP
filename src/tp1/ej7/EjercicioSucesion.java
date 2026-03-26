package tp1.ej7;
import java.util.List;
import java.util.ArrayList;
public class EjercicioSucesion {
	
	public List<Integer> calcularSucesion(int n){
		List <Integer> lista;
		if(n == 1) {
			lista = new ArrayList<Integer>();
		}
		else {
			if(n%2 == 0) {
				lista = calcularSucesion(n/2);
			}
			else {
				lista = calcularSucesion(3*n+1);
			}
		}
		lista.add(0,n);
		return lista;
}
	public void invertir(List<Integer> lista){
		if(lista.size() <= 1) {
		}
		else {
			Integer n = lista.remove(0);
			invertir(lista);
			lista.add(n);
		}
	}
	
	public int sumarLista(ArrayList<Integer> lista) {
	    int suma = 0;
	    if (lista.size() <= 1) {
	        // Si la lista está vacía, get(0) daría error, 
	        // pero como asumimos que no viene vacía, esto funciona:
	        suma = (lista.isEmpty()) ? 0 : lista.get(0);
	    }
	    else {
	        Integer n = lista.remove(0);
	        // Enganchamos el número actual con el resultado de la "pila"
	        suma = n + sumarLista(lista); 
	        // IMPORTANTE: Lo devolvemos al principio para no desordenar
	        lista.add(0, n); 
	    }
	    return suma;
	}
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
	    ArrayList<Integer> resultado = new ArrayList<Integer>(lista1.size() + lista2.size());
	    int i = 0, j = 0;

	    // 1. El duelo principal (Mientras AMBAS tengan elementos)
	    while (i < lista1.size() && j < lista2.size()) {
	        if (lista1.get(i) < lista2.get(j)) {
	            resultado.add(lista1.get(i));
	            i++;
	        } else {
	            resultado.add(lista2.get(j));
	            j++;
	        }
	    }

	    // 2. Barredora de lista 1 (Si sobraron elementos en lista 1)
	    // CAMBIO: i < lista1.size()
	    while (i < lista1.size()) { 
	        resultado.add(lista1.get(i));
	        i++;
	    }

	    // 3. Barredora de lista 2 (Si sobraron elementos en lista 2)
	    // CAMBIO: j < lista2.size()
	    while (j < lista2.size()) { 
	        resultado.add(lista2.get(j));
	        j++;
	    }

	    return resultado;
	}
}