package tp1.ej7;

public class Estudiante {
	private int legajo;
	private String nombre;
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Estudiante(int legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
	}
	
	
}
