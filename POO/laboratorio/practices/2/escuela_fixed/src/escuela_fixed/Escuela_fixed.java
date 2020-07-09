
package escuela_fixed;
import java.util.Scanner;

public class Escuela_fixed {//METODO 

    public static void main(String[] args) {
        
        Alumno student1 = new Alumno();
	Scanner sc = new Scanner(System.in);	

	student1.setNumCuenta(31506933);
	student1.setCarrera("Software Engineer");
        student1.setNombreM("POO");//Nombre de la materia

        
        //Impresión
        System.out.println("Número Cuenta: "+student1.getNumCuenta());
        System.out.println("Carrera: "+student1.getCarrera());
       	System.out.println("Materia: "+student1.getNombreM());


    }
    
}


