
package quicksort.sublistas;

/**
 *
 * @author pon_c
 */


public class QuickSortSublistas {

    //Variables globales   
    int array[];//Arreglo - lista
    int size;//Tamaño del arreglo

    //NOTA: Este método fue totalmente basada en un código encontrado en internet
    /*Es un código de llenado de un arreglo con números aleatorios */
    public QuickSortSublistas(int n){
        
        size=n;
        array=new int[n+1];
        
        for (int i=0;i<n;i++){
            array[i]=(int) Math.round(Math.random()*89+10);
            //Llenado alaeatorio 
        }
        array[n]=100;//99999;
    }
    
    
    //Método encargado de hacer las particiones de la lista o arreglo original
    public int partition(int p, int q) {
        int i = p;
        int j = q + 1;
        int pivot = array[p];
        
        do {

        //Cada uno de los do while sirve para cada una de las listas
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i <j) {
                swap(i, j);
            }

        } while (i <j);

        //Utilizamos el swap para mover el pivote a j 
        swap(p, j);
        return j;
    }

    //Método swap 
    //simplemente sirve para poder llevar a cabo los cambios de posición
    private void swap(int p, int j) {
        int temp = array[p];
        array[p] = array[j];
        array[j] = temp;
    }

    //PARTE RECURSIVA DEL CÓDIGO (base)
    public void quicksort(){
        quicksort(0, size-1);
    }

    //Método recursivo que servirá para unir posteriormente
    public void quicksort(int p, int q) {
        int j;
        if (p < q) {
            // Se divide en 2 partes
            j = partition(p, q);
            //Parte recursiva
            quicksort(p, j - 1);
            quicksort(j + 1, q);
        }
    }
    
    //Método de impresión de la lista 
    public void print(){
       for(int i=0;i<size;i++){
        System.out.print(array[i]+" | ");
        }
       System.out.println();
    }

    
    //Método public solamente para probar el programa
    public static void main(String args[]) {
        QuickSortSublistas q = new QuickSortSublistas(15);
        System.out.println("Antes");
        q.print();
        
        //Parte de impresión ya ordenada
        q.quicksort();//Lamamos al método de ordenamiento
        System.out.println("Despues*");
        q.print();

    }

    
    
}

