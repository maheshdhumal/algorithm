/**
 * 
 */
package com.tutorial.divideandconquer;


/**
 * @author mahesh
 *
 */
public class MaximumSubArray {

	
	public static void main(String[] args)
	{
		int[] A={100,60,110,85,105,102,86,63,81,101,94,107,101,79,94,90,97};
		int[] change=calculateChange(A);
		int max=findMaximumSubArray(change,0,change.length-1);
		System.out.println("Maximum sum is "+max);
		
		
	}
	
	private static int findMaximumSubArray(int[]change,int low,int high)
	{
		if(low==high)
		{
			return change[low];
		}
		
		else
		{
			int mid=(low+high)/2;
			int total = findMaxCrossing(change, low, high, mid);
			int left=findMaximumSubArray(change, low, mid);
			int right=findMaximumSubArray(change, mid+1, high);
			return findMax(right,left,total);
		}
		
		
		
	}

	private static int findMaxCrossing(int[] change, int low, int high, int mid) {
		int sum=0;
		int leftSum=0;
		for(int i=mid;i>=low;i--)
		{
			sum=sum + change[i];
			if(leftSum < sum)
			{
				leftSum=sum;
			}
		}
		int rightSum=0;
		sum=0;
		for(int i=mid+1;i<high;i++)
		{
			sum=sum+change[i];
			if(rightSum < sum)
			{
				rightSum=sum;
			}
		}
		return leftSum+rightSum;
	}

	private static int findMax(int rightSum, int leftSum, int max) {
		max=Math.max(max, leftSum);
		max=Math.max(max, rightSum);
		return max;
	}

	

	private static int[] calculateChange(int[] A) {
		int[] change=new int[A.length-1];
		for(int i=1;i<A.length;i++)
		{
			change[i-1]=A[i]-A[i-1];
			System.out.print(" "+change[i-1]);
		}
		return change;
	}
}
