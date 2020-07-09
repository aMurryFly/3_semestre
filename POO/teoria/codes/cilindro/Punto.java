public class Punto extends Figura {
	
	private int x;
	private int y;

	public Punto( int valorX, int valorY ){
		x = valorX;
		y = valorY;
	}

	public void establecerX( int valorX ){
		x = valorX;
	}
	public int obtenerX(){
		return x;
	}

	public void establecerY( int valorY ){
		y = valorY;
	}

	public int obtenerY(){
		return y;
	}

	public String obtenerNombre(){
		return "Punto";
	}

	public String describir(){
		return "["+obtenerX()+" ,"+obtenerY()+"]";
	}

}