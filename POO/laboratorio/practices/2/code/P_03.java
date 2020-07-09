//MURRIETA VILLEGAS ALFONSO 

import java.util.Scanner;
//import javax.swing.JOptionPane;

public class P_03{//Figuras Geométricas
	public static void main(String[] args){

		float area = 0f;//Es para indicar que es un flotant;
		float peri = 0f;
		//Para un long se necesita una l 
		//Solo existen 2 casos el float y long 

		int option;

		//Declaración de constante
		final float pi = 3.141592f;//Final es que siempre es el mismo 

		//Si es estática lo que menciona es que no requiero de un objeto para cambiarla
		Scanner sc = new Scanner(System.in);

		do{
			System.out.println("\n Choose an option");
			System.out.println("[1] Cicle | [2] Triangule | [3] Square | [4] Terminar");
			option= sc.nextInt();

			switch(option){
				case 1:
					System.out.println("CIRCLE ");
					System.out.print("Ingresa radio: ");
					float radio= sc.nextFloat();
					peri= pi*(radio*2);
					area= (radio*radio)*pi;
					//area= pi * Math.pow(radio,2);
					break;

				case 2:
					System.out.println("Triangule Equilatero");
					System.out.print("Ingresa base: ");
					float base= sc.nextFloat();
					System.out.print("Ingresa altura: ");
					float altura= sc.nextFloat();
					peri= base*3;
					area= (base*altura)/2;

					break;
				
				case 3:
					System.out.println("Square ");
					System.out.print("Ingresa base: ");
					float baseC= sc.nextFloat();
					peri= baseC*4;
					area= baseC*baseC;

					break;

				case 4:
					System.out.println("Bye usuario ");
				continue;//Es algo parecido a el break

				default:
					System.out.println("Option no valid");
					continue;
	
			}
			System.out.println("The area is: " + area);
			System.out.println("The perimetro is: " + peri);


		}while(option!=4);

	sc.close();
	}
}