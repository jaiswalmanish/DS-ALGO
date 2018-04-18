package com.az.t9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordTrie {

		public Node root = new Node(false);

		public static class Node extends HashMap<Character, Node> {
			public boolean isWord;

			public Node(boolean isWord) {
				this.isWord = isWord;
			}
		}

		public WordTrie(Collection<String> words) {
			for (String word : words)
				add(word);
		}

		public void add(String word) {
			addHelper(root, word.toLowerCase());
		}

		private void addHelper(Node node, String word) {
			if (word.length() == 0) {
				node.isWord = true;
				return;
			}
			else {
				char first = word.charAt(0);
				String rest = word.substring(1);
				if (!node.containsKey(first)) node.put(first, new Node(false));
				addHelper(node.get(first), rest);
			}
		}

		public static WordTrie fromSystemWords() {
			try {
				List<String> words = Files.readAllLines(Paths.get("C:/Users/ManishJaiswal/workspace/AZtest/src/com/az/t9/t9Dictionary"));
				return new WordTrie(words);
			}
			catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

}
