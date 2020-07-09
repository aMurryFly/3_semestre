package murrieta_practica7;

public class Murrieta_practica7 {

    public static void main(String[] args) {
        
        
        //GRAFO  DE LA PRÁCTICA 
        Graph graph= new Graph(8);
        graph.addEdge(0,2);
        graph.addEdge(0,4);
        graph.addEdge(0,6);
        graph.addEdge(1,3);
        graph.addEdge(1,5);
        //Omitimos el de 2,0
        graph.addEdge(2,6);
        graph.addEdge(2,7);
        //Omitimos el 3,1
        graph.addEdge(3,6);
        graph.addEdge(3,7);
        //Omitimos el 4,0
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(4,7);
        //Omitimos el 5,1
        //Omitimos el 5,4
        //6 y 7 ya no se mencionan
        graph.addEdge(5,7);
        graph.DFS(1);
        
        
        //GRAFO PONDERADO Y PRIMM              
        
        Graph_P grafoPrimm = new Graph_P(7);
        grafoPrimm.addEdge(0,2,1);
        grafoPrimm.addEdge(0,3,3);
        grafoPrimm.addEdge(1,3,5);
        grafoPrimm.addEdge(1,5,2);
        grafoPrimm.addEdge(2,1,3);
        grafoPrimm.addEdge(2,4,2);
        grafoPrimm.addEdge(2,5,1);
        grafoPrimm.addEdge(3,4,6);
        
        grafoPrimm.printGraph(grafoPrimm);
        grafoPrimm.primm(grafoPrimm, 0);
        
        
        
        
        
        //DESCOMENTAR PARA VER LOS GRAFOS DE CLASE
        /*
        //GRAFO DE CLASE
        System.out.println("=======[GRAFO CLASE 1]==========");
        int V3=6;
        Graph graphClase2= new Graph(V3);   
        graphClase2.addEdge(0,2);
        graphClase2.addEdge(0,3);
        graphClase2.addEdge(0,1);
        graphClase2.addEdge(1,4);
        graphClase2.addEdge(1,5);
        graphClase2.addEdge(4,3);
        graphClase2.addEdge(3,1);
        graphClase2.DFS(0);

        //GRAFOS DE CLASE 
        System.out.println("=======[GRAFO CLASE 2]==========");
        int V2=5;
        Graph graphClase1= new Graph(V2);
        graphClase1.addEdge(0,1);
        graphClase1.addEdge(0,4);
        graphClase1.addEdge(1,2);
        graphClase1.addEdge(1,3);
        graphClase1.addEdge(1,4);
        graphClase1.addEdge(2,3);
        graphClase1.addEdge(3,4);
        graphClase1.DFS(1);

        
        //GRAFOS DE CLASE 
        System.out.println("=======[GRAFO CLASE 3]==========");
        int V4=5;
        Graph graphClase3= new Graph(V4);
        graphClase3.addEdge(0,1);
        graphClase3.addEdge(0,3);
        graphClase3.addEdge(1,3);
        graphClase3.addEdge(2,3);
        graphClase3.addEdge(3,4);
        graphClase3.DFS(1);
        */

        
    }
    
}
