//Code Alfonso Murrieta Villegas 

public class P_03{	//Agumentos a main 					

	public static void main(String[] args){ //String es una clase en este caso 	

		int size = args.length;
		float suma=0, promedio=0;

		for(int i=0;i<size;i++){
			suma +=Float.parseFloat(args[i]);
		}

		promedio=suma/size;

		System.out.println("El promedio es: " + promedio );

	}
}