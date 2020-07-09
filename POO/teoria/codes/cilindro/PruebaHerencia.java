public class PruebaHerencia{

	public static void main(String[] args) {
		Punto punto = new Punto( 7, 11 );
		Circulo circulo = new Circulo( 22, 8, 3.5 );
		Cilindro cilindro = new Cilindro( 20, 30, 3.3, 10.75 );
	

	String descripcion = punto.obtenerNombre() + ": " + punto.describir() + "\n" +
						 circulo.obtenerNombre() + ": " + circulo.describir() + "\n" +
						 cilindro.obtenerNombre() + ": " + cilindro.describir() + "\n";


	System.out.println(descripcion);
	}

}