/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.Scanner;

/**
 *
 * @author edaII05alu36
 */
public class Practica9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        int num;
        arbolB b = new arbolB(5);
      
        
        for (int i = 1; i < 32; i++) {
            b.agregar(i);
        }
        System.out.println("");
        b.imprimir(b.raiz);
        
        System.out.println(b.Buscar(b.raiz, 11));
        System.out.println(b.Buscar(b.raiz, 100));
        
       
        while (opcion!=4) {
        System.out.println("1-insercion \n 2-impresion \n 3-busqueda \4-salir");
        System.out.print("elija la opcion: "); 
        opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("insercion");
                    System.out.print("ingrese el numero: ");
                    num=sc.nextInt();
                    b.agregar(num);
                    break;
                
                case 2:
                    System.out.println("impresion");
                    b.imprimir(b.raiz);
                    break;
                
                case 3:
                    System.out.println("busqueda");
                    System.out.print("ingrese el numero: ");
                    num=sc.nextInt();
                    b.Buscar(b.raiz, num);
                    break;
                    
                case 4:
                    System.out.println("saliste");
                    break;
                    
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        
        }
        
        
    }
    
}
