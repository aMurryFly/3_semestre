
package practica8_murrieta_valdespino;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBin {

    Nodo root;
    
    //CONSTRUCTORES
    public ArbolBin(){
        root=null;
    }
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    
    //MÉTODOS DADOS
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    
    }
    
    public void breadthFirst(){
        Nodo r=root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                visit(r);
                if(r.izq!=null) 
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            
            }
        
        }

    }
    //MÉTODO DE BÚSQUEDA
    
        public String busqueda(int valor){
        Nodo r=root;
        Queue<Nodo> queue = new LinkedList();
        
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();               
                if(r.izq!=null) 
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
                if(r.valor==valor){ 
                    String a = ("NODO " + valor + " fue encontrado");
                    return a;                   
                }
            } 
        }
        return "Valor no fue encontrado " ;
    }
        
    
    //MÉTODOS HECHOS 
        
    public void add(Nodo padre, Nodo hijo, int lado){
        if(lado==0){
            padre.setIzq(hijo);
            
        
        }else{
            padre.setDer(hijo);
        }   
    }
    
    //NOTA SE REALIZÓ ESTE MÉTODO PARA PODER LLEVAR A CABO EL AGREGADO DE CADA NODO
    public void add(int lado,Nodo agregado, Nodo inicio){
        if(lado==0){
            if(inicio.izq==null){
                agregado.setFather(inicio);
                inicio.setIzq(agregado);
                
            }else if(inicio.der==null){
                inicio.setDer(agregado);
            }else{
                add(0,agregado,inicio.izq);       
            }
        }
        else{
            if(inicio.izq==null){
                agregado.setFather(inicio);
                inicio.setIzq(agregado);
            }else if(inicio.der==null){
                inicio.setDer(agregado);
            }else{
                add(1,agregado,inicio.der);       
            }
        }
    }
    
    
    //RECORRIDOS 
    
     public void preorden(){
        System.out.println("PRE-ORDEN");
        preordenUTIL(this.root);
    }
    
    public void preordenUTIL(Nodo raiz){
        Nodo r=raiz;
        Queue<Nodo> queue = new LinkedList();  
        
        if(r!=null){
            queue.add(r);            
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                visit(r);
                if(r.izq!=null){
                    
                    preordenUTIL(r.izq);
                }
                if(r.der!=null){
                   
                    preordenUTIL(r.der);
                }

            }
        }
    }
    
    public void inorden(){
        System.out.println("IN-ORDEN");
        inordenUTIL(this.root);
    }
   
    public void inordenUTIL(Nodo raiz){       
        Nodo r=raiz;          
        Queue<Nodo> queue = new LinkedList();    
        if(r!=null){
            queue.add(r);            
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                
                if(r.izq!=null){                   
                    inordenUTIL(r.izq);
                }               
                visit(r);                
                if(r.der!=null){   
                    inordenUTIL(r.der);
                }
            
            }
        }
    }
   
    public void postorden(){
        System.out.println("POST-ORDEN");
        postordenUTIL(this.root);
    }
     
     public void postordenUTIL(Nodo raiz){       
        Nodo r=raiz;          
        Queue<Nodo> queue = new LinkedList();    
        if(r!=null){
            queue.add(r);            
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                
                if(r.izq!=null){                   
                    postordenUTIL(r.izq);
                }               
                               
                if(r.der!=null){   
                    postordenUTIL(r.der);
                }
                visit(r); 
            
            }
        }
    }
}
