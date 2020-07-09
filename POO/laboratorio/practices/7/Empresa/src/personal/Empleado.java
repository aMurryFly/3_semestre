package personal;

public class Empleado {

    private int numEmpleado;
    private String nombre;
    private int sueldo;

    
    //CONSTRUCTORS
    public Empleado(int numEmpleado, String nombre) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.sueldo = 0;
    }//Sobrecarga de un método
    
    public Empleado(int numEmpleado, String nombre, int sueldo) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    //GETTERS Y SETTERS
    
    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo<0?0:sueldo;
    }
    
    //METODOS
    public void aumentarSueldo(int porcentaje){
        this.sueldo += (int)(this.sueldo*porcentaje/100);
    }

    @Override //Conversión a una cadena - sobre-escritura
    public String toString() {
        return "Empleado{" + "numEmpleado=" + numEmpleado + ", nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }
    
    
    
    
    
}
