public class PruebaClaseAbstracta{

	public static void main(String[] args) {
		Punto punto = new Punto( 7, 11 );
		Circulo circulo = new Circulo( 22, 8, 3.5 );
		Cilindro cilindro = new Cilindro( 20, 30, 3.3, 10.75 );
	

		Figura figuras[] = new Figura[3];
		figuras[0] = punto;
		figuras[1] = circulo;
		figuras[2] = cilindro;

		String calculos="";
		
		for (int i=0; i<figuras.length; i++ ) {
			calculos += "\n" + figuras[i].obtenerNombre() + ": " + figuras[i].describir() + "\n" +
						"Area = " + figuras[i].obtenerArea() + "\n" +
						"Volumen =  " + figuras[i].obtenerVolumen() + "\n";		
		}
				  

		System.out.println(calculos);

	}
}