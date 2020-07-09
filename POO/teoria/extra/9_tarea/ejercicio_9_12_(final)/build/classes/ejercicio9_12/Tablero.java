package ejercicio9_12;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static ejercicio9_12.Main.bingo;//Para llamar del bingo sin instancia
import javax.swing.*;
public class Tablero extends JFrame implements ActionListener{

     JLabel lblActual;
     JLabel[] label;
     JButton btn, winner;
     Thread thr;
     int number,n = 12;

     Aleatorio aleatorio = new Aleatorio();

    public Tablero() {
        this.setTitle("BINGO");
        this.setSize(600,670);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(null);
        this.add(panel);
        btn = new JButton();
        winner = new JButton();
        
        btn.setBounds(0,0,100,30);
        btn.setLocation(this.size().width/2-300, this.size().height/2+275);
        btn.setVisible(true);
        btn.addActionListener((ActionListener) this);
        btn.setText("START");
        
        
        winner.setBounds(0,0,100,30);
        winner.setLocation(this.size().width/2 + 100, this.size().height-60);
        winner.setHorizontalAlignment(SwingConstants.CENTER);
        winner.setVerticalAlignment(SwingConstants.CENTER);
        winner.addActionListener((ActionListener) this);
        winner.setText("CHECK");
        winner.setVisible(false);
        
        
        lblActual = new JLabel("BINGO");
        lblActual.setFont(new java.awt.Font("Calibri",0,60));
        lblActual.setForeground(Color.black);
        lblActual.setBounds(0,0,80,80);
        lblActual.setLocation(this.size().width/2 - 40, 20);
        lblActual.setHorizontalAlignment(SwingConstants.CENTER);
        lblActual.setVerticalAlignment(SwingConstants.CENTER);
        
        
        panel.add(lblActual);
        panel.add(btn);
        panel.add(winner);
        
        label = new JLabel[100];
        int renglon = 1;
        int columna = 0;
        for(int i=0;i<label.length;i++){
            if(i%10==0){
                renglon++;
                columna = 0;
            }
        columna ++;     
        label[i] = new JLabel(""+i);
        label[i].setFont(new java.awt.Font("Calibri",0,20));
        label[i].setForeground(Color.green);
        label[i].setBounds(columna*50,renglon*50,50,50);
        label[i].setHorizontalAlignment(SwingConstants.CENTER);
        label[i].setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label[i]);
        }
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void limpiar() {
        for(int i = 0; i<label.length;i++){
            label[i].hide();
        }
        lblActual.setText("");
    }

    public void agregarNuevoNumero() {
        while(label[aleatorio.getNumero()].isVisible()||aleatorio.getNumero()==0){
            aleatorio.generarNumero();
        }
        label[aleatorio.getNumero()].show();
        lblActual.setText(aleatorio.toString());
        number = aleatorio.getNumero();
    }
    
    public boolean ComprobarGanador(){
        boolean bandera;
        for(int i = 0; i < n; i++){
            bandera = bingo.ganador(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa tus datos: [Uno a uno]")));
            if(!bandera)
                return false;
        }
        return true;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            if(btn.getText().equals("DETENER")){
                thr.suspend();
                this.btn.setText("CONTINUE");
                this.winner.setVisible(true);
            }
            else if(btn.getText().equals("CONTINUE")){
                thr.resume();
                this.btn.setText("DETENER");
                this.winner.setVisible(false);
            }
            else{
                n = Integer.parseInt(JOptionPane.showInputDialog(null, "CASILLAS PARA GANAR: "));
                thr = new Thread(bingo.r);
                this.btn.setText("DETENER");
                thr.start();
            }
        }
        else if(e.getSource() == winner){
            if(ComprobarGanador()){
                JOptionPane.showMessageDialog(null, "WIN");
                this.setTitle("END GAME - WIN");
            }
            else{
                JOptionPane.showMessageDialog(null, "LOSE");
                this.setTitle("END GAME - LOSE");
            }   
        }
    }
}
