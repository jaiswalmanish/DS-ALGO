package com.az.test;

import java.util.*;

public class SubStringCount {
//	private static List<String> res2 = new ArrayList<>();
	
	private List<Integer> getDetail(String str){
		List<Integer> res = new ArrayList<>();		
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c: str.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int n = 0;
//		String s = "";
		HashSet<Character> set = new HashSet<>();
		for(char c: str.toCharArray()){
			n++;
//			s += c;
			set.add(c);
			if(map.get(c)==1){
				set.remove(c);
				if(set.isEmpty()){
					res.add(n);
//					res2.add(s);
					n=0;
//					s = "";
				}
			}
			map.put(c, map.get(c)-1);
		}		
		
		return res;
	}

	public static void main(String[] args) {
		SubStringCount s = new SubStringCount();
		for(int n : s.getDetail("zab12#*   ? /xZstsR")){
			System.out.print(n + " ");
		}
		
//		for(String sm : res2){
//			System.out.print(sm + " ");
//		}

	}

}
