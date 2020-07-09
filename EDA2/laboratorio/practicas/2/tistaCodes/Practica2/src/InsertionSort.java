public class InsertionSort{  //Clase Insertion Sort
    public static void insertionSort(int array[]) {  //Método estático 
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
            /*Ciclo while encargado de comparar y de hacer la inserción de los 
            valores que se cambiaran (Obvio si entra en el ciclo)*/
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    } 
}