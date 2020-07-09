//MURRIETA VILLEGAS ALFONSO 

import java.util.Scanner;

public class P_01{//Clase entradaScanner
	public static void main(String[] args){

	//	FORMA 1 - SIN IMPORT

	 //java.util.Scanner sc = new java.util.Scanner(System.in);

	Scanner sc = new Scanner(System.in);		
	
	 System.out.print("Ingresa una cadena: ");
	 String cadena =sc.nextLine(); //Cadenas 
	 System.out.println("Cadena: " + cadena);
	 
	 System.out.print("Ingresa una entero: ");
	 int entero =sc.nextInt(); //Cadenas 
	 System.out.println("Cadena: " + entero);

	 System.out.print("Ingresa una flotante: ");
	 float flotante =sc.nextFloat(); //Cadenas 
	 System.out.println("Cadena: " + flotante);

	
	}
}