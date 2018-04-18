package com.az.linkedlist;

public class linkedListBasics {
	private Node root;	
	
	public linkedListBasics(){
		this.root = new Node();
	}	
	
	public class Node{
		int val;
		Node next;
	}
	
	public void insert(int val){
		Node start = root;
		while(start.next != null){
			start = start.next;
		}
		start.next= new Node();
		start.next.val = val;
		start.next.next = null;
	}
	
	public void search(int val){
		Node start = root;
		int pos = 0;
		while(start != null){
			pos++;
			if(start.val==val)
				System.out.println("Found value " + val +"at pos "+ pos);
			start = start.next;
		}
	}
	
	public void delete(int val){
		while(root !=null && root.val==val){
			System.out.println("Deleteing.." + val);
			root= root.next;
		}
		Node start = root.next;
		Node prev = root;
		while(start != null){
			if(start.val==val){
				System.out.println("Deleteing.." + val);
				prev.next=start.next;
			}
				
			start = start.next;
			prev = start;
		}
		
	}

	public static void main(String[] args) {
		linkedListBasics link = new linkedListBasics();
		link.insert(2);
		link.insert(3);
		link.insert(4);
		link.search(4);

	}

}
