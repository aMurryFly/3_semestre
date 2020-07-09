//MURRIETA VILLEGAS ALFONSO 

import java.util.*;//Sirve para el arraylist

public class P_02{
	public static void main(String[] args){

	//int r = (int)Math.roud(Math.random()*10);
	//System.out.println(r);

	ArrayList<Integer> lista = new ArrayList <Integer>();
	int i=0;
	for(i=0;i<3; i++){
		lista.add( i );
	}
	
	for(Integer elemento: lista){
		System.out.println(lista);
	}


	Collections.sort(lista);

		for(Integer elemento: lista){
		System.out.println(lista);
	}

	HashSet <String> hash = new HashSet <String>(Arrays.asList("i","u","o","a","e"));
	for(String elemento: hash)
		System.out.println(hash+" ");


	hash.add("e");


	List <String> sortedSet = new ArrayList<String>(hash);
	Collections.sort(sortedSet);
	System.out.println("___________________________________");
	System.out.println(sortedSet);
	System.out.println(hash);



	}
}