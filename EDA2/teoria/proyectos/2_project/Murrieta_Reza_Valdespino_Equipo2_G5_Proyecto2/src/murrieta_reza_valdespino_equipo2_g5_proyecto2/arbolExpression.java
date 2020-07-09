/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murrieta_reza_valdespino_equipo2_g5_proyecto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Segarecha
 */
public class arbolExpression {
    //Variables globales

	NodosE raiz = new NodosE();
	NodosE aux = raiz;
        
        ArrayList<Character> carac = new ArrayList<Character>(Arrays.asList('+','-', '*', '/'));
	Stack<String> pila = new Stack<String>();
        
        String expresion;
	boolean signo = false;

        //Constructor
        public arbolExpression(){
		
	}
        
	public arbolExpression(String expression){
		expresion = expression;
		crear_arbol();
		System.out.println(raiz);
		recorrido();
		System.out.println("\n" + pila);
	}

        //Sobreescritura del recorrido del arbol - posfija
        
	public void recorrido(){//Caso vacio
		recorrido(raiz);
	}

        private void recorrido(NodosE nodoaux){
            if(nodoaux.sIzquierdo != null){
		recorrido(nodoaux.sIzquierdo);
            }
            if(nodoaux.sDerecho != null){
		recorrido(nodoaux.sDerecho); 
            }
            insertar(nodoaux.valor);
	}
        
        
        //MÉTODOS 
        
    public void insertar(String s){
	
        if(s.length() == 1){
            if(!carac.contains(s.charAt(0)))
		pila.add(s);
            else{
		System.out.println(pila);
		pila.add(operaciones(s));
            }
        }
        else{
            pila.add(s);
        }    
	
    }

    private void crear_arbol(){
            String aux_exp = eliminar();
            if(aux_exp != null){
                if(aux_exp.equals("(")){
                    aux.agregarIzq();
                    aux.sIzquierdo.padre = aux;
                    aux = aux.sIzquierdo;
                    crear_arbol();
		}
		else if(aux_exp.equals(")")){
                    aux = aux.padre;
                    crear_arbol();
		}
                    else{
                        aux.valor = aux_exp;

                        if(aux_exp.length() == 1){
                            if(carac.contains(aux_exp.charAt(0))){
                                aux.agregarDer();
                                aux.sDerecho.padre = aux;
                                aux = aux.sDerecho;
                                crear_arbol();
                            }
                            else{
                                aux = aux.padre;
                                crear_arbol();
                            }
                        }
                        else{
                            aux = aux.padre;
                            crear_arbol();
                        }
                    }
            }	
	}
   
    
    private String operaciones(String operacion){
		
        switch (operacion) {
            case "+":
                return "" + (Double.parseDouble(pila.pop()) + Double.parseDouble(pila.pop()));
            case "-":
                return "" + (-Double.parseDouble(pila.pop()) + Double.parseDouble(pila.pop()));
            case "*":
		return "" + (Double.parseDouble(pila.pop()) * Double.parseDouble(pila.pop()));
            case "/":
                try{
                    return "" + (1/Double.parseDouble(pila.pop()) * Double.parseDouble(pila.pop()));
                }catch(ArithmeticException ex){
                    System.out.println("División entre 0");
                }
            }
            
        return null;
    }

    private String eliminar(){
        if(!expresion.isEmpty()){
            String salExpresion = Character.toString(expresion.charAt(0));
            expresion = expresion.substring(1,expresion.length());
            if(!signo){
                if(carac.contains(salExpresion.charAt(0)) || (salExpresion.equals("(")) || (salExpresion.equals(")"))){
                    if(!expresion.isEmpty() && (expresion.charAt(0) == '+' || expresion.charAt(0) == '-')){
                        signo = true;
                    }
                    return salExpresion;
                }
				
                while(!carac.contains(expresion.charAt(0)) && (expresion.charAt(0) != '(') && (expresion.charAt(0) != ')')){
                    salExpresion = salExpresion + expresion.charAt(0);
                    expresion = expresion.substring(1,expresion.length());
		}
		return salExpresion;
            }
            else{
                signo = false;
		while(!carac.contains(expresion.charAt(0)) && (expresion.charAt(0) != '(') && (expresion.charAt(0) != ')')){
                    salExpresion = salExpresion + expresion.charAt(0);
                    expresion = expresion.substring(1,expresion.length());
		}
		
                return salExpresion;
            }
	}
        else{
            return null;
        }
			
    }
}
