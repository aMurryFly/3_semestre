package com.company;


/**
 *
 * @author pon_c
 */
public class Reloj extends Thread {
    boolean termino = false;
    Integer time;

    public Reloj(Integer time){
        this.time=time;

    }

    public void run(){
        for (int segundos = time; segundos>=0; segundos--) {
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
            }
            String na = String.valueOf(segundos);
            SpaceMain.text4.setText(na.toString());
        }

        termino = true;
    }




}
