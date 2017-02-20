/**
 * 
 */
package com.tutorial.stack;

/**
 * @author mahesh
 *
 */
public class MyStack {
	
	private int top;
	private int size;
	private String[] array;
	
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	
	public MyStack(int size)
	{
		this.size=size;
		array=new String[size];
		top=-1;
	}
	
	public void push(String element)
	{
		if(top==(size-1))
		{
			throw new RuntimeException("Stack overflow");
		}
		top=top+1;
		array[top]=element;
	}
	
	public String pop()
	{
		if(top==-1)
		{
			throw new RuntimeException("Stack is empty");
		}
		String element=array[top];
		array[top]="";
		top=top-1;
		return element;
	}
	
	
	public String peek()
	{
		if(top==-1)
		{
			throw new RuntimeException("Stack is empty");
		}
		String element= array[top];
		return element;
	}

	
	public static void main(String args[])
	{
		
	}
}
