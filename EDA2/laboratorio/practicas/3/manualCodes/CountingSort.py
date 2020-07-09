#Alfonso Murrieta Villegas

def CrearLista(k):
    L=[]
    for i in range(k+1):#Se crea lista con 0 
        L.append(0)
    return L

def CountingSort(A,k):
    C=CrearLista(k)#lista principal (La que contiene los datos )
    B=CrearLista(len(A)-1)#lista que resivirá los datos
    
    for j in range (1,len(A)):
        C[A[j]]=C[A[j]]+1
    print("Cantidad de datos: ")
    print(C)
    
    for i in range (1,k+1):#Ciclo que determina la posición de los datos 
        C[i]=C[i]+C[i-1]
    print("Indice de los datos: ")
    print(C)
    
    for j in range(len(A)-1,0,-1):
        B[C[A[j]]]=A[j]
        C[A[j]]=C[A[j]]-1
    return B

arr=[0, 21, 4 ,40, 10, 35, 19]
DateMax=2

#Se necesita conocer el dato mayor de la lista
for i in range (len(arr)):
    if (arr[i]>arr[DateMax]):
        DateMax=i

print("Lista Original: \n")
print(arr)
print("Valor más grande:  ")
print(arr[DateMax])
arr=CountingSort(arr,arr[DateMax]+1)

print("Lista Ordenada: \n")
print(arr)  
        