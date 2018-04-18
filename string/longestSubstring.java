package com.az.string;

//greedy without memoization
public class longestSubstring {
	
	public static int getLongestLength(String first, String second){
		int res = 0;
		res = getLongestLength(first,second,first.length()-1,second.length()-1);
		return res;		
	}

	private static int getLongestLength(String first, String second, int pointer1, int pointer2) {
		if(pointer1<0 || pointer2<0)
			return 0;
		if(first.charAt(pointer1)==second.charAt(pointer2)){
			return 1+getLongestLength(first,second,pointer1-1,pointer2-1);
		}
		
		int tmp1 = getLongestLength(first,second,pointer1,pointer2-1);
		int tmp2 = getLongestLength(first,second,pointer1-1,pointer2);
		return Math.max(tmp1, tmp2);
	}

	//with memoization	dynamic programming top-down
		public static int getLongestLength2(String first, String second){
			int res = 0;
			int[][] arr = new int[first.length()][second.length()];
			res = getLongestLength2(first,second,first.length()-1,second.length()-1,arr);
			return res;		
		}

		private static int getLongestLength2(String first, String second, int pointer1, int pointer2, int[][] arr) {
			if(pointer1<0 || pointer2<0)
				return 0;
			if(arr[pointer1][pointer2]!=0)
				return arr[pointer1][pointer2];
			if(first.charAt(pointer1)==second.charAt(pointer2)){
				return 1+getLongestLength(first,second,pointer1-1,pointer2-1);
			}
			
			int tmp1 = getLongestLength(first,second,pointer1,pointer2-1);
			int tmp2 = getLongestLength(first,second,pointer1-1,pointer2);
			int res= Math.max(tmp1, tmp2);
			arr[pointer1][pointer2] = res;
			return res;
		}
		
  //bottom-up approach dynamic
		public static int getLongestBottomUp(String first, String second){
			int[][] arr = new int[first.length()+1][second.length()+1];
			for(int i = 1; i<=first.length(); i++){
				for(int j=1; j<=second.length(); j++){
					if(first.charAt(i-1)==second.charAt(j-1)){
                       arr[i][j]=arr[i-1][j-1]+1;
					}
					else{
						arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
					}
				}
			}
			return arr[first.length()][second.length()];
		}
		
	public static void main(String[] args) {
		String a = "ABCDA";
		String b = "ACXXDYBCA";
		System.out.println(getLongestLength(a,b));
		System.out.println(getLongestLength2(a,b));
		System.out.println(getLongestBottomUp(a,b));
	}

}
