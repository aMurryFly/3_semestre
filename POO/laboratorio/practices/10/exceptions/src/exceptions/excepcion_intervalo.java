package exceptions;

public class excepcion_intervalo extends Exception{//Heredamos

    public excepcion_intervalo(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Excepción intervalo: "+super.getMessage(); 
    }
    
    
    
    
}
