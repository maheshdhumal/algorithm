package com.tutorial.tree;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author maheshd
 *
 */


public class TreeData {
	
	private Node root;
	private int height;
	private int max;
	private int min;
	private int diameter;
	
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
	
	private boolean searchNode(Node root,int data,boolean found)
	{
		if(root==null)
		{
			return false; 
		}
		if(root.getData()==data)
		{
			return true;
		}
		boolean foundLeft=searchNode(root.getLeft(), data,found);
		boolean foundRight=searchNode(root.getRight(), data,found);
		return (foundLeft || foundRight);
	}
	
	private Node deleteNode(Node root,int data)
	{
		if (root == null) {
			return root;
		}
		if (root.getData() == data) {
			if(root.getRight()==null && root.getLeft()==null)
			{
				root=null;
			}
			else if (root.getLeft() != null && root.getLeft().getRight() != null) {
				Node rightMostNode = findRightMostNode(root.getLeft());
				root.setData(rightMostNode.getData());
			} 
			else if (root.getLeft() != null) 
			{
				Node rightSide=root.getRight();
				root = root.getLeft();
				root.setRight(rightSide);
			}
			else if(root.getLeft()==null)
			{
				root=root.getRight();
			}
			return root;
		}
		Node rootLeft = deleteNode(root.getLeft(), data);
		Node rootRight = deleteNode(root.getRight(), data);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		return root;
		
	}
	
	private int findDiameter(Node root)
	{
		if(root==null)
		{
			return 0 ;
		}
		int dLeft=findDiameter(root.getLeft());
		int dRight=findDiameter(root.getRight());
		if(this.diameter < (dLeft+dRight))
		{
			this.diameter=(dLeft+dRight+1);
		}
		return dLeft > dRight ? dLeft+1 : dRight+1;
	}
	

	private Node findRightMostNode(Node root) {
		if(root==null)
		{
			return null;
		}
		Node right=findRightMostNode(root.getRight());
		if(right==null)
		{
			return root;
		}
		if(right==root.getRight())
		{
			root.setRight(right.getLeft());
		}
		return right;
	}
	
	private void levelTraversalWithQueue(Node root)
	{
		Queue<Node> queueNode = new LinkedList<Node>();
		queueNode.add(root);
		while (!queueNode.isEmpty()) {
			Node fromQueue = queueNode.poll();
			System.out.println(" " + fromQueue.getData());
			if (fromQueue.getLeft() != null) {
				queueNode.add(fromQueue.getLeft());
			}
			if (fromQueue.getRight() != null) {
				queueNode.add(fromQueue.getRight());
			}
		}
	}
	
	private void levelTraversalWithOutQueue(Node root)
	{
		findHeight(root, 0);
		for(int i=0;i<=this.height;i++)
		{
			traverse(root,i);
		}
	}

	private void traverse(Node root, int i) {

		if(root==null)
		{
			return;
		}
		if(i==0)
		{
			System.out.println(" "+root.getData());
		}
		else
		{
			traverse(root.getLeft(),i-1);
			traverse(root.getRight(), i-1);
		}
	}
	
	private void inOrderTraversalWithOutRecursion(Node root)
	{
		Node current;
		Node pre;
		Node post;
		current = root;
		while (current != null) {
			if (current.getLeft() != null) {
				post=current;
				pre = current.getLeft();
				while (pre.getRight() != null) {
					pre = pre.getRight();
				}
				current = current.getLeft();
				post.setLeft(null);
				pre.setRight(post);
				
			} else {
				System.out.println(" "+current.getData());
				current = current.getRight();
			}
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
		System.out.println("**** Is Tree Balance **** "+tree.isBalance(tree.root, 0));
		System.out.println("******Node Found******"+tree.searchNode(tree.root, 4,false));
		Node newRoot=tree.deleteNode(tree.root, 7);
		tree.inOrder(newRoot);
		tree.findDiameter(tree.root);
		System.out.println("**** Daimeter is "+tree.diameter);
		System.out.println("**** Level Traversal with Queue **** ");
		tree.levelTraversalWithQueue(tree.root);
		System.out.println("**** Level Traversal without Queue **** ");
		tree.levelTraversalWithOutQueue(tree.root);
		System.out.println("**** InOrder Traversal without Recursion and Stack **** ");
		tree.inOrderTraversalWithOutRecursion(tree.root);
		
	}

}
