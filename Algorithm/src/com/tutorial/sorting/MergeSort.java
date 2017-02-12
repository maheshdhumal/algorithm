/**
 * 
 */
package com.tutorial.sorting;

/**
 * @author mahesh
 *
 */
public class MergeSort {
	
	public int[] sort(int[] A,int left,int right)
	{
		if(left==right)
		{
			return A;
		}
		else
		{
			int mid=(left+right)/2;
			sort(A,left,mid);
			sort(A,mid+1,right);
			merge(A,left,mid,right);
		}
		return A;
	}

	private void merge(int[] Array, int left,int mid, int right) {
		int[] A= new int[Array.length];
		for(int i=left;i<=right;i++)
		{
			A[i]=Array[i];
		}
		
		int i=left;
		int j=mid+1;
		int k=left;
		while(i<=mid && j <= right)
		{
			if(A[i] <= A[j])	
			{
				Array[k]=A[i];
				k=k+1;
				i=i+1;
			}
			else
			{
				Array[k]=A[j];
				k=k+1;
				j=j+1;
			}
		}
		while(i<=mid)
		{
			Array[k]=A[i];
			k++;
			i++;
		}
	}
	
	public static void main(String[] args)
	{
		int[] A={11,2,13,7,4,1,9,3,5,6};
		MergeSort mergeSort=new MergeSort();
		A=mergeSort.sort(A,0,7);
		for (int z=0;z<8;z++)
		{
		System.out.println("  "+A[z]);
		}
	}

}
