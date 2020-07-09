package animales.aereos;
import animales.Animal;
import animales.terrestres.Patas;
import animales.aereos.Alas;
import animales.Movimiento;

//import animales.*;
//import animales.terrestres.*;

public class Ave extends Animal implements Patas, Alas{

	public Ave(){
		super();
		setTipoAnimal("Ave");
	}

	public Ave( String tipoAve){
		super(tipoAve);
	}

	public void moverse(){
		System.out.println("El "+getTipoAnimal()+" está "+Movimiento.TIPO[Movimiento.VL]);

	}

	public void numeroDePatas(int patas){
		System.out.println("El "+getTipoAnimal()+" tiene "+patas+" patas");
	}

	public void correr(){
		System.out.println("El "+getTipoAnimal()+" está corriendo");
	}	

	public void numeroDeAlas(int alas){
		System.out.println("El "+getTipoAnimal()+" tiene "+alas+" alas");
	}
	public void volar(){
		System.out.println("El "+getTipoAnimal()+" está volando");
	}


}