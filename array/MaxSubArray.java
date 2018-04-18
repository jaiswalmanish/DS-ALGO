package com.az.array;

public class MaxSubArray {
	
	public static int printMax(int[] arr){
		int maxTillNow = Integer.MIN_VALUE;
		int maxEndsHere = 0;// careful Integer.MIN_VALUE - 1 = Integer.MAX_VALUE
		for(int i = 0; i<arr.length; i++){
			maxEndsHere = Math.max(arr[i], maxEndsHere + arr[i]);
			System.out.println(maxEndsHere);
			if(maxTillNow < maxEndsHere){
				maxTillNow = maxEndsHere;
			}
		}
		return maxTillNow;
	}

	public static void main(String[] args) {
		int[] arr = {-1,-2,0,4,1,2,3,4,0,9,-2,-3,0};
		int max  = printMax(arr);
		System.out.println(max);

	}

}
