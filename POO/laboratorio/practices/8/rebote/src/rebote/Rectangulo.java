package rebote;

public class Rectangulo extends Poligono{
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
    
    public Rectangulo(Double base, Double Altura) {
        super(coordenadas(base,Altura));
        this.base = base;
        this.Altura = Altura; 
        if(base>Altura)
            super.setMaxL(base);
        else
            super.setMaxL(Altura);
    }
    
    public Rectangulo(Double base, Double Altura, String color) {
        super(coordenadas(base,Altura),color);
        this.base = base;
        this.Altura = Altura;
        if(base>Altura)
            super.setMaxL(base);
        else
            super.setMaxL(Altura);
    }
    
    
    public static Double[] coordenadas(Double base, Double altura){
        Double xy[] = new Double[8];
        
        xy[0] =  0.0;
        xy[1] =  0.0;
        
        xy[2] =  base;
        xy[3] =  0.0;
        
        xy[4] =  base;
        xy[5] =  altura;
        
        xy[6] =  0.0;
        xy[7] =  altura;

        return xy;
    }
    
}
