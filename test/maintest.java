package com.az.test;

import java.util.*;

public class maintest {

	// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED

	
	    class Coordinates{
	        int x;
	        int y;
	        Coordinates(int x, int y){
	            this.x =x;
	            this.y = y;
	        }
	        public int getxCord() {
				return x;
			}

			public int getyCord() {
				return y;
			}
	    }
	   
	    List<Coordinates> movedCrates = new ArrayList<Coordinates>();

		public List<Coordinates> moveToNew(int N,List<Coordinates> cratesToMove, int M)
		{
			
			if(M<=N)
			{
				Collections.sort(
		                cratesToMove,
		                (crate1, crate2) -> 
		                (int)(Math.sqrt((crate1.getxCord()*crate1.getxCord())+(crate1.getyCord()*crate1.getyCord())))
		                        - (int)(Math.sqrt((crate2.getxCord()*crate2.getxCord())+(crate2.getyCord()*crate2.getyCord()))));
				
				for(int i=0;i<M;i++)
				{
					movedCrates.add(cratesToMove.get(i));
				}
				
				return movedCrates;
			}
			else
			{
				System.out.println("Oops, old WareHouse do not have "+M+"crates");
				return null;
			}
		}
	
	    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    List<List<Integer>> closestLocations(int totalCrates, 
	                                         List<List<Integer>> allLocations, 
	                                         int truckCapacity)
		{
	        // WRITE YOUR CODE HERE
	        List<List<Integer>> result = new ArrayList();
	        HashMap<Integer, List<Coordinates>> hash = new HashMap();
	        int[] tempArr = new int[allLocations.size()];
	        int j =0;
	        for(List<Integer> list : allLocations ){
	            int x = list.get(0);
	            int y = list.get(1);
	            int distance = (int)Math.sqrt(x*x+y*y);
	            tempArr[j++] = distance;
	            if(hash.get(distance) == null){
	                hash.put(distance, new ArrayList());
	            }
	            hash.get(distance).add(new Coordinates(x,y));
	        }
	        //sort temparray
	        Arrays.sort(tempArr);
	        int l=0;
	        for(int i : tempArr){
	            if(l>truckCapacity){
	                break;
	            }
	            for(Coordinates arr: hash.get(i)){
	                result.add((List<Integer>) arr);
	                l++;
	            }
	        }
	        return result;
	    }
	    // METHOD SIGNATURE ENDS
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
