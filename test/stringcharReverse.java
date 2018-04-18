package com.az.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class stringcharReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		 System.out.print(revArr(arr));

	}

	private static ArrayList<Character> revArr(char[] arr) {
		ArrayList<Character> out = new ArrayList();
		revArr(arr, 0, out);
		return out;
	}

	private static void revArr(char[] arr, int i, ArrayList<Character> out) {
		if(i==arr.length){
			return;
		}
		Queue<Character>q = new LinkedList();
		for(int k=i; k<arr.length; k++){
			  if(arr[k] == ' '){
				  revArr(arr, k+1, out);
				  out.add(' ');
				  break;
			  }
			  q.add(arr[k]);
		}
		while(!q.isEmpty()){
			out.add(q.poll());
		}
	}

}
