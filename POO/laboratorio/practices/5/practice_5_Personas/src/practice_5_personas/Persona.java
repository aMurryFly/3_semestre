package practice_5_personas;

public class Persona {
    private String name;
    private String apellido;
    private fecha fnacimiento;
    private Auto mycar;

    public Persona() {
    }

    public Persona(String name, String apellido, fecha fnacimiento, Auto mycar) {
        this.name = name;
        this.apellido = apellido;
        this.fnacimiento = fnacimiento;
        this.mycar = mycar;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public fecha getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(fecha fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public Auto getMycar() {
        return mycar;
    }

    public void setMycar(Auto mycar) {
        this.mycar = mycar;
    }
    
    
    //MÉTODO DE IMPRESIÓN
    
    public void print(){
        System.out.println("Nombre:" + getName() );
        System.out.println("Apellido:" + getApellido());
        System.out.println("Fecha: " + fnacimiento.getDay()+ " / "+ fnacimiento.getMounth()+ " / " + fnacimiento.getYear());
        System.out.println("Mi carro: " + mycar.getColor()+ " / "+ mycar.getMarca());
    }

    
}
