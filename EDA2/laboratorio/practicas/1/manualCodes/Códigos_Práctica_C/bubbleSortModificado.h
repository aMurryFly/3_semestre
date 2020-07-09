//Murrieta Villegas Alfonso
//Programa encargado de las funciónes necesarias para llevar a cabo bubblesort modificado*


#ifndef bubbleSortModificado_h
#define bubbleSortModificado_h

#include "fGenericas.h"

void bubbleSortModificado(int a[], int size){

    int i, j, index;  
    int cmp = 1; // cmp es la variable que utilizamos como pseudo "boolean"
    i = size -1;
    
    while(i>0 && cmp==1){
        cmp = 0;
        index=0;
        for (j=0; j<i; j++) {
            if(a[j+1]<a[j]){
                swap(&a[j+1], &a[j]);
                index = j;
                cmp = 1;// si entra al ciclo, el valor se vuelve 1
            }
            else{//Realmente podemos omitir este else 
            	cmp = 0;
			}
            printArray(a, size);
        }
        printf("Fin de la Iteration \n");
        i = index;
    }

}

#endif 
