package com.az.test;

import java.util.*;

public class Solution
{        
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
			List<String> wordsToExclude)
	{
		HashSet<String> excludeSet = new HashSet<>(wordsToExclude);
		HashMap<String, Integer> textMap = new HashMap<>();
		for(String str: literatureText.split("\\s+")){
			if(!excludeSet.contains(str)){
				int num = 1;
				if(textMap.get(str)!=null)
					num += textMap.get(str);
				textMap.put(str,num);   
			}
		}

		Object[] a = textMap.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue()
		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
		    }
		});
		List<String> res = new ArrayList<>();
		int maxFreq = ((Map.Entry<String, Integer>) a[0]).getValue();		
		for (Object e : a) {
			if(((Map.Entry<String, Integer>) e).getValue() != maxFreq)
                break;
		   res.add(((Map.Entry<String, Integer>) e).getKey());
		}
		return res;
	}
	// METHOD SIGNATURE ENDS
	public static void main(String[] args) {
		List<String> target = new ArrayList<>(Arrays.asList("in", "the", "spain"));
		List<String> tag = new ArrayList<>(Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"));
		
		for(String i : retrieveMostFrequentlyUsedWords("in the spain man gan man tan tan", target)){
			System.out.println(i + " ");
		}

	}
}

