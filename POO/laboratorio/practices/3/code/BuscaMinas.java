import java.util.*;
class BuscaMinas{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int puntos=0;
		String letra;
		Hashtable<String, String> tablero = new Hashtable<String, String>();
		int cont;
		String casillas[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","t","u","v","w","x","y","z"};

		for (int i=0; i<casillas.length; i++ )
			tablero.put(casillas[i], casillas[i]);

		HashSet<String> minas = generarPuntoMinas(3,casillas);

		do{
			imprimirTablero(tablero);
			System.out.print("\nSelecciona la letra (s para salir):_");
			letra = sc.next();
			if(letra.equals("s"))
				continue;
			letra = descubrirContenido(letra,tablero,minas);
			System.out.print("Puntos: " + puntos);

			puntos++;

		}while( !letra.equals("s") );

	}

	public static void imprimirTablero(Hashtable<String,String> tablero){

		System.out.print("\n\033\043");
		ArrayList<String> listaLlaves = new ArrayList<String>(tablero.keySet());
		Collections.sort(listaLlaves);

		int i=1;
		for(String llave : listaLlaves){
			System.out.print("\t"+tablero.get(llave));
			if( (i%5)==0 )
				System.out.print("\n\n");
			i++;
		}

	}

	public static String descubrirContenido(String letra,Hashtable<String,String> tablero, HashSet<String> minas){
		if(minas.contains(letra)){
			tablero.put(letra,"X");
			imprimirTablero(tablero);
			System.out.println("BOMBA");
			System.out.print("\n"+minas);

		}else{

			tablero.put(letra,"0");

		}
		return letra;
	}

	public static HashSet<String> generarPuntoMinas(int cant, String casillas[]){
		
		int rand;
		HashSet<String> minas= new HashSet<String>();
		for(int i= 0; i< cant; i++){
			rand = (int) Math.round(Math.random()*casillas.length);
			minas.add(casillas[rand]);
		}
		
		return minas;


	}

}