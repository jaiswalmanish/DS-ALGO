package com.az.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
		}

		private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
		tempList.add(nums[i]);
		backtrack(list, tempList, nums, i + 1);
		tempList.remove(tempList.size() - 1);
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,6,8,9,3};
		List<List<Integer>> test = subsets(arr);
		for(List<Integer> i : test){
			for(int j : i){
				System.out.print(j + " ");
			}
			System.out.println("");
		}

	}

}
