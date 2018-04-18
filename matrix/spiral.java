package com.az.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiral {
	

public static List<Integer> getSpiralTraversal(int[][] mx) {
	List<Integer> result = new ArrayList<>();

	// Set initial direction
	int dx = 1, dy = 0;
	// Set the starting point before the first mx cell
	int x = -1, y = 0;
	// Set the first side length and the next side length
	int sideLen = mx.length, nextSideLen = mx[0].length;
	int sideCounter = sideLen;
	// While both of the run lengths are non-zero
	while (sideLen > 0 && nextSideLen > 0) {
		if (sideCounter > 0) {
			// traverse the side while counter is > 0
			sideCounter--;
			x += dx;
			y += dy;
			result.add(mx[x][y]);
		} else {
			// switch direction when the counter is 0
			int tmp;
			// Switch the direction -> rotates the sequence (1,0) (0,1) (-1,0) (0,-1)
			tmp = dx; dx = -dy; dy = tmp;
			// Reduce the next run length with one and switch dimensions
			tmp = sideLen; sideLen = nextSideLen - 1; nextSideLen = tmp;
			// Reset the side run counter
			sideCounter = sideLen;
		}
	}
	
	return result;
}

public static void main(String args[]){
	int[][] arr = {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20}
	};
	for(int i : getSpiralTraversal(arr)){
		System.out.print(i+"  ");
	}
}

}