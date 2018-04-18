package com.az.test;

import java.util.*;
import java.util.Map.*;

public class Solution2 {
	
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		// WRITE YOUR CODE HERE
		HashMap<String,String> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for(String str: logLines){
		    String key = str.substring(0, str.indexOf(' '));
		    String val = str.substring(str.indexOf(' ') + 1);
		    if(val.matches(".*\\d+.*")){
		        list.add(str);
		        continue;
		    }
		    map.put(key,val);
		}
		
		List<Entry<String, String>> sortedEnteries = new ArrayList<>(map.entrySet());
            sortedEnteries.sort(Entry.comparingByValue());
            Collections.reverse(sortedEnteries);
        List<String> res = new ArrayList<>();
        for (Entry<String, String> e : sortedEnteries) {
            res.add(e.getKey()+" "+e.getValue());
        }
        
        for(String str : list)
        res.add(str);
        
        return res;
	}

    	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
                                                     List<String> wordsToExclude)
        {
            // Words to wordsToExclude
            //if(wordsToExclude.size()==0)
              // wordsToExclude.add("'");
            HashSet<String> excludeSet = new HashSet<>();
            for(String str: wordsToExclude){
                excludeSet.add(str.toLowerCase());
            }
                 
                 
            HashMap<String,Integer> mapFreq = new HashMap<>();
            String[] textArr = literatureText.replaceAll("[^a-zA-Z]", " ").split("\\s+");
            for(String str: textArr){
                str=str.toLowerCase();
                if(excludeSet.contains(str))
                   continue;
                int n= 1;
                if(mapFreq.get(str)!=null)
                   n += mapFreq.get(str);
                mapFreq.put(str, n);   
            }
            
            if(mapFreq.size()==0)
              return null;
            
           List<Entry<String, Integer>> sortedEnteries = new ArrayList<>(mapFreq.entrySet());
            sortedEnteries.sort(Entry.comparingByValue());
            Collections.reverse(sortedEnteries);
            
       
            int maxValue = sortedEnteries.get(0).getValue();
            List<String> res = new ArrayList<>();
            for (Entry<String, Integer> e : sortedEnteries) {
                if(e.getValue()==maxValue){
                    res.add(e.getKey());
                }
                System.out.println(e.getKey() + e.getValue());
                   
            }
            return res;     
        }
}