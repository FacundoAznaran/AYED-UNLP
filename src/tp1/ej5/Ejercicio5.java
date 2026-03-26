package tp1.ej5;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] v = new int[5];
		v[0] = 3;
		v[1] = 10;
		v[2] = 23454;
		v[3] = -20;
		v[4] = 1;
		
		Resultado r= Calcular.conReturn(v);
		
		
		System.out.println("resultado: max " + r.getMaximo() + " min " + r.getMinimo() + " promedio " + 
		r.getPromedio());
		
		Calcular.sinReturn(v, r);
		System.out.println("resultado: max " + r.getMaximo() + " min " + r.getMinimo() + " promedio " + 
				r.getPromedio());
		
		Calcular c = new Calcular(v);
		c.sinNada();
		System.out.println("resultado: max " + c.getMax() + " min " + c.getMin() + " promedio " + 
				c.getPromedio());
	}

}
