//MURRIETA VILLEGAS ALFONSO

#include <stdio.h>
#include "merge.h"

void printArray(int A[], int size)
{
	int i;
    for ( i=0; i<size; i++) {
        printf("%d ", A[i]);  
    }
    printf("\n");
}

int main(int argc, const char * argv[]) {
    
    int arr[] = {45,32,7,10,6};
    int arrS = (sizeof(arr)/sizeof(arr[0]));
    
    printf("Arreglo original \n");
    printArray(arr, arrS);
    
    mergeSort(arr, 0, arrS-1);//Esto es para no omitir un elemento
    
    printf("\nArreglo ordenado \n");
    printArray(arr, arrS);
    
    return 0;
    
    
}
    

	


