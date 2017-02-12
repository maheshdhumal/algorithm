/**
 * 
 */
package com.tutorial.string;


/**
 * @author mahesh
 *
 */
public class KMPAlgorithm {
	
	private static String text;
	private static String pattern;
	
	public static void main(String[] args)
	{
		text="abcdddfababcdabcaee"; 
		pattern="abcdabca";
		match(text,pattern);
	}

	
	private static void match(String text,String pattern)
	{
		int j=0;
		int[] function=function(pattern);
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)==pattern.charAt(j))
			{
				if(j==pattern.length()-1)
				{
					System.out.println("Match Found At :"+ (i-(pattern.length()+1)));
					return;
				}
				j++;
			}
			else if(j>0)
			{
				 j=function[j-1];
				 i--;
			}
		}
		System.out.println("Match Not Found");
	}
	
	private static int[] function(String pattern)
	{
		int[] function =new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++)
		{
			if(pattern.charAt(j)==pattern.charAt(i))
			{
				function[i]=j+1;
				j++;
			}
			else if(j>0)
			{
				j=function[j-1];
				i--;
			}
		}
		return function;
		
	}
}
