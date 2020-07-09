#Murrieta Villegas Alfonso
#Myrry_fly#

#Búsqueda lineal
def busquedaLineal(A,n,x):
    encontrado=-1
    for k in range (n):
        if A[k] == x:
            encontrado=k
    return encontrado

#Búsqueda lineal Mejorada
def busquedaLinealMejorada(A,n,x):
    encontrado=-1
    for k in range (n):
        if A[k] == x:
            encontrado=k
            break
    return encontrado

#Búsqueda con Centinela
def busquedaLinealCentinela(A,n,x):
    tmp=A[n]
    A[n]=x
    k=0
    while A[k]!=x:
        k=k+1
    print(k)
    A[n]=tmp
    if k<n or A[n]==x:
        return k
    else:
        return-1
    #return encontrado 

lista=[0, 21, 4 ,40, 10, 35, 19]
size=len(lista)
x= 4 #Valor a buscar 

resultado=busquedaLineal(lista,size,x)
#resultado=busquedaLinealMejorada(lista,size,x)
#resultado=busquedaLinealCentinela(lista,size,x)

print("A continuación se muestra la salida de todas las versiones")
print("Elemento a buscar: ")
print(x)
print("Posición del elemento: ")
print(resultado)


