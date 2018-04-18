package com.az.dynamic;

public class Knapsack {
	

	public static int getVal(int[][] input, int C) {
		int res = 0;
		int len = input.length;
		int[][] arr = new int[len][C+1];
		res = getVal(input,len-1,C,arr);
		return res;
	}

	private static int getVal(int[][] input, int n, int c,int[][] arr) {
		if(n<0||c==0)
			return 0;
		if(arr[n][c]!=0){
			return arr[n][c];
		}
		//System.out.println("[n][0]" + input[n][0]);
		if(input[n][0]>c){
			return getVal(input,n-1,c,arr);
		}	
		else{
			int tmp1 = getVal(input,n-1,c,arr);
			int tmp2 = input[n][1]+getVal(input,n-1,c-input[n][0],arr);
			int res= Math.max(tmp1, tmp2);
			//System.out.println("res: "+ res);
			arr[n][c] = res;
			return res;
			
		}
	}

	public static void main(String[] args) {
		//{weight, price}
		int[][] input = {{1,5},{2,3},{4,5},{2,3},{5,2}};
		int capacity = 10;
		System.out.println(getVal(input, capacity));

	}


}
