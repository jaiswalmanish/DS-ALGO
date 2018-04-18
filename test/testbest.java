package com.az.test;

import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class testbest{
	class Coordinate{
		int row;
		int col;
		Coordinate(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public int shortestPath(List<List<Integer>> field, Coordinate start, int treeHeight ){
		int[][] distance = new int[field.size()][field.get(0).size()];
		int[][] moves = {{1,0,-1,0},{0,1,0,-1}};
		distance[start.row][start.col] = 1;
		Queue<Coordinate> queue = new LinkedList();
		queue.add(start);
		while(!queue.isEmpty()){
			Coordinate coor = queue.poll();
			int dist = distance[coor.row][coor.col];
			if(field.get(coor.row).get(coor.col) == treeHeight){
				start.row = coor.row;
				start.col= coor.col;
				return dist;
			}
			for(int i=0; i<moves[0].length;i++){
				int X = coor.row + moves[0][i];
				int Y = coor.col + moves[1][i];
				if(X>=0 && X<field.size() && Y>=0 && Y<field.get(0).size() && field.get(X).get(Y) !=0 && distance[X][Y] ==0){
					distance[X][Y] = dist + 1;
					queue.add(new Coordinate(X,Y));
				}
			}
		}
		return -1;
	}


	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	int levelFieldTime(int numRows, int numColumns, List<List<Integer>> field)
	{
		// WRITE YOUR CODE HERE
		ArrayList<Integer> trees = new ArrayList();
		HashMap<Integer, Coordinate> hash = new HashMap();
		//Heights are unique
		for(int row=0; row<numRows; row++){
			for(int col=0; col<numColumns; col++){
				if(field.get(row).get(col)>1){
					trees.add(field.get(row).get(col));
					hash.put(field.get(row).get(col), new Coordinate(row,col));
				}
			}
		}
		//sort ArrayList
		Collections.sort(trees);

		int totatlTime = 0;
		Coordinate CurrentCordinate = new Coordinate(0,0);
		for(int i=0; i<trees.size(); i++){
			int time = shortestPath(field, CurrentCordinate, trees.get(i));
			if(time == -1){
				return -1;
			}
			else{
				totatlTime += time;
			}
			CurrentCordinate = hash.get(trees.get(i));
		}
		return totatlTime;
		// METHOD SIGNATURE ENDS
	}
	
	public static void main(String[] args){
		int[][] test = {{1,1,0,1},{1,1,5,1}};
		List<List<Integer>> field = new ArrayList();
		for(int i=0; i<test.length; i++){
			 field.add(new ArrayList());
			for(int j=0;j<test[0].length; j++){
				field.get(i).add(test[i][j]);
				//System.out.println(test[i][j]);
			}
		}
		testbest t = new testbest();
		System.out.println(t.levelFieldTime(2, 4, field));
	}
}