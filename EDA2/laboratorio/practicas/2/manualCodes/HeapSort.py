#Función Selection Sort (Básico)
#Murrieta Villegas Alfonso

import math #Necesitamos esta biblioteca para funciones posteriores

def hIzq(i):#regresa el izquierdo
    return 2*i

def hDer(i):#Regresa el derechi
    return (2*i)+1

def intercambio(A,x,y):#Función de intercambio
    tmp=A[x]
    A[x]=A[y]
    A[y]=tmp
    
def MaxHeapify(A,i,sizeHeap):#Función principal y la que lleva la lógica
    L=hIzq(i)
    R=hDer(i)
    
    if( L<=sizeHeap and A[L]>A[i]):
        posMax=L
    else:
        posMax=i
    
    if(R<=sizeHeap and A[R]>A[posMax]):
        posMax=R
        
   
    if(posMax!=i):
        intercambio(A,i,posMax)
        print(lista)
        MaxHeapify(A,posMax,sizeHeap)
        
def construirHeapMaxIni(A,sizeHeap):#Función encargada de la contrucción 
    
    for i in range(math.ceil(sizeHeap/2)-1,0,-1):
        MaxHeapify(A,i,sizeHeap)
        
def ordenHeapSort(A,sizeHeap):#Función encargada de ordenar
    construirHeapMaxIni(A,sizeHeap)
   
    #Realmente a través de las funciones previas ordena la lista
    for i in range(len(A[1:]),1,-1):
        
        intercambio(A,1,i)
        
        sizeHeap=sizeHeap-1
        MaxHeapify(A,1,sizeHeap)
        
        
lista=[0,34,78,45,12,98,67]
print(lista)
ordenHeapSort(lista,len(lista)-1)
print(lista)

                