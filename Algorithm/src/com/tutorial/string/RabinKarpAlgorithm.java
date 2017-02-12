/**
 * 
 */
package com.tutorial.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author mahesh
 *
 */
public class RabinKarpAlgorithm {
	
	
	static String s, sub;
	static long pHash=0;
	static long prime=7;

	
	public static void main(String[] args)
	{
		s = "findaneedleinahaystack";
        sub="needle";
        for(int i=0;i<sub.length();i++)
        pHash=hash(sub, i, pHash);
	    System.out.println("Match found at index "+match(s, sub));
	}


	private static int match(String s, String sub) {
		
		long cHash=0;
		long lastHash=0;
		for(int i=0;i<s.length();i++)
		{
		cHash=hash(s,i,lastHash);
		lastHash=cHash;
		if(cHash==pHash)
		{
			return i-sub.length();
		}
		}	
		
		return -1;
	}


	private static long hash(String str, int i, long lastHash) {
		if(i>=sub.length())
		{
			lastHash=(lastHash-str.charAt(i-sub.length()))/prime;
			return (long) (lastHash+str.charAt(i)*Math.pow(prime, sub.length()-1));
		}
		else
		{
			return (long) (lastHash+str.charAt(i)*Math.pow(prime, i));
		}
	}

	
	
}
