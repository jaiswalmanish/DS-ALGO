package com.az.island;

public class Island3 {

	public static void main(String[] args) {
		  int[][] mat = {
			       {0,1,1,1},
			       {1,0,0,1},
			       {0,0,0,1},
			       {1,0,1,1},
			
	              };
           System.out.println(getmaxIsland(mat));

	}

	private static int getmaxIsland(int[][] mat) {
		int max = 0;
		int[][] visited = new int[mat.length][mat[0].length];
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				int count = 0;
				if(mat[i][j]==1 && visited[i][j] != 1){
					count++;
					visited[i][j] = 1;
					count += DFS(i,j,visited,mat);
				}
				if(max<count){
					max =  count;
				}
			}
		}
		
		return max;
	}

	private static int DFS(int i, int j, int[][] visited, int[][] mat) {
		int count = 0;
		int [] dx = {0,0,1,-1};
		int [] dy = {1,-1,0,0};
		for(int x =0; x<4; x++){
			if(i+dx[x] >= 0 && j+dy[x] >=0 && i+dx[x] <mat.length && j+dy[x]<mat[0].length && mat[i+dx[x]][j+dy[x]] == 1 && visited[i+dx[x]][j+dy[x]] != 1){
				count++;
				visited[i+dx[x]][j+dy[x]] = 1;
				count += DFS(i+dx[x],j+dy[x],visited, mat);
			}
		}
		return count;
	}

}
