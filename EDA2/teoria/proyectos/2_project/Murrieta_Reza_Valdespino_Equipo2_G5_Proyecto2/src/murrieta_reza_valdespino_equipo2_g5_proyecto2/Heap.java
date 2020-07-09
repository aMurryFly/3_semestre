/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murrieta_reza_valdespino_equipo2_g5_proyecto2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.lang.NullPointerException;
/**
 *
 * @author Segarecha
 */
public class Heap {
    int cantidad;
    int nivel;
    
    NodosH raiz;
    
    
    public Heap(){
        this.cantidad=0;
        this.raiz=null;
        this.nivel=0;  
    }
    //Agregado de un nodo y el acomodo
    public void add(int valor){
        System.out.println("\t\tAgregar: "+valor);
        if(!find(valor,this.raiz)){
            NodosH ultimo=agregar(valor);
            checar(ultimo);
        }
    }
    //Función para revisar si el dato a agregar se encuentra o no en el heap
    public boolean find(int valor,NodosH dato){
        if(this.raiz!=null){
            Queue <NodosH> lista= new LinkedList <NodosH>();
            lista.add(dato);
            //Recorrido BFS para la búsqueda de valores
            while(!lista.isEmpty()){
                NodosH aux=lista.poll();
                //Si el valor es diferente a la del nodo visitado
                if(aux.valor!=valor){
                    if(aux.NodoIzq!=null){
                        
                        lista.add(aux.NodoIzq);
                    }if(aux.NodoDer!=null){
                        
                        lista.add(aux.NodoDer);    
                    }
                }else if(aux.valor==valor){
                    System.out.println("\t\tEl dato "+valor+ " ya se encuentra en el heap.");
                    //Si es igual regresará verdadero, avisará que si se encuentra en el heap
                    return true;
                }
            }

            //No se encuentro coincidencia
            return false;
        }else{
            //Si se encuentra vacia
            return false;
        }
        
        
    }
    //Agregado de datos en el heap
    public NodosH agregar(int valor){
        
        Queue <NodosH> lista= new LinkedList <>();
        List <NodosH> LevelList= new ArrayList <>();
        NodosH regreso = null;
        boolean guardado=false;
        if(this.raiz==null){
            //Caso del nodo raíz
            nivel++;
            this.raiz= new NodosH(valor,nivel);
            cantidad++;
            nivel++;
            regreso=this.raiz;
            
        }else{
            //Caso de los nodos siguientes
            lista.add(this.raiz);
            System.out.println("\t\tNivel: "+nivel);
            while(!lista.isEmpty()){
                NodosH n= lista.poll();
                //Obtendión de los nodos del penúltimo nivel
                if(n.nivel==this.nivel-1){
                    LevelList.add(n);
                }
                if(n.NodoIzq!=null)
                    lista.add(n.NodoIzq);
                if(n.NodoDer!=null)
                    lista.add(n.NodoDer);
            
            }
            //Si el nivel máximo está lleno, se usará esta referencia para el nuevo nivel
            NodosH aux= LevelList.get(0);
            
            
            
            //Agregado del nodo junto con las referencias
            while(!LevelList.isEmpty()){
                //Ingreso del nuevo nodo a la posición más a la izquierda y abajo del heap
                NodosH g = LevelList.remove(0);
                if(g.NodoIzq==null){
                    g.NodoIzq= new NodosH(valor,nivel);
                    g.NodoIzq.NodoPadre=g;
                    regreso=g.NodoIzq;
                    guardado=true;
                    break;
                }else if(g.NodoIzq!=null && g.NodoDer==null){
                    g.NodoDer=new NodosH(valor,nivel);
                    regreso=g.NodoDer;
                    g.NodoDer.NodoPadre=g;
                    guardado=true;
                    break;
                }
                
            }
            //Si todo el nivel está lleno, aumenta el nivel el nivel y se guarda en ese
            if(!guardado){
                nivel++;
                aux.NodoIzq.NodoIzq= new NodosH(valor,nivel);
                aux.NodoIzq.NodoIzq.NodoPadre=aux.NodoIzq;
                regreso=aux.NodoIzq.NodoIzq;
                
            }
            cantidad++;
            
            
        }
            if(regreso.NodoPadre!=null){
                System.out.println("\t\tNodo "+regreso.valor+ " padre "+regreso.NodoPadre.valor);
            }
            
            //Regresa el nuevo nodo con las referencias para el chequeo
            return regreso;
        
        }
    //Función que revisará si el nodo agregado cumple con las especificaciones de un heap
    public void checar(NodosH check){
        if(check.NodoPadre!=null){
            NodosH copy=check;
            NodosH copyIzq= check.NodoIzq;
            NodosH copyDer=check.NodoDer;
            NodosH aux=check.NodoPadre;
            
                if(check.valor>aux.valor){
                    //Caso en el que el nodo agregado tenga actualmente al nodo raíz
                    if(aux.equals(this.raiz)){
                        if(aux.NodoIzq.equals(check)){
                            //Cambio de referencias con el nodo izquierdo
                            check.NodoIzq=aux;
                            try{
                            aux.NodoDer.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoDer=aux.NodoDer;
                            
                        }else if(aux.NodoDer.equals(check)){
                            //Cambio de referencias con el nodo derecho
                            check.NodoDer=aux;
                            try{
                            aux.NodoIzq.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoIzq=aux.NodoIzq;
                            
                        }
                        check.NodoPadre=null;
                        check.nivel=aux.nivel;
                        
                        //Nodo Padre
                        aux.NodoPadre=check;
                        try{
                            copyIzq.NodoPadre=aux;
                            copyDer.NodoPadre=aux;
                        }catch(NullPointerException en){}
                        aux.NodoIzq=copyIzq;
                        aux.NodoDer=copyDer;
                        aux.nivel=copy.nivel+1;
                        
                        this.raiz=check;
                        
                        //Si el nodo no tiene referencias y es diferente al nodo raiz
                    }else if((check.NodoIzq==null && check.NodoDer==null)&&!aux.equals(this.raiz)){
                        //Cambio de referencias
                        check.NodoPadre=aux.NodoPadre;
                        System.out.println("\t\tNivel de "+ check.valor +" es "+check.nivel);
                        
                        //Referencia del nodo abuelo
                        if(aux.NodoIzq.equals(check)){
                            check.NodoIzq=aux;
                            try{
                            aux.NodoDer.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoDer=aux.NodoDer;
                            
                        }else if(aux.NodoDer.equals(check)){
                            check.NodoDer=aux;
                            try{
                            aux.NodoIzq.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoIzq=aux.NodoIzq;
                            
                        }
                        check.nivel=aux.nivel;
                        
                        //Nodo Padre
                        aux.NodoPadre=check;
                        try{
                            copyIzq.NodoPadre=aux;
                            
                        }catch(NullPointerException en){}
                        try{
                            copyDer.NodoPadre=aux;
                        }catch(NullPointerException en){}
                        aux.NodoIzq=null;
                        aux.NodoDer=null;
                        aux.nivel=copy.nivel+1;
                      
                        try{
                            if(check.NodoPadre.NodoIzq.equals(aux))
                                check.NodoPadre.NodoIzq=check;
                            else if (check.NodoPadre.NodoDer.equals(aux)){
                                check.NodoPadre.NodoDer=check;
                            }
                        }catch(NullPointerException en){}
                        //Si el nodo tiene una referencia (nodo izquierdo)
                    }else if((check.NodoIzq!=null && check.NodoDer==null) &&!aux.equals(this.raiz)){
                        //Cambio de referencias
                        check.NodoPadre=aux.NodoPadre;
                        System.out.println("\t\tNivel de "+ check.valor +" es "+check.nivel);
                        
                        //Referencia del nodo abuelo
                        if(aux.NodoIzq.equals(check)){
                            check.NodoIzq=aux;
                            try{
                            aux.NodoDer.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoDer=aux.NodoDer;
                            
                        }else if(aux.NodoDer.equals(check)){
                            check.NodoDer=aux;
                            try{
                            aux.NodoIzq.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoIzq=aux.NodoIzq;
                            
                        }
                        check.nivel=aux.nivel;
                        
                        //Nodo Padre
                        aux.NodoPadre=check;
                        try{
                            copyIzq.NodoPadre=aux;
                            
                        }catch(NullPointerException en){}
                        try{
                            copyDer.NodoPadre=aux;
                        }catch(NullPointerException en){}
                        aux.NodoIzq=copyIzq;
                        aux.NodoDer=copyDer;
                        aux.nivel=copy.nivel+1;
                        
                        try{
                            if(check.NodoPadre.NodoIzq.equals(aux))
                                check.NodoPadre.NodoIzq=check;
                            else if (check.NodoPadre.NodoDer.equals(aux)){
                                check.NodoPadre.NodoDer=check;
                            }
                        }catch(NullPointerException en){}
                        //Caso en el que el nodo tiene 2 hijos
                    }else if((check.NodoIzq!=null && check.NodoDer!=null) &&!aux.equals(this.raiz)){
                        //Cambio de referencias
                        check.NodoPadre=aux.NodoPadre;
                        System.out.println("\t\tNivel de "+ check.valor +" es "+check.nivel);
                        
                        //Referencia del nodo abuelo
                        if(aux.NodoIzq.equals(check)){
                            check.NodoIzq=aux;
                            try{
                            aux.NodoDer.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoDer=aux.NodoDer;
                            
                        }else if(aux.NodoDer.equals(check)){
                            check.NodoDer=aux;
                            try{
                            aux.NodoIzq.NodoPadre=check;
                            }catch(java.lang.NullPointerException en){}
                            check.NodoIzq=aux.NodoIzq;
                            
                        }
                        check.nivel=aux.nivel;
                        //Nodo Padre
                        aux.NodoPadre=check;
                        try{
                            copyIzq.NodoPadre=aux;
                            
                        }catch(NullPointerException en){}
                        try{
                            copyDer.NodoPadre=aux;
                        }catch(NullPointerException en){}
                        aux.NodoIzq=copyIzq;
                        aux.NodoDer=copyDer;
                        aux.nivel=copy.nivel+1;
                        
                        try{
                            if(check.NodoPadre.NodoIzq.equals(aux))
                                check.NodoPadre.NodoIzq=check;
                            else if (check.NodoPadre.NodoDer.equals(aux)){
                                check.NodoPadre.NodoDer=check;
                            }
                        }catch(NullPointerException en){}

                    }
                    //Si se puede hacer la recursividad con el nodo
                    if(check.nivel>1)
                        checar(check);
                    
                    
             //Caso en el que cumple las condiciones       
            }else{
                    System.out.println("\t\tNodo establecido. ");
            }
        }
        
    }    
    //Eliminar raiz
    public void deleteRoot(){
        System.out.println("\t\tSe eliminará el nodo: "+this.raiz.valor);
        eliminar();
    }
    //Esta función eliminará la raíz y y lo sustituye con la última posición del nodo
    public void eliminar(){
        NodosH ultimoN=BuscarUltimo();
        System.out.println("\t\tValor del último nodo: "+ultimoN.valor);
        //Eliminar referencias del último nodo con su padre
        if(ultimoN.NodoPadre.NodoIzq.equals(ultimoN)){
            ultimoN.NodoPadre.NodoIzq=null;
        }else if(ultimoN.NodoPadre.NodoDer.equals(ultimoN)){
            ultimoN.NodoPadre.NodoDer=null;
        }
        ultimoN.NodoPadre=null;
        
        //Nuevas referencias de la raíz
        ultimoN.NodoIzq=this.raiz.NodoIzq;
        ultimoN.NodoDer=this.raiz.NodoDer;
        //Referencias de los hijos
        if(this.raiz.NodoIzq!=null)
            this.raiz.NodoIzq.NodoPadre=ultimoN;
        if(this.raiz.NodoDer!=null)
            this.raiz.NodoDer.NodoPadre=ultimoN;
        
        ultimoN.nivel=1;
        this.cantidad--;
        this.raiz=ultimoN;
        
        //Reacomodo del heap despues de la eliminación
        acomodo(this.raiz);
        
        
        
    }
    
    //Función la cual acomoda el heap después de eliminar y haber sustituido la raíz
    public void acomodo(NodosH ultimoN){
        //Nodo máximo y copias de la información del nodo
        NodosH max;
        NodosH CopiaUltHijo;
        NodosH MIzq=null;
        NodosH MDer=null;
        if(ultimoN.equals(this.raiz)){
            //Caso del primer acomodo entre la raíz y sus hijos
            if(ultimoN.NodoIzq!=null&&ultimoN.NodoDer!=null){
                
                if(ultimoN.NodoIzq.valor>ultimoN.valor || ultimoN.NodoDer.valor>ultimoN.valor){
                    //Obtención del nodo mayor
                    max = max(ultimoN.NodoIzq, ultimoN.NodoDer);
                    if(max.NodoIzq!=null){
                        MIzq=max.NodoIzq;
                    }
                    if(max.NodoDer!=null){
                        MDer=max.NodoDer;
                    }
                    if(max.equals(ultimoN.NodoDer)){
                        //Cambio de referencias con el nodo derecho
                        CopiaUltHijo=ultimoN.NodoIzq;
                        
                        max.NodoIzq=CopiaUltHijo;
                        CopiaUltHijo.NodoPadre=max;
                        max.NodoDer=ultimoN;
                        ultimoN.NodoPadre=max;
                        max.NodoPadre=null;
                        this.raiz=max;
                        max.nivel=1;
                        if(MIzq!=null){
                            ultimoN.NodoIzq=MIzq;
                            MIzq.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoIzq=null;
                        }
                        if(MDer!=null){
                            ultimoN.NodoDer=MDer;
                            MDer.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoDer=null;
                        }
                        
                        ultimoN.nivel++;
                    }else if(max.equals(ultimoN.NodoIzq)){
                        //Cambio de referencias con el nodo izquierdo
                        CopiaUltHijo=ultimoN.NodoDer;
                        
                        max.NodoDer=CopiaUltHijo;
                        CopiaUltHijo.NodoPadre=max;
                        max.NodoIzq=ultimoN;
                        ultimoN.NodoPadre=max;
                        max.NodoPadre=null;
                        this.raiz=max;
                        max.nivel=1;
                        if(MIzq!=null){
                            ultimoN.NodoIzq=MIzq;
                            MIzq.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoIzq=null;
                        }
                        if(MDer!=null){
                            ultimoN.NodoDer=MDer;
                            MDer.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoDer=null;
                        }
                        ultimoN.nivel++;
                    }
                    //Revisará si aun tiene referencias de hijos
                    if(ultimoN.NodoIzq!=null || ultimoN.NodoDer!= null){
                        System.out.println("\t\tRecursion");
                        acomodo(ultimoN);
                    
                    }
                }
            
            }
        //Caso para los nodos intermedios y sus hijos
        }else if(!ultimoN.equals(this.raiz)){
            System.out.println("\t\tNo es raíz");
            NodosH CopiaP= ultimoN.NodoPadre;
            if(ultimoN.NodoDer!=null && ultimoN.NodoIzq!=null){
                if(ultimoN.NodoIzq.valor>ultimoN.valor || ultimoN.NodoDer.valor>ultimoN.valor){
                    max = max(ultimoN.NodoIzq, ultimoN.NodoDer);
                    if(max.NodoIzq!=null){
                        MIzq=max.NodoIzq;
                    }
                    if(max.NodoDer!=null){
                        MDer=max.NodoDer;
                    }
                    if(max.equals(ultimoN.NodoDer)){
                        //Cambio de referencias con el nodo derecho
                        CopiaUltHijo=ultimoN.NodoIzq;
                        
                        max.NodoIzq=CopiaUltHijo;
                        CopiaUltHijo.NodoPadre=max;
                        max.NodoDer=ultimoN;
                        ultimoN.NodoPadre=max;
                        max.NodoPadre=CopiaP;
                        
                        if(CopiaP.NodoIzq.equals(ultimoN))
                            CopiaP.NodoIzq=max;
                        else if(CopiaP.NodoDer.equals(ultimoN))
                            CopiaP.NodoDer=max;
                        
                        
                        max.nivel--;
                        if(MIzq!=null){
                            ultimoN.NodoIzq=MIzq;
                            MIzq.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoIzq=null;
                        }
                        if(MDer!=null){
                            ultimoN.NodoDer=MDer;
                            MDer.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoDer=null;
                        }
                        
                        ultimoN.nivel++;
                    }else if(max.equals(ultimoN.NodoIzq)){
                        //Cambio de referencias con el nodo izquierdo
                        CopiaUltHijo=ultimoN.NodoDer;
                        
                        max.NodoDer=CopiaUltHijo;
                        CopiaUltHijo.NodoPadre=max;
                        max.NodoIzq=ultimoN;
                        ultimoN.NodoPadre=max;
                        max.NodoPadre=CopiaP;
                        if(CopiaP.NodoIzq.equals(ultimoN))
                            CopiaP.NodoIzq=max;
                        else if(CopiaP.NodoDer.equals(ultimoN))
                            CopiaP.NodoDer=max;
                        
                        
                        max.nivel--;
                        if(MIzq!=null){
                            ultimoN.NodoIzq=MIzq;
                            MIzq.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoIzq=null;
                        }
                        if(MDer!=null){
                            ultimoN.NodoDer=MDer;
                            MDer.NodoPadre=ultimoN;
                        }else{
                            ultimoN.NodoDer=null;
                        }
                        ultimoN.nivel++;
                    }
                    //Revisará si hay nodos hijos
                    if(ultimoN.NodoIzq!=null || ultimoN.NodoDer!= null){
                        System.out.println("\t\tRecursion");
                        acomodo(ultimoN);
                    
                    }
                }
            }else if(ultimoN.NodoDer==null && ultimoN.NodoIzq!=null){
                if(ultimoN.NodoIzq.valor>ultimoN.valor ){
                    //Cambio de información con el nodo izquierdo
                    max =ultimoN.NodoIzq;
                    max.NodoIzq=ultimoN;
                    ultimoN.NodoPadre=max;
                    max.NodoPadre=CopiaP;
                    if(CopiaP.NodoIzq.equals(ultimoN))
                        CopiaP.NodoIzq=max;
                    else if(CopiaP.NodoDer.equals(ultimoN))
                        CopiaP.NodoDer=max;
                    
                    max.nivel--;
                        
                    ultimoN.NodoIzq=null;
                    ultimoN.nivel++;
                    }
                }
            
            }    
        }
        
   
    //Función que busca el nodo en la última posición del heap.
    public NodosH BuscarUltimo(){
        Queue <NodosH> lista= new LinkedList <>();
        List <NodosH> Leaf= new ArrayList <>();
        NodosH last;
        lista.add(this.raiz);
        //Recorrido BFS
        while(!lista.isEmpty()){
            NodosH n= lista.poll();
            if(n.NodoIzq==null && n.NodoDer==null){
                Leaf.add(n);
            }
            if(n.NodoIzq!=null)
                    lista.add(n.NodoIzq);
            if(n.NodoDer!=null)
                lista.add(n.NodoDer);
            
        }
        //Ultimo nodo en la última posición del heap
        last=Leaf.get(Leaf.size()-1);
        return last;
    
    }
    //Funcióon que obtiene el nodo mayor para hacer el acomodo del heap
    public NodosH max(NodosH izq, NodosH der){
        
        if(izq.valor>der.valor)
            return izq;
        else
            return der;
    }
    
    //Impresión
    public void printHeap(){
        System.out.println("\t\tImpresión de Heap");
        System.out.println("\t\tCantidad de datos: "+this.cantidad);
        print(this.raiz);
        
    }
    //Recorrido para la impresión
    public void print(NodosH dato){
        
        Queue <NodosH> lista= new LinkedList <NodosH>();
        lista.add(dato);
        //BFS para la impresión de la información
        while(!lista.isEmpty()){
            NodosH aux=lista.poll();
            System.out.println("\t\tNodo: "+aux.valor);
            System.out.println("\t\tNivel actual: "+aux.nivel);
            if(aux.NodoPadre!=null){
                System.out.println("\t\t\tNodo Padre: "+aux.NodoPadre.valor);

            }
            if(aux.NodoIzq!=null){
                System.out.println("\t\t\tNodo Izq: "+aux.NodoIzq.valor);
                lista.add(aux.NodoIzq);
            }if(aux.NodoDer!=null){
                System.out.println("\t\t\tNodo Der: "+aux.NodoDer.valor);
                lista.add(aux.NodoDer);
                
            }
        }
    
    }
}
