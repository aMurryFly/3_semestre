#Alfonso Murrieta Villegas

def ObtenerElemSinClaves(E):
    Elem=[]
    Elem.append("000000")
    for i in range(1,len(E)):
        Elem.append(E[i][0])
    return Elem

def CountingSort2(A,k):
    C=[0 for _ in range (k+1)]
    B=[list(0 for _ in range(2))for _ in range (len(A))]
    
    for j in range(1,len(A)):
        C[A[j][1]]=C[A[j][1]]+1
        
    for i in range(k-1,0,-1):#Parte del código que fue editada 
        C[i]=C[i]+C[i+1]
        
    for j in range(len(A)-1,0,-1):
        B[C[A[j][1]]][1]=A[j][1]
        B[C[A[j][1]]][0]=A[j][0]        
        C[A[j][1]]=C[A[j][1]]-1
    return B

def FormaArregloConClaves(B,numCar):
    Btmp=[]
    for i in range (len(B)):
        Btmp.append([B[i]]*2)
        A3=list(B[i])
        Btmp[i][1]=ord(A3[numCar-1])
    return Btmp

def RadixSort(A):
    numCar=len(A[1])
    for i in range (numCar,0,-1):
        cc=FormaArregloConClaves(A,i)
        ordenado=CountingSort2(cc,122)
        A=ObtenerElemSinClaves(ordenado)
        print(A)
    return A

arr=['000000','X17FS6','PL4ZQ2','JI8FR9','XL8F16','PY2ZR5','KV7WS9','JL2ZV3','KI4WR2']
print("Lista original: ")
print(arr)

arr=RadixSort(arr)
print("Lista ordenada: ")
print(arr)


    