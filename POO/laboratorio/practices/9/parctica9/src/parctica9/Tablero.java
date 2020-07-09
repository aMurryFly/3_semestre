package parctica9;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Tablero extends JFrame{

    JLabel lblActual;

    JLabel[] etiqueta;

    int numActual;

    Aleatorio random = new Aleatorio();

    public Tablero() {
        
        this.setSize(960, 1040);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(null);
        this.add(panel);
        
        lblActual = new JLabel("Bingo");
        lblActual.setFont(new java.awt.Font("Console", 0, 50));
        lblActual.setForeground(Color.green);
        lblActual.setBounds(0,0,960,150);
        lblActual.setHorizontalAlignment(SwingConstants.CENTER);
        lblActual.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(lblActual);
        
        etiqueta = new JLabel[100];
        int ren=1;
        int col=0;
        for (int i=0; i<etiqueta.length; i++){
            if ( i%10 == 0){
                ren=0;
                col++;
            }
            ren++;
            
            /*
                if ( i%10 == 0){
                col=0;
                ren++;
            }
            col++;
            */
            
            
            etiqueta[i]= new JLabel(""+i);
            etiqueta[i].setFont(new java.awt.Font("Console", 0, 35));
            etiqueta[i].setBounds(col*80,ren*80,60,60);
            etiqueta[i].setHorizontalAlignment(SwingConstants.CENTER);
            etiqueta[i].setVerticalAlignment(SwingConstants.CENTER);
            panel.add(etiqueta[i]);
            
        }
        
        
        
    }

    public void mostrar() {
        
        this.setVisible(true);
        
    }

    public void limpiar() {
        for (int i=0; i<etiqueta.length;i++){
            etiqueta[i].hide();
        }
        lblActual.setText("");
    }

    public void addNumActual() {
        while(etiqueta[random.getNumero()].isVisible() || random.getNumero() == 0){
        
            random.generarNumero();
        }
        etiqueta[random.getNumero()].show();
        lblActual.setText(random.toString());
        numActual=random.getNumero();
                
        
    }
}
