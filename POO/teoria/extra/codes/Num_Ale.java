//MURRIETA VILLEGAS ALFONSO

import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;//Opción alternativa a random de util
import java.util.Random;

public class Num_Ale{
	public static void main(String[] args){
		
		//Objetos
		Scanner sc = new Scanner(System.in);	
		Random rd = new Random();

		//Variables
		int limit1, limit2,linea,asiento;//Limites
		String condition;
		String restriccion = "A";

		System.out.println("Generador de number aleatorios\n");


		do{
			System.out.print("Number arriba de 0: \n\n");
			System.out.print("Input the number of sillas*:_");
			limit1 = sc.nextInt();//+1;
			System.out.print("Input the number of filas*:_");
			limit2 = sc.nextInt();

			System.out.println("\n_______________________________\n");
	
			//Variables 
			linea= rd.nextInt(limit1)+1;//Número aleatorio linea
			asiento= rd.nextInt(limit2)+1;//Número aleatorio asiento

			//linea = ThreadLocalRandom.current().nextInt(1, limit1 + 1);
			//asiento= ThreadLocalRandom.current().nextInt(1, limit2 + 1);

			System.out.println("Estudiante seleccionado: ");
			System.out.println("Linea: "+ linea + ", Asiento: " + asiento);

			System.out.println("\n _______________________________");

			System.out.println("Presione A para proporcionar otro lugar aleatorio, o S para salir");
			System.out.println("[Letras mayu*sculas]");
			condition = sc.next();
			//System.out.println(condition);//Solo fue para prueba
		}while(restriccion.equals(condition));

			 

		sc.close();
	}
}
