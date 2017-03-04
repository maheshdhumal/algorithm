/**
 * 
 */
package com.tutorial.queue;

/**
 * @author mahesh
 *
 */
public class MyQueue {
	
	int front;
	int rear;
	int size;
	int[] array;
	
	public MyQueue(int n)
	{
		size=0;
		array=new int[n];
		front=-1;
		rear=-1;
	}
	
	public void enqueue(int element)
	{
		if(size >= array.length)
		{
			throw new RuntimeException("Queue is full");
		}
		if(front==-1)
		{
			front++;
		}
		rear=(rear+1)%array.length;
		array[rear]=element;
		size++;
		System.out.println(+element+" is added");
	}
	
	public int dequeue()
	{
		if(size <= 0)
		{
			throw new RuntimeException("Queue is empty");
		}
		int element=array[front];
		front=(front+1)%array.length;
		size--;
		System.out.println(+element+" is removed");
		return element;
	}

	
	public static void main(String[] args)
	{
		MyQueue myQueue=new MyQueue(6);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(6);
		myQueue.dequeue();
		myQueue.enqueue(7);
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
	}
}
