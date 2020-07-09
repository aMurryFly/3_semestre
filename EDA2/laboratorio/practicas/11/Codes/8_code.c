#include<stdio.h>
#include<stdlib.h>
#include <math.h>
#define n 10

void llenaArreglo(int *a);
void suma(int *a,int *b,int *c);

main(){
    int max,*a,*b,*c;
    a=(int *)malloc(sizeof(int)*n);
    b=(int *)malloc(sizeof(int)*n);
    c=(int *)malloc(sizeof(int)*n);
    llenaArreglo(a);
    llenaArreglo(b);
    suma(a,b,c);
}

void llenaArreglo(int *a){
int i;
    for(i=0;i<n;i++) {
        a[i]=rand()%n;
        printf("%d\t", a[i]);
    }
    printf("\n");
}

void suma(int *A, int *B, int *C){
int i,tid;
#pragma omp parallel private(tid)
{
    tid = omp_get_thread_num();
    #pragma omp for
        for(i=0;i<n;i++){
            C[i]=A[i]+B[i];
            printf("hilo %d calculo C[%d]= %d\n",tid,i, C[i]);
        }
    }
}
