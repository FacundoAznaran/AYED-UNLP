package tp1.ej2;
import java.util.Scanner;
public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("ingrese el numero");
		int x = s.nextInt();
		int [] v = CrearVector.crear(x);
		for (int i = 0; i < x; i++) {
			System.out.println(v[i]);
		s.close();
		}
	}

}
