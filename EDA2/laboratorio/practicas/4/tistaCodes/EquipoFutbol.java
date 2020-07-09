package practica4_.murrieta.alfonso;
import java.util.*;

public class EquipoFutbol {
    
//Atributos no son privados :(
    String nombreEquipo;
    String estadoEquipo;
    String paisEquipo;
    String divisionEquipo;
    int numJugadores;

//Constructores    
 
    EquipoFutbol(){
        this.nombreEquipo = "No name";
        this.estadoEquipo = "No data";
        this.paisEquipo = "No data";
        this.divisionEquipo = "No data";
        this.numJugadores = 12;
    }
    
    EquipoFutbol(String name, String state, String country, String division){
        this.nombreEquipo = name;
        this.estadoEquipo = state;
        this.paisEquipo = country;
        this.divisionEquipo = division;
        this.numJugadores = 12;
    }
    
    EquipoFutbol(String name, String state, String country, String division, int num){
        this.nombreEquipo = name;
        this.estadoEquipo = state;
        this.paisEquipo = country;
        this.divisionEquipo = division;
        this.numJugadores = num;
    }
    
    //SETTER
    public void setNombreEquipo(String nombre){
        this.nombreEquipo = nombre;
    }
    
    public void setEstadoEquipo(String estado){
        this.estadoEquipo = estado;
    }
    
    public void setPaisEquipo(String pais){
        this.paisEquipo = pais;
    }
    
    public void setDivisionEquipo(String division){
        this.divisionEquipo = division;
    }
    
    public void setNumJugadores(int cant){
        this.numJugadores = cant;
    }
    
    //GETTERS
    public String getNombreEquipo(){
        return this.nombreEquipo;
    }

    public String getEstadoEquipo(){
        return this.estadoEquipo;
    }
    
    public String getPaisEquipo(){
        return this.paisEquipo;
    }
    
    public String getDivisionEquipo(){
        return this.divisionEquipo;
    }
    
    public int getNumJugadores(){
        return this.numJugadores;
    }
    //MÉTODO DE IMPRESIÓN DE LOS EQUIPOS 
    
    public static void printTeams(List<EquipoFutbol> lista){
        
        for (EquipoFutbol clave: lista){
            System.out.println("=============================");
            System.out.println("Equipo: " + clave.nombreEquipo);
            System.out.println("Estado: " + clave.estadoEquipo);
            System.out.println("País: " + clave.paisEquipo);
            System.out.println("Division: " + clave.divisionEquipo);
            System.out.println("Jugadores: " + clave.numJugadores);
        }
    }

}
