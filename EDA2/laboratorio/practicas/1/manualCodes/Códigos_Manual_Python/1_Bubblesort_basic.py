#Función Bubble Sort (Básico)
#Murrieta Villegas Alfonso

A=[12,5,13,8,9,65]

def bubblesort(A):
    for i in range (1,len(A)):
        for j in range (len(A)-1):
            if A[j]>A[j+1]:
                temp = A[j]
                A[j]=A[j+1]
                A[j+1]=temp
          
A=[12,5,13,8,9,65]
bubblesort(A)
print(A) 


def bubblesort2(A):
    bandera = True
    pasada=0
    while pasada < len(A)-1 and bandera:
        bandera=False
        for j in range (len(A)-1):
            if A[j]>A[j+1]: 
                bandera=True
                temp=A[j]
                A[j]=A[j+1]
                A[j+1]=temp
        print(pasada) #Linea agregada para cehcar las pasadas
        pasada=pasada+1

A=[12,5,13,8,9,65]
bubblesort2(A)
print('Segunda función')
print(A)           
        