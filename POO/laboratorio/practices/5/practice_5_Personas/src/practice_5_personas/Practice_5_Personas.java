
package practice_5_personas;

public class Practice_5_Personas {

    public static void main(String[] args) {
        
        //declaración
        Persona p1 = new Persona();
        fecha nacimiento = new fecha();
        Auto carro = new Auto();
        
        p1.setName("Alfonso");
        p1.setApellido("Murrieta");
        
        //Primero asignarle desde la fecha
        nacimiento.setDay(11);
        nacimiento.setMounth(1);
        nacimiento.setYear(1999);
        
        //Asignación desde el auto
        carro.setColor("rojo");
        carro.setMarca("Audi");
        carro.setModelo(10);
        
        //Enviarle los datos a la persona
        p1.setFnacimiento(nacimiento);
        p1.setMycar(carro);
        
        //Impresión
        p1.print();
        
    }
    
}
