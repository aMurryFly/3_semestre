#Función Quick Sort (Básico)
#Murrieta Villegas Alfonso

def quickSort(lista):
   quickSortAlterna(lista,0,len(lista)-1)#Empezamos desde el primer valor

def quickSortAlterna(lista,primero,ultimo):#Función recursiva 
   if primero<ultimo:

       swap = partition(lista,primero,ultimo)

        #Parte recursiva del programa 
       quickSortAlterna(lista,primero,swap-1)
       quickSortAlterna(lista,swap+1,ultimo)


def partition(lista,primero,ultimo):#Función de partición
   pivote = lista[primero]

    #Estas 2 variables son para poder llevar a cabo las particiones
   marcaIzqui = primero+1
   marcaDere = ultimo 

   checador = False#Condición para validar el ciclo (Bandera)
   
   while not checador:#Ciclo while basado en el código de java 

       while marcaIzqui <= marcaDere and lista[marcaIzqui] <= pivote:
           marcaIzqui = marcaIzqui + 1

       while lista[marcaDere] >= pivote and marcaDere >= marcaIzqui:
           marcaDere = marcaDere -1

       if marcaDere < marcaIzqui:
           checador = True
       else:
           temp = lista[marcaIzqui]
           lista[marcaIzqui] = lista[marcaDere]
           lista[marcaDere] = temp

   temp = lista[primero]
   lista[primero] = lista[marcaDere]
   lista[marcaDere] = temp


   return marcaDere

#Parte de prueba
lista = [54,26,93,17,77,31,44,55,20]
quickSort(lista)
print(lista)