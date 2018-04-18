package com.az.graph;

import java.util.*;

public class DFSImplementation {
	
	public class Node{
		int id;
		ArrayList<Node> adj = new ArrayList<>(); //or LinkedList
		Node(int id){
			this.id = id;
		}		
	}
	
	public void addEdge(Node s, Node e){
		s.adj.add(e);		
	}
	
	public boolean DFS(Node s, Node d){
		HashSet<Node> visited = new HashSet<>();
		return DFS(s,d,visited);	
	}

	private boolean DFS(Node s, Node d, HashSet<Node> visited) {
		if(visited.contains(s))
			return false;
		if(s.id == d.id){
			return true;
		}
		for(Node c: s.adj){
			if(DFS(c,d,visited)){
				return true;
			}
		}
		return false;
	}
	
	public boolean BFS(Node s, Node d){
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> visited = new HashSet<>();
		
		queue.add(s);//add start in queue
		
		while(!queue.isEmpty()){
			Node check = queue.poll();
			if(check.id==d.id)// found it..
				return true;
			visited.add(check);
			for(Node child : check.adj){
				if(!visited.contains(child))
					queue.add(child);
			}
		}
			
		return false;
	}

	public static void main(String[] args) {
		int[] test = {2,3,4,5,6,12,13};//assuming unique list
		Node[] nodes = new Node[test.length];
		DFSImplementation x = new DFSImplementation();
		for(int i=0; i<test.length; i++){
			nodes[i] = x.new Node(test[i]);
		}
		x.addEdge(nodes[0], nodes[1]);
		x.addEdge(nodes[0], nodes[2]);
		x.addEdge(nodes[1], nodes[3]);
		x.addEdge(nodes[2], nodes[4]);
		x.addEdge(nodes[5], nodes[6]);
		//x.addEdge(nodes[5], nodes[6]);
		
		//DFS
		System.out.println(x.DFS(nodes[1], nodes[4]));//expected true
		System.out.println(x.DFS(nodes[0], nodes[5]));//expected false
		
		//BFS
		System.out.println(x.BFS(nodes[1], nodes[4]));//expected true
		System.out.println(x.BFS(nodes[0], nodes[5]));//expected false

	}
}
