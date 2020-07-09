/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

/**
 *
 * @author edaII05alu36
 */
public class arbolB {
    int m;
    NodoB raiz;

    public arbolB(int m) {
        this.m = m;
        raiz = new NodoB(m,1);
        raiz.esRaiz=true;
        raiz.padre = null;
    }
    
    
    public void agregar(int n)
    {
        System.out.println("se agrega: "+n);
        raiz.addNum(raiz,n,0);
 
    }
    
    public void imprimir(NodoB rai)
    {   
        System.out.println("nivel 0");
        System.out.println("nodo raiz-"+rai.key);  
      
        ImpUtil(rai,1);
      
    }
    
    public void ImpUtil(NodoB rai,int nivel)
    {  
       
      
       for(NodoB r : rai.hijo)
       {
        System.out.println("nivel: "+nivel);
        System.out.println(" nodo hijo "+r.key);  
        
       }
       if(rai.hijo!=null){ 
            
            for(NodoB a : rai.hijo)
            {
            ImpUtil(a,nivel+1);
            }
       }
    }
    
    public boolean Buscar(NodoB rai,int x)
    {   
        System.out.println("se busca "+x);
        int indice =0;
        boolean encontrado=false;
        
        for(int b:rai.key){
            
            if(x>b)
            indice++;
            else if(b == x)
            {
             System.out.println("se encontro en nivel 0");
             encontrado = true;
             return encontrado;
            }
        }
        System.out.println("entra en hijo "+indice);
        //if(encontrado==false)
        return BuscarUtil(rai.hijo.get(indice),1,encontrado,x);
        
        //return encontrado;
        
    }

    private boolean BuscarUtil(NodoB rai, int nivel,boolean encontrado,int x) {
        
        int indice=0;
        // for (NodoB r:rai.hijo) {
            
            for(int b:rai.key){
                
                if (x>b) {
                 indice++;   
                }
                else if(b == x)
                {
                System.out.println("se encontro en nivel "+nivel);
                encontrado=true;
                return encontrado;
                }
            }
        //}
        if(rai.esHoja!=true){ 
            
            //for(NodoB a : rai.hijo)
            //{
            System.out.println("entra en hijo "+indice);
            //if(encontrado==false)
            return BuscarUtil(rai.hijo.get(indice),nivel+1,encontrado,x);
            //}
        }
         
        return encontrado;  
    }
    
       
}
