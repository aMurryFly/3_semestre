package ejercicio9_12;

import java.util.Scanner;

public interface Controlador {
    
    Scanner sc = new Scanner(System.in);
    
    
    public static int getAutorizacion(){
        String autorizacion = sc.nextLine();
        if(autorizacion.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    public static void decir(String s){
        try{
           Runtime.getRuntime().exec("say "+s);
        }catch(java.io.IOException ioe){
            
        }
    }

    public static void decir(int s){
        try{
           Runtime.getRuntime().exec("say "+s);
        }catch(java.io.IOException ioe){
            
        }
    }
}
