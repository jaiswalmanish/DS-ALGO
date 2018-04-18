package com.az.t9;

import java.util.LinkedList;

public class T9TrieTest {
	public static String[] map = {"0","1","abc","def","ghi","jkl", "mno","pqrs","tuv","wxyz"};
    public static class Node{
    	WordTrieTest.Trie node;
    	String prefix;
    	Node(WordTrieTest.Trie node, String prefix){
    		this.node = node;
    		this.prefix = prefix;
    	}
    }
	public static void main(String[] args) {
		WordTrieTest trie = WordTrieTest.fromSystemWords();
		System.out.println(getMatches(trie, new int[] { 2, 2, 5, 5 }));
	}

	private static LinkedList<String> getMatches(WordTrieTest trie, int[] digits) {
		LinkedList<Node> queue = new LinkedList();
		LinkedList<String> arr = new LinkedList();
		if(digits.length == 0){
			return arr;
		}
		queue.add(new Node(trie.root,""));
		
		for(int i=0; i<digits.length; i++){
			int num = digits[i];
			String str = map[num];
			int size = queue.size();
			while(size!=0){
				Node subnode = queue.remove();
				for(char c: str.toCharArray()){
					if(subnode.node.children.get(c) != null){
						queue.add(new Node(subnode.node.children.get(c), subnode.prefix+c));
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

}
