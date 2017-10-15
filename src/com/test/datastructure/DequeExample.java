package com.test.datastructure;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DequeExample {

	public static void main(String[] args) {

		Deque<String> dq = new LinkedList<String>();
		Queue<String> q = new LinkedList<String>();
		
	
		
		dq.add("E1-tail");
		dq.addFirst("E2-head");
		dq.addLast("E3-tail");
		dq.offer("E4-tail");
		dq.offerFirst("E5-head");
		dq.offerLast("E6-tail");
		dq.push("E7-head");
		
		System.out.println(dq);
		
		Iterator it = dq.iterator();
		
		System.out.println("Head To Tail");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("Tail to head");
		Iterator rit = dq.descendingIterator();
		while(rit.hasNext()){
			System.out.println(rit.next());
		}
	}

}
