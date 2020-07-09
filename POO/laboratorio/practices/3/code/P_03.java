//MURRIETA VILLEGAS ALFONSO 

import java.util.*;

public class P_03{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String letra;
		Hashtable <String, String> tablero = new Hashtable <String, String>();

		String casillas[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","t","u","v","w","x","y","z"};
		//s es para salir

		for(int =0; i< casillas.length; i++ ){
			tablero.put(casillas[i],casillas[i]);
		}


		Hashset <String> minas = new Hashset <String>(Arrays.asList("a","e","i","o","u"));

		do{
			imprimirTablero(tablero);
			System.out.println("Selecciona la letra (s para salir)");
			letra = sc.next();

			if(letra.equals("s")){
				continue;
			}



		}while(!letra.equals("s"));

		
		}

	public static void imprimirTablero(Hashtable<String,String> _tablero){
		System.out.println("\n");
		ArrayList <String> listaLlaves = new ArrayList <String>(tablero.keySet());
		Collections.sort(listaLlaves);//Para ordenar el arreglo

		int i = 1;

		for(String llave: listaLlaves){
			System.out.print("\n"+tablero.get(llave));

			if((i%5)==0){
				System.out.println("\n\n");
				i++;
			}

		}

	}	



}