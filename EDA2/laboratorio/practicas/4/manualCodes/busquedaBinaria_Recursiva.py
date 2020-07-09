#Murrieta Villegas Alfonso
#Myrry_fly#

import math 

def BusquedaBinariaRecursiva(A,x,izquierda,derecha):
    
    if izquierda >   derecha:
        return -1
    
    medio = math.floor((izquierda+derecha)/2)
    print(medio)
    
    if A[medio] == x:
        return medio 
    elif A[medio] < x:
        return BusquedaBinariaRecursiva(A,x,medio+1,derecha)
    else:
        return BusquedaBinariaRecursiva(A,x,izquierda,medio-1)
    

lista=[0, 21, 4 ,40, 10, 35, 19]
size=len(lista)
x= 40 #Valor a buscar 

resultado=BusquedaBinariaRecursiva(lista,x,lista[0],size )

print("Elemento a buscar: ")
print(x)
print("Posición del elemento: ")
print(resultado)
