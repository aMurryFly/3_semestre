//Murrieta Villegas Alfonso
//Programa encargado de las pruebas de todas las funciones


#include <stdio.h>

//Bibliotecas programadas 
#include "bubbleSort.h"
#include "bubbleSortModificado.h"
#include "bubbleSortInversa.h"
#include "QuickSort.h"

int main(int argc, const char * argv[]) {
    int arr[] = {103,40,280,98,133,237,0};
    int size = sizeof(arr)/sizeof(arr[0]);
    
    //NOTA PARA EL PROFESOR: Puede probar cualquera de las opciones ya solamente es quitar el comentario
    
    //quickSort(arr, 0, size - 1);
    //bubbleSort(arr, size);
    //bubbleSortModificado(arr, size);
	//bubbleSortInversa(arr, size);
    
    printf("Arreglo Ordenado: \n");
    printArray(arr, size);
    
    return 0;
}
