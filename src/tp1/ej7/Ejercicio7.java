package tp1.ej7;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio7 {
	
	public static void crearLista() {
		List<Estudiante> lista = new ArrayList<Estudiante>(3);
		Estudiante e1 = new Estudiante(1,"pepe");
		Estudiante e2 = new Estudiante(2,"juan");
		Estudiante e3 = new Estudiante(3,"roberto");
		lista.add(e1);
		lista.add(e2);
		lista.add(e3);
		
		List<Estudiante> lista2 = new ArrayList<>(lista);
		System.out.println("---------lista 1---------");
		for(Estudiante e: lista) {
			System.out.println(e.getNombre());
		}
		System.out.println("---------lista 2---------");
		for(Estudiante e: lista2) {
			System.out.println(e.getNombre());
		}
		lista.get(0).setNombre("adglñagsdflkads");
		
		System.out.println("---------lista 1---------");
		for(Estudiante e: lista) {
			System.out.println(e.getNombre());
		}
		System.out.println("---------lista 2---------");
		for(Estudiante e: lista2) {
			System.out.println(e.getNombre());
		}
	}
	
	public static boolean esCapicua(List<Integer>lista) {
		boolean aux = true;
		for(int i = 0; i < lista.size()/2; i++) {
			if(!lista.get(i).equals(lista.get(lista.size()-i-1))) {
				aux = false;
				break;
			}
		}
		return aux;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		List<Integer> lista = new ArrayList<Integer>(10);
		System.out.println("ingrese un numero (0 para terminar)");
		int n = s.nextInt();
		while(n != 0) {
			lista.add(n);
			n = s.nextInt();
		}
		System.out.println("contenido de la lista: ");
		for(Integer x: lista) {
			System.out.println(x);
		}
		
		
		//crearLista();
		System.out.println("es capicua?: " + esCapicua(lista));
		
		
		s.close();
	}

}
