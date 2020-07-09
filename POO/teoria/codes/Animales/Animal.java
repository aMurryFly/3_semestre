package animales;

public abstract class Animal{
	private String tipoAnimal;

	public Animal(){

	}

	public Animal(String tipoAnimal){
		this.tipoAnimal = tipoAnimal;
	}

	public void comer(){
		System.out.println("El "+tipoAnimal+" está comiendo");
	}

	public void sonido(){
		System.out.println("El "+tipoAnimal+" está sonando");
	}

	public abstract void moverse();

	public String getTipoAnimal(){
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipo){
		this.tipoAnimal=tipo;
	}

}