package com.az.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	HashMap<Integer, Node> lookup = new HashMap(); //unique keys and their values
	HashSet<Edge> edgeset = new HashSet(); //unique values
	
	public class Node{
		int val;
		ArrayList<Node> adj = new ArrayList();
		int cost;
		Node(int val, int cost){
			this.val = val;
			this.cost =  cost;			
		}
	}
	
	public class Edge{
		int parent;
		int child;
		int cost;
		Edge(int p, int ch, int co){
			this.parent = p;
			this.child = ch;
			this.cost = co;
		}
	}
	
	public void addEdge(Edge ed){
		Node s = lookup.get(ed.parent);
		Node e = lookup.get(ed.child);
		if(s == null){
			s = new Node(ed.parent,0);
			lookup.put(ed.parent, s);
		}	
		if(e == null){
			e = new Node(ed.child,0);
			lookup.put(ed.child, e);
		}
		s.adj.add(new Node(ed.child,ed.cost));
		edgeset.add(ed);
		//System.out.println("Adding " + ed.parent + " " + ed.child + " " + ed.cost );
	}

	public Edge[] getAllEdges(){
		return edgeset.toArray(new Edge[edgeset.size()]);
	}

}
