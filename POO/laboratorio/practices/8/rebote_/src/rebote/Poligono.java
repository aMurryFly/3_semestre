package rebote;

public class Poligono extends javafx.scene.shape.Polygon implements Relleno{//Heredando 
    Double[] puntos;
    private Double maxL = 0d;//Tamaño máximo _ por ser double


    //Constructor
    public Poligono(Double[] puntos) {
        this.puntos = puntos;
        this.getPoints().addAll(puntos);
    }
    
    public Poligono(Double[] puntos, String colorRelleno) {
        this.puntos = puntos;        
        this.colorRelleno= colorRelleno;
        this.getPoints().addAll(puntos);
        this.setColorRelleno(colorRelleno);
        
    }
    

    public Double getMaxL() {
        return maxL > 0.0 ? maxL : 40.0;//condición if
    }

    public void setMaxL(Double maxL) {
        this.maxL = maxL;
    }

    private String colorRelleno;
    
    @Override
    public String getColorRelleno() {
        return this.colorRelleno;
    }

    
}
