package com.az.binarysearch;

public class findNthroot {

	  static double root(double x, int n) {
	      // your code goes here
	      return binarysearch(x,0,x,n);
	    }
	  
	  static double binarysearch(double x, double min, double max, int num ){
	    double mid = (min+max)/2;
	    double temp = 1;
	    for(int i=0; i<num; i++){
	        temp *= mid;
	    }
	    double margin = temp - x;
	    if(margin > 0.0001){
	       max = mid;
	      return binarysearch(x,min,max,num);
	    }
	    else if(margin < -0.0001){
	      min = mid;
	      return binarysearch(x,min,max,num);
	    }
	     return mid;
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(root(9,2));

	}

}
