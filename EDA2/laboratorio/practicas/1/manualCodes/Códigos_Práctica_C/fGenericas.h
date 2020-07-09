//Murrieta Villegas Alfonso
//Programa encargado de las funci�nes b�sicas de ambos algoritmos(Burbuja y quicksort)

#ifndef fGenericas_h
#define fGenericas_h

//Funci�n de cambio de posici�n
void swap(int* a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

//Funci�n para impresi�n del arreglo 
void printArray(int arr[], int size){
    int i;
    for (i=0; i < size; i++)//Ciclo for de impresi�n
        printf("%d ", arr[i]);
    printf("\n");
}

#endif 
