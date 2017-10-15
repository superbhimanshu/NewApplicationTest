package com.test.linkedlist;



public class FindStartOfLoopInLinkedList {

	public static void main(String[] args) {
		Node n = new Node("a");
		n.next = new Node("b");
		n.next.next = new Node("c");
		n.next.next.next = new Node("d");
		n.next.next.next.next=n.next.next.next;
		
		
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
	
	public static Node findStartingOfLoop(Node n){
		Node slow = n;
		Node fast = n;
		boolean loopDetected = false;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				loopDetected =true;
				break;
			}
		}
		if(loopDetected){
			slow=n;
			while(fast!=null && fast.next!=null){
				slow=slow.next;
				fast=fast.next;
				if(fast==slow){
					break;
				}
			}
		}
		return slow;
	}
}
