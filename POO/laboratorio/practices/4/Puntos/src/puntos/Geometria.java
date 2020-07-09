package puntos;

public class Geometria {

	public static void main(String[] args){
		Puntos p1= new Puntos(100,200);
		Puntos p2= new Puntos(200,300);
                Linea l1 = new Linea(p1.x,p1.y,p2.x,p2.y);
                Ovalo o1 = new Ovalo(300,100, 100 , 50 );
                Rectangulo  r1 = new Rectangulo(250,200,200,100);
                Rectangulo  r2 = new Rectangulo(250,350,100,100);

		p1.coordenadas();
		Ventana frame = new Ventana();
                
                frame.setPunto(p1);
                frame.setPunto(p2);
                frame.setLinea(l1);
                frame.setOvalo(o1);
                frame.setRectangulo(r1);
                frame.setRectangulo(r2);
		frame.setVisible(true);
	}
    
}
