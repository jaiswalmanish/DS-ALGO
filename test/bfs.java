package com.az.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
	
	public static LinkedList<Integer>[] adj;
	
	bfs(int n){
		adj = new LinkedList[n];
		for(int i=0;i<n;i++){
			adj[i] = new LinkedList();
		}
	}
	
	private void addEdge(int i, int j) {
		  adj[i].add(j);		
	}

	private static void getList(int n) {
		Queue<Integer> q = new LinkedList();
		boolean[] visited = new boolean[adj.length];
		visited[n] = true;
		q.add(n);
		Iterator<Integer> i = adj[n].listIterator();
		while(q.size() != 0){
			System.out.print(q.poll() + " ");
		while(i.hasNext()){
			int s = i.next();
			if(visited[s] == false){
				visited[s] = true;
				q.add(s);
			}
		}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bfs g = new bfs(4);
		   g.addEdge(0, 1);
		   g.addEdge(1, 2);
		   g.addEdge(2, 3);
		   g.addEdge(3, 3);
		getList(0);
		//System.out.print(getList(2));
	}


}
