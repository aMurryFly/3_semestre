package puntos;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Ventana extends JFrame{
    
    //Declaración de la listas
    ArrayList <Puntos> puntos = new ArrayList <Puntos>();//Arreglo de puntos
    ArrayList <Linea> lineas = new ArrayList <Linea>();//Arreglo de lineas 
    ArrayList <Ovalo> ovalos = new ArrayList <Ovalo>();//Arreglo de ovalos
    ArrayList <Rectangulo> rectangulos = new ArrayList <Rectangulo>();//Arreglo de rectangulos 

    //Constructor de la Ventana
    public Ventana(){
	this.setSize(500,500);
	this.setTitle("Puntos");
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //Setters 
    void setPunto(Puntos p){
        puntos.add(p);
    }
    
    void setLinea(Linea l){
        lineas.add(l);
    }
    
    void setOvalo(Ovalo o){
        ovalos.add(o);
    }
    
    void setRectangulo(Rectangulo r){
        rectangulos.add(r);
    }

    //Método de impresión en la venta
    public void paint(Graphics g){

        super.paint(g);
        g.setColor(Color.red);
	//g.drawLine(50,50,50,50);//Iluminar linea 
    
        //For para los puntos
        for(int i=0; i <puntos.size(); i++){
            g.drawOval(puntos.get(i).x, puntos.get(i).y, 4, 4);
        }
        
        //For para los ovalos /Circulos
        for(int i=0; i <ovalos.size(); i++){
            g.drawOval(ovalos.get(i).x, ovalos.get(i).y, ovalos.get(i).ejex, ovalos.get(i).ejey);
        }
        
        
        //For para las lineas
        for(int i=0; i <lineas.size(); i++){
            g.drawLine(lineas.get(i).x_1,lineas.get(i).y_1,lineas.get(i).x_2,lineas.get(i).y_2);
        }
        
        //For para los puntos
        for(int i=0; i <puntos.size(); i++){
            g.drawOval(puntos.get(i).x, puntos.get(i).y, 4, 4);
        }
        
        //For para los rectangulos 
        
        for(int i=0; i <rectangulos.size(); i++){
            g.drawRect(rectangulos.get(i).x, rectangulos.get(i).y, rectangulos.get(i).width, rectangulos.get(i).height);
        }
        
        
    }
}
