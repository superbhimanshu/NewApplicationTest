package com.test.linkedlist;



public class FindMiddleElementInLinkedList {

	public static void main(String[] args) {
		Node n = new Node("a");
		n.next = new Node("b");
		n.next.next = new Node("c");
		n.next.next.next = new Node("d");
		n.next.next.next.next = new Node("e");
		n.next.next.next.next.next = new Node("f");
		n.next.next.next.next.next.next = new Node("g");
		Node mid = middleElement(n);
		System.out.println(mid);
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
	
	public static Node middleElement(Node head){
		
		Node fastNode = head;
		Node slowNode = head;
		while(fastNode!=null && fastNode.next!=null){
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode;
		
	}
}
