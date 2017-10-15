package com.test.linkedlist;

import com.test.linkedlist.LinkedListReversal.Node;

public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		Node n = new Node("a");
		n.next = new Node("b");
		n.next.next = new Node("c");
		n.next.next.next = new Node("d");
		n.next.next.next.next=n.next.next.next;
		
		System.out.println(isLoopPresent(n));
		
	}
	
	public static boolean isLoopPresent(Node n){
		boolean isPresent = false;
		Node singleMove = n;
		Node doubleMove = n;
		int count=0;
		while(doubleMove !=null && doubleMove.next!=null ){
			if(singleMove==doubleMove && count!=0){
				isPresent =true;
				break;
			}
			singleMove = singleMove.next;
			doubleMove=doubleMove.next.next;
			count++;
		}
		
		
		return isPresent;
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
