/**
 * 
 */
package com.tutorial.stack;

/**
 * @author mahesh
 *
 */
public class KStack {
	
	int[] array;
	int[] top;
	int[] next;
	int free;
	
	public KStack(int k,int n)
	{
		array=new int[n];
		top=new int[k];
		next=new int[n];
		free=0;
		for(int i=0;i <n-1;i++)
		{
			next[i]=i+1;
		}
		next[n-1]=-1;
		for(int i=0;i <k;i++)
		{
			top[i]=-1;
		}
	}

	public void push(int element,int k)
	{
		if(isFull())
		{
			throw new RuntimeException("Stack Overflow");
		}
		int i=free;
		free=next[i];
		next[i]=top[k];
		top[k]=i;
		array[i]=element;
		System.out.println(+element+" is added to "+k);
	}
	
	public int pop(int k)
	{
		if(isEmpty(k))
		{
			throw new RuntimeException(+k+" Stack is empty"); 
		}
		int i=top[k];
		int element=array[i];
		top[k]=next[i];
		next[i]=free;
		free=i;
		System.out.println(+element+" is removed from "+k);
		return element;
	}
	
	public int peek(int k)
	{
		if(isEmpty(k))
		{
			throw new RuntimeException(+k+" Stack is empty"); 
		}
		int i=top[k];
		int element=array[i];
		System.out.println(+element+" is top element of stack "+k);
		return element;
	}

	private boolean isFull() {
		return free==-1 ? true : false;
	}
	
	private boolean isEmpty(int k)
	{
		return top[k]==-1 ? true : false;
	}
	
	public static void main(String[] args)
	{
		KStack kStack=new KStack(3, 10);
		kStack.push(11, 0);
		kStack.push(12, 1);
		kStack.push(13, 2);
		kStack.push(14, 1);
		kStack.push(15, 2);
		kStack.push(16, 0);
		kStack.push(17, 2);
		kStack.push(18, 1);
		kStack.push(19, 0);
		kStack.push(20, 0);
		kStack.pop(1);
		kStack.pop(0);
		kStack.pop(2);
		kStack.pop(0);
		kStack.pop(1);
		kStack.pop(2);
		kStack.pop(0);
		kStack.pop(0);
		kStack.push(21, 0);
		kStack.peek(0);
		kStack.pop(0);
	}
}
