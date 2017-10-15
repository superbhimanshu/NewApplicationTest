package com.test.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQExample {

	public static void main(String[] args) {
		
		Queue<Integer> priorityQ = new PriorityQueue<>(7);
		Random rand = new Random();
		for(int i=0;i<7;i++){
			priorityQ.add(new Integer(rand.nextInt(100)));
		}
		for(int i=0;i<7;i++){
			System.out.println(priorityQ.poll());
		}
	//	priorityQ.
		//priority queue with comparator
		Queue<Customer> pqCust = new PriorityQueue<>(7, new Comparator<Customer>(){
			@Override
			public int compare(Customer c1, Customer c2){
				return (int) (c1.getId()-c2.getId());
			}
		});
		
		addDataToQueue(pqCust);
		for(int i=0;i<7;i++){
			Customer c = pqCust.poll();
			System.out.println(c.name + " " + c.id );
		}
		
	}
	
	 private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
	        Random rand = new Random();
	        for(int i=0; i<7; i++){
	            int id = rand.nextInt(100);
	            customerPriorityQueue.add(new Customer(id, "cust "+id));
	        }
	    }
	
//	public static Comparator<Customer> idComparator = 
	
	static class Customer{
		int id;
		String name;
		public Customer(int i, String n){
			this.id=i;
			this.name = n;
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

}
