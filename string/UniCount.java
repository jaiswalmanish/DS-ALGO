package com.az.string;

import java.util.HashMap;
import java.util.HashSet;

public class UniCount {
	
	public static int getCount(String str){
		int count = 0;
		//int prevCount = 0;
		HashSet<Character> set = new HashSet();
		for(int i=0;i<str.length();i++){
			char cur = str.charAt(i);
			set.add(cur);
			int n = set.size();
			count += (n * (n+1))/2;			
		}
		
		return count;
	}
	
	//second
	public int solution(String str) {
        int sum = calculate(0, str);
        return sum;
    }

    public int calculate(int startIndex, String str) {

        if (startIndex == str.length()) {
            return 0;
        }

        int sum = 0;
        for (int i = startIndex + 1; i <= str.length(); i++) {
            String substring = str.substring(startIndex, i);
            sum += countUniqueChars(substring);
        }
        sum += calculate(startIndex + 1, str);

        return sum;
    }

    public int countUniqueChars(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
        }
        int counter = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                counter++;
            }
        }
        return counter;
    }

	public static void main(String[] args) {
		UniCount u = new UniCount();
		System.out.println(getCount("CODILITY"));
		System.out.println(u.solution("CODILITY"));

	}

}
