package practice_5_personas;

public class Auto {
    private String marca;
    private String color;
    private int modelo;

    public Auto() {
    }

    public Auto(String marca, String color, int modelo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    
    
    
    
    
}
