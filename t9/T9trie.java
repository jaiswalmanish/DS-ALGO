package com.az.t9;

import java.util.*;


public class T9trie {
	static String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static class Node{
		 String prefix;
		 WordTrie.Node node;
		 public Node(String prefix, WordTrie.Node node){
			 this.prefix = prefix;
			 this.node = node;
		 }
	}

	public static LinkedList<String> getMatchesIterative(WordTrie trie, int[] keypresses) {
		LinkedList<Node> queue =  new LinkedList();
		LinkedList<String> arr =  new LinkedList();
		queue.add(new Node("", trie.root));
		for(int i : keypresses){
			int size = queue.size();
			while(size!=0){
				Node n = queue.remove();
				for(char c : map[i].toCharArray()){
					String prefix = n.prefix + c;
					WordTrie.Node subnode = n.node.get(c);
					if(subnode != null){
                       queue.add(new Node(prefix, subnode));                       
					}						
				}	
				size--;
			}
		}	
		
		while(!queue.isEmpty()){
			Node res = queue.remove();
			if(res.node.isWord){
				arr.add(res.prefix);
			}
		}
		return arr;
	}

	public static Set<String> getMatches(WordTrie trie, int[] keypresses) {
		return getMatchesHelper(trie.root, keypresses, 0);
	}

	private static Set<String> getMatchesHelper(WordTrie.Node node, int[] keypresses, int i) {
		Set<String> matches = new HashSet<String>();
		if (i >= keypresses.length) {
			if (node.isWord) matches.add("");
			return matches;
		}
		int keypress = keypresses[i];
		for (char firstChar : map[keypress].toCharArray()) {
			WordTrie.Node subNode = node.get(firstChar);
			if (subNode != null) {
				Set<String> suffixes = getMatchesHelper(subNode, keypresses, i + 1);
				for (String suffix : suffixes)
					matches.add("" + firstChar + suffix);
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		WordTrie trie = WordTrie.fromSystemWords();
		System.out.println(getMatches(trie, new int[] { 2, 2, 5, 5 }));
		System.out.println(getMatchesIterative(trie, new int[] { 2, 2, 5, 5 }));
		System.out.println(getMatches(trie, new int[] { 2, 2, 8 }));
		System.out.println(getMatches(trie, new int[] { 3, 6, 4 }));
		System.out.println(getMatches(trie, new int[] { 3, 2, 8, 2 }));
		System.out.println(getMatches(trie, new int[] { 7, 8, 7, 8, 2, 8, 8, 7, 3 }));
		System.out.println(getMatches(trie, new int[] { 2, 6, 6, 7, 8, 8, 3, 7 }));
		System.out.println(getMatches(trie, new int[] { 7, 2, 4, 3, 6, 2, 3 }));
	}

}
