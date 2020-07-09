package practica5.murrietaalfonso;
import static java.lang.Math.*;
import java.util.*;

public class Hash_Modulo {
    
    public void menu() {

        //Variables y declaraciones generales
        ArrayList<Integer> lista = new ArrayList<>(20);
        Scanner sc= new Scanner(System.in);

        lista.clear();
        int opc , dato, cant =0;
        
        //Llenado del ArrayList
        for(int i=0; i<20;i++){
            lista.add(0);
        }
        
        //MENU PRINCIPAL
        do{
            System.out.println("HASH-MODULO");
            System.out.println("1] Agregar elemento 2]Imprimir lista 3]Buscar elemento 4]SALIR ");
            opc=sc.nextInt();
            switch (opc) {
                case 1:
                    if(cant<20){
                        System.out.println("INSERTAR ELEMENTOS");
                        System.out.print("Ingrese el dato: ");
                        dato=sc.nextInt();
                        hashfunction(dato,lista);
                        
                    }else{
                        System.out.println("Lista llena");
                    }
                    
                    break;
                    
                case 2:
                    System.out.println("IMPRESION DE LA LISTA");
                    System.out.println(lista);
                    break;
                    
                case 3:
                    System.out.println("BUSQUEDA DE ELEMENTOS");
                    System.out.println("Ingrese el valor del elemento: ");
                    dato=sc.nextInt();
                    search(lista,dato);
                    
                    break;
                default:
                    System.out.println("Escriba una opción válida: ");
            }
        }while(opc!=4);
    }
    
    
        public static void hashfunction(int dato, ArrayList<Integer> lista ){
            
        //VARIABLES    
        int condicional = 0;
        boolean isSave=false;//Recomnedación del profesor
        int modulo=(int)round(dato%17);
        
        do{
            System.out.println("El modulo es "+modulo);
            if(modulo<20){
                if(lista.get(modulo)==0){
                    lista.set(modulo,dato);
                    System.out.println(dato+" está en posición: "+modulo);
                    isSave=true;
                }else{
                    
                    modulo=fixCuadra(modulo*modulo);
                    condicional++;
                }
                
            }else{
                modulo=fixCuadra(modulo*modulo);
                condicional++;
            }

        }while(condicional!=3 && isSave==false);
        
        if(condicional==3 || isSave==false){
            System.out.println("No se ha podido agregar: "+dato);
        }
    } 
    
    public static int fixCuadra(int dato){
        int u, d, valor=0;
        /*
        //Son valores para las posiciones
        u es para las unidades
        d es para las decenas 
        */
        
        if(dato<20){
            System.out.println(dato);
            return dato;
        }else{
            //PARA OBTENER LA CANTIDAD
            String cantidadE= Integer.toString(dato);
            int num= cantidadE.length();
            int mid = num/2;
            
            if(mid>1){//SEGUNDO INTENTO
                u= dato%(int)(pow(10,mid-1));
                d= dato%(int)(pow(10,mid+1));
                valor=(d-u)/(int)(pow(10,mid-1));

                System.out.println("Modulo: "+valor);
            }else{
                valor=dato;
            }
            
            if(valor<20){//TERCER INTENTO
                return valor;
            }
            else{
                return valor%10;
            }
        }
    }        
        
    public static void search(ArrayList<Integer> lista, int busqueda){
        
        int modulo=(int)round(busqueda%17);;
        int condition=0;
        
        boolean isHere=false;
        
        while(condition!=3 && isHere==false){
            if(modulo<20){
                if(lista.get(modulo)==busqueda){
                    System.out.println("El dato "+busqueda+" está en la posición"+ modulo);
                    isHere=true;
                    
                }else{
                    modulo=fixCuadra(modulo*modulo);
                    condition++;
                }
            }else{
                modulo=fixCuadra(modulo*modulo);
                condition++;
            }

        }
        
        if(condition==3){
            System.out.println("El dato "+busqueda+" no se ha encontrado");
        }
        
    
    }

}
