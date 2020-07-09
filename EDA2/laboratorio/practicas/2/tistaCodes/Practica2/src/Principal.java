
public class Principal {
    public static void main(String args[]){  
        int[] arr1 = {9,14,3,2,43,11,58,22}; 
        int[] arr2 = {10,15,4,3,44,12,59,23}; 
        System.out.println("Arreglo Original");  
        imprimirArreglo(arr2);
        
        //InsertionSort.insertionSort(arr2);
        
        SelectionSort seleccion = new SelectionSort();   
        seleccion.selectionSort(arr1);  
       
             
        System.out.println("Arreglo ordenado");  
        //imprimirArreglo(arr2);  
        imprimirArreglo(arr1); //Para selectionSort
    }  
    
    public static void imprimirArreglo(int[] arreglo){//Método de impresión
        for(int i:arreglo){  
            System.out.print(i+" ");  
        }
        System.out.println(" ");
    }
}
