package com.az.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class Graph2 {
    HashMap<Integer, Node> lookup = new HashMap();
	HashSet<Node> visited = new HashSet();
	Stack<Node> stk = new Stack();
	
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
		lookup.put(val, n);
		return n;
	}

	public void addEdge(int parentVal, int childVal){
		Node parent = lookup.get(parentVal);
		Node child = lookup.get(childVal);
		parent.adj.add(child);
	}



	public boolean DFSSearch(int currentVal, int targetVal){
		Node current = lookup.get(currentVal);
		Node target = lookup.get(targetVal);
		if(current == null || target==null)
			return false;
		if(visited.contains(current))
			return false;
		stk.push(current);
		if(current.val== target.val){
			String s = "";
			for(Node n: stk){
				s +=  "->"+ Integer.toString(n.val);
			}
			System.out.println(s);
			return true;
		}
			
			
		visited.add(current);
		for(Node child: current.adj){ //Node child = current.adj
			if(DFSSearch(child.val,targetVal))
				return true;
		}
		stk.pop();
		return false;
	}
}
