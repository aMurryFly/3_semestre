/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murrieta_reza_valdespino_equipo2_g5_proyecto1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Win10
 */
public class Polifase {
    
    /** Variables globales
     * <br>
     * @see #Polifase() 
     * @param f0  direccion del archivo resultado
     * @param f1  direccion del archivo para bloques
     * @param f2  direccion del archivo para bloques
    */
    static File f0 = new File("F0.txt");
    static File f1 = new File("F1.txt");
    static File f2 = new File("F2.txt");
        
        
    static String direccionF0 = ponerdoblebarraP(f0.getAbsolutePath());
    static String direccionF1 = ponerdoblebarraP(f1.getAbsolutePath());
    static String direccionF2 = ponerdoblebarraP(f2.getAbsolutePath());
    
    /**
     * metodo que contiene el proceso para la realizacion del ordenamiento por polifase
     * <br>
     * Variables
     * <br>
     * mllaves determina la cantidad maxima de elementos por bloque
     * <br>
     * fw - fw2 - atraves de su declaracion permite escribir en el documento f0
     * <br>
     * @see #polifase(java.lang.String, int) 
     * Proceso
     * <br>
     * @see #copiarArchivo(java.lang.String, java.lang.String) 
     * -copia el archivo madre al archivo f0 
     * <br>
     * @see #tamanio(java.lang.String) 
     * mediante un ciclo donde el numero de llaves sea menor al tamaño del archivo (metodo) se repetira el siguiente proceso.
     * 
     * <br>
     * @see #leerAsignar(int, java.lang.String, java.lang.String, java.lang.String) 
     * -se leera el archivo f0 y asignara bloques de igual tamaño tanto en f1 y f2 (metodo)
     * <br>
     * @see #ordenacion(int, int, int, java.lang.String, java.lang.String, java.lang.String) 
     * -se ordenaran los datos de f1 y f2, posteriormente lo transcribiran a f0 (metodo)
     * <br>
     * @see #polifase(java.lang.String, int) 
     * -la variable mllaves se multiplica x2, ya que dos bloques generan uno del doble de tamaño
     * <br>
     * @see #polifase(java.lang.String, int) 
     * -escribe un salto de linea en f0 para evitar un error de lectura posterior.
     * @param direccionArch direccion del archivo madre usado para ordenar

     * @param opcion opcion que determina el tipo de ordenacion
     * @throws IOException Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */ 
    public static  void polifase(String direccionArch,int opcion) throws IOException
    {
        int mllaves = 1; //tamaño de los bloques
        int tamanioArchivo = tamanio(direccionArch); //determina el tamaño del archivo
            FileWriter fw = new FileWriter(direccionF0,true); //escribe sin perder el contenido previo
            fw.write("Ordenamiento por polifase \n"); 
            fw.close();
       
         
        copiarArchivo(direccionArch,direccionF0); //copia el contenido del archivo del usuario a F0
         
         
        while(mllaves < tamanioArchivo){  //determina la cantidad de veces que se hara el proceso depende del tamaño de los bloques y del archivo (cantidad de datos) 
         
            leerAsignar(mllaves,direccionF0,direccionF1,direccionF2); //asigna los bloques correspondientes a F1 Y F2
            ordenacion(opcion,mllaves,tamanioArchivo,direccionF1,direccionF2,direccionF0); //ordena por intercalacion de bloques escribiendo a F0
            mllaves*=2; //cuando se termine la operacion los bloques aumentan al doble su tamaño
         //
            FileWriter fw2 = new FileWriter(direccionF0,true);
            fw2.write("\n"); //se escribe un salto de linea para evitar error en la lectura
            fw2.close();
       //
    
        }
        System.out.println("El archivo esta ordenado");
      
        
    }

