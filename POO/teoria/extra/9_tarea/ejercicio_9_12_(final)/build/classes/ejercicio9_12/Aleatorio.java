package ejercicio9_12;
import java.util.Random;

public class Aleatorio {

     int numero;

     Random rnd = new Random();

    public Aleatorio() {
        this.generarNumero();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void generarNumero() {
        numero = rnd.nextInt(100);
    }

    @Override
    public String toString() {
        return numero < 10? "0" + numero: "" + numero;
    }
    
}
