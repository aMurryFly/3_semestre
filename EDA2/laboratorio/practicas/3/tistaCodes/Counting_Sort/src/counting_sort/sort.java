//MURRIETA VILLEGAS ALFONSO
//MURRYFLY

package counting_sort;
import java.util.*;

public class sort {

    public static void countingSort(String Lista[], int n, int limite){
       
        String Lista_final[] = new String[limite];
	int auxiliar[]= new int[n]; 
        
        for (int i=0; i<limite ; i++) {
            System.out.print("ENTRA: "+Lista[i]+"\t");

            if(Lista[i].equals("A")){
                auxiliar[0]+=1;
                System.out.println("A tiene: : "+auxiliar[0]);
            }else if(Lista[i].equals("B")){
                auxiliar[1]+=1;
                System.out.println("B tiene: : "+auxiliar[1]);
            }else if(Lista[i].equals("C")){
                auxiliar[2]+=1;
                System.out.println("C tiene: : "+auxiliar[2]);
            }else if(Lista[i].equals("D")){
                auxiliar[3]+=1;
                System.out.println("D tiene: : "+auxiliar[3]);
            }else if(Lista[i].equals("E")){
                auxiliar[4]+=1;
                System.out.println("E tiene: : "+auxiliar[4]);
            }else if(Lista[i].equals("F")){
                auxiliar[5]+=1;
                System.out.println("F tiene: : "+auxiliar[5]);
            }else if(Lista[i].equals("G")){
                auxiliar[6]+=1;
                System.out.println("G tiene: : "+auxiliar[6]);
            }else if(Lista[i].equals("H")){
                auxiliar[7]+=1;
                System.out.println("H tiene: : "+auxiliar[7]);
            }
			
        }
        
        //INDICES PARA LAS LETRAS
	int index_a=auxiliar[0]-1;
	int index_b=index_a+auxiliar[1];
	int index_c=index_b+auxiliar[2];
	int index_d=index_c+auxiliar[3];
	int index_e=index_d+auxiliar[4];
        int index_f=index_e+auxiliar[5];
        int index_g=index_f+auxiliar[6];
        int index_h=index_g+auxiliar[7];

        for (int i=0; i<limite ; i++) {
            System.out.print("ENTRA: "+Lista[i]+"\t"); //de igual  manera se puede usar un else-if
            
            switch (Lista[i]) {
                case "A":
                    Lista_final[index_a]= Lista[i];
                    index_a--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "B":
                    Lista_final[index_b]= Lista[i];
                    index_b--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "C":
                    Lista_final[index_c]= Lista[i];
                    index_c--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "D":
                    Lista_final[index_d]= Lista[i];
                    index_d--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "E":
                    Lista_final[index_e]= Lista[i];
                    index_e--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "F":
                    Lista_final[index_f]= Lista[i];
                    index_f--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "G":
                    Lista_final[index_g]= Lista[i];
                    index_g--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                case "H":
                    Lista_final[index_h]= Lista[i];
                    index_h--;
                    System.out.println(Arrays.toString(Lista_final));
                    break;
                default:
                    break;
            }
			
	}
 
	System.out.println("La lista ordenada es: ");
	System.out.println(Arrays.toString(Lista_final));
    
    }
}
 
	
    

