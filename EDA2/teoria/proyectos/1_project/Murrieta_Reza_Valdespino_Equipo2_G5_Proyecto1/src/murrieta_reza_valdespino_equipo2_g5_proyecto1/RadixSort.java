package murrieta_reza_valdespino_equipo2_g5_proyecto1;

//BIBLIOTECAS
import static java.lang.Math.round;
import java.io.*; //Para el File 
import java.util.*; // Para los ArrayList

public class RadixSort {
    
    /**@see #RadixSort() 
     * Se crearán los atributos de la función Radix Sort, los cuales consisten en los archivos de apoyo, como lo son los archivos que funcionarán como 
     * colas y el archvo que obtendrá los resultados parciales. También sus direcciones serán declaradas en String para su uso en general en el código.
     * <br>
     * Variables
     * <br>
     * Files cola: Colas de apoyo para el vaciado de los datos del archivo
     * <br>
     * direcciónC: String que tiene la dirección del archivo con la función ponerdoblebarraR();
     */
        static File cola0= new File("Cola0.txt");
        static File cola1= new File("Cola1.txt");
        static File cola2= new File("Cola2.txt");
        static File cola3= new File("Cola3.txt");
        static File cola4= new File("Cola4.txt");
        static File cola5= new File("Cola5.txt");
        static File cola6= new File("Cola6.txt");
        static File cola7= new File("Cola7.txt");
        static File cola8= new File("Cola8.txt");
        static File cola9= new File("Cola9.txt");
        static File auxiliar= new File("Auxiliar.txt");
        
        static String direccionC0 = ponerdoblebarraR(cola0.getAbsolutePath());
        static String direccionC1 = ponerdoblebarraR(cola1.getAbsolutePath());
        static String direccionC2 = ponerdoblebarraR(cola2.getAbsolutePath());
        static String direccionC3 = ponerdoblebarraR(cola3.getAbsolutePath());
        static String direccionC4 = ponerdoblebarraR(cola4.getAbsolutePath());
        static String direccionC5 = ponerdoblebarraR(cola5.getAbsolutePath());
        static String direccionC6 = ponerdoblebarraR(cola6.getAbsolutePath());
        static String direccionC7 = ponerdoblebarraR(cola7.getAbsolutePath());
        static String direccionC8 = ponerdoblebarraR(cola8.getAbsolutePath());
        static String direccionC9 = ponerdoblebarraR(cola9.getAbsolutePath());
        static String direccionAux = ponerdoblebarraR(auxiliar.getAbsolutePath());
        static int op;         
    //MÉTODO DE LLAMADO GENERAL  
        /**La función o método radix obtendrá la dirección del archivo que se querrá ordenar y el dato que determinará el ordenamiento
         * <br>
         * Variables
         * <br>
         * lista: ArrayList que obtendrá los datos de la lista a checar.
         * <br>
         * valores: Cadena de strings que serán los valores de la linea final
         * <br>
         * cantidad: Obtendrá el número de dígitos del número mayor de la lista.
         * <br>
         * Proceso:
         * <br>
         * Las varibles que se crearón son un ArrayList que obtendrá los datos del archvo y sus modificaciones parciales.
         * <br>
         * Una cadena de String que obtnderá y separará los datos de la última linea del archivo, con esto se modificarán los datos 
         * de Strings a Integer con la función Data_Convertion. Se obtendrá el dato con la mayor cantidad de dígitos con la fucnión getMax que obtendrá la 
         * información de la lista. 
         * <br> 
         * Existirá una varible que servirá para las comapraciones de las unidades a los digitos más importantes.
         * <br>
         * @see #VaciarArch(java.lang.String) 
         * Para guardado de los datos se vaciará el contendio de todos los archivos con el llamado de la función VaciarArch y sus respectias direcciones.
         * Se realizará un ciclo que terminará cuando el índice sea mayor a la cantidad de dígitos máxima. En el ciclo, la lista obtendrá la lista 
         * generada que proporcionará la función radixSort(). 
         * @see #radixSort(java.util.ArrayList, int, int)  
         * El método obtendrá la información de la lista en ese momento, el tamaño máximo de dígitos y el exponente. 
         * <br>
         * Cuando termine el proceso del método anterior el exponenete se incrementará. Cuando el ciclo termina significa que la lista ya estará ordenada.
         * @param fileAdress Dirección del archivo a ordenar
         * @param opcion Variable para saber que tipo de orden tendrá el acomodo de datos
         * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
         */
        
