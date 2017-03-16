/**
 * 
 */
package com.tutorial.heap;

/**
 * @author mahesh
 *
 */
public class Heap {
	
	int[] array;
	int count;
	int capacity;
	int heap_type;
	
	public Heap(int capacity,int heap_type)
	{
		this.capacity=capacity;
		this.heap_type=heap_type;
		this.count=0;
		this.array=new int[capacity];
	}
	
	public int parent(int i)
	{
		return i <=0 || i>=this.count ?-1 :(i-1)/2;
	}
	
	public int leftChild(int i)
	{
		int left=2*i+1;
		return left >= this.count ? -1:left;
	}
	
	public int rightChild(int i)
	{
		int right=2*i+2;
		return right >= this.count ? -1:right;
	}
	
	public int getMaximum()
	{
		return this.count == 0 ? -1:array[0];
	}
	
	public int[] percolateDown(int i)
	{
		int l,r,max,temp;
		l=leftChild(i);
		max=l!=-1 && array[l] > array[i] ? l:i;
		r=rightChild(i);
		max=r!=-1 && array[r] > array[max] ? r:max;
		if(max!=i)
		{
			temp=array[max];
			array[max]=array[i];
			array[i]=temp;
			percolateDown(max);
		}
		return array;
	}
	
	public static void main(String[] args)
	{
		Heap heap=new Heap(6,1);
		int[] harray ={11,12,10,8,6,4};
		heap.array=harray;
		heap.count=5;
		heap.array=heap.percolateDown(0);
		for(int i=0;i < heap.array.length;i++)
		{
			System.out.println(""+heap.array[i]);
		}
	}
}
