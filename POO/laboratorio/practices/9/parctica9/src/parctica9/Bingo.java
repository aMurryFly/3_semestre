package parctica9;

public class Bingo implements Juego {

    Tablero tablero;

    public Bingo(Tablero tablero) {
        this.tablero = tablero;
    }

    public void jugar() {
        tablero.addNumActual();
        Controlador.decir(tablero.numActual);
    }

    public void pausar() {
    }

    public boolean continuar() {
        int respuesta = Controlador.getAutorizacion();
        if (respuesta==1)
            return true;
        else
            return false;
        
    }

    public void terminar() {
    }

    public void comenzar() {
        tablero.limpiar();
        tablero.mostrar();
        tablero.addNumActual();
        Controlador.decir(tablero.numActual);
    }

    public void reiniciar() {
        comenzar();
    }
}
