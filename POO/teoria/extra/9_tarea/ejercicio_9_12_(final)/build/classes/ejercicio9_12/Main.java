
package ejercicio9_12;
//MURRIETA VILLEGAS ALFONSO 

public class Main {

    public static Bingo bingo;

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        bingo = new Bingo(tablero);
        bingo.comenzar();
        
        
    }
   
    
    
}
