package com.az.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RandomNumber {
	
	private ArrayList<Integer> arr;
	private HashMap<Integer, Integer> hash;
	
	public RandomNumber(){
		arr = new ArrayList<Integer>();
		hash = new HashMap<Integer, Integer>();
	}
	
	public void add(int x){
		if(hash.get(x) != null)
			return;
		arr.add(x);
		hash.put(x, arr.size()-1);
	}
	public void remove(int x){
		//swap with last and remove last o(1)
		int last = arr.get(arr.size()-1);
		if(last == x){
			arr.remove(arr.size()-1);
			hash.remove(x);
		}
		else{
		int index = hash.get(x);
		Collections.swap(arr, index, arr.size()-1);
		arr.remove(arr.size()-1);
		
		hash.remove(x);
		System.out.println("Print last index " + last + " "+ index);
		hash.put(last, index);
		}
		//return index;
	}
	public int get(int x){
		int index=hash.get(x);
		return arr.get(index);
	}
	public boolean search(int x){
		if(hash.get(x) != null){
			return true;
		}		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNumber rn = new RandomNumber();
		rn.add(50);
		rn.add(60);
        rn.add(70);
        System.out.println(rn.get(60));
        rn.remove(70);
        System.out.println(rn.search(70));
	}

}
