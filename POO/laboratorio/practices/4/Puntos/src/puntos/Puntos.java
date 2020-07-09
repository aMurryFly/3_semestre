package puntos;

public class Puntos {

    //Atributos 
    int x, y;

    //Constructores
    Puntos(){

    }
    
    Puntos(int X, int Y){
	x=X;
	y=Y;

    }
    
    //Esta función reamente no se ve en la ventana sino en consola
    public void coordenadas(){
	System.out.println("Punto \nx="+x+"\ny="+y);
    }
   
}
