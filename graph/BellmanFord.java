package com.az.graph;

import java.util.*;

public class BellmanFord {
    
	public class Graph {
		List<Node> vertices;
		List<Edge> edges;
		public Graph(List<Node> vertices, List<Edge> edges){
			this.vertices = vertices;
			this.edges = edges;
		}
		public void shortestPath(Node start, Node end){
			System.out.println("shortest path" + 0);
			
		}
	}
	
	public class Node {
		private String name;
		private boolean isVisited;
		private List<Edge> adjacenciesList;
		private int minDistance = Integer.MAX_VALUE;
		public Node(String name){
			this.name = name;
			this.adjacenciesList = new ArrayList<>();
		}
		
		public void addEdge(Edge edge){
			this.adjacenciesList.add(edge);
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public List<Edge> getAdjacenciesList() {
			return adjacenciesList;
		}

		public void setAdjacenciesList(List<Edge> adjacenciesList) {
			this.adjacenciesList = adjacenciesList;
		}

		public int getMinDistance() {
			return minDistance;
		}

		public void setMinDistance(int minDistance) {
			this.minDistance = minDistance;
		}			
	}
	
	public class Edge{
		private int weight;
		private Node sourceNode;
		private Node destNode;
		
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public Node getSourceNode() {
			return sourceNode;
		}
		public void setSourceNode(Node sourceNode) {
			this.sourceNode = sourceNode;
		}
		public Node getDestNode() {
			return destNode;
		}
		public void setDestNode(Node destNode) {
			this.destNode = destNode;
		}
		
	}
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node("A");
		Node b = new Node("B");
		Edge e = new Edge();
		e.setWeight(2);
		e.setSourceNode(a);
		e.setDestNode(b);
		a.addEdge(edge);
		Graph test = new Graph();
		

	}

}
