package animales.terrestres;
import animales.Animal;
import animales.terrestres.Patas;
import animales.Movimiento;

//import animales.*;

public class Perro extends Animal implements Patas{

	public Perro(){
		super();
		setTipoAnimal("Perro");
	}

	public Perro( String tipoAnimal){
		super(tipoAnimal);
		
	}

	public void moverse(){
		System.out.println("El "+getTipoAnimal()+" está "+Movimiento.TIPO[Movimiento.MV]);
	}

	public void numeroDePatas(int patas){
		System.out.println("El "+getTipoAnimal()+" tiene "+patas+" patas");
	}

	public void correr(){
		System.out.println("El "+getTipoAnimal()+" está "+Movimiento.Cr);
	}

}