package rebote;

public interface Relleno {

    default void setColorRelleno(String colorRelleno){
        ((javafx.scene.shape.Polygon)this).setFill(ColorFx.StringToColor(colorRelleno));
    } 
     
    String getColorRelleno();
    
    
}
