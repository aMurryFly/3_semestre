package murrieta_practica7;

public class VertAdy implements Comparable<VertAdy> {
    
    //VARIABLES GLOBALES
    Vertice conexion;
    Vertice Actual;
    int ponderacion;
    
    //Constructor
    VertAdy(Vertice nodo,Vertice actual, int pond){
        this.conexion=nodo;
        this.ponderacion=pond;
        this.Actual=actual;
    }

    //GETTERS
    public Vertice getActual() {
        return Actual;
    }

    public Vertice getConexion() {
        return conexion;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    //MÉTODO DE SALIDA GENERAL _POO
    public String toString(){
        
        return ("-> \n INICIO [ "+getConexion().value+" ]"+" FIN [ "+getActual().value+" ]"+" Valor: "+getPonderacion());
    }
    
    //SOBRE ESCRITURA 
    @Override
    public int compareTo(VertAdy vert) {
        if (ponderacion>vert.getPonderacion()){
            return 1;
        }
        else if(ponderacion<vert.getPonderacion()){
            return -1;
        }
        else{
            return 0;
        }
    }
}