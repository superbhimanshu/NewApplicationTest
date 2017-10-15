package com.test.trees.practice;

public class BinaryTreePractice {

	static Node root;

	public static void main(String[] args) {
		root = insert(root, 1);
		insert(root, 5);
		insert(root, 6);

		inOrderTraversal(root);
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			if (root.left == null) {
				root.left = insert(root.left, val);
			} else if (root.right == null) {
				root.right = insert(root.right, val);
			}
		}
		return root;
	}

	public static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.val + " ");
		inOrderTraversal(root.right);
	}

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

	}
}
