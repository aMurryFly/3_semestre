//MURRIETA VILLEGAS ALFONSO 

import java.util.Scanner;
import javax.swing.JOptionPane;

public class P_02{//Clase entradaScanner
	public static void main(String[] args){

	/*Scanner sc = new Scanner(System.in);		
	
	System.out.print("Ingresa una cadena: ");
	String cadena =sc.nextLine(); //Cadenas 
	System.out.println("Cadena: " + cadena);
	 
	System.out.print("Ingresa una entero: ");
	int entero =sc.nextInt(); //Cadenas 
	System.out.println("Cadena: " + entero);

	System.out.print("Ingresa una flotante: ");
	float flotante =sc.nextFloat(); //Cadenas 
	System.out.println("Cadena: " + flotante);*/


	String texto= JOptionPane.showInputDialog("Ingresa el texto: ");
	JOptionPane.showMessageDialog(null, texto, "title", JOptionPane.INFORMATION_MESSAGE);

	
	}
}