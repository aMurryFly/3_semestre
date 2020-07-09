#Murrieta Villegas Alfonso

class Nodo:
    def __init__(self, valor):
        self.hijoIzq=None
        self.hijoDer=None
        self.val=valor

class Arbol:
    def __init__(self):
        self.raiz=None
        
    def obtenerRaiz(self):
        return self.raiz

    def agregar(self, val):
        if (self.raiz == None):
            self.raiz=Nodo(val)
        else:
            self.agregarNodo(val, self.raiz)
            
    def agregarNodo(self, val, nodo):
        if(val<nodo.val):
            if(nodo.hijoIzq!=None):
                self.agregarNodo(val,nodo.hijoIzq)
            else:
                nodo.hijoIzq=Nodo(val)
        else:
            if (nodo.hijoDer!=None):
                self.agregarNodo(val,nodo.hijoDer)
            else:
                nodo.hijoDer=Nodo(val)
            
    def preorden(self,nodo):
        if(nodo!=None):
            print(str(nodo.val))
            if(nodo.hijoIzq!=None):
                self.preorden(nodo.hijoIzq)
            if (nodo.hijoDer!=None):
                self.preorden(nodo.hijoDer)
    def ImprimePreorden(self):
        if(self.raiz!=None):
            self.preorden(self.raiz)
            
    def busqueda(self, busqueda):
        nodo=self.obtenerRaiz()
        if(busqueda!=nodo.val):
            self.depthSearch(busqueda,nodo)
        else:
            print("El valor "+str(busqueda)+"se encuentra en el arbol")
            #Este es en caso de que sea la misma raíz
    
    def depthSearch(self, busqueda,nodo):
        
        if busqueda<nodo.val:
            nodo=nodo.hijoIzq
            if(nodo!=None):
                if(nodo.val!=busqueda):
                    self.depthSearch(busqueda,nodo)
                else:
                    print("[ "+str(busqueda)+" ] si está en el árbol")
                
        else:
            nodo=nodo.hijoDer
            if(nodo!=None):
                if(nodo.val!=busqueda):
                    self.depthSearch(busqueda,nodo)
                else:
                    print("[ "+str(busqueda)+" ] si está en el árbol")

                  
            else:
                print("[ "+str(busqueda)+" ] NO está en el árbol")

        
            
def main():
    g=Arbol()
    
    print("Arbol Binario")
    g.agregar(8)
    g.agregar(3)
    g.agregar(1)
    g.agregar(10)
    g.agregar(14)
    g.agregar(13)
    g.agregar(6)
    g.agregar(4)
    g.agregar(7)
    g.ImprimePreorden()
    print("Búsqueda en el árbol Binario")
    g.busqueda(324)
    g.busqueda(19)    
    
main()
        
