/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edaII05alu36
 */
public class NodoB {
    int m;
    ArrayList<Integer> key =  new ArrayList();
    int indiceIns=0; //numero de llaves en un nodo
    int indiceHijo=0;//numero de hijos en un nodo 
    ArrayList<NodoB> hijo;
    NodoB padre;
    boolean esHoja;
    boolean esRaiz;

    NodoB(int m,int Hoja) {
        this.m = m;
        esRaiz = false;
        hijo =  new ArrayList<NodoB>();
        if(Hoja==1) esHoja =true;
        else if(Hoja==0) esHoja=false;
    }
    
    
    public void addNum(NodoB nodo,int x,int indice)
    {   
      if(nodo.esHoja==true && nodo.esRaiz==true){  
            System.out.println(nodo.indiceIns);
            System.out.println(nodo.m);
            if(nodo.indiceIns<m-1){   
            nodo.key.add(x);  
            Collections.sort(nodo.key);
            nodo.indiceIns++; 
            System.out.println("nodo raiz "+nodo.key);
            }
            else
            {
            divisionPadre(nodo,x);
            
            }
        }
      else if(nodo.esHoja==true){
            System.out.print(nodo.indiceIns+"->");
            System.out.println(nodo.m);
            if(nodo.indiceIns<m-1){   
            nodo.key.add(x);  
            Collections.sort(nodo.key);
            nodo.indiceIns++; 
            System.out.println("padre"+nodo.padre.key);
            System.out.println("hijo: "+nodo.key);
            }
            else
            {
            divisionHijo(nodo,x,indice);
            
            }
      }
      else
      { //esta compara con los elementos y elige el nodo de insercion
          int index=0;
          for(int i=0; i<nodo.key.size();i++)
          {
            if(x> nodo.key.get(i)){
            index++;
            System.out.println("aumenta indice de insercion");
            }
        }
          System.out.println("inserta en nodo "+index);
          System.out.println(""+nodo.hijo.get(index).key);
          //System.out.println("cantidad de hijos "+nodo.hijo.size());
          addNum(nodo.hijo.get(index),x,index);
      }
      
      
      
    }

    private void divisionPadre(NodoB nodo, int x) {
       
     
       NodoB hijo1 = new NodoB(this.m,1);
       NodoB hijo2 = new NodoB(this.m,1);
       
       nodo.key.add(x);
       Collections.sort(nodo.key);
       
       ArrayList<Integer> list = new ArrayList(nodo.key);
        System.out.println("list"+list);
       nodo.key.removeAll(key);
       
       
       List<Integer> sub1 = list.subList(0,2);
       List<Integer> sub2 = list.subList(3,5);
       hijo1.padre = nodo;
       hijo2.padre = nodo;
       System.out.println("dividido");
       nodo.key.add(list.get(2));
       nodo.indiceIns =1;
       nodo.esRaiz=true;
       nodo.esHoja=false;
       System.out.println("padre "+nodo.key);
       nodo.hijo.add(hijo1);
       nodo.hijo.get(indiceHijo).key = new ArrayList(sub1);
       nodo.hijo.get(indiceHijo).indiceIns = 2;
       System.out.println("hijo "+indiceHijo+" "+nodo.hijo.get(indiceHijo).key );
       indiceHijo++;
       nodo.hijo.add(hijo2);
       nodo.hijo.get(indiceHijo).key = new ArrayList(sub2);
       nodo.hijo.get(indiceHijo).indiceIns = 2;
       System.out.println("hijo2 "+indiceHijo+" "+nodo.hijo.get(indiceHijo).key );
       indiceHijo++;
       
       //verificacion
       hijo1.esHoja=true;
       hijo2.esHoja=true;
       hijo1.indiceIns=2;
       hijo2.indiceIns=2; 
        System.out.println("padre: "+nodo.hijo.size());
      
        
    }

