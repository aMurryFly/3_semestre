//LINEAS AGREGADAS - IMPORTS 6 PACKAGE
package geometrias.ventanas;

import geometrias.lineas.Linea;
import geometrias.puntos.Punto;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.ArrayList;

public class Ventana extends JFrame {
  	
    ArrayList<Punto> puntos = new ArrayList<>();
    ArrayList<Linea> lineas = new ArrayList<>();

    public Ventana(){
        this.setSize(350, 250);
        this.setTitle("Puntos");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void agregar( Punto p ){
        puntos.add(p);
    }

    public void agregar( Linea l ){
        lineas.add(l);
    }
    
    public void paint(Graphics g){

        super.paint(g);
        
        for( int i=0; i<lineas.size() ; i++ ){
            g.setColor (Color.red);
            g.drawLine(lineas.get(i).pi.x, lineas.get(i).pi.y, lineas.get(i).pf.x, lineas.get(i).pf.y);
        }

        for( int i=0; i<puntos.size() ; i++ ){
            g.setColor (Color.blue);
            g.drawLine(puntos.get(i).x, puntos.get(i).y, puntos.get(i).x, puntos.get(i).y);
        }


        
        
    }
}