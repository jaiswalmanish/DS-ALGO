package com.az.temp;

import com.az.temp.Graph2.Node;

public class mainApplication {

	public static void main(String[] args) {
		int[] arr = {1,3,19,2,5,8,12,4};
		Node[] nodeArr = new Node[arr.length];
		//Graph g = new Graph();
		Graph2 g2 = new Graph2();
		for(int i=0; i<nodeArr.length;i++){
			nodeArr[i] = g2.addNode(arr[i]);
		}
		
		g2.addEdge(arr[0], arr[1]);
		g2.addEdge(arr[1], arr[3]);
		g2.addEdge(arr[3], arr[7]);
		g2.addEdge(arr[7], arr[4]);
		g2.addEdge(arr[2], arr[5]);
		g2.addEdge(arr[2], arr[6]);
		
		System.out.println(g2.DFSSearch(1,4));

	}

}
