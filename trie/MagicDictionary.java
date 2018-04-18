package com.az.trie;

import java.util.HashMap;

public class MagicDictionary {
	 
	    MagicDictionary(){
	        root = new TrieNode();
	    }
	    
	       public TrieNode root;
	  
	   private class TrieNode{
	        HashMap<Character,TrieNode> hash;
	        boolean isWord;
	        TrieNode(){
	            hash = new HashMap<>();
	            isWord = false;
	        }
	    }
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        if(dict.length==0) return;
	        for(String str : dict){
	            TrieNode parent = root;
	            for(int j=0;j<str.length(); j++){
	                if(parent.hash.get(str.charAt(j)) == null){
	                    parent.hash.put(str.charAt(j), new TrieNode());
	                }                
	                parent = parent.hash.get(str.charAt(j));
	                if(j==str.length() - 1) parent.isWord = true;
	            }
	        }
	        
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	        if(word.length() == 0) return false;
	        TrieNode parent = root;
	       // int count = 0;
	              for(int j=0;j<word.length(); j++){
	                if(parent.hash.get(word.charAt(j)) == null){
	                    //if(count==0){
	                    //    count++;
	                   // }
	                   // else{
	                        return false;
	                   // }                 
	                }                
	                parent = parent.hash.get(word.charAt(j));
	                if(j==word.length() - 1 && parent.isWord)  return true;
	            }
	       return false;
	    }


	/**
	 * Your MagicDictionary object will be instantiated and called as such:
	 * MagicDictionary obj = new MagicDictionary();
	 * obj.buildDict(dict);
	 * boolean param_2 = obj.search(word);
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"test","testing"};
		 MagicDictionary obj = new MagicDictionary();
		  obj.buildDict(dict);
		  boolean param_2 = obj.search("test1");
		  System.out.println(param_2);
	}

}
