package exceptions;

import java.io.*;

public class Exceptions {

    public static void main(String[] args){// throws IOException{//Para omitir el error de excepción
        
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            //Lector e flujo de datos / lo convierte en cadenas
            BufferedReader br = new BufferedReader(isr);

            int x, y; 

            System.out.println("Escribe el numerado: ");
            x = Integer.parseInt(br.readLine());//para cambiar la cadena a entero
            System.out.println("Escribe el divisor: ");
            y = Integer.parseInt(br.readLine());//para cambiar la cadena a entero

            verificarrango(x,y);
            System.out.println("EL resultado es: " + (x/y) );
        }
        
        catch(java.lang.ArithmeticException ex){
            System.out.println("No se puede dividir entre cero >:v ");
            ex.printStackTrace();
        }
        
        //PARA CADA EXCEPCIÓN CREADA O USADA
        
        catch(IOException x){//Versión alternativa a throws IOException en el método        
        }
        catch(excepcion_intervalo ex){
            System.out.println(ex.getMessage());
        }
        
        finally{
            System.out.println("Procedimiento de guardado");
        }
        
    }

//Puede que lance a través de throws    
    static void verificarrango(int n, int d) throws excepcion_intervalo{
        if((n<0)|| (d<0)){
            throw new excepcion_intervalo("Número fuera de rango");
        }
    }
    
    
}
