public class Circulo extends Punto{

	private double radio;

	public Circulo( int x, int y, double valorRadio ){
		super( x, y );
		establecerRadio( valorRadio );
	}

	public void establecerRadio( double valorRadio ){
		radio = ( valorRadio < 0.0 ? 0.0 : valorRadio );
	}

	public double obtenerRadio(){
		return radio;
	}

	public double obtenerDiametro(){
		return 2 * obtenerRadio(); 
	}

	public double obtenerCircunferencia(){
		return Math.PI * obtenerDiametro();
	}

	public double obtenerArea(){
		return Math.PI * obtenerRadio() * obtenerRadio();
	}

	public String obtenerNombre(){
		return "Circulo";
	}

	public String describir(){
		return " Centro = "+super.describir()+"; Radio = "+obtenerRadio();
	}

}