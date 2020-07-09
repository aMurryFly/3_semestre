/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p13;


public class P13 {
    //Alfonso Murrieta Villegas
 
    public static void main(String[] args) {
        Logger usuario = Logger.getInstance();
        usuario.setFileName("miLog.txt");
        usuario.addLog("Ingresó: ");
        ServerForm server_= new ServerForm ();
        server_.setVisible(true);
        ClientForm cf = new ClientForm();
        cf.setVisible(true);
        cf.getDat(server_);
    }
    
}
