package practica4_.murrieta.alfonso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Practica4_MurrietaAlfonso {

    public static void main(String[] args) {
        
        List<Integer> lista1 = new  LinkedList<>();
        List<Integer> lista3 = new  LinkedList<>();

        
        lista1.add(15);
        lista1.add(16);
        lista1.add(17);
        lista1.add(18);
        lista1.add(19);
        lista1.add(20);
        lista1.add(80);
        
        //Solo lista 3
        lista3.add(1);
        lista3.add(5);
        lista3.add(6);
        lista3.add(6);
        lista3.add(7);
        lista3.add(9);
        lista3.add(10);
        
        
        System.out.println("Estado punto 1: ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        lista1.add(1,300);
        lista1.add(3,500);
        lista1.add(5,700);
        
        System.out.println("Estado punto 2: ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        lista1.set(0,4);
        lista1.set(2,6);
        lista1.set(7,7);
        
        System.out.println("Estado punto 3: ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        List<Integer> lista2;
        lista2= lista1.subList(3, 6);
        imprimirLista(lista2);
        System.out.println(" *** ");
        System.out.println(lista1.equals(lista2));
        
        lista1.remove(2);//Remover elementos
        lista1.remove(3);
        System.out.println(lista1.isEmpty());

        //PARA EL REMOVE
        System.out.println("Estado punto 4 Métodos): ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        //ISEMPTY
        System.out.println("Is empty? ");
        System.out.println(lista1.isEmpty()); 
    
        //BUSCAR UN ELEMENTO
        System.out.println("ELEMENTOS(BÚSQUEDA): ");
        System.out.println(lista1.contains(11));
        lista1.add(7);
        System.out.println(lista1.indexOf(7));
        System.out.println(lista1.lastIndexOf(1100));
        
        //APARTADO DE BÚSQUEDA LINEAL
        System.out.println("BÚSQUEDA LINEAL: ");
        System.out.println(BusquedaLineal.True_False_Lineal(500,lista1));
        System.out.println(BusquedaLineal.Index_Here_Lineal(300,lista1));
        System.out.println(BusquedaLineal.Count_Lineal(7,lista1));
        
        //APARTADO DE BÚSQUEDA BINARIA
        System.out.println("BÚSQUEDA BINARIA: ");
        Collections.sort(lista3);//ES NECECARIO QUE ESTÉ ORDENADA LA LISTA
        imprimirLista(lista3);
        System.out.println(BusquedaBinaria.True_False_Binaria(5,lista3));
        System.out.println(BusquedaBinaria.Count_Binario(6,lista3));
        
        
        //PARTE DEDICADA A LA BÚSQUEDA DE LOS OBJETOS
        
        System.out.println("\n\n\n\nBÚSQUEDA  DE OBJETOS: ");
        System.out.println("\n\n ");
        
        //Creación de equipos
        EquipoFutbol e1 = new EquipoFutbol("Real Madrid","Madrid","España","UEFA",20); 
        EquipoFutbol e2 = new EquipoFutbol("Barcelona","Barcelona","España","UEFA",21); 
        EquipoFutbol e3 = new EquipoFutbol("Valencia","Madrid","España","UEFA",22); //Obvio es para prueba 
        EquipoFutbol e4 = new EquipoFutbol("Paris","Paris","Francia","UEFA",18); 
        
        //Lista de equipos
        List<EquipoFutbol> EquiposDeFutbol = new  LinkedList<>();
        
        //Lista de equipos lista 1
        EquiposDeFutbol.add(e1);
        EquiposDeFutbol.add(e2);
        EquiposDeFutbol.add(e3);
        EquiposDeFutbol.add(e4);
        EquipoFutbol.printTeams(EquiposDeFutbol);
        
        //BÚSQUEDA LINEAL
        System.out.println("\n\nBÚSQUEDA LINEAL");
        System.out.println("Is Paris? "+BusquedaLineal.T_F_L_Nombre("Paris",EquiposDeFutbol));
        System.out.println("Hay de Madrid? "+BusquedaLineal.T_F_L_Estado("Madrid",EquiposDeFutbol));
        System.out.println("Posición de Paris? "+BusquedaLineal.Index_Here_L_Nombre("Paris",EquiposDeFutbol));
        System.out.println("Cuántos Hay de Madrid? "+BusquedaLineal.Count_Lineal_Estado("Madrid",EquiposDeFutbol));

        //BÚSQUEDA BINARIA
        System.out.println("\n\nBÚSQUEDA BINARIA");
        //La parte mediante el nombre
        Collections.sort(EquiposDeFutbol, (o1, o2) -> o1.getNombreEquipo().compareTo(o2.getNombreEquipo()));
        //EquipoFutbol.printTeams(EquiposDeFutbol); lo usé para comprobar el ordenamiento
        System.out.println("Is Valencia? "+BusquedaBinaria.T_F_B_Nombre("Valencia",EquiposDeFutbol));
        System.out.println("Cuántos hay de Berlín? "+BusquedaBinaria.Count_B_Nombre("Berlin",EquiposDeFutbol));
        
        //La parte mediante el estado
        Collections.sort(EquiposDeFutbol, (o1, o2) -> o1.getEstadoEquipo().compareTo(o2.getEstadoEquipo()));
        System.out.println("Is Madrid? "+BusquedaBinaria.T_F_B_Estado("Madrid",EquiposDeFutbol));
        System.out.println("Cuántos Hay de Madrid? "+BusquedaBinaria.Count_B_Estado("Madrid",EquiposDeFutbol));
        


    }
    
    public static void imprimirLista(List<Integer> listaPrint){
        for(Integer var: listaPrint){
            System.out.println(var);
        }
    }
    
    
}
