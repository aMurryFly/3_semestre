package murrieta_reza_valdespino_equipo2_g5_proyecto2;
import java.util.Scanner;

public class Murrieta_Reza_Valdespino_Equipo2_G5_Proyecto2 {
    public static void main(String[] args) {
        int op,op2;
        int valor;
        Scanner sc=new Scanner(System.in);
        
        
        
        
        System.out.println("PROYECTO 2: ÁRBOLES BINARIOS");
        do{
            System.out.println("\tIngrese el árbol con el que desea trabajar");
            System.out.print("\t1)Arboles Binarios de búsqueda\n\t2)Heaps\n\t3)Expresiones aritméticas\n\t4)Salir\n\tOpción: ");
            op=sc.nextInt();
            switch(op){
                case 1:
                    searchTree p=new searchTree();
                    do{
                        System.out.println("\n\n\t->Árboles Binarios de búsqueda");
                        System.out.print("\n\t1)Agregar\n\t2)Buscar\n\t3)Eliminar\n\t4)Mostrar árbol\n\t5)Salir\n\tOpción: ");
                        op2=sc.nextInt();
                        switch(op2){
                            case 1:
                                System.out.print("\n\tAgregar");
                                System.out.print("\n\tIngrese el valor que deseé agregar al árbol binario de búsqueda: ");
                                valor=sc.nextInt();
                                if(p.root!=null){
                                    p.agregar(valor);
                                }else{
                                    //Mensaje si se encuentra vacio y se agrega la raíz
                                    System.out.println("\t\tNodo raíz: "+valor);
                                    p=new searchTree(valor);
                                }
                                
                                break;
                            case 2:
                                System.out.print("\n\tBuscar");
                                System.out.print("\n\tIngrese el valor que deseé buscar al árbol binario de búsqueda: ");
                                valor=sc.nextInt();
                                p.busqueda(valor);
                                break;
                            case 3:
                                System.out.print("\n\tEliminar");
                                System.out.print("\n\tIngrese el valor que deseé buscar al árbol binario de búsqueda: ");
                                valor=sc.nextInt();
                                p.eliminarUtil(valor);
                                break;
                            case 4:
                                System.out.print("\n\tMostrar árbol\n");
                                if(p.root!=null){
                                    p.imprimir();
                                }else{
                                    //Mensaje si se encuentra vacia
                                    System.out.println("\t\tÁrbol vacío"); 
                                }
                                break;
                            case 5:
                                System.out.print("\n\tHa salido de la opción de árboles binarios de búsqueda\n");
                                break;
                            default:
                                System.out.print("Opción no válida");
                                break;
                        }
                    }while(op2!=5);
                    break;
                case 2:
                    Heap heap= new Heap();
                    do{
                        System.out.println("\n\n\t->Heaps");
                        System.out.print("\n\t1)Agregar Nodo\n\t2)Eliminar Raíz\n\t3)Mostrar árbol\n\t4)Salir\n\tOpción: ");
                        op2=sc.nextInt();
                        switch(op2){
                            case 1:
                                System.out.print("\n\tAgregar nodo");
                                System.out.print("\n\tIngrese el valor que deseé agregar al heap: ");
                                valor=sc.nextInt();
                                heap.add(valor);
                                
                                break;
                            case 2:
                                System.out.println("\n\tEliminar raíz");
                                
                                if(heap.raiz!=null){
                                    heap.deleteRoot();
                                }else{
                                    //Mensaje si se encuentra vacia
                                    System.out.println("El heap se encuentra vacío.");
                                }
                                break;
                            case 3:
                                System.out.println("\n\tMostrar árbol");
                                if(heap.raiz!=null){
                                    heap.printHeap();
                                }else{
                                    //Mensaje si se encuentra vacia
                                    System.out.println("heap vacío.");
                                }
                                break;
                            case 4:
                                System.out.print("Ha salido de la opción de Heaps\n");
                                break;
                            default:
                                System.out.print("Opción no válida");
                                break;
                                  
                        }
                    }while(op2!=4);
                    
                    break;
                case 3:
                    arbolExpression arbol_1= new arbolExpression();
                    do{
                        System.out.println("\n\n\t->Árboles de expresiones aritméticas");
                        System.out.print("\n\t1)Ingresar expresión y resolver\n\t2)Mostrar árbol\n\t3)Salir\n\tOpción: ");
                        op2=sc.nextInt();
                        
                        
                        switch(op2){
                            case 1:
                                System.out.println("\n\tIngresar expresión"); 
                                System.out.print("\n\tIngrese la cadena de la operación\n\tExpresión:  ");
                                String expression=sc.next();
                                arbol_1= new arbolExpression(expression);
                                break;
                            case 2:
                                System.out.print("\n\tMostrar árbol");
                                arbol_1.recorrido();
                                break;
                            case 3:
                                System.out.print("\n\tHa salido de la opción de árboles de expresiones aritméticas\n");
                                break;
                            default:
                                System.out.print("\n\tOpción no válida");
                                break;
                                
                        
                        }
                    }while(op2!=3);
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa. Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        
        }while(op!=4);
        
    }
    
}
