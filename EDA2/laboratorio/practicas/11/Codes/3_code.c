#include <stdio.h>
#include <omp.h>
int main() {
    int i;

    #pragma omp parallel
    {
        printf("Hola mundo \n");

        for(i=0;i<10;i++){
                    printf("Iteration: %d \n",i);
        }
    }
    return 0;
}
