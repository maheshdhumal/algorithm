/**
 * 
 */
package com.tutorial.stack;

import java.util.Stack;

/**
 * @author mahesh
 *
 */
public class StackAlgorithms {
	
	private MyStack myStack;
	
	public void setMyStack(MyStack myStack) {
		this.myStack = myStack;
	}

	public MyStack getMyStack() {
		return myStack;
	}
	
	private void eveluatePostFix(String exp)
	{
		String[] expression=exp.split(" ");
		myStack=new MyStack(expression.length);
		for(int i=0;i<expression.length;i++)
		{
			if(isNumeric(expression[i]))
			{
				myStack.push(expression[i]);
			}
			
			else
			{
				Integer b =Integer.parseInt(""+myStack.pop());
				Integer a=Integer.parseInt(""+myStack.pop());
				Integer c=evaluate(expression[i], a, b);
				myStack.push(c.toString());
				
			}
		}
		System.out.println(""+myStack.pop());
	}
	
	private void evelauatePrefix(String exp)
	{
		String[] expression=exp.split(" ");
		myStack=new MyStack(expression.length);
		for(int i=expression.length-1;i>-1;i--)
		{
			if(isNumeric(expression[i]))
			{
				myStack.push(expression[i]);
			}
			
			else 
			{
				Integer b =Integer.parseInt(""+myStack.pop());
				Integer a=Integer.parseInt(""+myStack.pop());
				Integer c=evaluate(expression[i], b, a);
				myStack.push(c.toString());
				
			}
		}
		System.out.println(""+myStack.pop());
	}
	
	private String infixToPostfix(String exp)
	{
		String[] expression=exp.split(" ");
		myStack=new MyStack(expression.length);
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<expression.length;i++)
		{
			if(!isNumeric(expression[i]))
			{
				if(expression[i].equals("("))
				{
					myStack.push(expression[i]);
				}
				else if(expression[i].equals(")"))
				{
					while(!myStack.peek().equals("("))
					{
						stringBuffer.append(myStack.pop());
					}
					myStack.pop();
				}
				else if(myStack.getTop()!=-1)
				{
				  while(myStack.getTop()!=-1 && priority(myStack.peek()) >= priority(expression[i]))
				  {
					  stringBuffer.append(myStack.pop()); 
				  }
				  myStack.push(expression[i]);
				}
				
			}
			
			else 
			{
				stringBuffer.append(expression[i]); 
			}
		}
		while(myStack.getTop()!=-1)
		{
			stringBuffer.append(myStack.pop());
		}
		
		return stringBuffer.toString();
	}
	
	private Integer evaluate(String operator,Integer a,Integer b)
	{
		switch(operator)
		{
		   case "+":
			return a+b;   
		   case "-":
			return a-b;     
		   case "*":
			return a*b;     
		   case "/":
			return a/b;     
		   case"^":
			   int i= (int) Math.pow(a, b);
			   return (Integer)i; 
		}
		return 0;
	}
	
	private Integer priority(String operator)
	{
		switch(operator)
		{
		   case "+":
		   case "-":
			return 1;     
		   case "*":
		   case "/":
			return 2;     
		   case"^":
			return 3;   
		}
		return 0;
	}
	
	private boolean isNumeric(String charElement)
	{
		switch(charElement)
		{
		   case "+":
		   case "-":
		   case "*":
		   case "/":
		   case "^":
		   case "(":
		   case ")":
		   return false;
		   default: return true;   
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		StackAlgorithms stackAlgorithms=new StackAlgorithms();
		//stackAlgorithms.eveluatePostFix("( A + B / c * ( D + E ) - F)");
		/*stackAlgorithms.evelauatePrefix("+ + 2 * 3 2 / 10 2");
		System.out.println(""+s);
		stackAlgorithms.eveluatePostFix("2 3 2 * * 10 2 / +");*/
		//String s= stackAlgorithms.infixToPrefix("2 + 3 * 2 + 10 / 2");
		//System.out.println(""+s);
		String s=stackAlgorithms.infixToPostfix("( A + B / c * ( D + E ) - F )");
		System.out.println(""+s);
	}

	private String infixToPrefix(String exp) 
	{
		
		String[] expression=exp.split(" ");
		StringBuffer buffer=new StringBuffer();
		for(int i=expression.length-1;i>=0;i--)
		{
			buffer.append(expression[i]+" ");
		}
		return infixToPostfix(buffer.toString());
	}
}
