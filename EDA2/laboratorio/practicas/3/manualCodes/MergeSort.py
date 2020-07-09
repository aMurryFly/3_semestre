#Alfonso Murrieta Villegas


def CrearSubArreglo(A, indIzq,indDer):

    return A[indIzq:indDer+1]

def Merge(A,p,q,r):
    Izq=CrearSubArreglo(A, p,q)  
    print(Izq)
    Der=CrearSubArreglo(A, q+1,r)
    print(Der)
    i=0
    j=0
    for k in range (p,r+1):
        if (j>=len(Der)) or (i < len(Izq)) and Izq[i] < Der[j]:
            A[k]  = Izq[i]
            i= i +1
        else:
            A[k]  = Der[j]
            j= j +1
    print(lista)
        
def MergeSort(A,p,r):
    if r-p > 0:
        q= int((p+r)/2)
        MergeSort(A,p,q)
        MergeSort(A,q+1,r)
        Merge(A,p,q,r)


lista=[34,78,45,12,98,67]
print(lista)
MergeSort(lista, 0, len(lista)-1)
print(lista)




