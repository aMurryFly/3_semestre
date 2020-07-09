package puntos;
import javax.swing.JFrame;

//NOTA IMPORTANTE Y CONCEPTUALIZACIÓN 

/*
Realmente la única diferencia que hay entre el rectángulo y el cuadrado es 
la diferencia entre los tamaños de lados, es decir realmente el cuardado es un 
caso particular del rectángulo, es por ello que solamente se realizará esta clase 
para ambos métdos 
*/

public class Rectangulo {
    
    int x, y , width, height;
    
    //Construcutores
    Rectangulo(){
    }
    
    Rectangulo(int _x, int _y, int _width, int _height){
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        
        if(width == height){
           System.out.println("En este caso lo que se ha creado es un CUADRADO");
        }
        else {
            System.out.println("En este caso lo que se ha creado es un RECTANGULO");
        }
    }
}
