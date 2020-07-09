//Alfonso Murrieta Villegas

#include <stdio.h>
#define LENGTH 10 //Tamaño ya definido 

int heapSize;//Variable que guardará el tamaño

void printArray(int arr[],int size){// Función que se encarga  de imprimir el arreglo
int i;
  	for (i=0; i < size; i++)
       	printf("%d ", arr[i]);
    	printf("\n");
}

void Heapify(int* A, int i){
	
  int l = 2 * i + 1;
  int r = 2 * i + 2;
  int largest;

  if(l <= heapSize && A[l] < A[i])//Invertí el signo >
    largest = l;
  else
    largest = i;
  
  if(r <= heapSize && A[r] < A[largest])//Invertí el signo >
    largest = r;
  
  if(largest != i){
  	
      printArray(A,LENGTH);
      int temp = A[i];
      A[i] = A[largest];
      A[largest] = temp;
      Heapify(A, largest);
     }
}

void BuildHeap(int* A){//Esta función se encarga de construir el HEAP
	
  heapSize = LENGTH - 1;
  int i;
  for(i = (LENGTH - 1) / 2; i >= 0; i--)//Este ciclo for llama a la función "Heapify"
    Heapify(A, i);
  printf("Termino de construir el HEAP \n\n");
}

void HeapSort(int* A){//Le pasamos un apuntador al arreglo
	
  BuildHeap(A);//Construimos el heap
  int i;
  for(i = LENGTH - 1; i > 0; i--){
  	
      int temp = A[heapSize];
      A[heapSize] = A[0];
      A[0] = temp;
      heapSize--;
      printf("Iteracion HS: \n");
	  Heapify(A, 0);
     
    }
}

int main(){//Función 

  int prueba[LENGTH] = {10,4,12,6,70,5,8,23,31,38};//Arreglo 
  HeapSort(prueba);//Pasamos el arreglo a la función "HeapSort"
  int i;
  
  for(i = 0; i < LENGTH; i++)
    printf("%d ",prueba[i]);
  return 0;
}
