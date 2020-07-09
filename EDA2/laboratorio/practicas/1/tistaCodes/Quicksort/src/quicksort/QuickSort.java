package quickSort;//ALFONSO: Paquetes (Todavía no los he usado)
/**
 *
 * @author Edgar
 */
public class QuickSort {//ALFONSO: Clase principal de donde se darán los métodos y objetos

    int partition(int arr[], int low, int high){
    //ALFONSO:Método partición encargado de partir el arreglo en sub-arreglos
    
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++){
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                 // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    
    void sort(int arr[], int low, int high){
    //ALFONSO: Método sort es el encargadoir cambiando las posiciones de los elementos    
        
        if (low < high){
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
     /* A utility function to print array of size n */
    static void printArray(int arr[]){
    //ALFONSO: Método encargado de la impresión de los arreglos
        
        int n = arr.length;//Podemos utilizar el método length para saber el tamaño
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[]){
    //ALFONSO: Método principal del que se llamará todo lo anterior    
        
        int arr[] = {34,56,89,12,25};
        int n = arr.length;
        QuickSort ob = new QuickSort();//ALFONSO: Se crea un objeto del tipo quicksort
        ob.sort(arr, 0, n-1);
        System.out.println("Arreglo ordenado");
        printArray(arr);
    }
    
/*OPINIÓN GENERAL: 
La verdad java es un lenguaje que pese a penas estoy aprendiendo realmente parece
muy llamativo sobretodo en la forma en que se lleva a cabo la persepción del programador
    
*/
}
