
package main;
import java.io.*;
/**
 *
 * @author pon_c
 */
 
public class metodos_archivos {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    //Constructor
    public metodos_archivos(){
    
    }
    
    public String openFile(File arch){
        String texto="";
        try{
            entrada = new FileInputStream(arch);
            int tx;
            while((tx = entrada.read())!= -1){
                char car = (char)tx;
                texto += car;
            }//Conversión del valor ascci a caracter
            //después inclusión en el string 
            
        }
        catch(Exception xx){ }
        
    return texto;    
    }
    
    public String saveFile(File arch, String cont){
        String isokay = null;
        try{
            salida = new FileOutputStream(arch);
            //El método outputstream trae bytes de los archivos
            byte[] bytestxt = cont.getBytes();
            salida.write(bytestxt);
            isokay = "ARCHIVO GUARDADO";
        }
        catch(Exception xx){
        }
    
    return isokay;
    }
    
    public String createFile(File arch){
        String isokay = null;
        try{
            salida = new FileOutputStream(arch);
            isokay = "ARCHIVO GUARDADO";
        }
        catch(Exception xx){
        }
    
    return isokay;
    }
}
