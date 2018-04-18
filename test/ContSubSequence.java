package com.az.test;

import java.util.*;

public class ContSubSequence {
	
	public List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList) {
		List<Integer> vResult = new ArrayList();
        
        // corner case
        if (targetList.isEmpty() || availableTagList.isEmpty()) {
            vResult.add(0);
            return vResult;
        }
        
        HashMap<String, Integer>  hash = new HashMap();
        
        for (String str : targetList)
            hash.put(str, 1);
                
        // window start/end point, hit count ( sum { positive hash[i] } ), min result length, result start index
        int left = 0, right = 0, count = targetList.size(), len = Integer.MAX_VALUE, start = 0;
        
        while (right < availableTagList.size()) {
            if (hash.get(availableTagList.get(right)) != null && hash.get(availableTagList.get(right)) >0) // could use == 1 as well coz that no dup in targetList
                -- count;
            if(hash.get(availableTagList.get(right)) != null)
            hash.put(availableTagList.get(right),hash.get(availableTagList.get(right))-1);
            
            ++ right;
            
            // continue move window start point rightward to minimize window until condition not valid
            while (0 == count) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                
                if (hash.get(availableTagList.get(left)) !=null && hash.get(availableTagList.get(left)) >= 0) // could change the condition to == 0 if condition for -- count varies
                    ++ count;
                if(hash.get(availableTagList.get(left))!=null)
                hash.put(availableTagList.get(left),hash.get(availableTagList.get(left))+1);
                
                ++ left;
            }
        }

        if (len != Integer.MAX_VALUE) {
            vResult.add(start);
            vResult.add(start + len - 1);
        } else
            vResult.add(0);   // Don't miss the empty result if no match
            
        return vResult;
    }
	
	
	private List<Integer> findSequence(List<String> target, List<String> tag){
		List<Integer> res = new ArrayList<>();
		HashMap<String,List<Integer>> tagmap = new HashMap<>();
		int i = 0;
		for(String s: tag){
			if(!tagmap.containsKey(s)){
				tagmap.put(s, new ArrayList<>());
			}
			tagmap.get(s).add(i++);
		}
		
		int k = 0;
		for(String s:target){
			if(!tagmap.containsKey(s))
				return null;
			int count = 0;
			int listLength = res.size();
			List<Integer> l =tagmap.get(s);
			while(count < l.size()) {
				//if you see an element getting inserted which is less that the 
				//last element remove one element from the front
				if(listLength > 0 && l.get(count) < res.get(listLength-1))
					res.remove(k++);	
				//add otherwise
				res.add(l.get(count));
				count++;
		}
		}
		
		return res;
	}
	
	private static int[] getMinimum(List<String> target, List<String> available) {
		//Add to the map
		Map<String, List<Integer>> listMap = new HashMap<>();
		int counter = 0;
		for(String availableItem : available) {
			if(listMap.containsKey(availableItem))
				listMap.get(availableItem).add(counter);
			else {
				List<Integer> temp = new ArrayList<>();
				temp.add(counter);
				listMap.put(availableItem, temp);
			}
			counter++;
		}
		
		List<Integer> resultList = new ArrayList<>();
		int k=0;
		//add all element list to resultList
		for(String targetItem : target) {
			if(listMap.get(targetItem) == null)
				break;
			else {
				int count = 0;
				int listLength = resultList.size();
				List<Integer> l =listMap.get(targetItem);
				while(count < l.size()) {
					//if you see an element getting inserted which is less that the 
					//last element remove one element from the front
					if(listLength > 0 && l.get(count) < resultList.get(listLength-1))
						resultList.remove(k++);	
					//add otherwise
					resultList.add(l.get(count));
					count++;
				}
			}
		}
		
		int left = resultList.get(0);
		int right = resultList.get(resultList.size()-1);
		return new int[] {left, right};

	}

	public static void main(String[] args) {
		List<String> target = new ArrayList<>(Arrays.asList("in", "the", "spain"));
		List<String> tag = new ArrayList<>(Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"));
		ContSubSequence c = new ContSubSequence();
		for(int i : c.subSequenceTags(target, tag)){
			System.out.println(i + " ");
		}

	}

}
