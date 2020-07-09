package murrieta_practica7;

/*
PARA EL DESARROLLO DE ESTE ALGORITMO TUVO QUE PARTICE NUEVAMENTE DESDE CEROS 
DEBIDO A LAS LIMITACIONES DL CÓDIGO ANTERIOR  
*/

import java.util.*;

public class Graph_P {
    
    //VARIABLES GLOBALES 
        //Para las clases 
        private LinkedList<Integer> adjList[];
        private LinkedList<Vertice> ListVertices;
        //Variables anteriores 
        private int V;
        private int [][] ponderados=null;
        private int cantAristas=0;
    
        
    //CONSTRUCTOR    
    Graph_P(int v){
        V=v;
        adjList= new LinkedList[v];
        ListVertices= new LinkedList<Vertice>();
        for(int i =0; i<V; i++){
            ListVertices.add(new Vertice(i));
        }
        
        for(int i=0; i<v; ++i){
            adjList[i]=new LinkedList();
        }
        
        int [][] pond = new int[v][v];
        ponderados= pond;
        
    }

    void addEdge(int v, int w, int pond){
        
        ponderados[v][w]=pond;
        ponderados[w][v]=pond;
        
        ListVertices.get(v).vertAdyacente.add(new VertAdy(ListVertices.get(w),ListVertices.get(v), pond));
        ListVertices.get(w).vertAdyacente.add(new VertAdy(ListVertices.get(v),ListVertices.get(w), pond));

    }

    //MÉTODO DE IMPRESIÓN 
    void printGraph (Graph_P graph){
        
        System.out.println("\nLISTA DE ADYACENCIA [GRAFO]");
        for(int v=0; v<graph.V; v++){
            System.out.println("[Para: "+v+"]");
            for (VertAdy vertAdy : ListVertices.get(v).vertAdyacente) {
                System.out.println(v+" -> "+vertAdy.conexion.value+" Valor: "+ vertAdy.ponderacion);
            }  
        }
        System.out.println("\n");
    }

    //LÓGICA Y ALGORITMO DE PRIMM
    
    void primm(Graph_P graph, int nodoInicio){
        
        PriorityQueue<VertAdy> colaPrioridad= new PriorityQueue<VertAdy>();//cola de prioridad 
        boolean checked[]= new boolean[graph.V];
        LinkedList <VertAdy> listaPrimm= new LinkedList<>();
        Vertice nodo= graph.ListVertices.get(nodoInicio);
        checked[nodo.value]=true;
        Iterator <VertAdy> iterador= nodo.vertAdyacente.listIterator();
        int peso =0;
        
        System.out.println("MST - PRIMM\n");
        System.out.println("Nodo de inicio: "+nodoInicio);

        while (iterador.hasNext()){
            VertAdy j= iterador.next();
            colaPrioridad.add(j);
        }
        
        VertAdy chequeo = colaPrioridad.poll();
        UtilPrimm(chequeo,graph,colaPrioridad,checked,listaPrimm);
        
        for(int j=0; j<listaPrimm.size();j++) {
            System.out.println(listaPrimm.get(j).toString());
            peso = peso + listaPrimm.get(j).getPonderacion();
        }
        System.out.println("\n El total del recorrido es: "+peso);
    }
    
    
    //MÉTODO RECURSIVO BASADO EN UN CÓDIGO OBTENIDO DE : https://github.com/search?q=PRIMM+ALGORITHM
    
    /*
    El desarrolo de la parte del chequeo de la cola de prioridad sin duda alguna 
    fue la parte que debo atribuirle el crédito a varios códigos de otras personas
    */
    
    void UtilPrimm(VertAdy check,Graph_P grafo, PriorityQueue <VertAdy> colaP,boolean [] listCheck,LinkedList <VertAdy> listaPrimm){

        if(listCheck [check.conexion.value]==false){
            
            listCheck [check.conexion.value]=true;
            listaPrimm.add(check);
            Vertice aux_ = grafo.ListVertices.get(check.conexion.value);
            Iterator <VertAdy> aux = aux_.vertAdyacente.listIterator();
            
            while (aux.hasNext()){
                VertAdy j= aux.next();
                colaP.add(j);
            }

        }
        
        VertAdy sig= colaP.poll();
        //Parte recursiva
        if(!colaP.isEmpty()){
            UtilPrimm(sig,grafo,colaP,listCheck,listaPrimm);
        }
    
    } 
    
    
}
