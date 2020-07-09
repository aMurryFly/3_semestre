//LINEAS AGREGADAS - IMPORTS 6 PACKAGE
package geometrias;


import geometrias.lineas.Linea;
import geometrias.puntos.Punto;
import geometrias.ventanas.Ventana;

/**
* Es una clase que permite trabajar con paquetes y muestra una salida
* @author Murrieta Villegas Alfonso
* @version FINAL-VERSION
**/


public class Geometrias{


    public static void main(String[] args) {

        Punto p1 = new Punto(100,100);
        Punto p2 = new Punto(200,200);

        Linea l1 = new Linea(p1,p2);

        Punto p3 = new Punto(150,100);
        Punto p4 = new Punto(250,200);

        Ventana frame = new Ventana();

        frame.agregar(p1);
        frame.agregar(p2);

        frame.agregar(l1);
        
        frame.setVisible(true);
        
      
    }

}