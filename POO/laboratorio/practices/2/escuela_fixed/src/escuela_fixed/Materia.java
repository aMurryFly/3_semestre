
package escuela_fixed;

public class Materia {
    
    	private String nombre;
	
	//Constructores
	public Materia(){
		this.nombre = "No data";
	}
	
	public Materia(String name ){
		this.nombre = name;
	}

        //GETTER
	public String getNombreM(){
		return this.nombre;
	}

	//SETTERS
	public void setNombre(String name){
		this.nombre = name;
	}
    
}

