package arreglo;


public class Arreglo {

    public static void main(String[] args) {
        try{    
            int n = Integer.parseInt("2");
            int arr[]= new int[n];

            for(int i= 0; i < n; i++){
                arr[i]=i+1;
            }
            for(int i= 0; i < n; i++){
                System.out.println("arr["+i+"]: "+arr[i]);
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException ex){
            System.out.println("Se generó una excepción debido a que el indice o el valor del tamaño del arreglo no puede ser cero, la excepción es:  ");
            ex.printStackTrace();
        }
    
    }
    
}
