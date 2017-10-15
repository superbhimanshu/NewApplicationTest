package com.test.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedListReversal {

	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		
		Node n = new Node("a");
		n.next = new Node("b");
		n.next.next = new Node("c");
		n.next.next.next = new Node("d");
		reverse(l);
		Node reverN= reverse(n);
		System.out.println(reverN);
	}

	private static Node reverse(Node currentNode) {
		
		//for first node previous node is null
		Node previousNode = null;
		Node nextNode;
		while(currentNode!=null){
			nextNode=currentNode.next;
			//reverse the link
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode= nextNode;
		}
		return previousNode;
		
	}
	
	public static Node recursiveReverse(Node node){
		if(node==null || node.next==null)
			return node;
		Node remaining = recursiveReverse(node.next);
		node.next.next = node;
		node.next=null;
		return remaining;
	}

	private static void reverse(List<String> l) {

		Collections.reverse(l);
		
	}
	
	public static class Node{
		
		Node next;
		String val;
		
		public Node(String val){
			this.val = val;
		}
		public String toString(){
			return this.val;
		}
	}
}
