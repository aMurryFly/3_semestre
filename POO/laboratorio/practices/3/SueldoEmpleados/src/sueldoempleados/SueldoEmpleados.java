//Murrieta Villegas Alfonso
//Code fixed by murry_fly (Nickname)

package sueldoempleados;

import java.util.*;

public class SueldoEmpleados {

    public static void main(String[] args) {
        
        //Objetos
        Scanner sc = new Scanner(System.in);
        String[] empleados = new String[3];

        //Variables 
        double[] sueldos = new double[3];
        String nombreMayor="";//No fue inicializado el string
        double mayorSueldo=0;//Tampoco fue inicializada 
        
        System.out.println("Escriba lo nombres y sueldos de empleados: ");
        
        for (int i = 0; i < empleados.length; i++){
            System.out.print("Empleado " + (i + 1) + ": ");
            empleados[i] = sc.nextLine();
            System.out.print("Sueldo: ");
            sueldos[i] = sc.nextDouble();

            if(i==0){
                mayorSueldo = sueldos[i];
                nombreMayor = empleados[i];
            }else if (sueldos[i] > mayorSueldo) {
                mayorSueldo = sueldos[i];
                nombreMayor = empleados[i];
            }
            sc.nextLine();//Sirve para limpiar el buffer
        }
        
        
        
        System.out.println("\nEmpleado con mayor sueldo es: " + nombreMayor );
        System.out.println("Su sueldo es : " + mayorSueldo);
        sc.close();//Cerrar el scanner
    }
}
