package com.test.linkedlist;



//http://www.java2blog.com/2016/04/java-program-to-reverse-linked-list-in.html
public class ReverseLinkedListInPairs {

	public static void main(String[] args) {
		Node n = new Node("a");
		n.next = new Node("b");
		n.next.next = new Node("c");
		n.next.next.next = new Node("d");
		
		Node p = pairwiseReversal(n);
		System.out.println(p);
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
	
	public static Node pairwiseReversal(Node head){
		Node current=head;
		Node temp=null;
		Node newHead = null;
		while(current!=null && current.next!=null){
			if(temp!=null){
				temp.next.next=current.next;
				
			}
			temp=current.next;
			current.next=temp.next;
			temp.next=current;
			if(newHead==null)
				newHead=temp;
			current = current.next;
		}
		return newHead;
	}

}