    public static void radix(String fileAdress, int opcion) throws IOException{
        
        ArrayList<Integer> lista = new ArrayList<Integer>();
        String[] valores = read_file(fileAdress);
        lista = Data_Convertion(valores);
        op=opcion;
        int cantidad =cantDigitos(getMax(lista));//digitos del mayor elemento
        int exp =1;
        System.out.println("LOS DATOS SON: "+lista); 
        
        VaciarArch(direccionC0);
        VaciarArch(direccionC1);
        VaciarArch(direccionC2);
        VaciarArch(direccionC3);
        VaciarArch(direccionC4);
        VaciarArch(direccionC5);
        VaciarArch(direccionC6);
        VaciarArch(direccionC7);
        VaciarArch(direccionC8);
        VaciarArch(direccionC9);
        VaciarArch(direccionAux);
        
        //CICLO PARA CADA ITERACIÓN DEL RADIX
        for(int i=0; i<cantidad;i++){
            lista= radixSort(lista,cantidad,exp);
            exp*=10;
        }
        
        System.out.println("LOS DATOS ORDENADOS: "+lista); 

    }

    //MÉTODO ENCARGADO DE LA LECTURA DE ARCHIVOS
    /**La función read_file obtiene la dirección del archiivo a ordenar.
     * <br>
     * Variables:
     * <br>
     * sparador: El separador ayudará para segmentar los datos de la última linea del archivo
     * <br>
     * String [] valores: Aquí se almacenerán los datos ya segmentados
     * <br>
     * FileReader y BufferReader : Lectura de los datos.
     * <br>
     * Proceso:
     * <br>
     * Se obtendrá la última cadena con ayuda del ciclo, mientras que la linea de la lectura de archivo sea diferente de nula se obtendrá 
     * las cadenas hasta llegar a la última del archivo.
     * Los datos obtendios se guardarán en al arreglo de String, esto siendo separados por "," y el arreglo generado se devolverá caundo lo invoquen.
     * @param direccionArch Dirección del archivo a leer
     * @return String[]
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static String[] read_file(String direccionArch) throws  IOException{
        
        final String separador = ","; 
        String [] valores = null;
        String cadena;
        String ultimaCadena=null;
        FileReader f = new FileReader(direccionArch);
        BufferedReader b = new BufferedReader(f);
        
        //Para leer la última linea
        while((cadena = b.readLine())!=null) { 
            ultimaCadena=cadena;  
        }
          
        valores=ultimaCadena.split(separador); 
        
    return valores;
    }
    
    //MÉTODO ENCARGADO DE LA LECTURA DE LAS COLAS 
    /**La función read_file_Cola obtiene la dirección del archivo a ordenar.
     * <br>
     * Variables:
     * <br>
     * sparador: El separador ayudará para segmentar los datos de la última linea del archivo
     * <br>
     * String [] valores: Aquí se almacenerán los datos ya segmentados
     * <br>
     * FileReader y BufferReader : Lectura de los datos.
     * <br>
     * Proceso:
     * <br>
     * Se obtendrá la última cadena con ayuda del ciclo, mientras que la linea de la lectura de archivo sea diferente de nula se obtendrá 
     * las cadenas hasta llegar a la última del archivo.
     * En esta versión de readFile nada más se quiere obtener el string de la última linea para poder ponerla directo en el archivo Auxiliar.
     * @param direccionArch Dirección de la cola
     * @return String
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion).  
     */
    public static String read_file_Cola(String direccionArch) throws  IOException{        

        String cadena=null;
        String ultimaCadena=null;
        FileReader f = new FileReader(direccionArch);
        BufferedReader b = new BufferedReader(f);
        
        //Para leer la última linea
        while((cadena = b.readLine())!=null) { 
            ultimaCadena=cadena;  
        }
 
        return ultimaCadena;
    }   
    
