/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javax.swing.JLabel;

/**
 *
 * @author pon_c
 */
public class Conta extends Thread {
    boolean termino = false;
    
    JLabel a;
    public Conta(JLabel n)
    {
        this.a = n;
        
    }
       
    public void run(){
        
        for (int segundos = 300; segundos>=0; segundos--) {
    try {
       sleep(1000);
    } 
    catch (InterruptedException e) {
    }
     String na = String.valueOf(segundos);
     a.setText(na);
     System.out.println(na);
    }
     
     termino = true;   
    }
   
    
    

}
