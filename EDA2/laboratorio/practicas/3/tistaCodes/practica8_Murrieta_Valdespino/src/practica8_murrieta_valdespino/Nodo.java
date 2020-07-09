/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8_murrieta_valdespino;

/**
 *
 * @author edaII05alu36
 */
public class Nodo{
    int valor;
    Nodo izq= null;
    Nodo der= null;
    int altura; //SE AGREGÓ
    
   
   
    public Nodo(int data)
    {
        this(data,null,null);
    }
    
    public Nodo(int data, Nodo lt, Nodo rt)
    {
      valor= data;
      izq = lt;
      der = rt;
    }
    
     public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
}