    //CONVERSIÓN DE LOS DATOS 
    /**La funcición Data_Convertion obtenere el arreglo de String de los datos obenidos de la separación por coma.
     * <br>
     * Variables:
     * <br>
     * lista: ArrayList que obtendrá los datos convertiods del arreglo.
     * <br>
     * Proceso:
     * <br>
     * Los arreglos en String, con ayuda del método parseInt se agregarán a una lista de enteros. 
     * Esta lista generada se mandará al terminar el proceso.
     * @param datos Cadena de String que se convertirán en enteros y serán agregados a una lista de enteros
     * @return ArrayList
     */
    public static ArrayList<Integer> Data_Convertion(String[] datos){

        ArrayList<Integer> lista = new ArrayList();
        
        for(String i:datos){
            lista.add(Integer.parseInt(i));
        }
        
    return lista;
    }

    //MÉTODOS CONDICIONALES y AUXILIARES
    /**La función getMax obtiene el dato de mayor tamaño en toda la lista
     * <br>
     * Variable:
     * <br>
     * max: Entero que obtendrá el dato de mayor tamaño, comparandose con los otros.
     * <br>
     * Proceso:
     * Para esto se realizará el proceso de SelectionSort. Primero se eligirá un dato como incio del máximo
     * <br>
     * En el ciclo que terminará cuando el índice sea mayor al tamaño de la lista, si el dato de la lista es mayor al dato maximo, 
     * entonces el auxiliar ahora será el máximo.
     * @param elementos Lista a evaluar para obtener el dato mayor
     * @return max
     */
    public static int getMax(ArrayList <Integer> elementos){
        /**
         * 

         * 
         */
        int max = elementos.get(0);

        for(int i = 0;i<elementos.size();i++){
            int aux = elementos.get(i);
            if(aux > max ){
                max = aux;
            }
        }
        
    return max;
    }
    /**En este método se obtiene la cantidad de digitos del dato mayor de la lista.
     * <br>
     * Variables:
     * <br>
     * cant: contador de cantidad de digitos
     * <br>
     * Proceso:
     * <br>
     * En el ciclo propuesto se dividirá el dato máximo entre 10 y el contador de digitos se incrementará
     * Si el maximo es igual a 0, el ciclo se termina. La condición del ciclo para que termine es si la división del máximo sobre 10 es menor a 0.
     * Al terminar con el ciclo, la contador de la cantidad de dígitos será enviada.
     * @param max Valor de mayor tamaño a evaluar
     * @return cant de dígitos
     */
    public static int cantDigitos(int max){

        int div = 10;
        int cant = 0;

        while((max/10)>=0){
            max = max / div;
            cant++;
                
            if (max == 0){
                break;
            }
        }
   
    return cant;
    }
    
    //BORRAR DESPUÉS
     /**
     * Método de limpieza de los archivos auxiliares después de haberlos usado en procesos anteriores.
     * @param direccionArch Obtiene la direccion de los archivos auxiliares.
     * @throws FileNotFoundException En caso de no encontrar el archivo a manejar
     * @throws IOException En caso de no poder realizar una operacion de escritura, lectura o encontrar el archivo (direccion). 
     */
    public static void VaciarArch(String direccionArch)throws FileNotFoundException, IOException{
        /**
        * El método obtendrá la dirección de un archivo, se creará un un escritor y un buffer de archivos
        * con esto se llamará al método write() que eliminará los datos con la escritura de ""
        * 
        **/
        BufferedWriter bf = new BufferedWriter(new FileWriter(direccionArch)) ;
        bf.write("");
        bf.close();
    
    }    

