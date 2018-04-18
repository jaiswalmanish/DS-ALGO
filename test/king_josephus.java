package com.az.test;

import java.util.*;

public class king_josephus {
	
	private static List<Integer> check(int N){
		List<Integer> res = new ArrayList();
		int turn = 1;
		int first = 1;
		int last = N;
		while(N > 3){
			if(N % 2 != 0){
				first += turn * 2;
			}
		    else{
		    	last -= turn;
		    }
				    
			turn *= 2;
		    N /= 2;
		}
    res.add(first);
    res.add(last);
	return res;
	}

	public static void main(String[] args) {
         System.out.println(check(14));
	}

}
