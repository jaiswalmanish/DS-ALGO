package com.az.test;

import java.util.Stack;

public class spiral {
    public static int[] generate(int m, int n, int[][] arr){
    	int[] res = new int[m*n];
    	int row =0;
    	int col= 0;
    	Stack<Integer> stk = new Stack();
    	while(row < m && col <n){
    		//scan first row
    		for(int i=col; i<n; i++){
    			stk.push(arr[row][i]);
    		}
    		row++;
    		//scan last col
    		for(int i=row; i<m; i++){
    			stk.push(arr[i][n-1]);
    		}
    		n--;
    		//scan last row
    		for(int i=n-1;i >=col; i--){
    			stk.push(arr[m-1][i]);
    		}
    		m--;
    		//scan first col
    		for(int i=m-1; i>=row; i--){
    			stk.push(arr[i][col]);
    		}
    		col++;
    	}
    	int x =0;
    	while(!stk.isEmpty()){
    		res[x++] = stk.pop();    		
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		for(int x: generate(4,5,mat)){
            System.out.print(x +" ");
		}
	}

}
