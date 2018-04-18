package com.az.test;

public class tempTest {

	public static void main(String[] args) {
		String str = "51234";
		int res = 1;
		int mul = 1;
		for(int i=str.length()-1;i>=0; i--){
			//System.out.println(str.charAt(i));
			char c = str.charAt(i);
			int num = c -'0';
			res += num * mul;
			mul *= 10;			
		}
		System.out.println(res);
	}

}
