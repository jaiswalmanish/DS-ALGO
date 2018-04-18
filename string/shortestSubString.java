package com.az.string;

import java.util.HashMap;

public class shortestSubString {
	
	public static String getShortestSubString(char[] arr, String str){
		String res = "";
		int startWindow = 0;
		int endWindow = 0;
		int len = str.length();
		int tempLen = 0;
		HashMap<Character, Integer> countHash = new HashMap();
		
		//create intial hashmap
		for(int i=0; i<arr.length; i++){
			countHash.put(arr[i], 0);
		}
		//xyyzyzyx
		while(endWindow < len){ 
			char cur = str.charAt(endWindow);
			//System.out.println(cur);
			if(!countHash.containsKey(cur)){
				endWindow++;
				continue;
			}
			
			if(countHash.get(cur) == 0){
				tempLen++;
				//System.out.println(cur+" "+tempLen);
			}			
			countHash.put(cur, countHash.get(cur)+1);
			while(tempLen == arr.length){
				if(res.equals("") || endWindow + 1 - startWindow < res.length()){
				    res=str.substring(startWindow, endWindow+1);
				    //System.out.println(res);
				}			
				
				char cur2 = str.charAt(startWindow);	
				if(countHash.containsKey(cur2)){
					countHash.put(cur2, countHash.get(cur2)-1);
					if(countHash.get(cur2) == 0){
						tempLen--;
					}
				}
				startWindow++;				
			}
			
		   	endWindow++;
		}		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String str = "xyabdryzyzabycdx";
          char[] chArr = {'x', 'y', 'z'}; 	
          
          String test =  getShortestSubString(chArr, str);
          System.out.println(test);
          
	}

}

/*
xyyzyzyx
 


*/