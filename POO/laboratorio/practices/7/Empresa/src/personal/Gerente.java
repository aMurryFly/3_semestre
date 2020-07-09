package personal;

public class Gerente extends Empleado{
    private int presupuesto;

    //Constructor
    public Gerente(int presupuesto,int numEmpleado, String nombre, int sueldo) {
        super(numEmpleado, nombre, sueldo);
        //Constructor de esta clase
        this.presupuesto=presupuesto;
    }

    public Gerente(int numEmpleado, String nombre, int sueldo) {
        super(numEmpleado, nombre, sueldo);
        //Constructor de esta clase
        this.presupuesto=0;
    }
    
    
    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString(){//Lo toma antes que el de empleado 
        return (super.toString()+" Gerente{"+"presupuesto="+presupuesto+"}");
        //llamamos mediante el super el del empleado
    }
    

    
}