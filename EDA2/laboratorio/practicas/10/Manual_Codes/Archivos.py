a=open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo.txt','r')
c1=a.read(3)
c2=a.read()
print(c1)

#Impresión

#Impresión de linea
while True:
    linea=a.readline()
    if not linea:
        break
    print(linea)


#impresión lineas
lista=a.readlines()
numlin=0
for linea in lista:
    numlin+=1
    print(numlin,linea)

#uso de archivos de forma optima
with open('C:/Users/pon_c/OneDrive/Documentos/Universidad/3° Semestre/EDA II/Prácticas_LAB/10_practice/Manual_Codes/ejemplo.txt','r') as archivo:
    for linea in archivo:
        a.close



