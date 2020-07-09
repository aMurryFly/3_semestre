
package murrieta_reza_valdespino_equipo2_g5_proyecto1;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * @author Murrieta_Alfonso
 * @author Reza_Sergio
 * @author Valdespino_Joaquín
 */

public class Murrieta_Reza_Valdespino_Equipo2_G5_Proyecto1 {

   
    public static void main(String[] args) throws IOException {
        
        /**
        *Función principal del programa en donde se crea el menú para la elección del método externo de ordenamiento 
        *1)Polifase
        *2)Mezcla Equilibrada
        *3)Distribución o Radix Sort
        *Se creará un archivo,el cual tiene los datos del archivo a ordenar
        */
        int op1=0;
        int op2=0;
        
        String archivo=null;
        

        Scanner sc= new Scanner(System.in);
        System.out.println("PROYECTO 1 ORDENAMIENTO EXTERNO");
        System.out.println("Ingrese el nombre del archivo a ordenar");
        archivo=sc.nextLine();
        archivo=archivo+".txt";
        
        do{

            
            System.out.println("Nombre del archivo a ordenar: "+archivo);
            
            File pruebaFile= new File(archivo);
            String prueba=ponerdoblebarra(pruebaFile.getAbsolutePath());
            System.out.println("\nElija un tipo de ordenamiento externo.");
            System.out.println("1)Polifase\n2)Mezcla Equilibrada\n3)RadixSort\n4)Salir");
            System.out.println("\tOpción:");
            op1=sc.nextInt();
            switch (op1) {
                case 1:
                    System.out.println("Polifase");
                    
                        System.out.println("\nForma:\n\t1)Ascendente\n\t2)Descendente");
                        op2=sc.nextInt();
                        switch (op2) {
                            case 1:
                                Polifase.polifase(prueba,1);
                                break;
                            case 2:
                                Polifase.polifase(prueba,2);
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    
                    break;
                
                case 2:
                    System.out.println("Mezcla Equilibrada");
                    
                        System.out.println("\nForma:\n\t1)Ascendente\n\t2)Descendente");
                        op2=sc.nextInt();
                        switch (op2) {
                            case 1:
                                Equilibrada.MezclaEquilibrada(prueba,1);
                                break;
                            case 2:
                                Equilibrada.MezclaEquilibrada(prueba,2);
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    
                    break;
                    
                case 3:
                    System.out.println("Radix Sort");
                    
                        System.out.println("\nForma:\n\t1)Ascendente\n\t2)Descendente");
                        op2=sc.nextInt();
                        switch (op2) {
                            case 1:
                                RadixSort.radix(prueba,1);
                                break;
                            case 2:
                                RadixSort.radix(prueba,2);
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa.");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            
        }while(op1!=4);
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
                direccionDoble=direccionDoble+"src\\\\murrieta_reza_valdespino_equipo2_g5_proyecto1\\\\"+n[i];
            }
        }
      
        
      
        return direccionDoble;
    }

    
}
