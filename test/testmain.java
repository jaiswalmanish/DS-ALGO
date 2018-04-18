package com.az.test;

import java.util.*;
import com.az.test.*;

public class testmain {
//	public static ArrayList<ArrayList<String>> test(){
//		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
//		arr.add(new ArrayList<String>(Arrays.asList("Test", "Best1")));
//		return arr;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<ArrayList<String>>  str = test();
//        System.out.print(str);
     	 String[][] lunchMenuPairs = { { "pizza", "Italian"} , { "Masala", "Indian"}, {"stick", "Italian"} };
	 String[][] teamCuisinePreference = { {"John", "*"} , { "Ramu", "Italian"}, {"Man", "Punjabi"} };
	 listcheck check = new listcheck();
	 
	 String[][] str = check.matchLunches(lunchMenuPairs, teamCuisinePreference);
	 for(int i=0; i<str.length; i++){
		 System.out.println(str[i][0] + " " + str[i][1]);
	 }
	 
//   ArrayList<ArrayList<String>> str = check.matchLunches(lunchMenuPairs, teamCuisinePreference);
//	 for(ArrayList arr : str){
//		 System.out.println(Arrays.toString(arr.toArray()));
//	 }
	 
	 //anagram
	 anagram an = new anagram();
	 List<Integer> test = an.getAnagramIndices("pabcdAAdbc", "bAcd");
	 System.out.println(test.toString());
}	
}
