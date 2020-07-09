
package escuela_fixed;

public class Alumno extends Materia  {
    
    	private int numCuenta;
	private String carrera;
    
    	//Constructores
	public Alumno(){
		this.numCuenta = 000000;
		this.carrera = "N/A";
	}

    	//SETTERS
	
	public void setNumCuenta(int numeroCuenta ){
		this.numCuenta=numeroCuenta;
	}

	public void setCarrera(String carrera){
		this.carrera= carrera;
	}
	
	//GETTERS
	
	public int getNumCuenta(){
		return this.numCuenta;
	}
	
	public String getCarrera(){
		return this.carrera;
	} 
    
}
