package com.az.binarysearch;

public class getNumFrimShiftedArr {
	 //9 10 11 2 4 5 6 7
	public static int findPivot(int[] arr){
		int start = 0;
		int end = arr.length -1;
		while(end >= start){
		   int mid = (start + end)/2;
		   System.out.println("start " + start + "end " + end + "mid "+ mid);
		   if(mid==end || arr[mid]>arr[mid+1]){
			   return mid;
		   }
		   else if(arr[mid]>arr[0]){
			   start = mid+1;
		   }
		   else if(arr[mid]<arr[0]){
			   end = mid-1;
		   }
		}
		return -1;
	}
	public static int binarySearch(int[] arr, int start, int end, int num){
		while(end>=start){
			
			int mid = (start+end)/2;
			//System.out.println("m here" +"start "+ start+"end " + end+"mid " + mid);
			if(arr[mid] == num){
				return mid;
			}
			else if(arr[mid]<num){
				start = mid+1;
			}
			else{
				end = mid -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,10,11,2,3,4,6,7};
		int num = 6;
		int piv = findPivot(arr);
		int start;
		int end;
		if(num<arr[0]){
			start = piv;
			end = arr.length -1;
		}
		else{			
			start = 0;
			end = piv;			
		}
		System.out.print(binarySearch(arr,start, end, num));

	}

}
