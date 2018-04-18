package com.az.test;

import java.util.Arrays;

public class ResizableArray {
	int[] arr;
	int cur_size;
	ResizableArray(){
		arr = new int[1];
		cur_size = 0;
	}
	public void add(int a){
		if(cur_size == arr.length){
			//int[] temp = arr;
			//arr = new int[cur_size * 2];
			int[] copy = new int[cur_size * 2];
			System.arraycopy(arr, 0, copy, 0, cur_size);
			arr = copy;
		}
		arr[cur_size++] = a;
	}
	
	public int size(){
		return arr.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizableArray arr =  new ResizableArray();
		arr.add(3);
		arr.add(2);
		System.out.println("size : " + arr.size());
		arr.add(3);
		arr.add(2);
		System.out.println("size new : " + arr.size());
	}

}
