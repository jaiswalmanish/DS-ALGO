package com.az.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralRecurssive {

	public static void main(String args[]){
		int[][] arr = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		for(int i : getSpiralReccursiveTraversal(arr)){
			System.out.print(i+"  ");
		}
	}

	private static List<Integer> getSpiralReccursiveTraversal(int[][] arr) {
		List<Integer> result = new ArrayList<>();
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		
		return result;
	}

}
