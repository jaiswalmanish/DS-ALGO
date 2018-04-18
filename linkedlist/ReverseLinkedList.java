package com.az.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {
 public Node head;
 public static class Node{
		public int data;
		public Node next;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static Node reverseList(Node head){
		Node newhead;
		if(head == null){
			return null;
		}
		if(head.next == null){
			newhead = head;
		}
		else{
		    newhead = reverseList(head.next);
		    newhead.next = head;
		}
		return newhead;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node prev = new Node(2);
		 prev.next = new Node(3);
		 prev.next.next = new Node(4);
         Node check = prev;
         for(int i = 0;i<3;i++){
        	 System.out.print(check.data + " ");
        	 check = check.next;
         }
         check = reverseList(prev);
         for(int i = 0;i<3;i++){
        	 System.out.print(check.data + " ");
        	 check = check.next;
         }
	}

}
