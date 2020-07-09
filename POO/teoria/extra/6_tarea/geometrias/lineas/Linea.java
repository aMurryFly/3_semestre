//LINEAS AGREGADAS - IMPORTS 6 PACKAGE
package geometrias.lineas;

import geometrias.puntos.Punto;

public class Linea{
	
	public Punto pi, pf;


	public void imprimeCoordenadas(){
		System.out.println("Punto Inicial [x="+pi.x+", y="+pi.y+"]");
		System.out.println("Punto Final [x="+pf.x+", y="+pf.y+"]");
	}

	public Linea(Punto _pi, Punto _pf){
		pi = _pi;
		pf = _pf;
	}


}