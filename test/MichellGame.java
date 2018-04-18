package com.az.test;

import java.util.*;

public class MichellGame {
	
	private List<String> subString(String str, int K){
		List<String> res = new ArrayList<>();
		int n = 0;
		String s = "";
		for(int i=0; i<str.length(); i++){
			n++;
			s += str.charAt(i);
			if(n<K)
				continue;			
			if(checkSubString(s, K)){
				res.add(s);					
			}	
			  s = s.substring(1);
		}		
		return res;
	}
	
	private boolean checkSubString(String str, int K){
		HashSet<Character> set = new HashSet<>();
		for(char c: str.toCharArray()){
			set.add(c);
		}
		if(set.size()==K){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MichellGame m = new MichellGame();
		for(String s : m.subString("awaglk", 4)){
			System.out.print(s + " ");
		}

	}

}
