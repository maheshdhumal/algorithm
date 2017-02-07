/**
 * 
 */
package com.tutorial.tree;

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
		leftMerge(root1, root2);
		rightMerge(root1,root2);
	}
	private void leftMerge(Node root1, Node root2) {
		if(root1==null||root2==null)
		{
			return;
		}
		if(root1.getData() > root2.getData())
		{
			leftMerge(root1.getLeft(),root2);
			inOrder(root2);
			leftMerge(root1.getLeft(),root2.getRight());
		}
		else
		{
			leftMerge(root1,root2.getLeft());
			inOrder(root1);
			leftMerge(root1.getRight(),root2.getLeft());
		}
	}
	
	private void rightMerge(Node root1, Node root2) {
		if(root1==null||root2==null)
		{
			return;
		}
		if(root1.getData() > root2.getData())
		{
			rightMerge(root1,root2.getRight());
			inOrder(root2);
			rightMerge(root1.getLeft(),root2.getRight());
		}
		else
		{
			rightMerge(root1.getRight(),root2);
			inOrder(root1);
			rightMerge(root1.getRight(),root2.getLeft());
		}
	}
	
	private void inOrder(Node root)
	{
		if(root==null || root.isVisited())
		{
			return;
		}
		inOrder(root.getLeft());
		System.out.println(""+root.getData());
		root.setVisited(true);
	}
	
	
	
	
	public static void main(String[] args)
	{
		BinarySearchTree binaryTree=new BinarySearchTree();
/*		int[] input={4,2,1,3,6,5,7,8,9};
		binaryTree.root=null;
		for(int i=0;i<input.length;i++)
		{
			binaryTree.root=binaryTree.constructBST(binaryTree.root,input[i]);
		}
		binaryTree.findAncestors(binaryTree.root, 1, 3);*/
		
		int[] input1={8,2,1,10};
		Node root1=null;
		for(int i=0;i<input1.length;i++)
		{
			root1=binaryTree.constructBST(root1,input1[i]);
		}
		
		int[] input2={5,3,0};
		Node root2=null;
		for(int i=0;i<input2.length;i++)
		{
			root2=binaryTree.constructBST(root2,input2[i]);
		}
		binaryTree.merge(root1, root2);
		
	}

}
