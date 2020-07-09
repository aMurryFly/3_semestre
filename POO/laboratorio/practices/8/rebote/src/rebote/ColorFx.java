package rebote;

import javafx.scene.paint.Color;
public interface ColorFx {
    String ROJO = "rojo";
    String VERDE = "verde";
    String AZUL = "azul";
    String DEMON = "demon";
    String TRANSPARENTE = "transparente";        

    static Color StringToColor(String c){
        Color color;
        switch(c){
            case "rojo":
                color = Color.RED;
                break;
            case "verde":
                color = Color.GREEN;
                break;
            case "azul":
                color = Color.BLUE;
                break;
            case "demon":
                color = Color.DARKBLUE;
                break;    
            case "transparente":
                color = Color.TRANSPARENT   ;
                break; 
            default:
                color = Color.BLACK;
                break;     
        }
        
    return color;    
    }
    
}
