#include <stdio.h>
int main() {
int i;
#pragma omp parallel private(i)
{

    printf("Hola mundo \n");
    for(i=0;i<10;i++)
        printf("Iteration: %d\n",i);
}

return 0;
}
