//MURRIETA VILLEGAS ALFONSO 
//@MURRUFLY
package radix_sort_java;

import java.util.*;

public class Radix_Sort_Java {

    
    public static void main(String[] args) {
        
        ArrayList<Integer> Main_list= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        
        int cant;//Cantidad de elementos
        int i= 0;//contador
        
        System.out.println("Ordenamiento por Radix Sort");
        System.out.print("\n\nIngrese cantidad de elementos: ");
        cant=sc.nextInt();
       
        do{
            System.out.print("\n\nIngrese el dato "+(i+1)+" : ");
            int datos=sc.nextInt();
            Main_list.add(datos);
            i++; 
            /*if(Integer.toString(datos).length() == 4){
                Main_list.add(datos);//Método de agregar datos de los arraylist
                i++; 
            }else{
                System.out.println("DATO NO PERMITIDO\n");
            }*/
        }while( i<cant);
        
        System.out.println("\n\nSu lista es: "+Main_list);
        int valor = getMax(Main_list);
        int digitos = cantDigitos(valor);
                
        sort(Main_list, digitos);
        System.out.println("\n\nLista Ordenada: "+Main_list);
        

    }
    
    public static int getMax(ArrayList <Integer> elementos){
        int max = elementos.get(0);
        int aux = 0;
        
        for(int i = 0;i<elementos.size();i++){
            aux = elementos.get(i);
            if(aux > max ){
                max = aux;
            }
        }
        
    return max;
    }
    
    public static int cantDigitos(int max){
        int div = 10;
        int cant = 0;

        while((max/10)>=0){
            max = max / div;
            cant++;
                
            if (max == 0){
                break;
            }
        }
   
    return cant;
    }
    

    public static void sort(ArrayList <Integer> elementos, int digitos){
        
        //Estructuras de Java que se emplearán como colas
        ArrayList <Integer> queue_0=new ArrayList <>();
        ArrayList <Integer> queue_1=new ArrayList <>();
        ArrayList <Integer> queue_2=new ArrayList <>();
        ArrayList <Integer> queue_3=new ArrayList <>();
        ArrayList <Integer> queue_4=new ArrayList <>();
        ArrayList <Integer> queue_5=new ArrayList <>();
        ArrayList <Integer> queue_6=new ArrayList <>();
        ArrayList <Integer> queue_7=new ArrayList <>();
        ArrayList <Integer> queue_8=new ArrayList <>();
        ArrayList <Integer> queue_9=new ArrayList <>();
        
        //Ciclo for para el ordenamiento usando RadixSort
        for(int j=digitos;j>=1;j--){
            
            do{
                /* OPCIÓN DE AYUDAr - by Sergio
                int index = 0;
                int tmp=j;
                int digitosaux=digitos;
                int dato=cantDigitos(elementos.get(index));
                if(cantDigitos(elementos.get(index))<digitos){
                    while(dato!=digitosaux ){
                        //queue_0.add(elementos.remove(0)); 
                        digitosaux--;
                    }
                    j=digitosaux;
                }
                ////////*/
                
                switch(elementos.toString().charAt(j)){
                    case '0': 
                        queue_0.add(elementos.remove(0));
                        break;
                    case '1': 
                        queue_1.add(elementos.remove(0));
                        break;
                    case '2': 
                        queue_2.add(elementos.remove(0)); 
                        break;
                    case '3': 
                        queue_3.add(elementos.remove(0));
                        break;
                    case '4': 
                        queue_4.add(elementos.remove(0));
                        break; 
                    case '5': 
                        queue_5.add(elementos.remove(0));
                        break;
                    case '6': 
                        queue_6.add(elementos.remove(0));
                        break; 
                    case '7': 
                        queue_7.add(elementos.remove(0));
                        break;
                    case '8': 
                        queue_8.add(elementos.remove(0));
                        break;
                    case '9': 
                        queue_9.add(elementos.remove(0));
                        break;
                    /*default:
                        queue_0.add(elementos.remove(0));
                        break;*/
                
                } 
                printQueue(queue_0,queue_1,queue_2,queue_3,queue_4);
                printQueue2(queue_5,queue_6,queue_7,queue_8,queue_9);
                //j=tmp;
                //index++;
            }while(!elementos.isEmpty());
            
            clearQueue(elementos,queue_0);
            clearQueue(elementos,queue_1);
            clearQueue(elementos,queue_2);
            clearQueue(elementos,queue_3);
            clearQueue(elementos,queue_4); 
            clearQueue(elementos,queue_5); 
            clearQueue(elementos,queue_6); 
            clearQueue(elementos,queue_7); 
            clearQueue(elementos,queue_8); 
            clearQueue(elementos,queue_9); 
            
        }
           
    }

    //Método encargado de limpiar las colas para posteriormente usarlas 
    public static void clearQueue(ArrayList <Integer> elementos, ArrayList <Integer> queue){                  
        if(!queue.isEmpty()){
            while(!queue.isEmpty()){
                elementos.add(queue.remove(0));
            }
        } 
    }
    
    //Método encargado de imprimir las colas 
    public static void printQueue(ArrayList <Integer> queue_0, ArrayList <Integer> queue_1, ArrayList <Integer> queue_2, ArrayList <Integer> queue_3 , ArrayList <Integer> queue_4){            
            System.out.println("Los elementos están en las colas");
            System.out.println("[0]: "+queue_0);
            System.out.println("[1]: "+queue_1);
            System.out.println("[2]: "+queue_2);
            System.out.println("[3]: "+queue_3);
            System.out.println("[4]: "+queue_4);

    }
    public static void printQueue2(ArrayList <Integer> queue_0, ArrayList <Integer> queue_1, ArrayList <Integer> queue_2, ArrayList <Integer> queue_3 , ArrayList <Integer> queue_4){            
            System.out.println("[5]: "+queue_0);
            System.out.println("[6]: "+queue_1);
            System.out.println("[7]: "+queue_2);
            System.out.println("[8]: "+queue_3);
            System.out.println("[9]: "+queue_4);

    }
    
    
    
}
