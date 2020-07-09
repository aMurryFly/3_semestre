/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p13;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author poo03alu30
 */
//SingleTon
public class Logger {
    private static Logger log;
    
    private String fileName;
    
    private Logger(){
        
    }
    
    public static Logger getInstance(){
        if(log==null){
            log = new Logger();
        }
        return log;
        
    }
    
    public void addLog(String mensaje){
        
        try {
            Date d= new Date();
            File fl= new File(fileName);
            FileOutputStream fos = new FileOutputStream(fl, true);
            PrintStream ps= new PrintStream(fos);
            ps.print(d.toString()+": "+mensaje+"\n");
            ps.close();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
    
}
