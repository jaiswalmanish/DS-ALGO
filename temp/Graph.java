package com.az.temp;

import java.util.ArrayList;
import java.util.HashSet;


public class Graph {

	HashSet<Node> visited = new HashSet();
	public class Node{
		int val;
		ArrayList<Node> adj;
		Node(int x){
			this.val = x;
			this.adj = new ArrayList();
		}
	}

	public Node addNode(int val){
		Node n = new Node(val);
		return n;
	}

	public void addEdge(Node parent, Node child){
		parent.adj.add(child);
	}



	public boolean DFSSearch(Node current, Node target){
		if(visited.contains(current))
			return false;
		if(current.val== target.val)
			return true;
		visited.add(current);
		for(Node child: current.adj){ //Node child = current.adj
			if(DFSSearch(child,target))
				return true;
		}
		return false;
	}
}
