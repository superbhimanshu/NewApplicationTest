package com.test.linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class ReverserLinkList {

	public static String str = "abc def jacks lasga";
	public static Node head = null;
	public static Node tail = null;
	
	public static void main(String[] args) {
		
		String[] splits =  str.split(" ");
		List<String> abc = Arrays.asList(splits);
		
		Collections.reverse(abc);
	
		String nw = StringUtils.join(abc, " ");
		
		System.out.println( nw);

		ReverserLinkList obj = new ReverserLinkList();
	    head = obj.new Node();
	    head.value =1;
	    head.next = obj.new Node();
	    head.next.value=2;
	    head.next.next = obj.new Node();
	    head.next.next.value =3;
	    head.next.next.next = obj.new Node();
	    head.next.next.next.value = 4;
	    recursiveReverse(head);
	    
	    System.out.println(tail);
	    System.out.println(tail.next);
	    System.out.println(tail.next.next);
	    System.out.println(tail.next.next.next);
	}

	class Node {
		int value=0;
		Node next =null;
		
		public String toString() {
			return  "value = " + value;
		}
		
	}
	
	
	public static void recursiveReverse(Node currentNode )
	{  
	 //check for empty list 
	 if(currentNode == null)
	    return;

	/* if we are at the TAIL node:
	    recursive base case:
	 */
	if(currentNode.next == null) 
	{ 
	//set HEAD to current TAIL since we are reversing list
	tail = currentNode; 
	return; //since this is the base case
	}

	recursiveReverse(currentNode.next);
	currentNode.next.next = currentNode;
	currentNode.next = null; //set "old" next pointer to NULL
	}
}
