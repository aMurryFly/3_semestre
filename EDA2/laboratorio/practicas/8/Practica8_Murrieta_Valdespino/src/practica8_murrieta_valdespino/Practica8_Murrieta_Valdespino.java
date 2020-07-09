/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8_murrieta_valdespino;

import java.util.Scanner;

/**
 *
 * @author Murrieta
 */
public class Practica8_Murrieta_Valdespino {


    public static void main(String[] args) {
        
        //ACTIVIDAD 1
        
        System.out.println("BINARY TREE");
	ArbolBin arbol;
        
	Nodo n7=new Nodo(7);
	Nodo n9=new Nodo(9);
	Nodo n1=new Nodo(1,n7,n9);
	Nodo n15=new Nodo(15);
	Nodo n8=new Nodo(8);
	Nodo n4=new Nodo(4);
	Nodo n2=new Nodo(2);
	Nodo n16=new Nodo(16);
	Nodo n3=new Nodo(3);
        
	arbol=new ArbolBin(n1);
	arbol.add(n7,n15,0);
	arbol.add(n7,n8,1);
	arbol.add(n9,n4,0);
	arbol.add(n9,n2,1);
	arbol.add(n15,n16,1);
	arbol.add(n8,n3,0);
        arbol.breadthFirst();
        System.out.println("BÚSQUEDA: "+arbol.busqueda(8) );
        System.out.println("RECORRIDOS: ");
        arbol.preorden();
        arbol.inorden();
        arbol.postorden();
        
        //ACTIVIDAD 4
        System.out.println("SEARCH BINARY THREE");
        Nodo n17=new Nodo(17);
        Nodo n10=new Nodo(10);
	Nodo n11=new Nodo(11);
	Nodo n12=new Nodo(12);
        Nodo n13=new Nodo(13);
	Nodo n14=new Nodo(14);
        Nodo n19=new Nodo(19);
       
        searchBinaryThree arbol1 = new searchBinaryThree(n17);
     
        arbol1.add(n12);
        arbol1.add(n19);
        arbol1.add(n10);
        arbol1.add(n14);
        arbol1.add(n11);
        arbol1.add(n13); 
        arbol1.breadthFirst();
                
       
        System.out.println("NODOS: "+arbol1.numNodos()+ " ALTURA: "+arbol1.altura() + " BALANCEADO: " +arbol1.Balanceado());
        arbol1.eliminar(22);//BORRAMOS
        arbol1.breadthFirst();

        //ACTIVIDAD 2 Y 3 
        mainALT();

    }
    
    
    static void mainALT(){
        //VARIABLES
        int op,op2,valor,aux;
        Nodo n1, n2,n3;
        Scanner sc= new Scanner(System.in);
        System.out.println("[MENU]\n");
        
        
        
        do{
            System.out.println("1]Árbol Binario\n2]Árbol Binario de búsqueda\n3]Salir");
            System.out.println("INGRESE OPCIÓN:");
            op=sc.nextInt();
            
            switch (op) {
                case 1:
                    ArbolBin arbol= new ArbolBin();
                    do{
                        System.out.println("BINARY TREE");
                        
                        System.out.println("1]Agregar\n2]BFS\n3]Notación prefija\n4]Notación Infija\n5]otación Posfija\n6]Salir");
                        System.out.println("INGRESE OPCIÓN:");
                        op2=sc.nextInt();
                        switch (op2) {
                            case 1:
                                System.out.println("[AGREGAR]");
                                System.out.println("INGRESE NODO:");
                                valor=sc.nextInt();

                                if(arbol.root!=null){
                                    System.out.println("IZQUIERDA 0 / DERECHA 1");
                                    aux=sc.nextInt();
                                    arbol.add(aux,new Nodo(valor),arbol.root);
  

                                }else{
                                    arbol=new ArbolBin(valor);
                                }
                                break;
                            case 2:
                                System.out.println("BFS");
                                arbol.breadthFirst();
                                break;
                            case 3:
                                arbol.preordenUTIL(arbol.root);
                                break;
                            case 4:
                                arbol.inordenUTIL(arbol.root);
                                break;
                            case 5:
                                arbol.postordenUTIL(arbol.root);
                                break;
                            case 6:
                                System.out.println("---->");
                                break;
                            default:
                                System.out.println("INVALID");
                        }
                    }while(op2!=6);
                    break;
                    
                case 2:
                     searchBinaryThree arbolBT= new searchBinaryThree();
                    do{
                        System.out.println("SEARCH BINARY THREE");
                        System.out.println("1]Agregar\n2]Eliminar\n3]Buscar\n4]BFS\n5]Salir");
                        System.out.println("INGRESE OPCIÓN:");
                        op2=sc.nextInt();

                        switch (op2) {
                            
                            case 1:
                                System.out.println("[AGREGAR]");
                                System.out.println("INGRESE NODO:");
                                valor=sc.nextInt();
        
                                if(arbolBT.root!=null){                                  
                                    arbolBT.add(new Nodo(valor));  
                                }else{
                                    arbolBT=new searchBinaryThree(valor);
                                }
                                break;
                           
                            case 2:
                                System.out.println("[BORRAR]");
                                    if(arbolBT.root!=null){
                                        System.out.println("INGRESE NODO:");
                                        valor=sc.nextInt();
                                        arbolBT.eliminar(valor);

                                    }else{
                                        System.out.println("IS EMPTY");
                                    }
                                break;
                                
                            case 3:
                                System.out.println("[BUSCAR]");
                                System.out.println("INGRESE NODO:");
                                valor=sc.nextInt();
                                if(arbolBT.busqueda(valor)){
                                   System.out.println("NODO: "+valor+" si existe"); 
                                }else{
                                    System.out.println("NODO: "+valor+" no existe"); 
                                }                   
                                break;
                                
                            case 4:
                                System.out.println("BFS");
                                arbolBT.breadthFirst();                               
                                break;
                                
                            case 5:
                                System.out.println("---->");
                                break;
                                
                            default:
                                System.out.println("INVALID");
                        }
                    }while(op2!=5);
                    break;
                    
                case 3:
                    System.out.println("---->");
                default:
                    System.out.println("INVALID");
            }
            
            
        
        }while(op!=3);
    
    
    }
}
