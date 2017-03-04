/**
 * 
 */
package com.tutorial.queue;

/**
 * @author mahesh
 *
 */
public class KQueue {
	
	
	int[] rear;
	int[] front;
	int[] next;
	int[] array;
	int free;
	
	public KQueue(int k,int n)
	{
		rear=new int[k];
		front=new int[k];
		next=new int[n];
		array=new int[n];
		free=0;
		for(int i=0; i < n-1;i++)
		{
			next[i]=i+1;
		}
		next[n-1]=-1;
		for(int i=0; i <k;i++)
		{
			front[i]=-1;
		}
		for(int i=0; i <k;i++)
		{
			rear[i]=-1;
		}
	}
	
	public void enqueue(int element, int k)
	{
		if(isFull())
		{
			throw new RuntimeException("Queue is full");
		}
		int i=free;
		free=next[i];
		array[i]=element;
		if(isEmpty(k))
		{
			front[k]=i;
		}
		else
		{
			next[rear[k]]=i;
		}
		next[i]=-1;
		rear[k]=i;
		System.out.println(+element+" is added to "+k);
	}
	
	private boolean isFull() {
		return free==-1 ? true: false;
	}

	public int dequeue(int k)
	{
		if(isEmpty(k))
		{
			throw new RuntimeException("Queue is empty");
		}
		int i=front[k];
		int element=array[i];
		front[k]=next[i];
		next[i]=free;
		free=i;
		System.out.println(+element+" is removed from "+k);
		return element;
	}

	private boolean isEmpty(int k) {
		return  front[k]==-1 ? true: false;
	}
	

	public static void main(String[] args)
	{
		KQueue kQueue=new KQueue(3, 10);
		kQueue.enqueue(11, 0);
		kQueue.enqueue(12, 1);
		kQueue.enqueue(13, 2);
		kQueue.enqueue(14, 0);
		kQueue.enqueue(15, 2);
		kQueue.enqueue(16, 1);
		kQueue.enqueue(17, 2);
		kQueue.enqueue(18, 1);
		kQueue.enqueue(19, 0);
		kQueue.enqueue(20, 2);
		kQueue.dequeue(2);
		kQueue.dequeue(1);
		kQueue.dequeue(0);
		kQueue.dequeue(0);
		kQueue.dequeue(1);
		kQueue.dequeue(2);
		kQueue.dequeue(2);
		kQueue.dequeue(2);
		kQueue.dequeue(2);
		kQueue.enqueue(21, 0);
	}
	
}
