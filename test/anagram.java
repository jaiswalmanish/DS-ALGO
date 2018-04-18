package com.az.test;

import java.util.*;

public class anagram {
	public List<Integer> getAnagramIndices(String haystack, String needle){
		List<Integer> result = new ArrayList<Integer>();
		int lenHayStack = haystack.length();
		int lenNeedle = needle.length();
		if(lenHayStack == 0 || lenNeedle == 0 || lenNeedle > lenHayStack){
			return result;
		}

        //define 256 alphabet ASCII char arrays
		int[] needleArr = new int[256];
		int[] windowChk = new int[256];
		
		//update array for needle and initial window from haystack
		for(int i=0; i<lenNeedle; i++){
			needleArr[(int)needle.charAt(i)]++;
			windowChk[(int)haystack.charAt(i)]++; // initial from haystack
		}

		//define window in haystack and check each
		for(int i=lenNeedle; i<lenHayStack; i++){
			if(compare(windowChk, needleArr)){
				result.add(i-lenNeedle);
			}
			windowChk[(int)haystack.charAt(i)]++;
			windowChk[(int)haystack.charAt(i-lenNeedle)]--;
		}
		
		//chk last char in haystack
		if(compare(windowChk, needleArr)){
			result.add(lenHayStack-lenNeedle);
		}
		
		return result;
		
	}
	
	public boolean compare(int[] windowChk, int[] needleArr){
		//All ASCII character
		for(int i=0; i<256; i++){
			if(windowChk[i] != needleArr[i]){
				return false;
			}
		}
		return true;
	}

}
