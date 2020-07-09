/*
PROFESOR:
EDGAR TISTA

ALUMNOS: 
MURRIETA VILLEGAS ALFONSO 
VALDESPINO MENDIETA JOAQUÍN
REZA CHAVARRIA SERGIO GABRIEL

*/

#include<stdio.h>
#include<omp.h>
#include<stdlib.h>
#define sizeArray 100000
void InsertionSort(int *a,int size); 
void InsertionSortParallel(int *a,int size);
int main(){
	
	
	int i;
	
	//Arreglos de prueba
	int arrayNormal[sizeArray];
	int arrayParallel[sizeArray];
	//Incialización de ambos arreglos
	for(i=0;i<sizeArray;i++){
		arrayNormal[i]=arrayParallel[i]=rand()%10000;
	}
	
	//Llamada a funciones
	InsertionSort(arrayNormal,sizeArray);
	InsertionSortParallel(arrayParallel,sizeArray);
}
//Función serializada
void InsertionSort(int *a,int size) 
{
	double inicio, fin;
  	int i,j,k,temp;
  	
	inicio=omp_get_wtime();

	
	for(i = (size-1); i > 0; i--) 
    {   
		if(a[i]<a[i-1])
        {
            temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }
	for(i = 2; i<=(size-1); i++) 
    {
        j = i;
        temp = a[i];
        while(temp < a[j-1])
        {
            a[j] = a[j-1];
            j--;
        }
        a[j] = temp;
    }
    
  	fin = omp_get_wtime();

	printf("\nTiempo normal: %5fl\n",(fin - inicio));
	
	

}

void InsertionSortParallel(int *a,int size) 
{
	double inicio, fin;
  	int i,j,k,temp;
  	omp_set_num_threads(10);

	inicio=omp_get_wtime();
	//Bloque de código páralelo, se comparte la información del arreglo y se copian los datos de i y temp
	#pragma omp parallel for shared(a) private(i,temp)
	for(i = (size-1); i > 0; i--) 
    {   
		if(a[i]<a[i-1])
        {
            temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }


  	//Bloque de código de reacomodo, realiza el cambio excluyendo a los otros hilos temporalmente
  	
	#pragma omp critical (a)
	for(i = 2; i<=(size-1); i++) 
    {
        j = i;
        temp = a[i];
        while(temp < a[j-1])
        {
            a[j] = a[j-1];
            j--;
        }
        a[j] = temp;
    }
    
  	fin = omp_get_wtime();
	

	printf("\nTiempo paralelo: %5fl\n",(fin - inicio));
}
