package tp1.ej3;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Estudiante[] alumnos = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		alumnos[0] = new Estudiante();
		alumnos[0].setApellido("castillos");
		alumnos[0].setNombre("pepe");
		alumnos[0].setEmail("pepito@gmail.com");
		alumnos[0].setComision(1);
		alumnos[0].setDireccion("calle 5");
		
		alumnos[1] = new Estudiante();
		alumnos[1].setApellido("perez");
		alumnos[1].setNombre("roberto");
		alumnos[1].setEmail("roberto@gmail.com");
		alumnos[1].setComision(3);
		alumnos[1].setDireccion("calle 911");
		
		profesores[0] = new Profesor();
		profesores[0].setApellido("torres");
		profesores[0].setNombre("juan");
		profesores[0].setEmail("juan@gmail.com");
		profesores[0].setCatedra("catedra gil");
		profesores[0].setFacultad("UNLP");
		
		profesores[1] = new Profesor();
		profesores[1].setApellido("zurita");
		profesores[1].setNombre("catarina");
		profesores[1].setEmail("catarina@gmail.com");
		profesores[1].setCatedra("catedra gil");
		profesores[1].setFacultad("UNLP");
		
		profesores[2] = new Profesor();
		profesores[2].setApellido("saracho");
		profesores[2].setNombre("pedro");
		profesores[2].setEmail("pedro@gmail.com");
		profesores[2].setCatedra("catedra cacota");
		profesores[2].setFacultad("UTN");
		
		for(int i = 0; i < 2; i++) {
			System.out.println(alumnos[i].tusDatos());
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
	
}
