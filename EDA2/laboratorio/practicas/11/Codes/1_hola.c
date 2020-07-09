#include <stdio.h>
#include <omp.h>
int main() {
    int i;
    //int n = 2;

    #pragma omp parallel parallel num_threads (2)
    {
        printf("Hola mundo \n");

        for(i=0;i<10;i++){
                    printf("Iteration: %d \n",i);
        }
    }
    return 0;
}
