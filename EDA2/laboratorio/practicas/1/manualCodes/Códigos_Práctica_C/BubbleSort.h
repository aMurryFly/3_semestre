//Murrieta Villegas Alfonso
//Programa encargado de las funciónes necesarias para llevar a cabo bubblesort


#ifndef bubbleSort_h
#define bubbleSort_h

#include "fGenericas.h"

//Función principal y única encargada de la comparación de los elementos dentro del arreglo
void bubbleSort(int a[], int size){
    int i, j;
    int index;
    i = size -1;
    while(i>0){//Ciclo while para las iteraciones
        index=0;
        for (j=0; j<i; j++) {//Ciclo for para el recorrido de cada iteración
            if(a[j+1]<a[j]){
                swap(&a[j+1], &a[j]);
                index = j;
            }
            printArray(a, size);
        }
        printf("End iteration \n");
        i = index;
    }
}

#endif
