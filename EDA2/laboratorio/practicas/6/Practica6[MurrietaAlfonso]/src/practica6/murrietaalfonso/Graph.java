package practica6.murrietaalfonso;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjList[];
    
    Graph(int v){
        V=v;
        adjList = new LinkedList[v];
        
        for(int i=0; i<v; ++i){
            adjList[i]= new LinkedList();
        }
    }
    
    void addEdge(int v, int w){
        adjList[v].add(w);
        adjList[w].add(v);
        /*Para llevar a cabo el dirigido solamente debemos comentar una de 
        las lineas anteriores*/
    }
    
    void printGraph(Graph graph){
        for(int v=0; v < graph.V; v++){
            System.out.println("Lista de Adyacencia del vertice "+v);
            System.out.println(v);
            for(Integer node: graph.adjList[v]){
                System.out.println(" -> "+node);
            }
            System.out.println("\n");
        }
    }
    
    void BFS(int s){
        
        boolean visited[]= new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[s]=true;
        queue.add(s);
        
        System.out.println("LOS NODOS RECORRIDOS SON: ");
        while(queue.size() !=0){
            s=queue.poll();//Sacar elemento "desencolar"
            System.out.println(s+" ");
            
            Iterator<Integer> i= adjList[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }    
        }
    }
    
}
