package practica6.murrietaalfonso;

public class Practica6MurrietaAlfonso {

    public static void main(String[] args) {
        int V=5;
        
        Graph graph= new Graph(V);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph(graph);
        graph.BFS(1);

        
        //GRAFO DE CLASE
        int V2=6;
        Graph graphClase= new Graph(V2);   
        graphClase.addEdge(0,2);
        graphClase.addEdge(0,3);
        graphClase.addEdge(0,1);
        graphClase.addEdge(1,4);
        graphClase.addEdge(1,5);
        graphClase.addEdge(4,3);
        graphClase.addEdge(3,1);
        
        graphClase.printGraph(graphClase);
        graphClase.BFS(0);
        
        
        //GRAFO DE CLASE DIRIGIDO
        int v2=6;
        Graph graphClaseD= new Graph(v2);   
        graphClaseD.addEdge(0,2);
        graphClaseD.addEdge(0,3);
        graphClaseD.addEdge(0,1);
        graphClaseD.addEdge(1,4);
        graphClaseD.addEdge(1,5);
        graphClaseD.addEdge(4,3);
        graphClaseD.addEdge(3,1);
        
        
        
        //GRAFO PONDERADO
        
        Graph_Pon matrix = new Graph_Pon(5);//Se pasa el tamaño (cant nodos)
        
        matrix.addEdge(0, 1);
        matrix.addEdge(0, 1);
        matrix.addEdge(0, 2);
        matrix.addEdge(1, 0);
        matrix.addEdge(1, 0);
        matrix.addEdge(1, 4);        
        matrix.addEdge(2, 0);
        matrix.addEdge(2, 3);
        matrix.addEdge(2, 4);        
        matrix.addEdge(3, 2);        
        matrix.addEdge(4, 1);
        matrix.addEdge(4, 2);
        matrix.addEdge(4, 4);
        matrix.addEdge(4, 4);
        
        matrix.printGraph();
        
        
    }
    
}
