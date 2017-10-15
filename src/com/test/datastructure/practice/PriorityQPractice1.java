package com.test.datastructure.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQPractice1 {

	static Queue<Integer> pq = new PriorityQueue<Integer>(7, new Comparator<Integer>(){
		@Override
		public int compare(Integer a, Integer b){
			return b.compareTo(a);
		}
	});
	public static void main(String[] args) {

		Random rand = new Random();
		for(int i=0;i<10;i++){
			int j = rand.nextInt(100);
			System.out.print(j + " ");
			pq.add(j);
		}
		
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}

}
