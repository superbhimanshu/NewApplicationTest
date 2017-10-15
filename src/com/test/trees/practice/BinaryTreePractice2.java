package com.test.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePractice2 {

	static Node root;
	public static void main(String[] args) {

	}
	
	public static Node insert(Node root, int val){
		if (root==null){
			root=new Node(val);

		}else if(root.left==null){
			root.left = insert(root.left, val);
		}else if(root.right==null){
			root.right = insert(root.right,val);
		}
		
		return root;
	}
	
	//left root right
	public static void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.println(root.val);
			inOrder(root.right);
		}
	}
	
	//bfs level order traversal
	public static void levelOrderTraversal(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if(root==null){
			return;
		}
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.println(n.val);
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}

	public static int countNode(Node root){
		if(root==null){
			return 0;
		}
		int leftCount = countNode(root.left);
		int rightCount = countNode(root.right);
		return leftCount + rightCount +1;
	}
	
	public static boolean search(Node root, int val){
		if(root==null)
			return false;
		if(root.val==val){
			return true;
		}else if(search(root.left,val)){
			return true;
		}else if(search(root.right,val)){
			return true;
		}
		
		return false;
	}
}

class Node {
	int val;
	Node left;
	Node right;
	public Node(int val){
		this.val = val;
	}
}