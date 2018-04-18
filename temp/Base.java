package com.az.temp;

public class Base {
  private static int count = 0;
  
  public Base(){
	  count++;
  }
  
  public int getCount(){
	  return count;
  }
}
