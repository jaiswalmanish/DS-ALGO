package com.az.t9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class WordTrieTest {
	public Trie root = new Trie();
	
	public class Trie{
		HashMap<Character, Trie> children = new HashMap();
		boolean isWord;
	}
	
	public WordTrieTest(List<String> words) {
		for(String str : words){
			add(str);
		}
	}

	private void add(String str) {
		add(str, root);		
	}

	private void add(String str, Trie parent) {
		if(str.length()==0){
			parent.isWord = true;
			return;
		}
		char c = str.charAt(0);
		if(parent.children.get(c) == null){
			parent.children.put(c, new Trie());
		}
		add(str.substring(1),parent.children.get(c));
	}

	public static WordTrieTest fromSystemWords(){
		try {
			List<String> words = Files.readAllLines(Paths.get("C:/Users/ManishJaiswal/workspace/AZtest/src/com/az/t9/t9Dictionary"));
			return new WordTrieTest(words);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
    
}