    //PARA LAS DIRECCIONES-FIXED
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
     * @see #ponerdoblebarraR(java.lang.String) 
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
    public static String ponerdoblebarraR(String direc){

        String separador ="\\\\";
        String[] n = direc.split(separador);
        String direccionDoble ="";            
      
        for(int i=0;i<n.length;i++){
            if(i<n.length-1){
                direccionDoble=direccionDoble+n[i]+"\\\\";   
            }
            else{
                direccionDoble=direccionDoble+"src\\\\murrieta_reza_valdespino_equipo2_g5_proyecto1\\\\FilesRadix\\\\"+n[i];
            }
        }
 
    return direccionDoble;
    }
    //MÉTODO DE GUARDADO
    /**El método ingresoDatosAuxiliar obtiene la cadena de los datos.
     * <br>
     * Variable
     * <br>
     * FileWriter: Escrito de archivo para que escriba la cadena pasada en el archvio con la direcciónAux
     * Proceso:
     * <br>
     *  Se creará un FileWriter que tendrá la dirección del archivoAuxiliar
     * Existirá una condición, si los datos de la cola no tenian datos no se realizará la escritura de la cadena.
     * @param direccionAux dirección del archivo auxiliar
     * @param cadena ´ltima linea del archivo o cola
     * @throws IOException En caso de no encontrar el archivo a manejar
     */
    public static void ingresoDatosAuxiliar(String direccionAux, String cadena ) throws IOException{
        /**
         * 
         */
        FileWriter Auxiliar= new FileWriter(direccionAux,true);
        if(cadena!=null){
            Auxiliar.write(cadena);
        
        }
        Auxiliar.close();
    
    }
    //MÉTODO DE ORDENAMIENTO
    /**La función utilizará FileWriters que escribirán en los archivos de las colas y respetarán los datos anteriores.
     * <br>
     * Variables
     * <br>
     * FileWriter ColaW: Escritor de archivo para cada cola
     * <br>
     * String cadena: última cadena de la cola obtenido por 
     * <br>
     * Se determinará el tamaño de la lista, esto es para poder recorrer toda la lista con el ciclo siguiente.
     * Se tendrá un switch que su parametro será determinado por el rednodeo del dato de la lista en la posición i sobre el exponente pasado
     * Y a ese dato se sacará el módulo. Dependiendo del dato sacado, el dato de la lista se escribirá en la cola correspondiente.
     * @see #read_file_Cola(java.lang.String) 
     * Al terminar con los datos, se obtendrá las lineas finales de los archivos. 
     * <br>
     * @see #ingresoDatosAuxiliar(java.lang.String, java.lang.String) 
     * Las lineas se escribirán en el archivo auxiliar pasando la cadena y la dierección de este 
     * <br>
     * El guardado de datos dependerá del dato de op, el cual será el orden ascendente o descendente.
     * Después del guardado de las lineas de las colas al archivo auxiliar, se limpiará la lista y se dará lectura y conversión de datos a la última linea del archivo auxiliar. 
     * <br>
     * Con esto, el nuevo orden de la lista se mandará como variable de return.
     * @param lista Lista de datos a ordenar
     * @param n cantidad de dígitos máxima
     * @param exp Exponente para dividir el valor de la lista
     * @return Lista modificada
     * @throws IOException En caso de no encontrar el archivo a manejar
     */
    public static ArrayList<Integer> radixSort(ArrayList<Integer> lista, int n, int exp)throws IOException{
        FileWriter ColaW0= new FileWriter(direccionC0,true);
        FileWriter ColaW1= new FileWriter(direccionC1,true);
        FileWriter ColaW2= new FileWriter(direccionC2,true);
        FileWriter ColaW3= new FileWriter(direccionC3,true);
        FileWriter ColaW4= new FileWriter(direccionC4,true);
        FileWriter ColaW5= new FileWriter(direccionC5,true);
        FileWriter ColaW6= new FileWriter(direccionC6,true);
        FileWriter ColaW7= new FileWriter(direccionC7,true);
        FileWriter ColaW8= new FileWriter(direccionC8,true);
        FileWriter ColaW9= new FileWriter(direccionC9,true);
        FileWriter auxiliarW= new FileWriter(direccionAux,true);
            
        int n2 = lista.size();
            
        
            
        for(int i=0; i<n2;i++){ 

                switch((round(lista.get(i)/exp))%10){
                    case 0: 
                        ColaW0.write(lista.get(i)+","); 
                        break;

                    case 1:
                        ColaW1.write(lista.get(i)+",");
                        break;

                    case 2:
                        ColaW2.write(lista.get(i)+",");
                        break;

                    case 3:
                        ColaW3.write(lista.get(i)+",");
                        break;
                        
                    case 4:
                        ColaW4.write(lista.get(i)+",");
                        break;
                        
                    case 5:
                        ColaW5.write(lista.get(i)+",");
                        break;
                        
                    case 6:
                        ColaW6.write(lista.get(i)+",");
                        break;
                    
                    case 7:
                        ColaW7.write(lista.get(i)+",");
                        break;  
                        
                    case 8:
                        ColaW8.write(lista.get(i)+",");
                        break;
                        
                    case 9:
                        ColaW9.write(lista.get(i)+",");
                        break;    

                }
            } 

            ColaW0.write("\n");
            ColaW1.write("\n");
            ColaW2.write("\n");
            ColaW3.write("\n");
            ColaW4.write("\n");
            ColaW5.write("\n");
            ColaW6.write("\n");
            ColaW7.write("\n");
            ColaW8.write("\n");
            ColaW9.write("\n");
            auxiliarW.write("\n");
                 
            //CLOSE FILES     
            ColaW0.close();
            ColaW1.close();
            ColaW2.close();
            ColaW3.close();
            ColaW4.close();
            ColaW5.close();
            ColaW6.close();
            ColaW7.close();
            ColaW8.close();
            ColaW9.close();    
            
            //RECUPERACIÓN DE INFORMACIÓN
               
            String cadena0 = read_file_Cola(direccionC0);
            String cadena1 = read_file_Cola(direccionC1);
            String cadena2 = read_file_Cola(direccionC2);
            String cadena3 = read_file_Cola(direccionC3);
            String cadena4 = read_file_Cola(direccionC4);
            String cadena5 = read_file_Cola(direccionC5);
            String cadena6 = read_file_Cola(direccionC6);
            String cadena7 = read_file_Cola(direccionC7);
            String cadena8 = read_file_Cola(direccionC8);
            String cadena9 = read_file_Cola(direccionC9);
            

            //ESCRITURA EN EL AUXILIAR
            if(op==1){
                ingresoDatosAuxiliar(direccionAux,cadena0);
                ingresoDatosAuxiliar(direccionAux,cadena1);
                ingresoDatosAuxiliar(direccionAux,cadena2);
                ingresoDatosAuxiliar(direccionAux,cadena3);
                ingresoDatosAuxiliar(direccionAux,cadena4);
                ingresoDatosAuxiliar(direccionAux,cadena5);
                ingresoDatosAuxiliar(direccionAux,cadena6);
                ingresoDatosAuxiliar(direccionAux,cadena7);
                ingresoDatosAuxiliar(direccionAux,cadena8);
                ingresoDatosAuxiliar(direccionAux,cadena9);
                
                System.out.println("Cola 0: "+cadena0);
                System.out.println("Cola 1: "+cadena1);
                System.out.println("Cola 2: "+cadena2);
                System.out.println("Cola 3: "+cadena3);
                System.out.println("Cola 4: "+cadena4);
                System.out.println("Cola 5: "+cadena5);
                System.out.println("Cola 6: "+cadena6);
                System.out.println("Cola 7: "+cadena7);
                System.out.println("Cola 8: "+cadena8);
                System.out.println("Cola 9: "+cadena9);
                
            
            }else{
                ingresoDatosAuxiliar(direccionAux,cadena9);
                ingresoDatosAuxiliar(direccionAux,cadena8);
                ingresoDatosAuxiliar(direccionAux,cadena7);
                ingresoDatosAuxiliar(direccionAux,cadena6);
                ingresoDatosAuxiliar(direccionAux,cadena5);
                ingresoDatosAuxiliar(direccionAux,cadena4);
                ingresoDatosAuxiliar(direccionAux,cadena3);
                ingresoDatosAuxiliar(direccionAux,cadena2);
                ingresoDatosAuxiliar(direccionAux,cadena1);
                ingresoDatosAuxiliar(direccionAux,cadena0);
            
                System.out.println("Cola 9: "+cadena9);
                System.out.println("Cola 8: "+cadena8);
                System.out.println("Cola 7: "+cadena7);
                System.out.println("Cola 6: "+cadena6);
                System.out.println("Cola 5: "+cadena5);
                System.out.println("Cola 4: "+cadena4);
                System.out.println("Cola 3: "+cadena3);
                System.out.println("Cola 2: "+cadena2);
                System.out.println("Cola 1: "+cadena1);
                System.out.println("Cola 0: "+cadena0);
            }
            auxiliarW.close();
            //Cerramo auxiliar 
            
        
            //NUEVA LISTA
            lista.clear();
            String[] listaNew = read_file(direccionAux);
            auxiliarW.close();
            //System.out.println(listaNew);
            lista = Data_Convertion(listaNew);
            System.out.println("Iteración: \n"+lista);
        return lista;    
    }

    
}
