package com.az.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Check {
	
	public Collection<Integer> getKSmallest(List<Integer> list, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		//Arrays.sort(list);
		
		for(int i: list){
	        if(pq.size() <=k){
	             pq.add(i);  
	        }
	        else if(pq.peek()>i){
	           pq.poll();
	           pq.add(i);        
	        }     
	            
	      }
		
		
		return pq;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Check c1 = new Check();
		int k =2;
		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(3);
		l.add(-6);
		l.add(2);
		l.add(-1);
		l.add(2);
		l.add(0);
		l.add(0);

		for(int i :c1.getKSmallest(l, k)){
			System.out.println("k small " + i);
		}
		Base b = new Base();
		
		System.out.println(b.getCount());
		
		Base c = new Base();
		
		System.out.println(b.getCount());
		System.out.println(c.getCount());

	}

}
