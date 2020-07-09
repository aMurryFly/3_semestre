package murrieta_reza_valdespino_equipo2_g5_proyecto2;

import java.util.LinkedList;
import java.util.Queue;

public class searchTree{
    NodosS root;
    int altura;
    
    public searchTree(){
        root=null;
    }
    public searchTree (int val){
        root=new NodosS(val);
    }
    public searchTree (NodosS root){
        this.root=new NodosS(root.valor);
        root.altura=0;
        root.padre = null;
        
    } 
    //funcion auxiliar para la impresion
    protected void visit(NodosS n){ 
    System.out.println("\t\t"+n.valor+" ");   
    }
    //funcion de busquedas en un grafo aplicado a arbol bin 
    public boolean busqueda(int valor){ 
        NodosS r=this.root;
        Queue<NodosS> queue = new LinkedList();
        
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){ 
                r=(NodosS)queue.poll();               
                if(r.izq!=null && valor<r.valor) 
                    queue.add(r.izq);
                if(r.der!=null && valor>r.valor)
                    queue.add(r.der);
                if(r.valor==valor){ 
                    System.out.println("\t\tNODO " + valor + " fue encontrado");
                    return true;                   
                }
            } 
        }
        System.out.println("\t\tNODO " + valor + " no encontrado");
        return false ;
    }
    
 
    public void agregar(int n)
    {  
        NodosS x = new NodosS(n);
        System.out.println("\t\tAgregando: "+n);
        root = add(x,root); //Actualiza la raiz
    }

    public NodosS add(NodosS n,NodosS raiz){
        NodosS aux = raiz;
       
        if(n.valor<raiz.valor ){ //si el valor es menor a la raiz evaluada lo insertara a la izq
            if( raiz.izq==null){ //agrega si no esta ocupado
                System.out.println("\t\tAgregado izquierda de "+raiz.valor);
                raiz.izq=n;
                n.padre=raiz; 
              
            }
            else{  //si esta ocupado
              raiz.izq = add(n,raiz.izq); //buscara espacio en el nodo izq
             
             System.out.println("\t\tAltura izq - Altura der = "+(alturaNODOS(raiz.izq,1)-alturaNODOS(raiz.der,1)));
             if((alturaNODOS(raiz.izq,1)-alturaNODOS(raiz.der,1))>=2) //factor de balance o de equilibrio
             {
                 // Está desbalanceado rotara nodos
             
                    if(n.valor<raiz.izq.valor){ //si el nodo insertado fue a la izquieda 
                        System.out.println("\t\tRotacion Izquierda");   
                        aux = rotarIzq(raiz); //actualiza al nodo da la rotacion 
                        
                    }
                    else //si el nodo insertado fue a la derecha
                    {
                        aux = rotacionDobleI(raiz); 
                        
                    }
                
             }
             
            }
        }else if(n.valor>raiz.valor){ //si el dato es mayor que la raiz valuada lo insertara en el nodo derecho
            if(raiz.der==null){
            System.out.println("\t\tAgregado derecha de "+raiz.valor);
            raiz.der=n;
            n.padre=raiz;
            }else{
             
                raiz.der= add(n,raiz.der); //si esta ocupado lo insertara en su siguiente
                if((alturaNODOS(raiz.der,1)-alturaNODOS(raiz.izq,1))>=2) //factor de balance o equilbrio 
                {   
                    System.out.println("\t\tRotacion Derecha");
                    if(n.valor>raiz.der.valor) //si el nodo fue insertado a la derecha 
                        aux= rotarDer(raiz);//actualiza el nodo dada la rotacion 
                    else //si el nodo fue insertado a la izquierda
                    {
                        aux = rotacionDobleD(raiz);
                    }  
                }
            }
            
        }
        else if(n.valor == raiz.valor)
            System.out.println("\t\tDato duplicado-no insertado");
       
        
        raiz.altura = alturaNODOS(raiz,0);
        
        return aux; //actualiza los nodos
        
        
         
    }

    public NodosS rotarIzq(NodosS n)
    {  
         /*
          actualiza las referencias de los nodos
          
          promueve al aux a padre
          el hijo derecho de aux sera el hijo izquierdo del viejo padre
          el hijo derecho de aux sera el  viejo padre
          */ 
        System.out.println("\t\tNodo: "+n.valor);
        if(n.padre!=null)
            System.out.println("\t\tPadre"+n.padre.valor);
             
        NodosS aux = n.izq;
        if(aux.der!=null)
            aux.der.padre= n;
          
        n.izq = aux.der;
        aux.der = n;
          
        //if(n.padre!=null){
        aux.padre =n.padre;
        n.padre = aux;
          //}
            
           
        
        return aux;
       
    }
    
    public NodosS rotarDer(NodosS n)
    {   
        
        /*
         actualiza las referencias de los nodos 
         el aux se promueve a padre 
         el hijo izquierdo de aux sera el hijo derecho del viejo padre
         el hijo izquierdo de aux sera el viejo padre
        */
        
      
     
            NodosS aux = n.der;
            if(aux.izq!=null)
                aux.izq.padre = n;
            n.der = aux.izq;
            aux.izq = n;
           
           //if(n.padre!=null){
            aux.padre = n.padre;
            n.padre =aux;
           //}
          return aux;
          
         
    }
    
    public NodosS rotacionDobleI(NodosS raiz)
    { 
        System.out.println("\t\tRotacion doble Izquierda");
        NodosS aux;
        raiz.izq=rotarDer(raiz.izq); //rotacion simple a la derecha del hijo izquierdo
        aux = rotarIzq(raiz);  //del resultado se hara una rotacion simple a la izquierda
        return aux; //actualiza nodos
    }
    
    public NodosS rotacionDobleD(NodosS raiz)
    {   
        System.out.println("\t\tRotacion Doble Derecha");
        NodosS aux;
        raiz.der=rotarIzq(raiz.der); //se aplicara una rotacion simple a la izquierda del hijo derecho 
        aux = rotarDer(raiz);  // del resultado se aplicara una rotacion simple a la derecha
        return aux; //actualiza nodos
    }
    
   
   public int alturaNODOS(NodosS raiz,int altura) { //funcion que permite obtener la altura de un arbol/subarbol
      
        if(raiz!=null){ 

            int al=altura;

             al=alturaAUX(raiz, altura, al);

             raiz.altura=al;
             return al; //retorna la altura obtenida
        }
        return 0;
    }

    public int alturaAUX(NodosS raiz, int nivel,int al) { //metodo recursivo auxiliar que permite obtener la altura del arbol
 
       
        //System.out.println("valor: "+raiz.valor); 
        if (raiz.izq != null){   
            System.out.println("\t\tEntra izquierda");
            al=alturaAUX(raiz.izq, nivel + 1, al); //recorre el subarbol izquierdo
        }
            
        if (nivel > al) {
            al = nivel;
        }
            //System.out.println("al-"+al);
            
        if(raiz.der != null){   
            System.out.println("\t\tEntra derecha");
            al=alturaAUX(raiz.der, nivel + 1,al); //recorre el subarbol derecho
        }
        
        
        return al;
       
    }
    
    
    public void imprimir(){
        System.out.println("\t\tPRE-ORDEN");
        imprimirUtil(this.root);
    }
    
    public void imprimirUtil(NodosS raiz){ //metodo de impresion es directamente el recorrido en PreOrden 
        NodosS r=raiz;
        Queue<NodosS> queue = new LinkedList();  
        
        if(r!=null){
            queue.add(r);            
            while(!queue.isEmpty()){
                r=(NodosS)queue.poll();
                visit(r);
                if(r.izq!=null){
                    
                    imprimirUtil(r.izq);
                }
                if(r.der!=null){
                   
                    imprimirUtil(r.der);
                }

            }
        }
    }
    
    
    
    
    public  NodosS busquedaNODO(int valor){  //recorrido sobre el el arbol para encontrar el nodo junto con sus referencias
        return(busquedaNUTIL(valor,this.root));
    }   
    
    public NodosS busquedaNUTIL(int valor, NodosS raiz){
        
        if(raiz==null){
            
            return null;            
        }else if(raiz.valor==valor){
            
            return raiz;  //retorna si encontro el nodo
        }else if(raiz.valor>valor){
            
            return busquedaNUTIL(valor, raiz.izq); //busca en el subarbol izquierdo
            
        }else if(raiz.valor<valor){
            
            return busquedaNUTIL(valor,raiz.der); //busca en el subarbol derecho
        }   
        return null;
    }
    
  
    public  void eliminarUtil(int valor){
        NodosS n;
        n=busquedaNODO(valor);
        
        if(n!=null){
            if(n.izq==null&& n.der==null){//Si no tiene hijos
                eliminarWITHOUT(n);
                      
            }else if (n.izq!=null&& n.der==null){   //si tiene hijo izquierdo
                eliminarWITHONE(n);
                
            }else if (n.izq==null&& n.der!=null){   //si tiene hijo derecho 
                eliminarWITHONE(n);
                
            }else if(n.izq!=null&& n.der!=null){ //si tiene dos hijos
                eliminarWITHTWO(n);
                
            }
            
            requilibrar(root); //despues de eliminar hay que requilibrar
        }
         
    }

    public NodosS eliminarWITHOUT(NodosS n){ //elimina un nodo hoja
        /*
         el nodo del cual se borra, del padre se tiene que eliminar la referencia del hijo 
        */
       
        if(n.padre!=null){ 
            System.out.println("\t\tPadre "+n.padre.valor);
            NodosS iz=n.padre.izq;
            NodosS der=n.padre.der;

            if(iz==n){  //ya sea izquierdo
                n.padre.izq=null;
                System.out.println("\t\tEliminado");
            }
            if(der==n){ //ya sea derecho
                n.padre.der=null; 
                System.out.println("\t\tEliminado");
            }
            return n;
        }

        if(n==this.root){
            n=null;
        }
        return n;
    }

    public void eliminarWITHONE(NodosS n){ //elimina un nodo con un hijo
         
        /*
        si el nodo eliminado tiene un hijo el hijo se promueve a padre y la referencia de ese hijo se elimina
        */
        
        if(n.padre!=null){
            NodosS iz=n.padre.izq;
            NodosS der=n.padre.der;

            NodosS hijo;
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
            NodosS hijo;
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

    public void eliminarWITHTWO(NodosS n){ //elimina un nodo con dos hijos
        NodosS suc=sucesor(n);
        auxiliarDelate(suc);
        n.valor=suc.valor;

    }
    
    //SE NECESITA UN CASO MÁS DEBIDO A QUE TIENE LAS DOS RAICES
    public void auxiliarDelate(NodosS raiz){
    /*
      en este caso al tener dos hijos 
      se tiene que promover como nuevo padre sera el menor del subarbol derecho;
      la referencia de ese nodo suponiendo hoja, se elimina.
        
    */
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
    
    public NodosS minimo(NodosS raiz){
        NodosS actual=raiz;
        while(actual.izq!=null){
            actual=actual.izq;
        }
        return actual;
    }

    public NodosS sucesor(NodosS raiz){ //metodo que encuentra el nodo de menor valor del arbol derecho 
        NodosS suc=null;

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
    
    public void requilibrar(NodosS raiz)
    {
        root = requilibrarUtil(root);
    }
    
    
    private NodosS requilibrarUtil(NodosS raiz) {
        
        /*
        aplicando la logica de insercion 
        se llega hasta los nodos hoja de manera recursiva se evalua los factores de equilibrio
        si rompe la condicion de equiilibrio se verifica hacia donde esta mayor peso
        dependiendo de ello hara rotaciones para requilibrar
        requilibrara hasta llegar a la raiz 
        */
        NodosS aux = raiz;
       
        if(raiz!=null){
        
        requilibrarUtil(raiz.izq);
        requilibrarUtil(raiz.der);
        
            System.out.println("\t\tAltura izq - Altura der ="+(alturaNODOS(raiz.izq,1)-alturaNODOS(raiz.der,1)));
            if((alturaNODOS(raiz.izq,1)-alturaNODOS(raiz.der,1))>=2) //factor de balance
            {
                
                if((alturaNODOS(raiz.izq.izq,1)-alturaNODOS(raiz.izq.der,1))>(alturaNODOS(raiz.izq.der,1)-alturaNODOS(raiz.izq.izq,1))) //si el peso es mauor a la izquierda
                {
                    System.out.println("\t\tRotacion izq de: "+raiz.valor);
                    aux = rotarIzq(raiz);
                }
                 else  //si el peso es mayor a la derecha
                {   
                    System.out.println("\t\tRotacion doble I de: "+raiz.valor);
                    aux = rotacionDobleI(raiz);
                }
                 
                
            }
            else if((alturaNODOS(raiz.der,1)-alturaNODOS(raiz.izq,1))>=2) //factor de balance
            {
                 
                if((alturaNODOS(raiz.der.der,1)-alturaNODOS(raiz.der.izq,1))>(alturaNODOS(raiz.der.izq,1)-alturaNODOS(raiz.der.der,1))) //si el peso es mauor a la derecha
                { 
                    System.out.println("\t\tRotacion der de: "+raiz.valor);
                    aux =rotarDer(raiz);
                }
                else //si el peso es mayor a la izquierda 
                {   
                    System.out.println("\t\tRotacion doble D de: "+raiz.valor);
                    aux = rotacionDobleD(raiz);
                }
                 
            }
             
        System.out.println("\t\tReequilibrar nodo: "+raiz.valor);
        
        return aux;
        
        }
       
       
        return aux; //actualiza nodos
        
    }

  

}
