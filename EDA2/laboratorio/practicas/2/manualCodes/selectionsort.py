#Función Selection Sort (Básico)
#Murrieta Villegas Alfonso


def selectionSort(alist):
   for relleno in range(len(alist)-1,0,-1):
       posicion_max=0
       for localización in range(1,relleno+1):
           if lista[localización]>lista[posicion_max]:
               posicion_max = localización

       temp = lista[relleno]
       lista[relleno] = lista[posicion_max]
       lista[posicion_max] = temp

lista = [54,26,93,17,77,31,44,55,20]
selectionSort(lista)
print(lista)