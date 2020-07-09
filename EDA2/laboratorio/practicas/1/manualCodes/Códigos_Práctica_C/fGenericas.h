//Murrieta Villegas Alfonso
//Programa encargado de las funciónes básicas de ambos algoritmos(Burbuja y quicksort)

#ifndef fGenericas_h
#define fGenericas_h

//Función de cambio de posición
void swap(int* a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

//Función para impresión del arreglo 
void printArray(int arr[], int size){
    int i;
    for (i=0; i < size; i++)//Ciclo for de impresión
        printf("%d ", arr[i]);
    printf("\n");
}

#endif 
