package com.test.amzQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

// Given a website request log, compute the most common three step sequence taken by all users through the application.
//
//For example, given this request log:
//
//UserID,Path
//1,/login
//2,/home
//2,/browse
//1,/home
//1,/search
//1,/product
//2,/product
//3,/home
//1,/cart
//3,/search
//3,/product
//
//The most common 3 step sequence through the application would be /home -> /search -> /product

public class CommonUrlPath {

	static Map<Integer, List<String>> mp = new HashMap<Integer, List<String>>();
	static Map<String,Integer> inverseLookup = new HashMap<String,Integer>();
	public static void main(String[] args) {
		List<LogLine> data = new ArrayList<LogLine>();
		data.add(new LogLine(1,"/login"));
		data.add(new LogLine(2,"/home"));
		data.add(new LogLine(2,"/browse"));
		data.add(new LogLine(1,"/home"));
		data.add(new LogLine(1,"/search"));
		data.add(new LogLine(1,"/product"));
		data.add(new LogLine(2,"/product"));
		data.add(new LogLine(3,"/home"));
		data.add(new LogLine(1,"/cart"));
		data.add(new LogLine(3,"/search"));
		data.add(new LogLine(3,"/product"));
		data.add(new LogLine(1,"/login"));
		data.add(new LogLine(1,"/login"));
		
		commonUrl(data);
		
	}

	static class LogLine {
		public int userId;
		public String path;
		public LogLine(int userId, String path){
			this.userId = userId;
			this.path=path;
		}
	}
	
	static List<String> commonUrl(List<LogLine> data){
		
		List<String> result = new ArrayList<String>();
		
		for(LogLine log : data){
			if(mp.containsKey(log.userId)){
				if(mp.get(log.userId).size()==2){
					String keyInvLookup="";
					for(String s : mp.get(log.userId)){
						keyInvLookup = keyInvLookup + s;
					}
					keyInvLookup=keyInvLookup + log.path;
					if(inverseLookup.containsKey(keyInvLookup)){
						inverseLookup.put(keyInvLookup, inverseLookup.get(keyInvLookup) + 1);
					}else {
						inverseLookup.put(keyInvLookup, 1);
					}
					
					mp.get(log.userId).remove(0);
					mp.get(log.userId).add(log.path);
				}else {
					mp.get(log.userId).add(log.path);
				}
			}else {
				List<String> newList = new ArrayList<String>();
				newList.add(log.path);
				mp.put(log.userId,newList);
			}
		}
		
		SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<Map.Entry<String, Integer>>(
	            new Comparator<Map.Entry<String, Integer>>() {
	                @Override
	                public int compare(Map.Entry<String, Integer> e1,
	                        Map.Entry<String, Integer> e2) {
	                    return e2.getValue().compareTo(e1.getValue());
	                }
	            });

	  sortedset.addAll(inverseLookup.entrySet());
	  
	  System.out.println(sortedset.first().getKey() + " " +sortedset.first().getValue());
	  
	  String[] str = sortedset.first().getKey().split("/");
		result = Arrays.asList(str);
		return result;
	}

}
