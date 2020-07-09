//Murrieta Villegas Alfonso
//Programa encargado de las funciónes necesarias para llevar a cabo quicksort

#ifndef QuickSort_h
#define QuickSort_h
#include "fGenericas.h"

//Impresión de los subarreglos 
void printSubArray(int arr[], int low, int high){//Se pasan los valores del mayor y menor elemento
    int i;
    for (i = low; i <= high; i++)//For de impresión
        printf("%d ", arr[i]);
    printf("\n");
}

//Parte encargada de llamar a la función anterior para de esta forma imprimir los subarreglos
void quickSort(int arr[], int low, int high){
    if(low < high){
        int pi = partition(arr, low, high);
        printf("Sub array 1 (de %d): \t", arr[pi]);
        printSubArray(arr,low,pi-1);
        quickSort(arr, low, pi - 1);
        printf("Sub array 3 (de %d): \t", arr[pi]);
        printSubArray(arr,pi+1,high);
        quickSort(arr, pi+1, high);
    }
}

//Función principal que lleva la lógica del algoritmo
int partition(int arr[], int low, int high){
    int pivot = arr[high];
    int j,i = (low-1);
    for(j= low; j <= high - 1; j++){
        if (arr[j] <= pivot){
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i+1], & arr[high]);
    return (i+1);
}

#endif
