#Función Bubble Sort (Básico)
#Murrieta Villegas Alfonso
             
def bubblesort2(A):
    bandera = True
    pasada=0
    size= len(A) #Tamaño de la lista 
    while bandera:
        bandera=False
        for j in range (size-1):
            if A[j] < A[j+1]: #Invertimos los signos de comparación
                bandera=True
                temp=A[j]
                A[j]=A[j+1]
                A[j+1]=temp
        pasada=pasada+1

A=[12,5,13,8,9,65]
bubblesort2(A)
print('Versión inversa')
print(A) 
    




