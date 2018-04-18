package com.az.calander;

public class calander {
    
	public static int[] getTime(int[][] strA, int[][] strB, int dur){
		int i = 0;
		int j = 0;
		int[] res = new int[2];
		
		while(i<strA.length && j<strB.length){
			int start = Math.max(strA[i][0], strB[j][0]);
			int end = Math.min(strA[i][1], strB[j][1]);
			if(start+dur<= end){
				res[0] = start;
				res[1] = start + dur;
				return res;
			}
			if(strA[i][1] > strB[j][1]){
				j++;
			}
			else if(strA[i][1] < strB[j][1]){
				i++;
			}
			else{
				i++;
				j++;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] slotsA = {{10, 50}, {62, 120}, {140, 210}};
		int[][] slotsB = {{0, 15}, {60, 70}};
		int dur = 8;
		int[] res= getTime(slotsA, slotsB, dur);
		System.out.println(res[0] + " " + res[1]);

	}

}
