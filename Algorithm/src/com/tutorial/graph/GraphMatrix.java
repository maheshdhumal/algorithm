/**
 * 
 */
package com.tutorial.graph;

/**
 * @author mahesh
 *
 */
public class GraphMatrix {
	
	int verticesCount;
	int[][] adjc;
	
	public GraphMatrix(int verticesCount) {
		this.verticesCount=verticesCount;
		adjc=new int [verticesCount][verticesCount];
		this.initialiseGraph();
	}
	
	private void initialiseGraph()
	{
		for(int i=0;i < verticesCount;i++)
		{
			for(int k=0;k<verticesCount;k++)
			{
				adjc[i][k]=0;
			}
		}
	}

	private void addEdge(int u,int v) throws Exception
	{
		if(u>=0 && u < verticesCount && v>=0 && v < verticesCount)
		{
			adjc[u][v]=1;
			adjc[v][u]=1;
		}
		else
		{
			throw new Exception("Vertice is not valid");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		GraphMatrix graphMatrix=new GraphMatrix(5);
		graphMatrix.addEdge( 0, 1);
		graphMatrix.addEdge( 0, 4);
		graphMatrix.addEdge( 1, 2);
		graphMatrix.addEdge( 1, 3);
		graphMatrix.addEdge( 1, 4);
		graphMatrix.addEdge( 2, 3);
		graphMatrix.addEdge( 3, 4);
		graphMatrix.printGraph();
	}

	private void printGraph() 
	{
		for(int i=0;i < verticesCount;i++)
		{
			for(int k=0;k<verticesCount;k++)
			{
				System.out.print(" "+adjc[i][k]);
			}
			System.out.println();
		}
	}
}
