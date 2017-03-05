/**
 * 
 */
package com.tutorial.queue;

import java.util.LinkedList;

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

	public void findMaximumSubArray(int k,int[] aElement)
	{
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		for(int i=0;i<k;i++)
		{
			while(!linkedList.isEmpty() && aElement[i] > aElement[linkedList.peekLast()])
			{
				linkedList.removeLast();
			}
			linkedList.addLast(i);
		}
		for(int i=k;i<aElement.length;i++)
		{
			int count=linkedList.peekFirst();
			System.out.println(""+aElement[count]);
			if(count==i-k)
			{
				linkedList.removeFirst();
			}
			while(!linkedList.isEmpty() && aElement[i] > aElement[linkedList.peekLast()])
			{
				linkedList.removeLast();
			}
			linkedList.addLast(i);
		}
		System.out.println(""+aElement[linkedList.removeFirst()]);
		
	}
	
	public void findSumOfMaxAndMinSubArray(int k,int[] aElement)
	{
		LinkedList<Integer> maxLinkedList=new LinkedList<Integer>();
		LinkedList<Integer> minLinkedList=new LinkedList<Integer>();
		for(int i=0;i<k;i++)
		{
			while(!maxLinkedList.isEmpty() && aElement[i] > aElement[maxLinkedList.peekLast()])
			{
				maxLinkedList.removeLast();
			}
			while(!minLinkedList.isEmpty() && aElement[i] < aElement[minLinkedList.peekLast()])
			{
				minLinkedList.removeLast();
			}
			maxLinkedList.addLast(i);
			minLinkedList.addLast(i);
		}
		for(int i=k;i<aElement.length;i++)
		{
			int max=maxLinkedList.peekFirst();
			int min=minLinkedList.peekFirst();
			System.out.println(""+(aElement[max]+aElement[min]));
			if(max==i-k)
			{
				maxLinkedList.removeFirst();
			}
			while(!maxLinkedList.isEmpty() && aElement[i] > aElement[maxLinkedList.peekLast()])
			{
				maxLinkedList.removeLast();
			}
			maxLinkedList.addLast(i);
			
			
			if(min==i-k)
			{
				minLinkedList.removeFirst();
			}
			while(!minLinkedList.isEmpty() && aElement[i] < aElement[minLinkedList.peekLast()])
			{
				minLinkedList.removeLast();
			}
			minLinkedList.addLast(i);
			
			
		}
		System.out.println(""+(aElement[maxLinkedList.removeFirst()]+aElement[minLinkedList.removeFirst()]));
		
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
		int[] aElement= {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		myQueue.findMaximumSubArray(4, aElement);
		myQueue.findSumOfMaxAndMinSubArray(4, aElement);
	}
}
