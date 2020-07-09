public class Cilindro extends Circulo{
	
	private double altura;

	public Cilindro( int x, int y, double radio, double valorAltura ){
		super( x, y, radio );
		establecerAltura( valorAltura );
	}

	public void establecerAltura( double valorAltura ){
		altura = ( valorAltura < 0.0 ? 0.0 : valorAltura );
	}

	public double obtenerAltura(){
		return altura;
	}

	public double obtenerArea(){
		return 2 * super.obtenerArea() + obtenerCircunferencia() * obtenerAltura();
	}

	public double obtenerVolumen(){
		return super.obtenerArea() * obtenerAltura();
	}

	public String obtenerNombre(){
		return "Cilindro";
	}

	public String describir(){
		return super.describir() + "; Altura = " + obtenerAltura();
	}
}