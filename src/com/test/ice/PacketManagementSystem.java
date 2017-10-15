package com.test.ice;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Himanshu Verma
 *
 */
public class PacketManagementSystem {

	//using priorityblockingqueue to add new packets in order of their priority
	public static PriorityBlockingQueue<Packet> pqRouter = new PriorityBlockingQueue<>(1, new Comparator<Packet>(){
		@Override
		public int compare(Packet p1, Packet p2){
			if(p2.isManagementData() && !p1.isManagementData()){
				return 1;
			}else if(p1.isManagementData() && !p2.isManagementData()){
				return -1;
			}else if(p2.isLarge() && !p1.isLarge()){
				return 1;
			}else if(p1.isLarge() && !p2.isLarge()){
				return -1;
			}else if(p2.getTimestamp() < p1.getTimestamp()){
				return 1;
			}else {
				return -1;
			}
		}
	});
	
	public static void main(String[] args) {
		
	 /*========= Test Application with Main Thread ==========*/
		//Main Thread calls example
/*		addPacket(new Packet(true,false));
		addPacket(new Packet(true,true));
		addPacket(new Packet(true,true));
		addPacket(new Packet(true,false));
		addPacket(new Packet(false,false));
		
		remove();
		remove();
		remove();
		remove();
		remove(); */
		
		
		/*==========Testing Application with Multithreads ==============*/
		//Producer Consumer Example - where producer adds the packets and consumer removes them
		
	     Thread prodThread = new Thread(new Producer(pqRouter));
	     Thread consThread = new Thread(new Consumer(pqRouter));

	     //Starting threads
	     prodThread.start();
	     consThread.start();		

	}
	

	//Add Packet to the system	
	public static void addPacket(Packet p){
		pqRouter.add(p);		
		System.out.println("Added Packet: " + p);
	}
	
	//Remove packet from the system
	public static Packet remove(){
		Packet removedHighestPriorityElement = pqRouter.poll();
		System.out.println("Removed Packet: " + removedHighestPriorityElement);
		return removedHighestPriorityElement;
	}
	
	//Producer Class
	static class Producer implements Runnable {

		private final PriorityBlockingQueue pdQueue;

		public Producer(PriorityBlockingQueue pq) {
			this.pdQueue = pq;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				boolean isManagementData = Math.random() < 0.5;
				boolean isLarge = Math.random() <0.5;
				Packet packet  = new Packet(isManagementData, isLarge);
				pdQueue.add(packet);
				System.out.println("Packet Produced :" + packet);
			}
		}
	}
	
	
	//Consumer Class
	static class Consumer implements Runnable{

	    private final PriorityBlockingQueue consQueue;

	    public Consumer (PriorityBlockingQueue pq) {
	        this.consQueue = pq;
	    }
	  
	    @Override
	    public void run() {
	        while(true){
	                try {
	                	Thread.sleep(1000);
						System.out.println("Packet Consumed: "+ consQueue.take());
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
	        }
	    }
	}

}
