
package lineas;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Runner extends Thread{//1) Heredar de Hilo

    javax.swing.JProgressBar pista;
    Random rnd = new Random();            

    
    //2) Constructor
    public Runner(String name, javax.swing.JProgressBar pista) {
        super(name);
        this.pista = pista;
    }
    
    public void run(){
        
        for(int i =0; i<=100; i++){
            pista.setValue(i);
            try{
                sleep(rnd.nextInt(500));
            }
            catch(InterruptedException e){
            }
            
            
        }
         
        JOptionPane.showMessageDialog(null, getName()+" ya llegó.");

    }
   
    
    
    
    
}
