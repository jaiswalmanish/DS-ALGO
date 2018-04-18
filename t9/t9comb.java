package com.az.t9;

import java.util.*;

public class t9comb {

	public static LinkedList<String> getList(String digits){
		LinkedList<String> arr = new LinkedList();		
		if(digits.length() == 0){
			return arr;
		}
		//map
		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		arr.add("");
		while(digits.length()!=0){
			int ch = Character.getNumericValue(digits.charAt(0));//digits.charAt(0) - '0'
			String str = map[ch];
			int size = arr.size();			
			while(size != 0){
				String t =  arr.remove();				
				for(char c : str.toCharArray()){
					arr.add(t+c);
				}	
				size--;
			}
			digits = digits.substring(1);
		}

		return arr;
	}
//time complexity = 4^N
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            for(String i: getList("5670")){
            	System.out.println(i);
            }
	}

}
