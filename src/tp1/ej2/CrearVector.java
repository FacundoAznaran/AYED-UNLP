package tp1.ej2;

public class CrearVector {
	public static int[] crear (int x){
		int[] v = new int[x];
		for(int i = 0; i < x; i++) {
			v[i] = x * (i+1);
		}
		return v;
	}
}
