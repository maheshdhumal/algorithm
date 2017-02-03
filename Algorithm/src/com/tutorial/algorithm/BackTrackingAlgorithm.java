/**
 * 
 */
package com.tutorial.algorithm;

/**
 * @author maheshd
 *
 */
public class BackTrackingAlgorithm {
	
	
	public static void main(String[] args)
	{
		findKT();
	}
	
	public static void findKT()
	{
		int[][] sol= new int[8][8];
		int x=0;
		int y=0;
		int move=1;
		sol[0][0]=0;
		if(findKTUtil(x,y,move,sol))
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					System.out.println(""+sol[i][j]);
				}
				System.out.println("\n");
			}
		}
		else
		{
			System.out.println("Could not print");
		}
		
		
	}
	
	
	private static boolean findKTUtil(int x,int y,int move,int[][]sol)
	{

		if (move == 64) {
			return true;
		}
		 int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
	    int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

		for (int k = 0; k < 8; k++) {
			x = x + xMove[k];
			y = y + yMove[k];
			if (isSafe(x, y, sol)) {
				sol[x][y] = move;
				if (findKTUtil(x, y, move + 1, sol)) {
					return true;
				} else {
					sol[x][y] = 0;
				}
			}

		}

		return false;
	}


	private static boolean isSafe(int x, int y,int[][]sol) {
		if (x < 0 || x > 7 || y < 0 || y > 7|| sol[x][y]!=0)
			return false;
		else
			return true;
	}
	


}
