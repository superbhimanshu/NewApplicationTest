package com.test.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Write a function to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
//A tree is "superbalanced" if the difference between the depths of any two leaf nodes ↴ is no greater than one.
public class SuperBalancedBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode bt = new BinaryTreeNode(7);
		bt.left = new BinaryTreeNode(5);
		bt.right = new BinaryTreeNode(4);
		bt.left.left = new BinaryTreeNode(8);
		bt.left.right = new BinaryTreeNode(1);
		bt.right.left = new BinaryTreeNode(10);

		printLeafNodes(bt);

	}

	public static boolean isBalanced(BinaryTreeNode node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null) {
			return true;
		}

		/* Get the height of left and right sub trees */
		lh = depth2(node.left);
		rh = depth2(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		}

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	public void printTree(BinaryTreeNode tmpRoot) {

		Queue<BinaryTreeNode> currentLevel = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> nextLevel = new LinkedList<BinaryTreeNode>();

		int totalLevel = 0;
		int firstLeafLevel = 0;
		boolean isFirstLeaf = true;
		currentLevel.add(tmpRoot);

		while (!currentLevel.isEmpty()) {
			Iterator<BinaryTreeNode> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				BinaryTreeNode currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				if (currentNode.left == null && currentNode.right == null) {
					if (isFirstLeaf) {
						firstLeafLevel = totalLevel;
						isFirstLeaf = false;
					}
				}
				System.out.print(currentNode.value + " ");
			}
			System.out.println();
			totalLevel++;
			currentLevel = nextLevel;
			nextLevel = new LinkedList<BinaryTreeNode>();

		}

		if (totalLevel - firstLeafLevel >= 2) {
			System.out.println("tree not balanced");
		} else {
			System.out.println("tree  balanced");
		}

	}

	public static int depth2(BinaryTreeNode node) {
		if (node == null)
			return 0;
		int left = depth2(node.left);
		int right = depth2(node.right);

		int x = left > right ? left + 1 : right + 1;
		return x;
	}

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}

	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if (root == null) {
			return root;
		}
		if (root.value == a.value || root.value == b.value) {
			return root;
		}
		BinaryTreeNode left = lowestCommonAncestor(root.left, a, b);
		BinaryTreeNode right = lowestCommonAncestor(root.right, a, b);

		// if we get left and right not null it is lca for a and b
		if (left != null && right != null) {
			return root;
		}
		if (left == null)
			return right;
		else
			return left;
	}

	public static void reverseLevelOrderTraversal(BinaryTreeNode root) {

		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();

		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.right != null) {
				q.add(temp.right);
			}
			if (temp.left != null)
				q.add(temp.left);
			st.push(temp);
		}

		while (!st.isEmpty()) {
			System.out.println("" + st.pop().value);
		}
	}

	public static void printLeafNodes(BinaryTreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.value);
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
}
