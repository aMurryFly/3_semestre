package parctica9;

import java.util.Scanner;

public interface Controlador {
    
    Scanner sc = new Scanner(System.in);

    public static int getAutorizacion(){
        
        String auto= sc.nextLine();
        if (auto.isEmpty()){
            return 1;
        
        }else
    
        return 0;
    }

    public static void decir(String s){
        try{
            Runtime.getRuntime().exec("say "+s);//Hilos
        }catch(java.io.IOException ioe){}
    
    }

    public static void decir(int s){
        try{
            Runtime.getRuntime().exec("say "+s);
        }catch(java.io.IOException ioe){}
    }
}
