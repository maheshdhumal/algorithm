/**
 * 
 */
package com.tutorial.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maheshd
 *
 */

class BFSAlgorithm {
	private int V;
	private LinkedList<Integer> adj[];

	BFSAlgorithm(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	void BFS(int s, Queue<Integer> visited) {
		if (visited.size() == V) {
			return;
		}
		LinkedList<Integer> linkedList = adj[s];
		if (!visited.contains(s)) {
			visited.add(s);
			System.out.println(" " + s);
		}
		Iterator<Integer> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (!visited.contains(element)) {
				visited.add(element);
				System.out.println(" " + element);
			}
		}
		Iterator<Integer> iteratorNew = linkedList.iterator();
		while (iteratorNew.hasNext()) {
			Integer element = iteratorNew.next();
			BFS(element, visited);
		}

	}

	void DFS(int s, Queue<Integer> visited,int parent) {
		if (visited.size() == V) {
			return;
		}
		LinkedList<Integer> linkedList = adj[s];
		if (!visited.contains(s)) {
			visited.add(s);
			System.out.println(" " + s);
		}
		Iterator<Integer> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (!visited.contains(element)) {
				visited.add(element);
				System.out.println(" " + element);
				DFS(element, visited,s);
			}
			else
			{
				if(parent!=element)
				{
					System.out.println("Cycle is detected at "+element);
				}
			}
			
		}

	}

	// Driver method to
	public static void main(String args[]) {
		BFSAlgorithm g1 = new BFSAlgorithm(5);

		g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 0);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		Queue<Integer> visited = new LinkedList<Integer>();
		//g1.BFS(2, visited);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		Queue<Integer> visited1 = new LinkedList<Integer>();
		g1.DFS(4, visited1,0);
	}
}