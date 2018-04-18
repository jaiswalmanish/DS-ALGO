 package com.az.island;

public class Island2 {
	private static int ROW = 4, COL = 4;
	private static int[][] visitDetails = new int[ROW][COL];
	
	public static boolean isVisited(int i, int j){
		if(visitDetails[i][j] == 1)
			return true;
		return false;
	}
	
	public static int DFS(int[][] mat, int i, int j){
		int count = 0;
		int[] dx = {-1,1,0,0};
	    int[] dy = {0,0,-1,1};
		visitDetails[i][j] = 1;
		//mat[i][j] = 0;
		
			for(int k=0; k<4; k++){
				if(i+dx[k]>=0 && j+dy[k]>=0 && i+dx[k]<ROW && j+dy[k]<COL && mat[i+dx[k]][j+dy[k]] == 1 && !isVisited(i+dx[k],j+dy[k]))
			              count += DFS(mat,i+dx[k],j+dy[k]);
			}		   
		return count + 1;
	}
	
	public static int getmaxIsland(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;
		int max = 0;
		for(int i=0; i<row;i++){
			for(int j=0;j<col;j++){
				if(mat[i][j] == 1 && !isVisited(i,j)){
					int check = DFS(mat, i, j);
					if(check > max){max= check;}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {
				       {0,1,1,1},
				       {1,0,0,1},
				       {0,0,0,1},
				       {1,0,1,1},
				
		              };
       System.out.println(getmaxIsland(mat));
	}

}
