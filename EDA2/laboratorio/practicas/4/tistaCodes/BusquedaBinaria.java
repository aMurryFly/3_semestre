package practica4_.murrieta.alfonso;
import java.util.*;

public class BusquedaBinaria {
//BASADA EN EL CÓDIGO DE PYTHON DEL MANUAL
//VERSIÓN RECURSIVA         
    
    public static boolean True_False_Binaria(int valor, List<Integer> lista){
        
        boolean here = false;
    
        if(lista.size() != 0){
            int sub_size =(int)lista.size()/2;

            if(valor == lista.get(sub_size)){//CASO 1
                return here = true;
            }
            else{  //CASO 2        
                if(valor > lista.get(sub_size)){ //CASO 2 -1
                    return here = True_False_Binaria(valor,lista.subList(sub_size+1,lista.size()));
                }
                else if(valor< lista.get(sub_size)){//CASO 2-2
                    return here = True_False_Binaria(valor,lista.subList(0,sub_size-1));
                }
            }
       
        }
     
    return here; //CASO 3

    }
       

    public static int Count_Binario(int valor, List<Integer> lista){

        int cant=0; 

        if(lista.size() != 0){

            int sub_size =(int)lista.size()/2;

            if(valor == lista.get(sub_size)){
                    //Tenemos que sumar la cantidad de todos los casos 
                    cant = cant + 1; 
                    cant = cant + Count_Binario(valor,lista.subList(sub_size+1,lista.size())); 
                    cant = cant + Count_Binario(valor,lista.subList(0,sub_size)); 
                    return cant; 
            }
            else{

                if(valor >= lista.get(sub_size)){//CASO 1
                    return cant= Count_Binario(valor,lista.subList(sub_size+1,lista.size()));
                }
                else if(valor <= lista.get(sub_size)){ //CASO 2
                    return cant= Count_Binario(valor,lista.subList(0,sub_size));
                }
                else{// CASO 3
                    return cant; 
                //En este caso si ponemos este caso a diferencia del anterior método
                }
            }

        }

        return cant;
    }
    
    //PARTE DEDICADA A LA BÚSQUEDA DE LOS OBJETOS

    //TRUE OR FALSE METHODS
    
    public static boolean T_F_B_Nombre(String nombre,List<EquipoFutbol> lista){
    
        if(lista.size() != 0){

            int sub_size =(int)lista.size()/2;
            boolean here= false;

                if(nombre == lista.get(sub_size).nombreEquipo){
                    return here = true;
                }
                else{
                    if((nombre.compareTo(lista.get(sub_size).nombreEquipo))>0){
                        return here = T_F_B_Nombre(nombre,lista.subList(sub_size+1,lista.size()));
                    }
                    else if((nombre.compareTo(lista.get(sub_size).nombreEquipo))<0){
                         return here = T_F_B_Nombre(nombre,lista.subList(0,sub_size));
                    }
                    else{
                        return false; 
                    }
                }

        }
     
        return false;
    }
    
        public static boolean T_F_B_Estado(String estado,List<EquipoFutbol> lista){
    
        if(lista.size() != 0){

            int sub_size =(int)lista.size()/2;
            boolean here= false;

                if(estado == lista.get(sub_size).estadoEquipo){
                    return here = true;
                }
                else{
                    if((estado.compareTo(lista.get(sub_size).estadoEquipo))>0){
                        return here = T_F_B_Nombre(estado,lista.subList(sub_size+1,lista.size()));
                    }
                    else if((estado.compareTo(lista.get(sub_size).estadoEquipo))<0){
                         return here = T_F_B_Nombre(estado,lista.subList(0,sub_size));
                    }
                    else{
                        return false; 
                    }
                }

        }
     
        return false;
    }
    
//COUNT METHODS
    public static int Count_B_Nombre(String nombre, List<EquipoFutbol> lista){
        int index=0; 
        if(lista.size() != 0){
            int sub_size=(int)lista.size()/2;
        
            if(nombre == lista.get(sub_size).nombreEquipo){
                
                index = index + 1;
                index = index + Count_B_Estado(nombre,lista.subList(sub_size+1,lista.size())); 
                index = index + Count_B_Estado(nombre,lista.subList(0,sub_size)); 
                return index; 
            }
            else{
                if((nombre.compareTo(lista.get(sub_size).nombreEquipo))>0){
                    return index= Count_B_Estado(nombre,lista.subList(sub_size+1,lista.size()));
                }
                else if((nombre.compareTo(lista.get(sub_size).nombreEquipo))<0){
                     return index= Count_B_Estado(nombre,lista.subList(0,sub_size));
                }
                else{
                    return index; 
                }
             }
       
        }
    return index;
    }
        
        
        
    public static int Count_B_Estado(String estado, List<EquipoFutbol> lista){
        int index=0; 
        if(lista.size() != 0){
            int sub_size=(int)lista.size()/2;
        
            if(estado == lista.get(sub_size).estadoEquipo){
                
                index = index + 1;
                index = index + Count_B_Estado(estado,lista.subList(sub_size+1,lista.size())); 
                index = index + Count_B_Estado(estado,lista.subList(0,sub_size)); 
                return index; 
            }
            else{
                if((estado.compareTo(lista.get(sub_size).estadoEquipo))>0){
                    return index= Count_B_Estado(estado,lista.subList(sub_size+1,lista.size()));
                }
                else if((estado.compareTo(lista.get(sub_size).estadoEquipo))<0){
                     return index= Count_B_Estado(estado,lista.subList(0,sub_size));
                }
                else{
                    return index; 
                }
             }
       
        }
    return index;
    }
    
        
        
     
    
    
   
}
