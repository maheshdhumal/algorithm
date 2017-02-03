package com.tutorial.algorithm;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm {
	
	public static void main(String[] args)
	{
		String pattern="ABC";
		String text="ABAABBCABCD";
		int length=pattern.length()-1;
		Map<Character, Integer> shiftMap=badCharHeruestic(pattern,pattern.length());
		int index=searchPattern(text, pattern, length, shiftMap);
		System.out.println("------"+index);
			
	}
	
	public static Map badCharHeruestic(String pattern,int length)
	{
		Map<Character, Integer> shiftMap=new HashMap<Character,Integer>();
		Integer index;
		for(int i=0;i<length;i++)
		{
			if (!shiftMap.containsKey(pattern.charAt(i))) {

				if(i!=(length-1))
				{
				index=length-i-1;
				shiftMap.put(pattern.charAt(i), index);
				}
				else
				{
					shiftMap.put(pattern.charAt(i), length);
				}
			}
		}
		
		return shiftMap;
		
	}
	
	public static int searchPattern(String text,String pattern,int length,Map<Character, Integer> shiftMap)
	{
		if (length > text.length()) {
			return -1;
		}
		int l=length;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(pattern.length()-1 - i) != text.charAt(l - i)) {
				if (shiftMap.containsKey(text.charAt(length-i))) {
					l = length + shiftMap.get(text.charAt(length-i));
					searchPattern(text, pattern, l, shiftMap);
				} else {
					l = length + pattern.length();
					searchPattern(text, pattern, l, shiftMap);
				}
			}

		}

		return l;

	}

}
