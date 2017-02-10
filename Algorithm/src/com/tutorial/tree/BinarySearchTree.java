/**
 * 
 */
package com.tutorial.tree;

import java.util.Stack;

/**
 * @author maheshd
 *
 */
public class BinarySearchTree {
	
	private Node root;
	
	public void setRoot(Node root) {
		this.root = root;
	}
	public Node getRoot() {
		return root;
	}
	
	public Node constructBST(Node root,int key)
	{
		if(root==null)
		{
			return new Node(key);
		}
		
		if(root.getData() > key)
		{
			Node node=constructBST(root.getLeft(), key);
			root.setLeft(node);
		}
		else
		{
			Node node=constructBST(root.getRight(), key);
			root.setRight(node);
		}
			
	   return root;
	}
	
	private void findAncestors(Node root,int key1,int key2)
	{
		if(key1 < root.getData() && root.getData() < key2)
		{
			System.out.println(" "+root.getData());
		}
		else
		{
			if(root.getData() < key1)
			{
				findAncestors(root.getRight(), key1, key2);
			}
			else if(root.getData() > key2)
			{
				findAncestors(root.getLeft(), key1, key2);
			}
		}
	}
	
	private void merge(Node root1,Node root2)
	{
		Stack<Node> elements1=new Stack<Node>(); 
		while(root1!=null)
		{
			elements1.push(root1);
			root1=root1.getLeft();
		}
		
		Stack<Node> elements2=new Stack<Node>(); 
		while(root2!=null)
		{
			elements2.push(root2);
			root2=root2.getLeft();
		}
		Node node1=elements1.pop();
		Node node2=elements2.pop();
		while(!(elements1.isEmpty() && elements2.isEmpty()))
		{
			if(node1==null)
			{
				node1=elements1.pop();
			}
			if(node2==null)
			{
				node2=elements2.pop();
			}
			
			if(node1.getData() > node2.getData())
			{
				System.out.println(""+node2.getData());
				if(node2.getRight()!=null)
				{
					node2=node2.getRight();
					while(node2!=null)
					{
						elements2.push(node2);
						node2=node2.getLeft();
					}
				}
				node2=null;
				
			}
			else
			{
				System.out.println(""+node1.getData());
				if(node1.getRight()!=null)
				{
					node1=node1.getRight();
					while(node1!=null)
					{
						elements1.push(node1);
						node1=node1.getLeft();
					}
				}
				node1=null;
				
			}
		}
		
	}
	
	private void mergeByRecursion(Node node1,Node node2)
	{
		if(node1==null)
		{
			return;
		}
		if(node2==null)
		{
			return;
		}
		
		if(node1.getData() > node2.getData())
		{
			mergeByRecursion(node1.getLeft(), node2);
			inOrderByRecursion(node2);
			mergeByRecursion(node1, node2.getRight());
			
		}
		else if(node1.getData() < node2.getData())
		{
			mergeByRecursion(node1, node2.getLeft());
			inOrderByRecursion(node1);
			mergeByRecursion(node1.getRight(), node2);
			
		}
		
		System.out.println(" "+node1.getData());
		System.out.println(" "+node2.getData());
		
	}
	
	private void inOrderByRecursion(Node node)
	{
		if(node==null)
		{
			return;
		}
		inOrderByRecursion(node.getLeft());
		if(!node.isVisited())
		{
		 System.out.println(" "+node.getData());
		 node.setVisited(true);
		}
		//inOrderByRecursion(node.getRight());
	}
		
	private void inOrder(Node root)
	{
		Stack<Node> elements=new Stack<Node>(); 
		while(root!=null)
		{
			elements.push(root);
			root=root.getLeft();
		}
		while(!elements.isEmpty())
		{
			Node node=elements.pop();
			System.out.println(""+node.getData());
			if(node.getRight()!=null)
			{
			  node=node.getRight();	
			  while(node!=null)
			  {
				  elements.push(node);
				  node=node.getLeft();
			  }
			}
		}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		BinarySearchTree binaryTree=new BinarySearchTree();
		int[] input={4,2,1,3,6,5,7,8,9};
		binaryTree.root=null;
		for(int i=0;i<input.length;i++)
		{
			binaryTree.root=binaryTree.constructBST(binaryTree.root,input[i]);
		}
		//binaryTree.findAncestors(binaryTree.root, 1, 3);
		
		int[] input1={8,2,1,4,6,10,14,18,16};
		Node root1=null;
		for(int i=0;i<input1.length;i++)
		{
			root1=binaryTree.constructBST(root1,input1[i]);
		}
		
		int[] input2={5,3,0,7,9,13,11,15};
		Node root2=null;
		for(int i=0;i<input2.length;i++)
		{
			root2=binaryTree.constructBST(root2,input2[i]);
		}
		//binaryTree.inOrder(root1);
		binaryTree.mergeByRecursion(root1, root2);
		
	}

}
