package empresa;

import personal.Empleado;
import personal.Gerente;//Importa el gerente 

public class Empresa {

    public static void main(String[] args){
        Gerente gerente= new Gerente(20,1,"Alfonso",20000);
        System.out.println(gerente);
        //Para que envie la información de ambos
        
        //Identificación de la instancia
        if (gerente instanceof Gerente){
            System.out.println("Instancia de gerente");
        }
        
        if (gerente instanceof Empleado){
            System.out.println("Instancia de Empleado");
        }
        
        if (gerente instanceof Object){
            System.out.println("Instancia de un objeto");
        }
        
    }
    
}
