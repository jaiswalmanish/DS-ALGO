package com.az.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DijkstraImplementation {
	HashMap<Integer, Node> lookup = new HashMap();
	
	public class Node{
		int val;
		ArrayList<Edge> adj = new ArrayList();
		Node(int val){
			this.val = val;		
		}
	}
	
	public class Edge{ // Do we need start Node?
		Node start;
		public Node end;
		public int cost;
		Edge(Node start, Node end, int cost){
			this.start = start;
			this.end =  end;
			this.cost =  cost;
		}
	}
	
	public void addEdge(int start, int end, int cost){
		Node s = lookup.get(start);
		Node e = lookup.get(end);
		if(s == null){
			s = new Node(start);
			lookup.put(start, s);
		}	
		if(e == null){
			e = new Node(end);
			lookup.put(end, e);
		}
		s.adj.add(new Edge(s,e,cost));
		e.adj.add(new Edge(e,s,cost));
	}
	
	
	public static void main(String[] args) {
		//create graph
		DijkstraImplementation d = new DijkstraImplementation();
		d.addEdge(0, 1, 4);
		d.addEdge(0, 2, 8);
		d.addEdge(1, 2, 2);
		d.addEdge(1, 3, 6);
		d.addEdge(2, 4, 9);
		d.addEdge(2, 3, 5);
		d.addEdge(3, 4, 4);
		d.shortestPath(3);
	}



	private void shortestPath(int i) {
		int size = lookup.size();
		System.out.println("Size"+ size);
		boolean[] visited = new boolean[size];
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Node start = lookup.get(i);	
		dist[i] = 0;
		Node minDistNode = start;
		while(minDistNode != null){
			visited[minDistNode.val] = true;
			for(Edge child: minDistNode.adj){
				//System.out.println("Got child for "+ minDistNode.val+ "child value: "+ child.val + "child cost" +child.cost);
				int newDist = child.cost + dist[minDistNode.val];
				//System.out.println("New Dist:" + newDist);
				if(newDist<dist[child.end.val]){
					//System.out.println("Updating:" + dist[child.val]);
					dist[child.end.val] = newDist;					
				}
				
			}
			minDistNode = findMinDistNode(dist,visited);
		}
		
		for(int j=0; j<dist.length; j++){
			System.out.print(dist[j]+ " ");
		}
		
	}



	private Node findMinDistNode(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int val = -1;
		for(int i = 0; i<dist.length; i++){
			if(visited[i] == false){
				if(min>dist[i]){
					min = dist[i];
					val = i;
				}
					
			}			
		}
		return lookup.get(val);
	}

}
