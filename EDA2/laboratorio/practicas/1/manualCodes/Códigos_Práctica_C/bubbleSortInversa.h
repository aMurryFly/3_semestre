//Murrieta Villegas Alfonso
//Programa encargado de las funciónes necesarias para llevar a cabo bubblesort inverso


#ifndef bubbleSortInversa_h
#define bubbleSortInversa_h

#include "fGenericas.h"

void bubbleSortInversa(int a[], int size){
    int i, j, index;  
    int cmp = 1; 
	i=size;//Lo asociamos directamente al tamaño del arreglo
    
    while(cmp==1){//La única condición que debe cumplirse es la de la comparación o bandera
        cmp = 0;
        index=0;
        for (j=0; j<i; j++) {//A diferencia de los otros bubble sort solo cambiamos la manera de iterar
            if(a[j]<a[j+1]){//Invertimos los valores dentro de los arreglos
                swap(&a[j], &a[j+1]);
                index = j;
                cmp = 1;// si entra al ciclo, el valor se vuelve 1
            }
            printArray(a, size);
        }
        printf("Fin de la Iteration \n");
        i = index;
    }

}

#endif
