#Murrieta Villegas Alfonso
#Myrry_fly#

import math 

def BusquedaBinaria(A,x,izquierda,derecha):
    while izquierda <= derecha:
        medio = math.floor((izquierda+derecha)/2)
        if A[medio] == x:
            return medio
        elif A[medio] < x:
            izquierda= medio+1
        else:
            derecha = medio-1
    return -1

lista=[0, 21, 4 ,40, 10, 35, 19]
size=len(lista)
x= 21 #Valor a buscar 

resultado=BusquedaBinaria(lista,x,lista[0],size )

print("Elemento a buscar: ")
print(x)
print("Posición del elemento: ")
print(resultado)


            
