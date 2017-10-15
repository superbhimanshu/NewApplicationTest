package LRUTest.practice;

import java.util.HashMap;

public class LRUCachePractice1 {

	static int capacity;
	static Node head;
	static Node end;
	
	 static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	
	public static void main(String[] args) {

	}
	
	public static Node getVal(Integer key){
		Node n=null;
		if (map.containsKey(key)){
			n = map.get(key);
			remove(n);
			setHead(n);
		}
		return n;
	}
	
	public static void remove(Node n){
		if(n==head){
			n.next.pre=null;
			head = n.next;
			n.next=null;
		}
		if(n.pre!=null){
			n.pre.next = n.next;
		}
		
	}
	public static void setHead(Node n){
		if(head==null){
			head=n;
			n.pre=null;
			end =n;
		}
	}

}

class Node {
	int value;
	Node pre;
	Node next;
}
