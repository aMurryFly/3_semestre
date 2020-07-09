/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murrieta_reza_valdespino_equipo2_g5_proyecto2;


public class NodosE {
    //Variables globales
    	String valor;
	NodosE padre ;
	NodosE sDerecho;
	NodosE sIzquierdo;
    
        //Constructor
        public NodosE(){
        }
        
        //Metodos
        
        public void agregarNodo(String value){
		valor = value;
	}

	public void agregarDer(){
		sDerecho = new NodosE();
	}

	public void agregarIzq(){
		sIzquierdo = new NodosE();
	}
        
        //METODO DE SALIDA 
        
        @Override
	public String toString(){
                String aux = "";
                String aux2 = "";
                String salida = "";
                
                if(sIzquierdo == null){
                    aux = valor + "";
                }
                else{
                    aux = " Nodo Izquierdo " + sIzquierdo;
                }
                
                if(sDerecho == null){
                    aux2 = "";
                }
                else{
                    aux2 = "\t" + "Nodo Izquierdo " + sDerecho + "\n";
                }
                
                return salida = valor + aux + aux2;
	}
}
