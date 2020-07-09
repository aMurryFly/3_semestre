//CÓDIGO PARA GRAFOS PONDERADOS

package practica6.murrietaalfonso;

public class Graph_Pon {
    
    
    private int V;
    private int [][] ma_ady;
    
    //Construcor
    //NOTA: La matriz es cuadrada
    Graph_Pon(int n){
        V=n;

        ma_ady = new int[V][V];
        //se inicializa matriz en 0
        for(int i=0; i< V; i++){
            for(int j=0; j< V; j++){
                ma_ady[i][j] = 0;
            }            
        }
    }
    
    void addEdge(int v, int w){
        ma_ady[v][w] += 1;
    }
    
    void printGraph(){
        System.out.println("MATRIZ DE ADYACENCIA DE un GRADO PONDERADO");
        for(int i=0; i< V; i++){
            for(int j=0; j< V; j++){
                System.out.print( ma_ady[i][j] + "  " );        
            }
            System.out.println();
        }  
    }
    
}
