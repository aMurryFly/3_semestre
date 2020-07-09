package practica5.murrietaalfonso;
import java.util.*;

public class Practica5MurrietaAlfonso {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("TRANSFORMACIÓN POR LLAVES");
        System.out.println("Escoja alguna de las opciones siguientes:");
        
        do{    
            System.out.println("[1] Hash-modulo [2]Encadenamiento [3] Hash-Tables [4]SALIR ");
            opc = sc.nextInt();
            
            switch (opc) {
                case 1:
                    Hash_Modulo hash = new Hash_Modulo();
                    hash.menu();
                    break;

                case 2:
                    Encadenamiento hashT = new Encadenamiento();
                    hashT.menu();
                    break; 

                case 3:
                    Hash_Table table = new Hash_Table();
                    table.menu();
                    
                    break; 
                case 4:
                        System.out.println("See you :)");
                    break;
                    
                default:
                    System.out.println("Choose other option");

            }
        }while(opc != 4);
    }
    
}
