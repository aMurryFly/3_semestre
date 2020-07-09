//MURRIETA VILLEGAS ALFONSO
//MURRYFLY

package counting_sort;
import java.util.*;

public class Counting_Sort {
    public static void main(String[] args) {
                
        Scanner sc = new Scanner(System.in);                    
        int cant=8;//Cantidad de letras (rango)
        int limit=20;//MOVER SI NO QUIERE METER TANTOS DATOS
        String letra;
            
        String lista[] = new String[limit];   
            
        for (int i=0; i< limit ; i++) {
            System.out.print("Ingrese letra ["+(i+1)+"]: ");
            letra = sc.next();
            lista[i]= letra; 			
        }
         
        sort.countingSort(lista,cant,limit);//Para llamar a la clase y el método
                
    }
}
