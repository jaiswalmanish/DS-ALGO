package com.az.string;

import java.util.HashMap;

public class HORSPOOL {
	
/*
 * Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.	
 */
	/*
Primitive type 	Wrapper class
boolean 	Boolean
byte 	Byte
char 	Character
float 	Float
int 	Integer
long 	Long
short 	Short
double 	Double
	 */
	
	public boolean search(String small, String big) {
		//stage 1
		int slen = small.length();
		HashMap<Character, Integer> table = new HashMap();//unique keys-
		table.put('*', slen);
		for(int i=0; i<slen;i++){
			table.put(small.charAt(i), slen-i-1);
		}	
		for(char c: table.keySet()){
			System.out.println("talble: " + c + "=>" + table.get(c));
		}
		//stage 2
		int blen = big.length();
		int i=slen -1;
		while(i<blen){	
			System.out.println("I val: " + i);
			for(int j=slen-1;j>=0; j--){
				//System.out.println("J val: " + j);
				char bc = big.charAt(i);
				System.out.println("char:"+ bc +" j=>" + small.charAt(j));
				if(bc==small.charAt(j)){
					if(j==0){
						System.out.println("Final match pos:" +i);
						return true;
					}
						
					i--;
					System.out.println("I-1 val: " + i);
				}
				else if(table.get(bc)!=null){
					i += table.get(bc);
					System.out.println("I-2 val: " + i);
					break;
				}
				else{
					i += slen;
					System.out.println("I-3 val: " + i);
					break;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		String big = "manish says truts";
		String small = "truth";
		HORSPOOL h = new HORSPOOL();
		System.out.println(h.search(small,big));
	}

}
