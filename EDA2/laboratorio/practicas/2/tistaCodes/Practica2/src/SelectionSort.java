public class SelectionSort {  
    public  void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++){  
            System.out.println("Iteración "+(i+1));
            int min = i;  
            //Parte 
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[min]){  
                    min = j;  
                }                      
            }  
            //Parte del cambio
            int smallerNumber = arr[min];   
            arr[min] = arr[i];  
            arr[i] = smallerNumber;  
            System.out.println("Índice del mínimo "+min);
            System.out.println("Valor "+smallerNumber);
                    
            for(int j:arr){  
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }  
    }  

}  