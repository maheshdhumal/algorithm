package com.tutorial.tree;
/**
 * @author maheshd
 *
 */
import com.tutorial.tree.Node;;


public class TreeData {
	
	private Node root;
	private int height;
	private int max;
	private int min;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root)
	{
		this.root = root;
	}

	public void inOrder(Node root)
	{
		if(root==null)
		{
			return ;
		}
		inOrder(root.getLeft());
		System.out.println(" "+root.getData());
		inOrder(root.getRight());
	}
	
	public void preOrder(Node root)
	{
		if(root==null)
		{
			return ;
		}
		System.out.println(" "+root.getData());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public void postOrder(Node root)
	{
		if(root==null)
		{
			return ;
		}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(" "+root.getData());
		
	}
	
	public void printLeafNodes(Node root)
	{
		if(root.getLeft()==null && root.getRight()==null)
		{
			System.out.println(""+root.getData());
			return ;
		}
		if (root.getLeft() != null) {
		printLeafNodes(root.getLeft());
		}
		if (root.getRight() != null) {
		printLeafNodes(root.getRight());
		}
		
	}
	
	public void findHeight(Node root,int h)
	{
		if (root.getLeft() == null && root.getRight() == null) {
			if (h > this.height) {
				this.height = h;
			}
			return;
		}
		if (root.getLeft() != null) {
			findHeight(root.getLeft(), h + 1);
		}
		if (root.getRight() != null) {
			findHeight(root.getRight(), h + 1);
		}
	}
	
	public boolean isBalance(Node root,int h)
	{
		findMinAndMaxHeight(root, h);
		System.out.println(" "+this.min);
		System.out.println(" "+this.max);
		return (this.max-this.min) > 1 ? false:true;
	}

	private void findMinAndMaxHeight(Node root, int h) {
		if (root.getLeft() == null && root.getRight() == null) {
			if (h > this.max) {
				this.max = h;
			}
			if(h<this.min)
			{
				this.min=h;
			}
			return;
		}
		if (root.getLeft() != null) {
			findMinAndMaxHeight(root.getLeft(), h + 1);
		}
		if (root.getRight() != null) {
			findMinAndMaxHeight(root.getRight(), h + 1);
		}
	}
	

	public static void main(String args[]) 
	{
		TreeData tree=new TreeData();
		tree.height=0;
		tree.max=0;
		tree.min=100;
		tree.setRoot(new Node(4));
		tree.getRoot().setLeft(new Node(2));
		tree.root.getLeft().setLeft(new Node(1));
		tree.root.getLeft().setRight(new Node(3));
		tree.getRoot().setRight(new Node(6));
		tree.root.getRight().setLeft(new Node(5));
		tree.root.getRight().setRight(new Node(7));
		tree.root.getRight().getRight().setRight(new Node(8));
		tree.root.getRight().getRight().getRight().setRight(new Node(9));
		System.out.println("**** Inorder **** ");
		tree.inOrder(tree.getRoot());
		System.out.println("**** Preorder **** ");
		tree.preOrder(tree.getRoot());
		System.out.println("**** Postorder **** ");
		tree.postOrder(tree.getRoot());
		System.out.println("**** Leaf Nodes **** ");
		tree.printLeafNodes(tree.getRoot());
		tree.findHeight(tree.getRoot(),0);
		System.out.println("**** Height **** "+tree.height);
		System.out.println("**** Height **** "+tree.isBalance(tree.root, 0));
		
		
	}

}
