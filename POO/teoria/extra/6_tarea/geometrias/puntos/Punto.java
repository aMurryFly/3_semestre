//LINEAS AGREGADAS - IMPORTS 6 PACKAGE
package geometrias.puntos;

public class Punto{
	
	public int x,y;
	public void imprimeCoordenadas(){
		System.out.println("Punto [x="+x+", y="+y+"]");
	}

	public Punto(int _x, int _y){
		this.x=_x;
		this.y=_y;
	}

}