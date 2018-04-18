package com.az.test;

public class Pailendrom {
	 public static boolean validPalindrome(String s) {
	        int n = s.length() -1;
	        int i = 0;
	        int flag =0;
	        while(i<n){
	            if(s.charAt(i)!=s.charAt(n)){
	                if(flag == 0){
	                if(s.charAt(i)==s.charAt(n-1)) n--;
	                else if(s.charAt(i+1)==s.charAt(n)) i++;
	                    flag++;
	                    continue;
	                }
	                else{
	                    return false;
	                }
	            }
	            i++; n--;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(validPalindrome("babba"));
	}

}
