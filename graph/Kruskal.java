package com.az.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.az.graph.Graph.Edge;

public class Kruskal {
	//Minimum spanning tree
	
	public class CustomComparator implements Comparator<Edge> {
	    @Override
	    public int compare(Edge o1, Edge o2) {
	        return o1.cost - o2.cost;
	    }
	}
	
	private List<Edge> minSpanTree(Graph g) {
		List<Edge> res = new LinkedList();
		
		Edge[] edgeArr = g.getAllEdges();
		Arrays.sort(edgeArr, new CustomComparator());

		
		DisjoinSet d = new DisjoinSet(g.lookup.size()+1);
		for(int i=0;i<edgeArr.length;i++){
			int root1 = d.find(edgeArr[i].parent);
			int root2 = d.find(edgeArr[i].child);
			
			if(root1==root2)
				continue;
			
		    res.add(edgeArr[i]);
		    d.union(edgeArr[i].parent, edgeArr[i].child);
		}
		
		return res;
	}
	

	public static void main(String[] args) {
		Graph g =new Graph();
		g.addEdge(g.new Edge(1,2,3));
		g.addEdge(g.new Edge(1,4,1));
		g.addEdge(g.new Edge(2,4,3));
		g.addEdge(g.new Edge(2,3,1));
		g.addEdge(g.new Edge(4,3,1));
		g.addEdge(g.new Edge(4,5,6));
		g.addEdge(g.new Edge(3,6,4));
		g.addEdge(g.new Edge(3,5,5));
		g.addEdge(g.new Edge(5,6,2));
		
		Kruskal k = new Kruskal();
		List<Edge> res = k.minSpanTree(g);
		for(Edge e : res)
		 System.out.println(e.parent + " " + e.child + " " + e.cost);

	}

}
