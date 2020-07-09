package rebote;

public class Triangulo extends Poligono{
        
    private Double base;
    private Double Altura;

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double Altura) {
        this.Altura = Altura;
    }
    
    public Triangulo(Double base, Double Altura) {
        super(coordenadas(base,Altura));
        this.base = base;
        this.Altura = Altura;        
        super.setMaxL(base);
    }
    
    public Triangulo(Double base, Double Altura, String color) {
        super(coordenadas(base,Altura),color);
        this.base = base;
        this.Altura = Altura;
        super.setMaxL(base);
    }
    
    
    public static Double[] coordenadas(Double base, Double altura){
        Double xy[] = new Double[6];
        
        xy[0] =  base/2;
        xy[1] =  0.0;
        
        xy[2] =  base;
        xy[3] =  altura;
        
        xy[4] =  0.0;
        xy[5] =  altura;
        
        return xy;
    }
   
}
