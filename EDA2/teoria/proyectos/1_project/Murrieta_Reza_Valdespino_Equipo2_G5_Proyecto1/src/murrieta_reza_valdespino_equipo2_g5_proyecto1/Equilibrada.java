
package murrieta_reza_valdespino_equipo2_g5_proyecto1;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Equilibrada{
    /**
     * @see #Equilibrada() 
     * @param archF1,archF2,archAux Archivos de apoyo
     * @param filef1,filef2,fileE Direcciones de los archivos de apoyo, obtenidos de 
     * <br>
     * Proceso
     * <br>
     * Se dio la creaación de los archivos de apoyo. archF1 y archF2 serán los archivos de apoyo para los bloques
     * y ArchE será donde se vacíen los datos de los bloques. Las variables String obtendrán la dirección de los archivos con ayuda de la función 
     * ponerdoblebarra(). También habrá una variable int para saber que se hará el proceso ascendente (1) o descendente (2)
     * 
     */
    static File archF1=new File("FileF1.txt");
    static String filef1= ponerdoblebarraE(archF1.getAbsolutePath());
    static File archF2=new File("FileF2.txt");
    static String filef2= ponerdoblebarraE(archF2.getAbsolutePath());
    static File archE=new File("FileE.txt");
    static String fileE= ponerdoblebarraE(archE.getAbsolutePath());
    static int opcion;
    
    /**La función MezclaEquilibrada da inicio al ordenamiento por Mezcla equilibrad
     * <br>
     * Variables
     * <br>
     * separador: Da corte a los bloques de datos con ","
     * <br>
     * Valores: Cadena que obtiene los datos.
     * <br>
     * UltimaCadena: String que obtiene la última linea del archivo
     * <br>
     * Datos: ArrayList que obtendrá los datos de la linea.
     * <br>
     * @see #MezclaEquilibrada(java.lang.String, int)
     * Proceso:
     * <br>
     * @see #VaciarArch(java.lang.String) 
     * Vacia los archivos auxiliares cada vez que se inicia el proceso.
     * <br>
     * Se da un ciclo que obtiene la última linea con un FileReader y BufferFile
     * La cadena de string generada será guardada a la lista gracias al método Integer.parseInt(); 
     * Se mandan la lista de los datos a ordenar 
     * <br>
     * @see #MezclaEquilibrada(java.lang.String, int) 
     * @param direccionArch Dirección del archivo madre
     * @param opcion Opción que determinará el tipo de ordenación.
     * @throws FileNotFoundException En caso de no encontrar el archivo a manejar
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).
     */
    
    
    public static void MezclaEquilibrada(String direccionArch, int opcion)throws FileNotFoundException, IOException{
    
        Equilibrada.opcion=opcion;
        final String separador = ","; 
        String [] valores = null;
        String cadena;
        String ultimaCadena=null;
        ArrayList<Integer> datos = new ArrayList<Integer>();
        //Borrar residuos de archivo Auxiliares
        VaciarArch(filef1);
        VaciarArch(filef2);
        VaciarArch(fileE);
        
        FileReader rd = new FileReader(direccionArch);
        BufferedReader bu= new BufferedReader(rd);
        
        while((cadena = bu.readLine())!=null) {
           ultimaCadena=cadena;
           valores= ultimaCadena.split(separador); 
            
           System.out.println(cadena);
            
             
        }
         if(rd==null)
        {
            rd.close();
        }
        System.out.println(Arrays.toString(valores));
        
        for (String i: valores){
            datos.add(Integer.parseInt(i));
        }
        System.out.println(datos);
        Equilibrada(datos);
    }
    
    /**
     * Método do que hace la lectura de los datos de la última linea del archivo enviado cuando este ya esta dividido o segmentado por bloques
     * <br>
     * Varables
     * <br>
     * FileReader y BufferReader rd, bu: Lectura de últjima linea del archivo.
     * <br>
     * cadena, utimaCadena: Guarda la linea obtendia de rd y bu
     * <br>
     * valores[]: Datos obtendios guardados en un arreglo de String
     * <br>
     * separador: Variable para utilizar el método split, se inicalizará como "\\|" 
     * <br>
     * Proceso:
     * <br>
     * Obtenido la dirección, se creará un FileReader y un BufferReader para hacer la lectura de la última linea, gracias al método readLine();
     * Obtenido la última linea, se dará a la separación de datos, por medio de la función split(), con el separados de bloques "|"
     * @param direccionArch Obtiene la direccion de los archivos auxiliares,
     * @return String []
     * @throws FileNotFoundException En caso de no encontrar el archivo a manejar
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static String [] divisionInicial(String direccionArch) throws FileNotFoundException, IOException{

        FileReader rd = new FileReader(direccionArch);
        BufferedReader bu= new BufferedReader(rd);
        String cadena=null;
        String ultimaCadena=null;
        String []valores=null;
        final String separador = "\\|"; 
        while((cadena = bu.readLine())!=null) {
           ultimaCadena=cadena;
           valores= ultimaCadena.split(separador); 
  
             
        }
         if(rd==null)
        {
            rd.close();
        }
    
        return valores;
    }
    
    /**
     * Método de limpieza de los archivos auxiliares después de haberlos usado en procesos anteriores.
     * @param direccionArch Obtiene la direccion de los archivos auxiliares.
     * @throws FileNotFoundException En caso de no encontrar el archivo a manejar
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static void VaciarArch(String direccionArch)throws FileNotFoundException, IOException{

        
        BufferedWriter bf = new BufferedWriter(new FileWriter(direccionArch)) ;
        bf.write("");
        bf.close();
    
    }
    
    /**
     * El método de guardado obtiene y guardará los bloques de datos a segmentar la lista a modificar.
     * <br>
     * Variables
     * <br>
     * FileWriter fw: Objeto para la escritura de datos en el archivo pasado por la dirección
     * <br>
     * Proceso:
     * <br>
     * Se creará un FileWriter que respetará lo escrito anteriormente en el archivo. Se creará un ciclo el cual recorrerá los datos de la lista.
     * Se checará si el índice del dato checado es igual al índice en la posición señanala de la lista de índices, si es así escribirá un "|" para declarar la separación de bloques.
     * Si no es así, se escribirá el dato junto con una coma. 
     * @param File Lista de los datos obtendios a guardar en el archivo
     * @param indices Lista de los índices en donde se hizo la segmentación para los bloques de información
     * @param direccionArch Dirección del archivo para guardar la lista de datos
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static void Guardado(ArrayList<Integer> File,ArrayList <Integer> indices, String direccionArch)throws IOException {
        
        FileWriter fw = new FileWriter(direccionArch,true);
        int i=1;
        fw.write("\nIteración\n");
        
        for(int linea:File)
        {
        
            if(File.indexOf(linea)==indices.get(i)){
                
                fw.write(linea+"|");
                i++;
            
            }else{
                fw.write(linea+",");
            }
            if(i==indices.size()){
                i=0;
            }
        }
            fw.close();
        }
    
    /**
     * El método Equilibrada será la encargada de segmentar la información de la lista y poder guardar los datos en los archivos de apoyo y emepzar en el ordenamiento.
     * <br>
     * Variables
     * <br>
     * ArrayList FileF1, FileF2: Listas que guardarán los datos para los archivos de apoyo 1 y 2, respectivamente.
     * <br>
     * ArrayList indicesF1, indicesF2: Listas que guardarán los índices en donde se dio la diferencia de orden y la segmentación de datos.
     * <br>
     * corteF1, corteF2: índices que serán guardados cuando se realice la segmentación de datos.
     * <br>
     * boolean cambioArch: Varieable para saber en que lista se deben de seguir agregando los datos. Archivo 1 (True) y Archivo 2 (False
     * <br>
     * Proceso:
     * <br>
     *  El método Equilibrada creará 2 listas de apoyo, que serán utilizadas para el guardado de datos en las listas y 
     * otras 2 listas para obtener los índices donde se distinguiran los bloques cuando el dato es menor al anterior.
     * <br>
     * Al inicio se guardará el primer dato de la lista "datos" a la lista "File1" y se agregará el 0 a las listas de índices.
     * Se checará si será ascendente o descendente con el atributo de opción. En el ciclo, si el índice es diferente al tamaño de la 
     * lista realizará y evaluará. Si el dato anterior del índice es menor  al dato señalado con el índice actual entrará a checar en que archivo guardará el dato.
     * <br>
     * Con ayuda del boolean, checará si el dato se ingresará a la lista File1 (true) o File 2 (false). Si entra a cualquierá el número de cortes incrementará, 
     * se agregará el dato a la lista correspondiente y aumentará el contador del ciclo.
     * En el tal caso que no cumpla con la primera decisión, se checará si el estado del booleano, si es true, el dato del indice i se agregará en la otra lista (File2)
     * cambiará el bool a false, se agregará el contador del corte en la lista y se incrementarán el indice i y el del corte respectivo, y así en viceversa si es false, cambiará a la lista1 y el boolean a true.
     * <br>
     * Al final se checará si el índice del corte es diferente al tamaño de la lista, se agregará el tamaño de la lista a las listas de los cortes.
     * Este procedimineto se será igual pero cambiará en las condiciones para el ordenamiento descendente.
     * @see #Guardado(java.util.ArrayList, java.util.ArrayList, java.lang.String) 
     * Envirá la información de las listas generadas para los archivos, junto con la listas de índices y la dirección del archvo correspondiente para guardar los datos
     * @see #LectYOrd(java.lang.String, java.lang.String, java.lang.String) 
     * Realizará el la lectura de ambos archivos y poder guardarlos dependiento del orden en el archivo auxiliar.
     * @param datos Lista de datos obtendios de la lectura del archivo inicial y auxiliar.
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static void Equilibrada(ArrayList<Integer> datos)throws IOException{
        
        
        ArrayList<Integer> File1 = new ArrayList<Integer>();
        ArrayList<Integer> File2 = new ArrayList<Integer>();
        ArrayList <Integer> indicesF1= new ArrayList<Integer>();
        ArrayList <Integer> indicesF2= new ArrayList<Integer>();
        int corteF1=0, corteF2=0;
        boolean cambioArch=true;
        int i=0;
        File1.add(datos.get(i));
        i++;

        indicesF1.add(0);
        indicesF2.add(0);
        if(Equilibrada.opcion==1){
            
            while (i!=datos.size()){
                if(datos.get(i-1)<=datos.get(i)){
                    if(cambioArch){
                        corteF1++;
                        File1.add(datos.get(i));

                        i++;
                    }else{
                        corteF2++;
                        File2.add(datos.get(i));
                        i++;
                    }


                }else{
                    if(cambioArch==true){
                        cambioArch=false;
                        File2.add(datos.get(i));

                        indicesF1.add(corteF1);
                        corteF1++;
                        i++;
                    }else{
                        cambioArch=true;
                        File1.add(datos.get(i));

                        indicesF2.add(corteF2);
                        corteF2++;
                        i++;
                    }

                }


            }
            if(indicesF1.get(indicesF1.size()-1)!=File1.size()-1){
                indicesF1.add(corteF1);
            }
            if(indicesF2.get(indicesF2.size()-1)!=File2.size()-1){
                indicesF2.add(corteF2);
            }
        
        }else{
            while (i!=datos.size()){
            if(datos.get(i-1)>=datos.get(i)){
                if(cambioArch){
                    corteF1++;
                    File1.add(datos.get(i));
                    
                    i++;
                }else{
                    corteF2++;
                    File2.add(datos.get(i));
                    i++;
                }
              
            
            }else{
                if(cambioArch==true){
                    cambioArch=false;
                    File2.add(datos.get(i));
                    
                    indicesF1.add(corteF1);
                    corteF1++;
                    i++;
                }else{
                    cambioArch=true;
                    File1.add(datos.get(i));
                    
                    indicesF2.add(corteF2);
                    corteF2++;
                    i++;
                }
                
            }
            
            
            }
            if(indicesF1.get(indicesF1.size()-1)!=File1.size()-1){
                indicesF1.add(corteF1);
            }
            if(indicesF2.get(indicesF2.size()-1)!=File2.size()-1){
                indicesF2.add(corteF2);
            }
        
        
        }
        
        
        System.out.println("ARCHIVO 1: "+File1);
        System.out.println("Indices "+indicesF1);
        System.out.println("ARCHIVO 2: "+File2);
        System.out.println("Indices 2: "+indicesF2);
        
        Guardado(File1,indicesF1,filef1);
        Guardado(File2,indicesF2,filef2);
        LectYOrd(fileE,filef1,filef2);
    }
    
    /**
     * <br>
     * Proceso:
     * <br>
     * * La función realizará la lectura de los datos pasado de los archivos.
     * <br>
     * Variables
     * <br>
     * separador: Segmentará la cadena por medio de comas ","
     * <br>
     * String [] valoresF1, valoresF2: Guardarán las cadenas de los bloque ya segmentados.
     * <br> 
     * String [] valoresF11,valoresF21: Guardado de valores de los bloques obtenidos ya segmentados 
     * @see #divisionInicial(java.lang.String) 
     * El método devolverá los datos en arreglos de Strings. esto gracias a la separación por bloques con "|".
     * <br>
     * Con los tamaños de los arreglos se obtendrán los bloques actuales a manejar, esto será de ayuda para el final de la función.
     * <br>
     * Se obtendrá el tamaño de la lista del archivo F2 para realizar el procedimiento siguiente. Como siempre serán cantidades iguales de bloques en ambos 
     * archivos (pares) o el archivo File1 tendrá 1 bloque de más (impares), se realizará un ciclo la cantidad de bloques que tenga el archivo 2 (Nunca tendrá más bloques que el archivo F1).
     * <br>
     * En el ciclo que obtendrán los datos segmentados por coma "," de cada lugar del archivo. El ciclo obtendrá los bloques a comparar de las archivos.
     * @see #Ordenar(java.lang.String[], java.lang.String[], java.util.ArrayList) 
     * Ya obtendiendo los arreglos de los digitos se mandarán al método de Ordenar que recibe 2 arreglos y la información de la lista que contendrá los datos parciales.
     * Ya terminando ese método se sumarán los tamaños de los arreglos de los dígitos para obtener los índices en donde se segmentarán, debido a la unión de los bloques de información.
     * <br>
     * @see #Ordenar(java.lang.String[], java.util.ArrayList) 
     * En el tal caso que la cantidad de bloques sea impar, se llamará la función de ordenar que recibe un arreglo y la lista.
     * <br>
     * Después se restará la mitad de bloques, debido a que se juntan 2 bloques y forman 1, si son pares quedará la mitad de bloques, si son imparese se restará el redondeo de la mitad.
     * <br>
     * En el tal caso que bloques sea mayor a 1 entonces se vloverá a llamar la función Equilibrada con los nuevos datos preordenados de la lista, si no es así la lista ya estará ordenada. 
     * @param direccionArch Dirección del archivo auxiliar
     * @param ListF1 Dirección del archivo de apoyo 1
     * @param ListF2 Dirección del archivo de apoyo 2
     * @throws FileNotFoundException En caso de no encontrar el archivo a manejar
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
     public static void LectYOrd(String direccionArch, String ListF1,String ListF2)throws FileNotFoundException, IOException{
        
        ArrayList<Integer> list = new ArrayList<>();
        
        final String separador2= "\\,";
        //Antibarra doble para caracteres 
        String [] valoresF1 = null;
        String [] valoresF2 = null;
        ArrayList<Integer> indices = new ArrayList<>();
        indices.add(0);
        int index=0;
        int bloques=0;
        String []valoresF11 = null;
        String []valoresF21 = null;
        String cadena;
        
        int i=0;
        int j=0;
        
        valoresF1=divisionInicial(ListF1);
        valoresF2=divisionInicial(ListF2);
        
        System.out.println("Estado Archivo 1: ");
        System.out.println(Arrays.toString(valoresF1)+"\n");
        System.out.println("Estado Archivo 2: ");
        System.out.println(Arrays.toString(valoresF2)+"\n");
        
        bloques=valoresF1.length+valoresF2.length;
        int size=0;
        if(valoresF1.length>=valoresF2.length){
            size=valoresF2.length;
            
        }    
        
        for( j=0; j<size;j++){
            valoresF11=valoresF1[j].split(separador2);
            valoresF21=valoresF2[j].split(separador2);
            list=Ordenar(valoresF11,valoresF21,list);
            index=index+valoresF11.length+valoresF21.length-1;
            indices.add(index);
        }
        
        if(bloques%2!=0){
            valoresF11=valoresF1[j].split(separador2);
            list=Ordenar(valoresF11,list);
            index=index+valoresF11.length-1;
            indices.add(index);
        }
            
                
        
        
        bloques=bloques-(int)Math.round(bloques/2);
        System.out.println(list);
        System.out.println(indices);
        Guardado(list,indices,fileE);
        
        if(bloques>1){
            Equilibrada(list);
        }else{
            System.out.println("Lista Ordenada: \n"+list);
        }
        
         
    }
     
    /** Método Ordenar es un método sobre cargado. En el cual seobtiene los arreglos de los bloques de los datos 
     * de los archivos File1 y File2 y la información de la lista que obtendrá todos los datos.
     * <br>
     * Varibles
     * <br>
     * pivote: Será un dato de comparación para el gurdado de los datos de los arreglos en la lista.
     * <br>
     * int indF1,indF2: Cantidad de datos pasados de las listas
     * <br>
     * Proceso:
     * <br>
     * En este método se creará un ciclo que terminará cuando los contadores de los datos pasados sean iguales al tamaño respectivo de los arreglos.
     * <br>
     * Se designará un pivote para comenzar las comparaciones, en este caso tomará los datos del arreglo del File1 en la posición del contador de esté.
     * <br>
     * Si el pivote es mayor o igual al dato del arreglo en la posición del contador respectivo, entonces ese dato se ingresará a la lista y aumentará el indice del arreglo2.
     * <br>
     * Si no es así el dato pivote sera ingresado y aumentará el contador del arreglo del File 1.
     * <br>
     * Despues de checar y guardar los datos, en el tal caso que el indice de File 1 sea igual al tamaño del arreglo vF1 se creará un ciclo que vaciará los datos restantes del
     * arreglo del File 2 y en el tal caso que el índice de File 2 sea igual al tamaño del arreglo F2 entonces vaciará los datos restantes del arreglo vF1.
     * <br>
     * Como los datos ya están previamente ordenados en el tal caso que todos los datos de un arreglo se ingresen se vaciarán los datos del otro arreglo.
     * <br>
     * El proceso es similiar, con excepción de las comparaciones entre datos de los arreglo y el pivote, para el ordenamiento ascencente (1) o descendente (2).
     * @param vF1 Arreglo del segmento de los datos obtendios del bloque de F1
     * @param vF2 Arreglo del segmento de los datos obtendios del bloque de F1
     * @param lista Se obtendrá el nuevo orden de la lista
     * @return ArrayList 
     */
    public static ArrayList <Integer> Ordenar( String [] vF1, String [] vF2, ArrayList <Integer> lista){
       
        int pivote;
        int indF1=0,indF2=0;
        
        if(Equilibrada.opcion==1){
            do{
                pivote=Integer.parseInt(vF1[indF1]);
                if(pivote>=Integer.parseInt(vF2[indF2])){
                    lista.add(Integer.parseInt(vF2[indF2]));
                    indF2++;
                }
                else{
                    lista.add(Integer.parseInt(vF1[indF1]));
                    indF1++;


                }
                if(indF1==vF1.length){
                    for(int k=indF2;k<vF2.length;k++){
                        lista.add(Integer.parseInt(vF2[k]));
                    }
                }else if(indF2==vF2.length){
                    for(int k=indF1;k<vF1.length;k++){
                        lista.add(Integer.parseInt(vF1[k]));
                    }
                }

            }while(indF2!=vF2.length && indF1!=vF1.length);

        }
        else{
            do{
                pivote=Integer.parseInt(vF1[indF1]);
                if(pivote<=Integer.parseInt(vF2[indF2])){
                    lista.add(Integer.parseInt(vF2[indF2]));
                    indF2++;
                }
                else{
                    lista.add(Integer.parseInt(vF1[indF1]));
                    indF1++;


                }
                if(indF1==vF1.length){
                    for(int k=indF2;k<vF2.length;k++){
                        lista.add(Integer.parseInt(vF2[k]));
                    }
                }else if(indF2==vF2.length){
                    for(int k=indF1;k<vF1.length;k++){
                        lista.add(Integer.parseInt(vF1[k]));
                    }
                }

            }while(indF2!=vF2.length && indF1!=vF1.length);
        
        
        
        }
        
        
        return lista;
    } 
    
    /**
     * Método sobre cargado el cual servirá para el vaciado de nada más un bloque del File 1 o 2.
     * <br>
     * Variables:
     * <br>
     * indF: valores pasados del arreglo a la lista
     * <br>
     * El proceso recorrerá el arreglo pasado y los datos de este se guardará directo a la lista de apoyo.
     * Este método se declaró debido en el tal caso de que existan bloques de la mezcla impares.
     * @param vF Arreglo del archivo
     * @param lista Obtendrá los datos de la lista
     * @return ArrayList
     */
    public static ArrayList <Integer> Ordenar( String [] vF, ArrayList <Integer> lista){
        
        int indF=0;
        for (int k=0;k<vF.length;k++)
            lista.add(Integer.parseInt(vF[k]));
        return lista;
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
     * @see #ponerdoblebarraE(java.lang.String) 
     * Proceso
     *  <br>
     *  Declaradas las variables, a n se le asigna el arreglo generado por aplicar el metodo split con el separador \\
     *  <br>
     *  Mediante un for se va transcribiendo a la cadena DireccionDoble, cada elemento del arreglo n, concatenando la doble barra
     *  <br>
     *  En la ultima iteracion se agrega la carpetas donde se esta ejecuntando el archivo debido a que la direccion generada no lo contiene.
     *  <br>
     *  Retorna direccionDoble
     * 
     * @param direc direccion del archivo con una barra
     * @return String 
     */

    
    public static String ponerdoblebarraE(String direc)
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
            direccionDoble=direccionDoble+"src\\\\murrieta_reza_valdespino_equipo2_g5_proyecto1\\\\FilesEquilibrada\\\\"+n[i];
            }
        }
      
       
      
        return direccionDoble;
    }
    
}     
