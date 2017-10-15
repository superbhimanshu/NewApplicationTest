package com.test.trees;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class TreeTest {

	Node root;

	List<Integer> inOrderList = new ArrayList<Integer>();
	List<Integer> postOrderList = new ArrayList<Integer>();

	
	public void addNode(int key, String name) {
		Node newNode= new Node(key, name);
		if (root == null) {
			root = newNode;

		}else {
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(parent.leftChild!=null && parent.rightChild!=null) {
					focusNode = focusNode.leftChild;
					continue;
				}
				focusNode = focusNode.leftChild;
				if(focusNode==null) {
					parent.leftChild =newNode;
					return;
				}else {
					focusNode = focusNode.rightChild;
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
/*	public Node insertNode(Node focusNode, Node newNode){
		if(focusNode.rightChild==null) {
			focusNode.rightChild = insertNode()
		}
	}*/
	
	
	public void addNodeBinarySearchTree(int key, String name) {
		Node newNode = new Node(key, name);

		if (root == null) {
			root = newNode;

		} else {

			Node focusNode = root;

			Node parent;
			while (true) {
				parent = focusNode;

				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return; // All Done
					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			 System.out.println(focusNode);
			inOrderList.add(focusNode.key);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			// System.out.println(focusNode);
			inOrderList.add(focusNode.key);

		}

	}

	public Node findNode(int key) {

		Node focusNode = root;
		while (focusNode.key != key) {

			if (key < focusNode.key) {

				focusNode = focusNode.leftChild;

			} else {
				focusNode = focusNode.rightChild;

			}

			if (focusNode == null)
				return null;
		}

		return focusNode;

	}

	public static void main (String[] args) {

		TreeTest theTree = new TreeTest();

//		theTree.addNode(50, "Boss");
//
//		theTree.addNode(25, "Vice President");
//
//		theTree.addNode(15, "Office Manager");
//
//		theTree.addNode(30, "Secretary");
//
//		theTree.addNode(75, "Sales Manager");
//
//		theTree.addNode(85, "Salesman 1");
		try{
		theTree.addNode(2, "a");

		theTree.addNode(7, "b");

		theTree.addNode(5, "c");

		theTree.addNode(2, "d");

		theTree.addNode(6, "e");

		theTree.addNode(9, "f");
		
		theTree.addNode(5, "g");

		theTree.addNode(11, "h");

		theTree.addNode(4, "i");

		// Different ways to traverse binary trees

		 theTree.inOrderTraverseTree(theTree.root);
		}catch(Throwable e){
			System.out.println(getStackTrace(e));
		}
		

		// theTree.preorderTraverseTree(theTree.root);

	//	theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		// System.out.println("\nNode with the key 75");

		// System.out.println(theTree.findNode(75));

	}
	
	public static String getStackTrace(Throwable e) {
		if (e == null) {
			return null;
		}
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}

	
	public static Node lowestCommonAncestor(Node root, int a, int b) {
	    if (root == null) {
	        return null;
	    }
	    
	    if ((root.key == a) || (root.key ==b)) { 
	        // if at least one matched, no need to continue
	        // this is the LCA for this root
	        return root;
	    }

	    Node l = lowestCommonAncestor(root.leftChild, a, b);
	    Node r = lowestCommonAncestor(root.rightChild, a, b);

	    if (l != null && r != null) {
	    	return root;  // nodes are each on a seaparate branch
	    }

	    // either one node is on one branch, 
	    // or none was found in any of the branches
	    return l != null ? l : r;
	}
}

class Node {

	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	public String toString() {

		return name + " has the key " + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}
	

}