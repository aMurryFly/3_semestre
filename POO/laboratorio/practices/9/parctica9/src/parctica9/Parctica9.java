/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parctica9;

/**
 *
 * @author poo03alu30
 */
public class Parctica9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tablero tablero= new Tablero();
        Bingo bingo = new Bingo(tablero);
        bingo.comenzar();
        
        while(bingo.continuar()){
            bingo.jugar();
        }
        // TODO code application logic here
    }
    
}
