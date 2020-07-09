#include <stdio.h>

int main() {
    #pragma omp parallel
    {
        //printf("Hola mundo");
        #progma omp for
        for(int i=0;i<10;i++)
            printf("Iteration:%d\n",i);
    }

return 0;
}

