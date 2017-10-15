package com.test.trees;

import com.test.trees.SuperBalancedBinaryTree.BinaryTreeNode;

public class FindMaximumElementInBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode bt = new BinaryTreeNode(7);
		bt.left = new BinaryTreeNode(5);
		bt.right = new BinaryTreeNode(4);
		bt.left.left = new BinaryTreeNode(8);
		bt.left.right = new BinaryTreeNode(1);
		bt.right.left = new BinaryTreeNode(10);

		System.out.println(findMaximumElement(bt));
	}

	public static int findMaximumElement(BinaryTreeNode root){
		if(root==null){
			return 0;
		}
		int leftMax = findMaximumElement(root.left);
		int rightMax = findMaximumElement(root.right);
		
		return Math.max(Math.max(leftMax,rightMax), root.value);
		
		
	}
}
