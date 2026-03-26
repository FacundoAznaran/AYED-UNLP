package tp1.ej5;

public class Calcular {
	private int max;
	private int min;
	private double promedio;
	private int[] v;
	
	
	
	public Calcular(int[] v) {
		this.v = v;
	}

	public static Resultado conReturn(int [] v) {
		Resultado resultado = new Resultado();
		int max = v[0];
		int min = v[0];
		int cant = 0;
		for(int i = 0; i < v.length; i++){
			if(max < v[i])
				max = v[i];
			
			if(min > v[i])
				min = v[i];
				
			cant += v[i];
		}
		resultado.setMaximo(max);
		resultado.setMinimo(min);
		resultado.setPromedio((double)cant/v.length);
		return resultado;
	}
	
	public static void sinReturn(int [] v, Resultado resultado) {
		int max = v[0];
		int min = v[0];
		int cant = 0;
		for(int i = 0; i < v.length; i++){
			if(max < v[i])
				max = v[i];
			
			if(min > v[i])
				min = v[i];
				
			cant += v[i];
		}
		resultado.setMaximo(max);
		resultado.setMinimo(min);
		resultado.setPromedio((double)cant/v.length);
	}
	
	
	

	
	public void sinNada() {
		int max = v[0];
		int min = v[0];
		int cant = 0;
		for(int i = 0; i < v.length; i++){
			if(max < v[i])
				max = v[i];
			
			if(min > v[i])
				min = v[i];
				
			cant += v[i];
		}
		setMax(max);
		setMin(min);
		setPromedio((double)cant/v.length);
	}

	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public int[] getV() {
		return v;
	}

	public void setV(int[] v) {
		this.v = v;
	}
	
	
}
