package com.az.temp;

import java.util.Arrays;

public class xyz {

	class Solution {
		public int maxIncreaseKeepingSkyline(int[][] grid) {
			int row_len = grid.length;
			int col_len = grid[0].length;

			int[] row_arr = new int[row_len];
			int[] col_arr = new int[col_len];

			for(int i=0; i<row_len; i++){     	
				int[] tempi = new int[row_len];
				for(int j=0; j<col_len; j++){
					tempi[j]=grid[i][j];
				}	
				Arrays.sort(tempi); 
				row_arr[i]=tempi[row_len-1];
			}
			
			for(int j=0; j<col_len; j++){     	
				int[] tempj = new int[col_len];
				for(int i=0; i<row_len; i++){
					tempj[i]=grid[i][j];
				}	
				Arrays.sort(tempj); 
				col_arr[j]=tempj[col_len-1];
			}
			
            int res = 0;
            for(int i=0;i<row_len;i++){
            	for(int j=0; j<col_len;j++){
            		int y= Math.min(row_arr[i], col_arr[j]);
            		if(grid[i][j]<y)
            			res += y - grid[i][j];
            	}
            }
            return res;
		}
	}

}
