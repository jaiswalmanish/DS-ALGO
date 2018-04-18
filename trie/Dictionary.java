package com.az.trie;

import java.util.HashMap;

public class Dictionary {
	Node root;
	
	public class Node{
		HashMap<Character, Node> hash;
		boolean isWord;
	}
	
	Dictionary(){
		this.root = new Node();
		root.hash = new HashMap();
		root.hash.put(null, null);
		root.isWord = false;
	}
	
	void add(String s){
	   add(s, root);
	}
	
	void add(String s, Node parent){
	    if(s.isEmpty()){
	    	return;
	    }
	    parent.hash.put(s.charAt(0), new Node());
	    
	}

}


