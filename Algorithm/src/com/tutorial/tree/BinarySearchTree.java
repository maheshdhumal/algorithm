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
	private void inOrderReverse(Node root)
	{
		Stack<Node> elements=new Stack <Node>();
		elements.push(root);
		while(root.getRight()!=null)
		{
			root=root.getRight();
			elements.push(root);
		}
		while(!elements.isEmpty())
		{
			Node node=elements.pop();
			System.out.println(""+node.getData());
			if(node.getLeft()!=null)
			{
				node=node.getLeft();
				elements.push(node);
				while(node.getRight()!=null)
				{
					node=node.getRight();
					elements.push(node);
				}
				
			}
		}
	}
	
	private void findPairByGivenSum(Node root,int sum)
	{
		
		Stack<Node> leftStack = new Stack<Node>();
		leftStack.push(root);
		Node leftNode = root.getLeft();
		while (leftNode != null) {
			leftStack.push(leftNode);
			leftNode = leftNode.getLeft();
		}

		Stack<Node> rightStack = new Stack<Node>();
		rightStack.push(root);
		Node rightNode = root.getRight();
		while (rightNode != null) {
			rightStack.push(rightNode);
			rightNode = rightNode.getRight();
		}
		while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
			if (leftNode == null) {
				leftNode = leftStack.pop();
			}
			if (rightNode == null) {
				rightNode = rightStack.pop();
			}
			if(leftNode.getData()==rightNode.getData())
			{
				break;
			}
			if (sum == (leftNode.getData() + rightNode.getData())) {
				System.out.println("Two Nodes Found" + leftNode.getData() + " "
						+ rightNode.getData());
				break;
			}
			if (sum > (leftNode.getData() + rightNode.getData())) {
				leftNode=leftNode.getRight();
				while(leftNode!=null)
				{
					leftStack.push(leftNode);
					leftNode = leftNode.getLeft();
				}
			} else {
				
				rightNode = rightNode.getLeft();
				while(rightNode!=null)
				{
					rightStack.push(rightNode);
					rightNode=rightNode.getRight();
				}
			}
		}

		System.out.println("Nodes Not Found");
	}
		
	private void swapIncorrectNodes(Node root,Node previous,Node first,Node second)
	{
		if(root==null)
		{
			return ;
		}
		
		swapIncorrectNodes(root.getLeft(),previous,first, second);
		if(previous!=null && previous.getData() > root.getData())
		{
			if(first==null)
			{
				first=previous;
				second=root;
			}
			else if(first!=previous)
			{
				second=previous;
				System.out.println("First Node" +first.getData());
				System.out.println("Second Node" +second.getData());
				int temp=first.getData();
				first.setData(second.getData());
				second.setData(temp);
			}
		}
		previous.setData(root.getData());
	    swapIncorrectNodes(root.getRight(),previous, first, second);
		if(previous!=null && previous.getData() > root.getData())
		{
			if(first==null)
			{
				first=previous;
				second=root;
			}
			else if(first!=previous)
			{
				second=previous;
				System.out.println("First Node" +first.getData());
				System.out.println("Second Node" +second.getData());
				int temp=first.getData();
				first.setData(second.getData());
				second.setData(temp);
			}
		}
	}
	
	private void correctBST(Node root)
	{
		root=swapNodes(root,null, null, null);
		System.out.println("****In order Traverse***");
		inOrder(root);
	}
	
	private Node swapNodes(Node root,Node previous,Node first,Node second)
	{
		Stack<Node> stack=new Stack<Node>();
		Node rootLeft=root;
		while(rootLeft!=null)
		{
			stack.push(rootLeft);
			rootLeft=rootLeft.getLeft();
		}
		
		while(!stack.isEmpty())
		{
			Node node=stack.pop();
			if(previous!=null && previous.getData() > node.getData())
			{
				if(first==null)
				{
					first=previous;
					second=node;
				}
				else if(first!=previous)
				{
					second=node;
					break;
				}
			}
			previous=node;
			Node right=node.getRight();
			while(right!=null)
			{
				stack.push(right);
				right=right.getLeft();
			}
		}
		System.out.println("First Node" +first.getData());
		System.out.println("Second Node" +second.getData());
		int temp=first.getData();
		first.setData(second.getData());
		second.setData(temp);
		return root;
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
		//binaryTree.mergeByRecursion(root1, root2);
		//binaryTree.findPairByGivenSum(root1, 9);
		root1.getLeft().setData(4);
		root1.getLeft().getRight().setData(2);
		binaryTree.correctBST(root1);
		
	}

}
