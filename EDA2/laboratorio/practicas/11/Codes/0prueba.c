#include <omp.h>
#include <stdio.h>

int main(){
#pragma omp parallel
printf("\n Prueba hilo (thread) %d de %d  ", omp_get_num_threads(), omp_get_num_threads() );
return 0;
}
