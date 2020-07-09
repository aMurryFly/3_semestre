package practica5.murrietaalfonso;

import java.util.*;

public class Hash_Table {
    
    public void menu() {

        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        
        System.out.println("HASH TABLE - JAVA");
        int opc=0;

        do{
            System.out.println("Escoja alguna de las opciones siguientes:");
            System.out.println("1] Agregar elemento 2]Imprimir /Buscar Lista 3]Eliminar Elemento 4]SALIR ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Insertar llave: ");
                    int key =sc.nextInt();
                    System.out.println("Valor de la llave: ");
                    int value =sc.nextInt();
                    hash.put(key, value);
                    System.out.println("Método get(Inserte valor): ");
                    int valor1 =sc.nextInt();
                    System.out.println(hash.get(valor1));
                    break;

                case 2:
                    System.out.println("La cantidad de llaves es: " +hash.size() );
                    System.out.println(hash);
                    System.out.println("Buscar llave: ");
                    int llave =sc.nextInt();
                    System.out.println(hash.containsKey(llave));
                    System.out.println("Buscar valor: ");
                    int valor =sc.nextInt();
                    System.out.println(hash.contains(valor));
                    System.out.println("Buscar valor: ");
                    int value1 =sc.nextInt();
                    System.out.println(hash.contains(value1));
                    break; 

                case 3:
                    System.out.println("Eliminar elemento (key): ");
                    int delate =sc.nextInt();
                    hash.remove(delate);
                        
                    break;  
                    
                case 4:
                      System.out.println("MENU->");  
                    break;    
                    
                default:
                    System.out.println("\nEscriba una opción válida\n\n");
            }
   
        }while(opc != 4);

    }
    
    
    
}
