
package practica8_murrieta_valdespino;

import java.util.LinkedList;
import java.util.Queue;


public class ArbolBin {
    Nodo root;

    //cONSTRUCTORES
    
    public ArbolBin() {
        root = null;
    }
    
     public ArbolBin(int val) {
        root = new Nodo(val);
    }

    public ArbolBin(Nodo root) {
        this.root = root;
        
    }
    
    //MÉTODOS
    
    public void add(Nodo padre, Nodo hijo, int lado)
    {
        if(lado==0)padre.setIzq(hijo);
        else padre.setDer(hijo);
    }
    
    protected void visit (Nodo n)
    {
        System.out.println(n.valor+""); 
    }
   
    public void breadthFirst()
    {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        
        if(r!= null)
        {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo)queue.poll();
                visit(r);
                if(r.izq!=null) queue.add(r.izq);
                if(r.der!=null) queue.add(r.der);
                
            }
        }
    }
    
    public boolean busqueda(int val)
    {   
        
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if(r!= null)
        {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo)queue.poll();
                
                if(r.valor == val) 
                {
                    System.out.println("se encontro el dato"); 
                    return true;
                }
                
                // visit(r);
                if(r.izq!=null) queue.add(r.izq);
                if(r.der!=null) queue.add(r.der);
                
            }
        }
        System.out.println("no se encontro");
        return false;
    }
    
    //MÉTODOS DE RECORRIDO
    
    public void prefija(){
        System.out.println("PRE-ORDEN");
        Utilpre(root);     
    }
    
     private void Utilpre(Nodo root) {
        if(root == null)
        return;
         System.out.print(root.valor+",");
         Utilpre(root.izq);
         Utilpre(root.der);
         
    }
    
    public void inorden(){
        System.out.println("IN-ORDEN");
        inordenUtil(this.root);
    }
   
    public void inordenUtil(Nodo root){       
        Nodo r=root;          
        Queue<Nodo> queue = new LinkedList();  
        
        if(r!=null){
            
            queue.add(r);            
            
            while(!queue.isEmpty()){
                
                r=(Nodo)queue.poll();
                
                if(r.izq!=null){                   
                    inordenUtil(r.izq);
                }               
                visit(r); 
                
                if(r.der!=null){   
                    inordenUtil(r.der);
                }
            
            }
        }
    }
   
    public void postorden(){
        System.out.println("POST-ORDEN");
        postordenUtil(this.root);
    }
     
     public void postordenUtil(Nodo root){       
        Nodo r=root;          
        Queue<Nodo> queue = new LinkedList();    
        if(r!=null){
            
            queue.add(r);            
            while(!queue.isEmpty()){
                
                r=(Nodo)queue.poll();
                
                if(r.izq!=null){                   
                    postordenUtil(r.izq);
                }               
                               
                if(r.der!=null){   
                    postordenUtil(r.der);
                }
                visit(r); 
            
            }
        }
    }

   
}
