package com.az.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LogSort {
	
	public static class Node{
		String id;
		String value;
		Node(String id, String value){
			this.id = id;
			this.value = value;
		}
	}
	
	public static List<String> getResult(List<String> log){
		List<String> res = new ArrayList();
		List<String> numStrings = new ArrayList();
		List<Node> map = new ArrayList();
		for(String str: log){
			String id = str.substring(0,str.indexOf(' '));
			String value = str.substring(str.indexOf(' ')+1,str.length());
			
			//add into another list if value id numeric type
			if(Character.isDigit(value.charAt(0))){
				numStrings.add(str);
			}
			else{
				map.add(new Node(id, value));
			}			
		}
		

		Collections.sort(map, new Comparator<Node>() {
			@Override
		    public int compare(Node o1, Node o2) {
		    	if(o2.value.compareToIgnoreCase(o1.value)==0){
		    		return (o1.id.compareToIgnoreCase(o2.id));	    		
		    	}
		        return (o1.value.compareToIgnoreCase(o2.value));
		    }
		});
		
		for(Node n: map){
			res.add(n.id + " " + n.value);
		}
		for(String str: numStrings){
			res.add(str);
		}
		
		return res;
	}

	public static void main(String[] args) {
		List<String> inputLog = new ArrayList<String>();
		inputLog.add("a1 Act test");
		inputLog.add("a2 34 67 56");
		inputLog.add("a4 act man");
		inputLog.add("a3 act man");
		inputLog.add("b2 44 89 900");
		inputLog.add("b1 44 89 900");
		inputLog.add("b3 man test test");
		
		List<String> ans = getResult(inputLog);
		for(String s: ans)
			System.out.println(s);

	}

}