    /**
     * Este metodo lee la ultima linea del archivo f0 y asigna bloques de tamaño m a F1 y F2
     * <br>
     * Variables
     * <br>
     * valores - arreglo de cadenas leidos desde F0, son los numeros sin las comas
     * <br>
     * cadenaF1-cadenaF2 - ArrayList que guarda los bloques correspondientes de intercalacion
     * <br>
     * cortes - entero que permite dar la clasificacion de los datos por bloques
     * <br>
     * @see #leerAsignar(int, java.lang.String, java.lang.String, java.lang.String) 
     * Proceso
     * <br>
     * -se declara el arreglo y los arraylist
     * <br>
     * @see #lectura(java.lang.String) 
     * -se lee el archivo f0 y se guardan los datos- numeros en el arreglo ya separados(metodo)
     *  <br>
     * @see #leerAsignar(int, java.lang.String, java.lang.String, java.lang.String) 
     * -mediante un for que tiene n iteraciones donde n es el tamaño del arreglo valores, se ira asignando a cada arraylist una cantidad de datos, aumentando el indice de cortes 
     *  cada vez que llegue al limite dado por el parametro de llaves cambiara de direccion al otro arraylist
     *  <br>
     * @see #asignarbloqueF1(java.util.ArrayList, java.lang.String) 
     * -se transcribe el ArrayList cadenaF1 al archivo F1
     *  <br>
     * @see #asignarbloqueF2(java.util.ArrayList, java.lang.String) 
     * -se transcribe el ArrayList cadenaF2 al archivoF2
     * @param llaves delimita el tamaño de los bloques
     * @param direccionArch direccion del archivo F0 
     * @param f1 direccion del archivo F1 
     * @param f2 direccion del archivo F2
     * @throws IOException Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    public static  void leerAsignar(int llaves,String direccionArch,String f1,String f2) throws IOException
    {   
        String[] valores;
        ArrayList<String> cadenaF1 = new ArrayList<String>();
        ArrayList<String> cadenaF2 = new ArrayList<String>();
        int separacion=1, cortes=0; //la variable cortes permite hacer la separacion
       
        valores = lectura(direccionArch); //asigna un arreglo de Strings generado por la funcion
         
         
         ////////////////////////////////////////////
        for(int i=0;i<valores.length;i++)  //permite la clasificacion de datos
        {
            if(separacion==1){ //en caso de que separacion sea 1 se ira al ArrayList que se escribira en F1
                cadenaF1.add(valores[i]);
                cortes++; 
            }    
            else
            {
                cadenaF2.add(valores[i]);
                cortes++;
            }
           //////////////////////////////
            if(cortes==llaves)
            {
                if(separacion==1) //cambia la direccion de los datos F1 a F2
                {
                    separacion=2;
                    cortes=0;
                }
                else // de F2 a F1, la variable cortes se modificara dependiendo del tamaño de los bloques.
                {
                    separacion=1;
                    cortes=0;
                }
           }
           ///////////////////////////////
         }
        //////////////////////////////////////
        System.out.println("\nVa a F1:  "+Arrays.asList(cadenaF1));
        System.out.println("\nVa a F2 "+Arrays.asList(cadenaF2));
        ////
        
        asignarbloqueF1(cadenaF1,f1 ); //se tiene que ajustar la direccion dependiendo del equipo que lo ocupe 
        asignarbloqueF2(cadenaF2,f2 ); //se transcribe el ArrayList a su archivo correspondiente
    }
    
    /**
     * permite transcribir un bloque de datos (numeros) al archivo F1
     * 
     * Variables
     * <br>
     * fw- un filewirter con direccion del archivo F1 que permite escribir contenido en el
     * <br>
     * @see #asignarbloqueF1(java.util.ArrayList, java.lang.String) 
     * Proceso
     * <br>
     * -se declara un FileWriter dandole como parametros la direccion del archivo F1 y un booleano que permite sobreescribir en el archivo sin borrar el contenido
     * <br>
     * -mediante un for que se desplaza sobre el ArrayList dado como parametro,va escribiendo el valor mas una de una coma
     * <br>
     * -cierra el archivo.
     * 
     * @param cadena ArrayList que contiene los bloques de datos intercalados
     * @param direccionArch direccion del archivo F1
     * @throws IOException  Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    public static  void asignarbloqueF1(ArrayList<String> cadena,String direccionArch) throws IOException 
    { 
        /*/vaciar el archivo
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionArch)) ;
            bf.write("");
            bf.close();
         //fin vaciar*/
        
        
        FileWriter fw = new FileWriter(direccionArch,true); //escribira en F1 sin borrar el contenido previo
        
        
        for(String linea:cadena) //linea se desplaza sobre el ArrayList tomando sus valores
        {
            fw.write(linea+","); //transcribe el ArrayList a F1
        }
        fw.write("\n");
        fw.close(); //cierra archivo
    }
    
   /**
     * permite transcribir un bloque de datos (numeros) al archivo F2
     * <br>
     * Variables
     * <br>
     * fw- un filewirter con direccion del archivo F2 que permite escribir contenido en el
     * <br>
     * @see #asignarbloqueF2(java.util.ArrayList, java.lang.String) 
     * Proceso
     * <br>
     * -se declara un FileWriter dandole como parametros la direccion del archivo F2 y un booleano que permite sobreescribir en el archivo sin borrar el contenido
     * <br>
     * -mediante un for que se desplaza sobre el ArrayList dado como parametro,va escribiendo el valor mas una coma
     * <br>
     * -cierra el archivo.
     * 
     * @param cadena ArrayList que contiene los bloques de datos intercalados
     * @param direccionArch direccion del archivo F2
     * @throws IOException  Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    public static  void asignarbloqueF2(ArrayList<String> cadena,String direccionArch) throws IOException
    {
            /*/vaciar el archivo
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionArch)) ;
            bf.write("");
            bf.close();
            //fin vaciar*/
        
        
        FileWriter fw = new FileWriter(direccionArch,true);  //escribira en F2 sin borrar el contenido previo
        
        for(String linea:cadena) //linea se desplaza sobre el ArrayList tomando sus valores
        {
            fw.write(linea+","); //transcribe el ArrayList a F2
        } 
        fw.write("\n");
        fw.close();
    }
    
    //metodo de ordenacion //recibe archivos invoca la conversion 

    /**
     * este metodo ordena los datos por bloques intercalados entre F1 y F2 para luego escribirlos en F0
     * <br>
     * Variables
     * <br>
     * valoresF1-valoresF2- arreglos de Strings que contienen los datos correspondientes a los archivos F1 y F2
     * <br>
     * v1-v2 - ArrayList que contienen los datos de valores ya convertidos a enteros
     *<br>
     * v3- arreglo que contiene el resultado de la ordenacion de dos bloques intercalados
     * <br>
     * @see #ordenacion(int, int, int, java.lang.String, java.lang.String, java.lang.String) 
     * Proceso
     * <br>
     * -declaradas las variables
     * <br>
     * @see #lectura(java.lang.String) 
     * - se hace la lectura del archivo F1 y F2 para asignar los valores a sus arreglos correspondientes (metodo)
     * <br>
     * @see #conversion(java.lang.String[]) 
     * - los ArrayList se les asignan los valores ya enteros de los arreglos (metodo)
     * <br>
     * @see #delimitadorFor(int, int) 
     * - mediante un for con iteraciones dadas por un metodo se realiza la extraccion de los datos usando la variable llaves que determina cuantas debe extraer y estas se guardaran en v3
     * <br>
     * @see #ordenacion(int, int, int, java.lang.String, java.lang.String, java.lang.String) 
     * - dependiendo del parametro opcion se realizara el ordenamiento por selectionSort  de v3
     * <br>
     * @see #escrituraF0(java.util.ArrayList, java.lang.String) 
     * - despues se escribe el resultado en F0 (metodo)
     * <br>
     * @see #ordenacion(int, int, int, java.lang.String, java.lang.String, java.lang.String) 
     * - se limpia el arraylist para la siguiente iteracion 
     * @param opcion da el tipo de ordenacion que se va a realizar ascendente/descendente
     * @param llaves cantidad de elementos por bloque, permite delimitar la extraccion de elementos
     * @param tamanio tamaño del archivo, cantidad de elementos que se estan manejando 
     * @param Arch1 direccion del archivo F1
     * @param Arch2 direccion del archivo F2
     * @param arch3 direccion del archivo F0
     * @throws IOException Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    
    public static  void ordenacion(int opcion,int llaves,int tamanio,String Arch1, String Arch2, String arch3) throws IOException
    {
      System.out.println("De F1: ");
      String[] valoresF1 = lectura(Arch1); //obtiene los datos en forma de String de F1
      System.out.println("De F2: ");
      String[] valoresF2 = lectura(Arch2); //obtiene los datos en forma de String de F2
      ArrayList<Integer> v1 = new ArrayList<Integer>();
      ArrayList<Integer> v2 = new ArrayList<Integer>();
      ArrayList<Integer> v3 = new ArrayList<Integer>(); //usado para ordenar 
      v1= conversion(valoresF1); //hace un parseo de los datos de String a enteros
      v2= conversion(valoresF2); //hace un parseo de los datos de String a enteros
      
      int indice;
      //ORDENAR bloques
      for(indice=0;indice< delimitadorFor(tamanio,llaves)+1;indice++)  //este hara iteraciones dependiendo de lo que se obtenga del metodo
      { 
        for(int i=0;i<llaves;i++) //se extrae un bloque de datos de la primera lista
        {
            if(v1.isEmpty()!=true){
                if(v1.size()==1){
                  v3.add(v1.get(0)); //se agrega el dato al bloque conjunto  de bloques intercalados
                  v1.remove(0); //siempre se retira el primero ya que se tiene que respetar el orden de los datos
                }
                else{
                    v3.add(v1.get(0));
                    v1.remove(0);
                }
            }
        }
        
        for(int i=0;i<llaves;i++) //se extrae un bloque de datos de la segunda lista
        {
              if(v2.isEmpty()!=true){
                if(v2.size()==1){
                  v3.add(v2.get(0)); //se agrega el dato al bloque conjunto de bloques intecalados
                  v2.remove(0);  //se retira el primero ya que se tiene que respetar el orden de los datos
                }
                else{
                    v3.add(v2.get(0));
                    v2.remove(0);
                }
            }
        }
        
        System.out.println("\n Intecalando");
        System.out.println("V3= "+Arrays.asList(v3));
        ///ordenacion por el metodo selectionSort
        // ordena dos bloques intercalados
        System.out.println("ORDENACIÓN");
        int minimo;
        if(opcion==1){ //ordenacion ascedente 
            for(int x=0; x<v3.size()-1;x++)
            {
                minimo = x;
                for(int y=x+1; y<v3.size();y++)
                {
                    if(v3.get(y)<v3.get(minimo)) //cada vez que se encuentra un numero menor al actual se actualiza la posicion
                    {
                    minimo=y;  
                    }
                }
                //se intercambian los datos del elemento en la posicion i con el de la posicion minimo
                int aux = v3.get(minimo); 
                v3.set(minimo,v3.get(x));
                v3.set(x,aux);
                System.out.println(Arrays.asList(v3));
            
            }
        }
        else if(opcion==2){ //ordenacion descendente
             for(int x=0; x<v3.size()-1;x++)
            {
                minimo = x;
                for(int y=x+1; y<v3.size();y++)
                {
                    if(v3.get(y)>v3.get(minimo))  //cada vez que se encuentra un numero mayor al actual se actualiza la posicion
                    {
                    minimo=y;  
                    }
                }
                //se intercambian los datos del elemento en la posicion i con el de la posicion minimo
                int aux = v3.get(minimo);
                v3.set(minimo,v3.get(x));
                v3.set(x,aux);
                System.out.println(Arrays.asList(v3));
            
            }
            
        }
        /// fin ordenacion 
        
        escrituraF0(v3,arch3); //escribe el bloque ordenado a F0
        
        v3.clear(); //limpia la lista para la siguiente iteracion 
      
        
      }
      
      
       System.out.println("fin iteracion \n");
      
    }
    
    /**
     * permite separar los elementos de una linea con datos separados por coma
     * <br>
     * variables
     * <br>
     * separador- permite usarse en la funcion split para generar el arreglo de strings
     * <br>
     * cadena - usada para leer el archivo
     * <br>
     * ultimaCadena - usada para obtener la ultima linea de un archivo
     * <br>
     * f- FileReader que permite la lectura del archivo
     * <br>
     * b- BufferedReader que permite la lectura del archivo mediante un buffer
     * <br>
     * @see #lectura(java.lang.String) 
     * Proceso:
     * <br>
     * -Declaradas las variables se entra en un ciclo while que mientras que la cadena no sea nula entonces la ultima cadena obtendra el valor de cadena
     *   Esto permite leer todo el archivo linea por linea hasta que no haya siguiente, entonces se obtendra la ultima linea del archivo que contiene valores
     * <br>
     *  -Esta linea se aplica el metodo .split que permite generar un arreglo de cadenas sin el separador dado como parametro
     * <br>
     * - Se retorna el arreglo de Strings
     * @param direccionArch direccion de un archivo
     * @return String[]
     * @throws FileNotFoundException Excepcion lanzada en caso de no poder encontrar el archivo
     * @throws IOException Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    public static  String[] lectura(String direccionArch) throws FileNotFoundException, IOException
    {   
       final String separador = ",";  
        String[] valores = null;
        String cadena;
        String ultimaCadena = null;
        FileReader f = new FileReader(direccionArch); //permite leer el archivo
        BufferedReader b = new BufferedReader(f);  //permite leer mediante un buffer
        
        
        while((cadena = b.readLine())!=null) { //con este ciclo se garantiza obtener la ultima cadena de un archivo
            
           ultimaCadena = cadena;
            
           System.out.println(cadena);
            
             
        } 
        
        valores = ultimaCadena.split(separador);  //la cadena es un conjunto de datos separados por "," este es un separador, el metodo split permite
        //generar un arreglo de Strings de ese conjunto sin el separador 
        if(f==null)
        {
         f.close();
        }
         System.out.println("\nLa cadena se convirtio a array: "+Arrays.toString(valores));
         
         return valores; 
    }
    
    //metodo de conversion y asignacion a listas //usar Integer.parseInt

    /**
     * permite convertir un arreglo de Strings  a un ArrayList de enteros
     * <br>
     * Variables 
     * <br>
     * l- ArrayList de enteros
     * <br>
     * @see #conversion(java.lang.String[]) 
     * Proceso
     * <br>
     * -En un for que recorre el arreglo de Strings cada elemento se le hace un parseo al mismo tiempo que se agrega al ArrayList L
     * <br>
     * -devuelve la lista l
     * @param lista arreglo de Strings numericos
     * @return ArrayList(Integer)
     */
    public static  ArrayList<Integer> conversion(String[] lista)
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(String i:lista) //el String se deplaza sobre la lista de Strings
        {
         l.add(Integer.parseInt(i)); //cada String se le hace una conversion o parseo a Entero
        }
        
        return l;
    }
    
    
    //metodo de escritura para resultado f0//recibe listas y f0

    /**
     * permite escribir el contenido de un ArrayList en el archivo F0
     * <br>
     * Variables
     *  <br>
     * fw - FileWrite que permite escribir en el archivo F0
     *  <br>
     * @see #escrituraF0(java.util.ArrayList, java.lang.String) 
     * Proceso
     *  <br>
     * -mediante un ciclo que recorre el ArrayList se va escribiendo el elemento seguido de una coma
     *  <br>
     * -cierra el FileWriter
     * 
     * @param l1 ArrayList que contiene elementos numericos
     * @param f0 direccion del archivo F0
     * @throws IOException  Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    
    public static  void escrituraF0(ArrayList<Integer> l1,String f0) throws IOException
    {   
        
        FileWriter fw = new FileWriter(f0,true); //permite escribir en el archivo manteniendo el contenido previo
        
        for(int linea:l1)
        {
            fw.write(linea+","); //escribe los elementos de la lista separados por coma
        }
      
        fw.close();
    }
    
    //metodo tamaño del archivo es decir la cantidad de numeros

    /**
     * permite saber el tamaño de un conjunto de datos que se trabaja en un archivo
     * <br>
     * Variables 
     * <br>
     * valores - arreglo de Strings con los datos del archivo sin el separador
     * <br>
     * @see #tamanio(java.lang.String) 
     * Proceso
     * <br>
     * @see #lectura(java.lang.String) 
     * se obtiene el conjunto de datos sin el separador y se asigna al arreglo de Strings
     * <br>
     * @see #tamanio(java.lang.String) 
     * se retorna el tamaño del arreglo
     * 
     * @param direccionArch direccion del archivo Madre
     * @return int  
     * @throws IOException  Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    
    public static int tamanio(String direccionArch) throws IOException
    {
      String[] valores = lectura(direccionArch); //hace la lectura de la cadena y obtiene sus datos en forma de arreglo
      
      System.out.println(valores.length); //solo se obtiene la cantidad de datos que se van a trabajar
      return valores.length;
    }
    
    /**
     * permite delimitar la cantidad de iteraciones que se haran en un extraccion en ordenacion
     * <br>
     * Variables
     * <br>
     * n = es el numero de iteraciones
     * <br>
     * @see #delimitadorFor(int, int) 
     * Proceso
     * <br>
     * se divide el tamaño entre el numero de bloques por llave al resultado se vuelve a dividir entre 2
     * <br>
     * en caso de que la division de el tamaño entre las llaves sea un numero no par entoces la cantidad de iteraciones aumenta en uno
     * <br>
     * retorna n
     * @param tamanio tamaño del conjunto de datos que se trabaja
     * @param llaves cantidad de llaves por bloque
     * @return int 
     */
    public static int delimitadorFor(int tamanio, int llaves)
    {
     int n= (int)(tamanio/llaves)/2; //esta operacion delimita el numero de iteracion
     if((tamanio/llaves)%2 != 0) //en caso de de ser no par la cantidad de datos entonces se suma uno a las iteraciones 
     {
       n+=1;  
     }
     return n;
    }

    /**
     * Permite pasar el contenido de un archivo madre a F0
     * <br>
     * Variables
     * <br>
     * cadena. cadena1- almacena la cadena con los datos
     * <br>
     * f- FileReader permite leer el archivo madre
     * <br>
     * b- BufferedReader permite leer el archivo atraves de un buffer
     * <br>
     * fw- FileWriter permite la escritura en el archivo F0
     * 
     * <br>
     * @see  #copiarArchivo(java.lang.String, java.lang.String) 
     * Proceso
     * <br>
     * En un ciclo while mientras que la siguiente cadena no sea nula, la variable cadena 1 tomara el valor de cadena es decir la ultima cadena o linea de un archivo
     * <br>
     * la variable cadena1 se transcribe al archivo F0
     * <br>
     *  
     * @param direccionArch direccion del archivo madre
     * @param f0  direccion del archivo F0
     * @throws FileNotFoundException Excepcion lanzada en caso de no poder encontrar el archivo
     * @throws IOException  Excepcion lanzada en caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    public static void copiarArchivo(String direccionArch,String f0) throws FileNotFoundException, IOException {
        String cadena = null,cadena1 = null;
        FileReader f = new FileReader(direccionArch);
        BufferedReader b = new BufferedReader(f);
       
        while((cadena = b.readLine())!=null) { //se obtiene la ultima cadena del archivo madre
            
            cadena1 = cadena;
           System.out.println("\nLista de claves: "+cadena);
            
             
        } 
        
        FileWriter fw = new FileWriter(f0,true); //se abre el archivo F0
        
        fw.write(cadena1+"\n"); //se escribe la cadena, es decir se copia el contenido del archivo madre 
        
        fw.close();
        
    }

    /**
     * Permite generar una direccion valida para realizar operaciones con archivos
     * <br>
     * Variables
     *  <br>
     * separador - cadena que permite la separacion de una linea 
     * <br>
     * n- arreglo de tipo String que almacena partes de la direccion
     *  <br>
     * direccionDoble- variable resultado
     *  <br>
     * @see #ponerdoblebarra(java.lang.String) 
     * Proceso
     *  <br>
     * - declaradas las variables, a n se le asigna el arreglo generado por aplicar el metodo split con el separador \\
     *  <br>
     * -mediante un for se va transcribiendo a la cadena DireccionDoble, cada elemento del arreglo n, concatenando la doble barra
     *  <br>
     * - en la ultima iteracion se agrega la carpetas donde se esta ejecuntando el archivo debido a que la direccion generada no lo contiene.
     *  <br>
     * -retorna direccionDOble
     * 
     * @param direc direccion del archivo con una barra
     * @return String 
     */
    public static String ponerdoblebarra(String direc)
    {
        String separador ="\\\\"; //se usa 4 barras por genera error al poner un numero no par
        String[] n = direc.split(separador); //se separa la direccion en secciones, dados en un arreglo
        String direccionDoble =""; //variable resultado
        
      
        for(int i=0;i<n.length;i++)
        {
            if(i<n.length-1)
            {
                direccionDoble=direccionDoble+n[i]+"\\\\"; //cada elemento de la direccion ahora se pone con doble barra   
            }
            else
            {
                direccionDoble=direccionDoble+"src\\\\murrieta_reza_valdespino_equipo2_g5_proyecto1\\\\FilesPolifase\\\\"+n[i]; //en la ultima iteracion se especifica la carpeta de ejecucion ya que la direccion 
                //no contempla las direcciones donde se esta ejecutando el programa y llamando el archivo.
            }
        }

        return direccionDoble;
    }
    /**
     * Permite generar una direccion valida para realizar operaciones con archivos
     * <br>
     * Variables
     *  <br>
     * separador - cadena que permite la separacion de una linea 
     * <br>
     * n- arreglo de tipo String que almacena partes de la direccion
     *  <br>
     * direccionDoble- variable resultado
     *  <br>
     * @see #ponerdoblebarraP(java.lang.String) 
     * Proceso
     *  <br>
     * - declaradas las variables, a n se le asigna el arreglo generado por aplicar el metodo split con el separador \\
     *  <br>
     * -mediante un for se va transcribiendo a la cadena DireccionDoble, cada elemento del arreglo n, concatenando la doble barra
     *  <br>
     * - en la ultima iteracion se agrega la carpetas donde se esta ejecuntando el archivo debido a que la direccion generada no lo contiene.
     *  <br>
     * -retorna direccionDoble
     * 
     * @param direc direccion del archivo con una barra
     * @return String 
     */
    public static String ponerdoblebarraP(String direc)
    {
        String separador ="\\\\";
        String[] n = direc.split(separador);
        String direccionDoble ="";
        
      
        for(int i=0;i<n.length;i++)
        {
            if(i<n.length-1)
            {
                direccionDoble=direccionDoble+n[i]+"\\\\";   
            }
            else
            {
                direccionDoble=direccionDoble+"src\\\\murrieta_reza_valdespino_equipo2_g5_proyecto1\\\\FilesPolifase\\\\"+n[i];
            }
        }
      
        return direccionDoble;
    }
}
    
    


    
    
    
