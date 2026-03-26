package tp1.ej1;

public class MetodosDeImpresion {
	
	public static void impresionFor(int a, int b) {
		for(int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void impresionWhile(int a, int b) {
		int i = a;
		while(i <= b) {
			System.out.println(i);
			i++;
		}
	}
	public static void impresionRecursiva(int a, int b) {
		if(a <= b) {
			System.out.println(a);
			impresionRecursiva(a + 1, b);
		}
		
	}
}
