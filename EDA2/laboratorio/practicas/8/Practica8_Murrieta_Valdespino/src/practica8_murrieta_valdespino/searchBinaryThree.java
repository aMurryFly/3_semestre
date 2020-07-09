
package practica8_murrieta_valdespino;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Murrieta
 */
public class searchBinaryThree {
    
    //CONSTR5UCTORES Y MÉTODOS ANTERIORES
    Nodo root;
    int altura;
    
    public searchBinaryThree (){
        root=null;
    }
    public searchBinaryThree (int val){
        root=new Nodo(val);
    }
    public searchBinaryThree (Nodo root){
        this.root=root;
    } 
    
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
    
    //MÉTODOS NUEVOS Y CREADOS
    
    public boolean busqueda(int valor){
        return(busquedaUTIL(valor,this.root));
    }    
    public boolean busquedaUTIL(int valor, Nodo raiz){
         
        if(raiz==null){
            
            return false;            
        }else if(raiz.valor==valor){
            
            return true;
        }else if(raiz.valor>valor){
           
            return busquedaUTIL(valor, raiz.izq);
            
        }else if(raiz.valor<valor){
          
            return busquedaUTIL(valor,raiz.der);
        }   
        return false;
    }
    
    public Nodo busquedaNODO(int valor){
        return(busquedaNUTIL(valor,this.root));
    }   
    
    public Nodo busquedaNUTIL(int valor, Nodo raiz){
        
        if(raiz==null){
            
            return null;            
        }else if(raiz.valor==valor){
            
            return raiz;
        }else if(raiz.valor>valor){
            
            return busquedaNUTIL(valor, raiz.izq);
            
        }else if(raiz.valor<valor){
            
            return busquedaNUTIL(valor,raiz.der);
        }   
        return null;
    }
    
    public void add(Nodo n){
        Nodo p=this.root;
        if(!busqueda(n.valor)){
            
        do{
            
        if(n.valor<p.valor ){
            if( p.izq==null){
                p.izq=n;
                n.padre=p; 
            }else{
                p=p.izq;
            }
        }else if(n.valor>p.valor){
            if(p.der==null){
            p.der=n;
            n.padre=p;
            }else{
                p=p.der;
            }
            
        }
       
        
        }while(n.padre==null);
                
        }

    }

    //MÉTODOS ALTERNATIVOS Y AUXILIARESS
    
    public int numNodos(){
        Nodo r=root;
        Queue<Nodo> queue = new LinkedList();
        int n=0;
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                
                if(r.izq!=null) 
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
                n++;
            
            }
        return n;    
        }
        return 0;
    } 
    
    public Nodo minimo(Nodo raiz){
        Nodo actual=raiz;
        while(actual.izq!=null){
            actual=actual.izq;
        }
        return actual;
    }

    public Nodo sucesor(Nodo raiz){
        Nodo suc=null;

        if(raiz.der!=null){
            suc=minimo(raiz.der);
        }else{
            if(raiz.padre!=null){
                if(raiz==raiz.padre.izq){
                suc=raiz.padre;
                }else{
                    raiz.padre.der=null;
                    suc=sucesor(raiz.padre);
                    raiz.padre.der=raiz;
                }
            }

        }
        return suc;
    }      
    
//MÉTODOS APARTADO 4: ALTURA, CANTIDAD DE NODOS Y BALANCEADO
    
    public int altura() {       
        alturaUTIL(this.root, 0);
        return altura;
    }

    public void alturaUTIL(Nodo raiz, int nivel) {
        if (raiz != null) {            
            alturaUTIL(raiz.izq, nivel + 1);
            
            if (nivel > altura) {
                altura = nivel;
            }
            alturaUTIL(raiz.der, nivel + 1);
        }
    }

    public int alturaNODOS(Nodo raiz) {
        int al=raiz.altura;
        
        al=alturaAUX(raiz, 0, al);
        
        return al;
    }

    public int alturaAUX(Nodo raiz, int nivel,int al) {
 
        if (raiz != null) {  
            
            al=alturaAUX(raiz.izq, nivel + 1, al);
           
            if (nivel > al) {
               al = nivel;
            }
            al=alturaAUX(raiz.der, nivel + 1,al);
            
        }
        return al;
       
    }

    public boolean Balanceado(){
        int altIz;
        int altDer;
        int dif;

        altIz=alturaNODOS(root.izq);

        altDer=alturaNODOS(root.der);


        dif = Math.abs(altIz-altDer);
        return dif<=1;


    }

    //MÉTODO ELIMINAR PRINCIPAL
    public void eliminar(int valor){
        Nodo n;
        n=busquedaNODO(valor);
        
        if(n!=null){
            if(n.izq==null&& n.der==null){//Si no tiene hijos
                eliminarWITHOUT(n);
            }else if (n.izq!=null&& n.der==null){   //si tiene un hijo
                eliminarWITHONE(n);
            }else if (n.izq==null&& n.der!=null){
                eliminarWITHONE(n);
            }else if(n.izq!=null&& n.der!=null){ //si tiene dos hijos
                eliminarWITHTWO(n);
            
            }
        }
    }

    public void eliminarWITHOUT(Nodo n){
        if(n.padre!=null){
            Nodo iz=n.padre.izq;
            Nodo der=n.padre.der;

            if(iz==n){
                n.padre.izq=null;
                System.out.println("Eliminado");
            }
            if(der==n){
                n.padre.der=null;
                System.out.println("Eliminado");
            }
        }

        if(n==this.root){
            n=null;
        }
    }

    public void eliminarWITHONE(Nodo n){
         if(n.padre!=null){
            Nodo iz=n.padre.izq;
            Nodo der=n.padre.der;

            Nodo hijo;
            //Encontrar al nodo hijo
            if(n.izq!=null){
                hijo=n.izq;
            }else{
                hijo=n.der;
            }

            //Eliminar elemento
            if(iz==n){               
                n.padre.izq=hijo;
                n.izq=n.der=n.padre=null;
                n=null;
            }
            if(der==n){
                n.padre.der=hijo;
                n.izq=n.der=n.padre=null;
                n=null;
            }
    
        }
         
        if(n==this.root){
            Nodo hijo;
            //Encontrar al nodo hijo
            if(n.izq!=null){
                hijo=n.izq;
            }else{
                hijo=n.der;
            }
            
            this.root=hijo;
            n=null;
        }
        
    }

    public void eliminarWITHTWO(Nodo n){
        Nodo suc=sucesor(n);
        auxiliarDelate(suc);
        n.valor=suc.valor;

    }
    
    //SE NECESITA UN CASO MÁS DEBIDO A QUE TIENE LAS DOS RAICES
    public void auxiliarDelate(Nodo raiz){
    if(raiz.izq==null && raiz.der==null){
        if( raiz==raiz.padre.izq){
            raiz.padre.izq=null;
        }else{
            raiz.padre.der=null;
        }
    }else if(raiz.izq!=null || raiz.der!=null){
        if(raiz.izq!=null){
            if(raiz==raiz.padre.izq){
                raiz.padre.izq=raiz.izq;
            }else{
                raiz.padre.der=raiz.izq;
                raiz.izq.padre=raiz.padre;
            }
        }else{
            if(raiz.izq!=null){
                raiz.padre.izq=raiz.der;
                
            }else{
                raiz.padre.der=raiz.der;
                raiz.der.padre=raiz.padre;
            }
        }
        
    }
}
    
    
    
    
}   

     