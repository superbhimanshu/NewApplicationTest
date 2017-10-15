package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

	LinkedList<WordNode> queue = new LinkedList<WordNode>();
	
	public List<List<String>> combinations(Set<String> dict, String start, String end) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(start==null || end == null || dict ==null || dict.size()==0) {
			
			System.out.println("Invalid");
		}
		
		dict.add(end);
		queue.add(new WordNode(start, 1, null));
		
		
        int minStep = 0;
        
        HashSet<String> visited = new HashSet<String>();  
        HashSet<String> unvisited = new HashSet<String>();  
        unvisited.addAll(dict);
 
        int preNumSteps = 0;

		while (!queue.isEmpty()) {
			
			WordNode top  =  queue.remove();

			String str = top.word;
			int currNumSteps = top.numStep;
			
			if(str.equals(end)){
				if(minStep==0){
					minStep = top.numStep;
				}
				
                if(top.numStep == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
  //              return top.numStep;
            }
			
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }
            
            preNumSteps = currNumSteps;

			
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {

				for (char c = 'a'; c <= 'z'; c++) {
					char tmp = arr[i];
					if(arr[i] != c) {
						arr[i] = c;
					}
					String str2 = new String(arr);
					if(unvisited.contains(str2)) {
						queue.add(new WordNode(str2, top.numStep +1, top));
						visited.add(str2);
					}
					arr[i] = tmp;
				}
			}
		}
		
		return result;

	}
	
	public static void main(String[] args) {
		Set<String> d = new HashSet<String>();
		d.add("hot");
		d.add("dot");
		d.add("dog");
		d.add("lot");
		d.add("log");
		
		WordLadder2 wl = new WordLadder2();
		List<List<String>> result = wl.combinations(d, "hit", "cog");
		
	}
	
}

class WordNode {
	String word;
	int numStep;
	WordNode pre;
	

	public WordNode(String word, int numStep) {
		this.word = word;
		this.numStep = numStep;
		
	}
	
	public WordNode(String word, int numStep, WordNode pre){
		this.word=word;
		this.numStep = numStep;
		this.pre = pre;
	}
	
	public String toString(){
		return word + " " + numStep + ",";
	}
}
