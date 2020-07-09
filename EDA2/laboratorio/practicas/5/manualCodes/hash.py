#MURRIETA VILLEGAS ALFONSO

def formaArreglo(size):
    Arr=[None]*size
    return Arr

def obtenerLlaveNumerica(llave):
    hash=0
    for char in str(llave):
        hash+=ord(char)
    return hash

def H(llaveN):
    return llaveN%5

def agregar(llave,valor,map,size):
    llave_hash=H(obtenerLlaveNumerica(llave))
    ParllaveValor=[llave,valor]
    
    if map[llave_hash] is None:
        map[llave_hash]=list([ParllaveValor])
        return True
    else:
        for par in map[llave_hash]:
            if par[0]==llave:
                par[1]=valor
                return True
        for j in range (size):
            llaveh=(llave_hash+j)%13
            
            if(llaveh==len(map)):
                print("Tabla llena",llave_hash)
                break
            else:
                if map[llave_hash] is None:
                    map[llave_hash]=list([ParllaveValor])
                    return True
                
def buscar(llave, size):
    llave_hash=H(obtenerLlaveNumerica(llave))
    if map[llave_hash] is not None:
        for par in map[llave_hash]:
            if par[0]==llave:
                return par[1]
            
        else:
            for j in range(size):
                llaveh=(llave_hash+j)%13
                if(llaveh==len(map)):
                    break
                for par1 in map[llaveh]:
                    if par1[0]==llave:
                        return par1[1]
    return None

map=formaArreglo(10)
agregar("Hola1",1221321,map,10)
agregar("Hola2",1221322,map,10)
agregar("Hola3",1221323,map,10)
agregar("Hola4",1221324,map,10)
agregar("Hola5",1221325,map,10)
agregar("Hola6",1221326,map,10)
agregar("Hola7",1221327,map,10)
agregar("Hola8",1221328,map,10)
agregar("Hola9",1221329,map,10)
agregar("Hola10",1221330,map,10)
agregar("Hola11",1221311,map,10)



print(map)

print(buscar("Hola2",10))




