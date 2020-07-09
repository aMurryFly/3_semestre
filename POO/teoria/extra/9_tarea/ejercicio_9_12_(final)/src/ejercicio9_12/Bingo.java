package ejercicio9_12;

import static java.lang.Thread.sleep;
import java.util.*;

public class Bingo implements juego {

    Tablero tablero;
    int n = 0;
    ArrayList<Integer> generados = new ArrayList<Integer>(100);
    
    public Bingo(Tablero tablero) {
        this.tablero = tablero;
    }

    Runnable r = new Runnable(){
          public void run(){
              for(int i = 0; i < 100; i++) { 
                jugar();
              }
          }
        };
    
    public void jugar() {
        tablero.agregarNuevoNumero();
        generados.add(tablero.number);
        Controlador.decir(tablero.number);
        try {
            sleep(1500);//2 segundos
        } catch (InterruptedException ex) {
        }
    }

    public void pausar() {
    }

    public boolean continuar() {
        int respuesta = Controlador.getAutorizacion();
        if(respuesta == 1){
            return true;
        }else{
            return false;
        }
    }

    public void terminar() {
    }

    public void reiniciar() {
    }
    
    public boolean ganador(Integer elem){
        if(!generados.contains((Integer) elem))
            return false;
        return true;
            
    }
     public void comenzar() {
         tablero.limpiar();
         tablero.mostrar();
    }
     
     
}
