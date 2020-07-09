import animales.Animal;
import animales.terrestres.Perro;
import animales.aereos.Ave;

class Veterinaria{
	public static void main(String[] args) {
		
		Perro firulais = new Perro();
		firulais.comer();
		firulais.moverse();

		firulais.numeroDePatas(4);
		firulais.correr();


		Perro puppy = new Perro("Perrito");
		puppy.comer();
		puppy.moverse();

		Ave piolin = new Ave("Buho");
		piolin.comer();
		piolin.moverse();

		piolin.numeroDePatas(2);
		piolin.numeroDeAlas(2);
		piolin.correr();
		piolin.volar();


		Animal gallo = new Ave("Gallo");
		gallo.comer();
		gallo.moverse();
		//gallo.correr();
		//gallo.volar();

	}
}