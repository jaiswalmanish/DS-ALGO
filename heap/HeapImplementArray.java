package com.az.heap;

import java.util.Arrays;

public class HeapImplementArray {
	private int size;
	private int[] arr;
	
	public HeapImplementArray(){
		size = 0;
		arr = new int[10];
	}
	
	public void add(int x){
		checkArraySize();
		arr[size] = x;
		size++;
		heapyup();
	}
	
	private void heapyup() {
		int index = size -1;
		while(hasParent(index) && arr[getParentIndex(index)] > arr[index]){
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
		
	}

	private void swap(int index, int parentIndex) {
		int temp = arr[index];
		arr[index] = arr[parentIndex];
		arr[parentIndex] = temp;		
	}

	private int getParentIndex(int index) {
		if(hasParent(index)){
			return (index - 1)/2;
		}
		return -1;
	}

	private boolean hasParent(int index) {
		int pindex = (index - 1)/2;
		if(pindex >= 0)
			return true;
		return false;
	}

	private void checkArraySize() {
		if(arr.length==size){
		   arr=Arrays.copyOf(arr, size*2);
		}				
	}

	public int poll(){
		//exception if array is null
		int res = arr[0];
		arr[0] = arr[size -1];
		size--;
		heapydown();
		return res;
	}
	
	private void heapydown() {
		int index = 0;
        while(hasLeftChild(index)){
        	int smallerChild = getLeftChildIndex(index);
        	if(hasRightChild(index) && arr[getRightChildIndex(index)]<arr[smallerChild])
        		smallerChild = getRightChildIndex(index);
        	if(arr[smallerChild]<arr[index]){
        		swap(smallerChild, index);
        		index = smallerChild;
        	}
        	else{
        		break;
        	}
        }	
		
	}

	private int getRightChildIndex(int index) {
		return (index * 2 + 2);
	}

	private boolean hasRightChild(int index) {
		if(getRightChildIndex(index)<(size-1))
			return true;
		return false;
	}

	private int getLeftChildIndex(int index) {
		return (index * 2 + 1);
	}

	private boolean hasLeftChild(int index) {
		if(getLeftChildIndex(index)<(size -1))
			return true;
		return false;
	}

	public int peek(){
		return arr[0];
	}
	
	public int size(){
		return size;
	}
	

	public static void main(String[] args) {
		HeapImplementArray testHeap = new HeapImplementArray();
		testHeap.add(5);
		testHeap.add(8);
		testHeap.add(2);
		testHeap.add(7);
		testHeap.add(1);
		testHeap.add(4);
		System.out.println(testHeap.size());
		System.out.println(testHeap.peek());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.size());
		System.out.println(testHeap.peek());
	}

}
