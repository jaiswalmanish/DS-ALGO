package com.az.trie;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TrieHacker {
	TrieNode root = new TrieNode();
	
	public class TrieNode{
		HashMap<Character, TrieNode> children = new HashMap();
		boolean isWord;
	}

	public void add(String s){
		add(s, root);
	}

	public void add(String s, TrieNode parent){  
		if(s.isEmpty()){
			return;
		}
		char c = s.charAt(0); 
		if(s.length() == 1){
			parent.isWord = true;
		}
		if(parent.children.get(c) == null){ 
			TrieNode n = new TrieNode();  
			parent.children.put(c, n);  
			add(s.substring(1),n);  
		}
		else{  
			add(s.substring(1),parent.children.get(c));            
		}

	}

	public void search(String p){
		if(p.isEmpty()){
			return;
		}
		List<String> arr = new ArrayList();
		search(p, root, arr);
		System.out.println(arr.size());    
	}

	public void getWordForNode(String prefix, TrieNode node, List<String> arr){
		if(node == null){
			arr.add(prefix);
			return;
		}
		if(node.isWord){
			arr.add(prefix);
		}
		for(char c : node.children.keySet()){
			prefix += c;
			getWordForNode(prefix, node.children.get(c), arr);
		}
		return;
	}

	public void search(String p, TrieNode parent, List<String> arr){      
		String prefix = "";
		while(p.length() > 0){
			char c = p.charAt(0);
			if(!parent.children.containsKey(c)){
				return;
			}
			prefix += c;
			p = p.substring(1);
			parent = parent.children.get(c);
		}
		getWordForNode(prefix, parent, arr);
		return;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TrieHacker sl = new TrieHacker();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			if(op.equals("add")){
				sl.add(contact);
			}
			else{
				sl.search(contact);
			}
		}
	}

}
