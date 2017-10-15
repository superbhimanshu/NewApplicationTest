package com.test.intTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//input=  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
//output =   [(0, 1), (3, 8), (9, 12)]
//  [(1, 10), (2, 6), (3, 5), (7, 9)]

public class RangesFromIntegerTuples {

	public static void main(String[] args) {
		List<Tuple> input = new ArrayList<Tuple>();
		input.add(new Tuple(0,1));
		input.add(new Tuple(3,5));
		input.add(new Tuple(4,8));
		input.add(new Tuple(10,12));
		input.add(new Tuple(9,10));
		
		input.add(new Tuple(1,10));
		input.add(new Tuple(2,6));
		input.add(new Tuple(3,5));
		input.add(new Tuple(7,9));
		
		Collections.sort(input);
		for(int i=1; i<input.size(); ) {
			
			if(input.get(i).startTime <= input.get(i-1).endTime  && input.get(i).endTime > input.get(i-1).endTime){
				input.get(i-1).endTime = input.get(i).endTime;
				input.remove(i);
				i=1;
			}else if(input.get(i).startTime <= input.get(i-1).endTime  && input.get(i).endTime <= input.get(i-1).endTime){
				input.remove(i);
				i=1;
			}else{
				i++;
			}
		}
		System.out.println(input);
		
	}

	static class Tuple implements Comparable<Tuple>{

	    int startTime;
	    int endTime;

	    public Tuple(int startTime, int endTime) {
	        // number of 30 min blocks past 9:00 am
	        this.startTime = startTime;
	        this.endTime   = endTime;
	    }

	    public String toString() {
	        return String.format("(%d, %d)", startTime, endTime);
	    }
	    
	    public int compareTo(Tuple item) {
	        if (this.startTime < item.startTime) {
	            return -1;
	        }
	        else if(this.startTime > item.startTime){
	            return 1;
	        }

	        return 0;
	    }
	    
	}
}
