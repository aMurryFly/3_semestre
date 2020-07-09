#Función Quick Sort con sub-listas
#Murrieta Villegas Alfonso

def quicksort(lista):#Función principal
    if len(lista) < 2:#Si solo tiene un elemento (Caso más simple)
        return lista
    else:
        menores, medio, mayores = partition(lista)#Caso común donde llamamos a la partición
    
    #Devuelve 3 listas: menores, medio y mayores en una sola   
    return quicksort(menores) + medio + quicksort(mayores)
 
def partition(lista):
    #Devuelve 3 listas: menores, medio y mayores 
   
    pivote = lista[0]
    menores = []
    mayores = []
    size = len(lista)

    for x in range(1, size):
        if lista[x] < pivote:
            menores.append(lista[x])
            print(menores )
            #Append se utiliza para agregar nuevos elementos
        else:
            mayores.append(lista[x])
            print(mayores)
    medio=pivote[] 
    
    return menores, [pivote], mayores

#Parte de prueba
lista = [54,26,93,64,55,]
quicksort(lista)
print(lista)