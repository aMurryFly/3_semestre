
package murrieta_reza_valdespino_equipo2_g5_proyecto2;


public class NodosS {


    int valor;
    NodosS izq;
    NodosS der;
    NodosS padre;
    int altura;
        
        //CONSTRUCTORES
    
	public NodosS(){
            izq=der=padre=null;
	}

	public NodosS(int data){
		this(data,null,null);
                altura =0;
	}

        
	public NodosS(int data, NodosS lt, NodosS rt){
		valor=data;
		izq=lt;
		der=rt;

	}
     
}

