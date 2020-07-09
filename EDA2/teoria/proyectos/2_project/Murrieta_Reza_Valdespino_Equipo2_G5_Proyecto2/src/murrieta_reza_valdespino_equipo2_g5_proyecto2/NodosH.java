/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murrieta_reza_valdespino_equipo2_g5_proyecto2;


public class NodosH {
    NodosH NodoPadre;
    NodosH NodoIzq;
    NodosH NodoDer;
    
    int valor;
    int nivel;
    
    public NodosH(int valor,int level){
        this.NodoPadre=null;
        this.NodoIzq=null;
        this.NodoDer=null;
        this.valor=valor;
        this.nivel=level;
    }   
}
