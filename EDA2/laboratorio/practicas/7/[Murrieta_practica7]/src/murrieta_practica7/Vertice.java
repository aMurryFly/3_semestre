package murrieta_practica7;

import java.util.LinkedList;

public class Vertice {
    
    int value;//Realmente es el nombre o identificador
    LinkedList <VertAdy> vertAdyacente;
    
    //Constructor
    public Vertice(int valor){
        this.value=valor;
        vertAdyacente= new LinkedList<VertAdy>();  
    }
    
}
