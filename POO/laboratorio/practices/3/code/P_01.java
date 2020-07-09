//MURRIETA VILLEGAS ALFONSO 

import java.util.*;//Sirve para el arraylist

public class P_01{
	public static void main(String[] args){

	String cadena = "Hola";
	System.out.println(cadena);
	System.out.println("Tamano: "+cadena.length());					// Es más tamaño 
	System.out.println("En mayuscula¨* :  "+cadena.toUpperCase());  // Vuelve mayúsculas

	StringBuilder ab = new StringBuilder(cadena);
	System.out.println("Adjuntar " + ab.append(" EXTRA"));
	}
}