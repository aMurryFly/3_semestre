package parctica9;

import java.util.Random;

public class Aleatorio {

    int numero;

    Random random = new Random();

    public Aleatorio() {
        this.generarNumero();
    }

    public void setNumero(int numero) {
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void generarNumero() {
        numero = random.nextInt(100);
    }

    @Override
    public String toString() {
        return numero<10? "0"+numero : ""+numero;
    }
}
