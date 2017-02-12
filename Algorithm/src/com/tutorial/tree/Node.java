/**
 * 
 */
package com.tutorial.tree;

/**
 * @author maheshd
 *
 */
public class Node {
	
	private int data;
	private boolean isVisited;
	private Node left;
	private Node right;
	
	public Node(int data)
	{
		this.data=data;
	}
	
	public Node()
	{
		this.data=data;
	}
		
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isVisited() {
		return isVisited;
	}
}
