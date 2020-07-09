package puntos;
//NOTA IMPORTANTE Y CONCEPTUALIZACIÓN 

/*
Realmente la única diferencia que hay entre el ovalo (Elipse) y el círculo es 
la diferencia entre os ejes de las ´conicas, es decir realmente el círculo es un 
caso particular de una elipse (Ovalo) por lo que directamente podemos emplear 
esta clase para realizar ambas figuras geométrica.
*/

public class Ovalo {
    
    //Atributos
    int x, y, ejex, ejey;

    //Constructor
    Ovalo(){

    }
    
    //Los primeros 2 son argumentos  de posición, los siguientes 2 son el tamaño de los ejes
    Ovalo(int position_x, int position_y, int size_x, int size_y){
	x= position_x;
	y= position_y;
        ejex= size_x;
        ejey= size_y;
        
        //Condición si es un círculo
        if(ejex==ejey){
            System.out.println("En este caso lo que se ha creado es un CÍRCULO");
        }
        else {
            System.out.println("En este caso lo que se ha creado es una ELIPSE");
        }

    }

    
}
