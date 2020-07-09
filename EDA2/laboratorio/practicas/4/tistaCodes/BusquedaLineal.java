package practica4_.murrieta.alfonso;

import java.util.*;

public class BusquedaLineal {
    
    public static boolean True_False_Lineal(int valor, List<Integer> lista){
        boolean here = false;//here es si está o no

            for (int clave: lista){

                if(clave == valor){
                    here = true;
                }
            } 

        return here;    
    }

    public static int Index_Here_Lineal(int valor, List<Integer> lista){

        int index =-1;//Se le poné por convención este valor 
        int i=0;
            for (int clave: lista){

                if(clave == valor){
                    index =i;
                }
                i++;
            } 

        return index;
    }    

    public static int Count_Lineal(int valor, List<Integer> lista){

        int cantidad =0;
            for (int clave: lista){

                if(clave == valor){
                    cantidad= cantidad+1;//Parte que suma sobre la cantidad
                }

            } 

        return cantidad;
    }  
    
    //PARTE DEDICADA A LA BÚSQUEDA DE LOS OBJETOS
    
    //1) True - False
    public static boolean T_F_L_Nombre(String nombre,List<EquipoFutbol> lista){

        boolean here = false;

            for (EquipoFutbol clave: lista){

                if(clave.nombreEquipo.equals(nombre) ){
                    here = true;
                }

            } 
        return here;
    }

    public static boolean T_F_L_Estado(String estado,List<EquipoFutbol> lista){

        boolean here = false;

            for (EquipoFutbol clave: lista){

                if(clave.estadoEquipo.equals(estado) ){
                    here = true;
                }

            } 
        return here;
    }
    
    //2) Los que indican el índice 
    
    public static int Index_Here_L_Nombre(String nombre, List<EquipoFutbol> lista){

        int index =0;
        int i=0;
            for (EquipoFutbol clave: lista){

                if(clave.nombreEquipo.equals(nombre)){
                    index =i;
                }
                i++;
            } 

        return index;
    }
    
    public static int Index_Here_L_Estado(String estado, List<EquipoFutbol> lista){

        int index =0;
        int i=0;
            for (EquipoFutbol clave: lista){

                if(clave.estadoEquipo.equals(estado)){
                    index =i;
                }
                i++;
            } 

        return index;
    }
    
    // 3) Contadores de objetos
    
    public static int Count_Lineal_Nombre(String nombre, List<EquipoFutbol> lista){
        
        int count =0;

            for (EquipoFutbol clave: lista){

                if((clave.nombreEquipo.equals(nombre))){
                    count = count +1;
                }

            } 

        return count;
    }
    
    public static int Count_Lineal_Estado(String estado, List<EquipoFutbol> lista){
        
        int count =0;

            for (EquipoFutbol clave: lista){

                if((clave.estadoEquipo.equals(estado))){
                    count = count +1;
                }

            } 

        return count;
    }
}
