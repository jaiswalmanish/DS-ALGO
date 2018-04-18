package com.az.test;

import java.util.PriorityQueue;

public class test3 {
	 static int[] sortKMessedArray(int[] arr, int k) {
		    // your code goes here
		    PriorityQueue<Integer> pq = new PriorityQueue();
		    for(int i : arr){
		        pq.add(i);
		    }
		    int[] outarr = new int[arr.length];
		    int j = 0;
		    while(!pq.isEmpty()){
		      outarr[j] = pq.poll();
		      j++;
		    }
		    return arr;
		  }

		  public static void main(String[] args) {
		    int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
		     for (int i : sortKMessedArray(arr, 2)){
		       System.out.print(i + " ");
		     }
		  }


}
