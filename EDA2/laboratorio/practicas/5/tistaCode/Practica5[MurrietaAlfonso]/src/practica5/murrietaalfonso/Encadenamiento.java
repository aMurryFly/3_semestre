
package practica5.murrietaalfonso;

import static java.lang.Math.random;
import java.util.*;
//NOTA LA FUNCIÓN ALEATORIA SE HACE A TRAVÉS DEL RANDOM DE MATH EN JAVA

public class Encadenamiento {
    
        //Variable global
	ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>(15);
        //Lista de listas 
        
	public void menu(){
             
            Scanner sc = new Scanner(System.in);
            int opc;
            System.out.println("ENCADENAMIENTO");
            
            //LLenamos el Arraylist de Arrays -List
            for (int i = 0; i < 15 ; i++) {
		lista.add(new ArrayList<Integer>());
            }
            
            do{
            System.out.println("Escoja alguna de las opciones siguientes:");
            System.out.println("1] Agregar elemento 2]Imprimir Lista 3]SALIR ");
            opc = sc.nextInt();

                switch (opc) {
                    case 1:
                            System.out.println("AGREGAR ELEMENTO: ");
                            System.out.println("Ingrese la llave: ");
                            int num = sc.nextInt();
                            System.out.println(agregarElemento(num));
                        break;

                    case 2:
                            System.out.println("IMPRESIÓN LISTA");
                            printList();
                        break; 

                    case 3:
                            System.out.println("MENU->");  
                        break;    

                    default:
                        System.out.println("\nEscriba una opción válida\n\n");
                }

            }while(opc != 3);
            
            
            
            
	}

	public void printList(){
            for (int i = 0; i < lista.size(); i++){
            	System.out.println("Lista " + (i+1) + ": " + lista.get(i));
            }
	}

	public String  agregarElemento(int num){
            int index = (int) (random() *14);//la parte aleatoria está en el random
            lista.get(index).add(num);
            return "Lista encadenada: " + (index + 1) + " Elemento: " + lista.get(index).size();//cadena con todos los datos
	}
}
