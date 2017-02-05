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
		binaryTree.findAncestors(binaryTree.root, 1, 3);
	}

}