    private void divisionHijo(NodoB nodo, int x,int indice) {
       
        if(nodo.esRaiz==true)
        {
         System.out.println("entra caso 3");
          caso3(nodo,x,indice);
        }
        if(nodo.esHoja==false && nodo.esRaiz==false)
        {
          System.out.println("entra caso 2");  
          caso2(nodo,x,indice);
        }
        if(nodo.esHoja==true)
        {
          System.out.println("entra caso 1");  
          caso1(nodo,x,indice);
        }
       
    
    }

   
    public void caso1(NodoB nodo, int x, int indice)
    { 
        
       System.out.println("INDICE "+indice); 
       System.out.println("padre "+nodo.padre.key);
       nodo.padre.hijo.remove(nodo);
       NodoB hijo1 = new NodoB(this.m,1);
       NodoB hijo2 = new NodoB(this.m,1);
       
       nodo.key.add(x);
       Collections.sort(nodo.key);
       
       ArrayList<Integer> list = new ArrayList(nodo.key);
       System.out.println("list"+list);
       nodo.key.removeAll(key);
       
       
       List<Integer> sub1 = list.subList(0,2);
       List<Integer> sub2 = list.subList(3,5);
       
       hijo1.padre = nodo.padre;
       hijo2.padre = nodo.padre;
      
       
       System.out.println("dividido");
      
     
       
       Collections.sort(nodo.padre.key);
       
       nodo.padre.indiceIns =1;
      
      
       hijo1.key = new ArrayList(sub1);
       
      
       hijo2.key = new ArrayList(sub2);
     
      
       nodo.padre.hijo.add(indice, hijo1);
       nodo.padre.hijo.add(indice+1, hijo2);
       System.out.println("hijo "+indiceHijo+" "+nodo.padre.hijo.get(indice).key ); 
       System.out.println("hijo2 "+indiceHijo+" "+nodo.padre.hijo.get(indice+1).key);
       
       hijo1.indiceIns=2;
       hijo2.indiceIns=2;
       
       if(nodo.padre.key.size()<4)
       nodo.padre.key.add(list.get(2));
       else
       divisionHijo(nodo.padre,list.get(2),indice);
       
       nodo.padre=null;
       System.out.println("");
    }

    private void caso3(NodoB nodo, int x, int indice) {
       NodoB hijo1 = new NodoB(this.m,0);
       NodoB hijo2 = new NodoB(this.m,0);
       
       nodo.key.add(x);
       Collections.sort(nodo.key);
       
       ArrayList<Integer> list = new ArrayList(nodo.key);
       System.out.println("list"+list);
       nodo.key.removeAll(nodo.key);
       
       
       List<Integer> sub1 = list.subList(0,2);
       List<Integer> sub2 = list.subList(3,5);
       
       hijo1.padre=nodo;
       hijo2.padre=nodo;
        
       
       nodo.key.add(list.get(2));
       nodo.indiceIns=1;
       
       System.out.println("padre hijo1 "+hijo1.padre.key);
       System.out.println("padre hijo2"+hijo2.padre.key);
      
       hijo1.key = new ArrayList(sub1);
       hijo1.indiceIns=2;
       hijo2.key = new ArrayList(sub2);
       hijo2.indiceIns =2;
       
       hijo1.hijo.addAll(nodo.hijo.subList(0,3));
       hijo2.hijo.addAll(nodo.hijo.subList(3,6));
       
        for (int i = 0; i < 3; i++) {
            hijo1.hijo.get(i).padre=hijo1;
            hijo2.hijo.get(i).padre=hijo2;
        }
       
       
       System.out.println("tam h1 "+hijo1.hijo.size());
       System.out.println("tam h2 "+hijo2.hijo.size());
       nodo.hijo.removeAll(nodo.hijo);
       
       
       nodo.hijo.add(hijo1);
       nodo.hijo.add(hijo2);
       
        System.out.println("hijo1 "+hijo1.key);
        System.out.println("hijo2 "+hijo2.key);
       
       System.out.println("tam hijos padre "+hijo1.padre.hijo.size());
        System.out.println("");
    }

    private void caso2(NodoB nodo, int x, int indice) {
       NodoB hijo1 = new NodoB(this.m,0);
       NodoB hijo2 = new NodoB(this.m,0);
       
       nodo.key.add(x);
       Collections.sort(nodo.key);
       
       ArrayList<Integer> list = new ArrayList(nodo.key);
       System.out.println("list"+list);
       nodo.key.removeAll(nodo.key);
       
       
       List<Integer> sub1 = list.subList(0,2);
       List<Integer> sub2 = list.subList(3,5);
       
       hijo1.padre=nodo.padre;
       hijo2.padre=nodo.padre;
       
       indice = nodo.padre.hijo.indexOf(nodo);
       nodo.padre.hijo.remove(nodo);
       
       
       
       hijo1.padre.hijo.add(indice,hijo1);
       nodo.padre.hijo.add(indice+1,hijo2);
       
       hijo1.key = new ArrayList(sub1);
       hijo1.indiceIns=2;
       hijo2.key = new ArrayList(sub2);
       hijo2.indiceIns =2;
       
       hijo1.hijo.addAll(nodo.hijo.subList(0,3));
       hijo2.hijo.addAll(nodo.hijo.subList(3,6));
       
        for (int i = 0; i < 3; i++) {
            hijo1.hijo.get(i).padre=hijo1;
            hijo2.hijo.get(i).padre=hijo2;
        }
       
        System.out.println("hijo1 "+hijo1.key);
        System.out.println("hijo2 "+hijo2.key);
      
       
       if(nodo.padre.key.size()<4)
       nodo.padre.key.add(list.get(2));
       else
       divisionHijo(nodo.padre,list.get(2),indice);
       
       nodo.padre=null;
       
        System.out.println("padre "+hijo1.padre.key);
        System.out.println("");
    }
    
   
    
}
