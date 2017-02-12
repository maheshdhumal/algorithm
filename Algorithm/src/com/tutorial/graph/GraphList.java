/**
 * 
 */
package com.tutorial.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mahesh
 *
 */
public class GraphList {
	
	int verticeCount;
	List[] nodes;
	
	public GraphList(int vericeCount) {

		this.verticeCount=vericeCount;
		nodes=new List[verticeCount];
		initialise();
	}
	
	private void initialise() {
		for(int i=0;i<verticeCount;i++)
		{
			nodes[i]=new ArrayList<Integer>();
		}
	}

	private void addEdge(int u,int v)
	{
		if(u>=0 && u < verticeCount && v>=0 && v < verticeCount)
		{
			nodes[u].add(v);
			nodes[v].add(u);
		}
	}
	
	private void printGraph()
	{
		for(int i=0;i<verticeCount;i++)
		{
			for(Object obj:nodes[i] )
			{
				System.out.print(" "+(Integer)obj);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		GraphList graphList=new GraphList(5);
		graphList.addEdge( 0, 1);
		graphList.addEdge( 0, 4);
		graphList.addEdge( 1, 2);
		graphList.addEdge( 1, 3);
		graphList.addEdge( 1, 4);
		graphList.addEdge( 2, 3);
		graphList.addEdge( 3, 4);
		graphList.printGraph();
	}

}
