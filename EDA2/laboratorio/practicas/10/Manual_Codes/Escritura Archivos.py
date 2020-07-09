cadena1="Datos"
cadena2="Secretos"
archivo2= open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo2.txt','w')
print(cadena1+'\n')
#escribe cadena en archivo
archivo2.write(cadena1+'\n')
archivo2.write("hola")
archivo2.write(cadena2)
archivo2.close
#Escribe lista en archivo
lista=['lunes', 'Martes','Miercoles','jueves','viernes']
archivo2= open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo2.txt','w')
archivo2.writelines(lista)
archivo2.close

#apuntador seeky tell para posición de puntero - descomentar siguiente linea

arch= open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo2.txt','r')
arch.seek(5)
cadena1=arch.read(5)
print(cadena1)
print(arch.tell())
arch.close()



import pickle
lista=['alg1','alg2','estr']
archivo=open('materias.dat','wb')
pickle.dump(lista,archivo)
archivo.close
del lista
archivo=open('materias.dat','rb')
lista=pickle.load(archivo)
print(lista)
archivo.close

import os
def crear_directorio(ruta):
    try:
        os.makedirs(ruta)
    except OSError:
        pass
    os.chdir(ruta)
crear_directorio('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo/new')

rootDir='C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes'
for dirName, subdirList,fileList in os.walk(rootDir):
    print('Directorio encontrado: %s'%dirName)
    for frame in fileList:
        print('\t%s'%frame)
        
arch1=open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo.txt','r')
contenido=arch1.read()
nombre=arch1.name
modo=arch1.mode
encoding=arch1.encoding
arch1.close()

if arch1.closed:
    print("It's closed")
else:
    print("It's opened")
print(contenido)
print(nombre)
print(modo)
print(encoding)
