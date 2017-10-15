package com.test.amzQuestions.Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class CommonUrlpathPractice1 {

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

	private static void commonUrl(List<LogLine> data) {

		for(LogLine l : data) {
			if(mp.containsKey(l.userId)){
				if(mp.get(l.userId).size()==2){
					
					String s = mp.get(l.userId).get(0) + mp.get(l.userId).get(1) + l.path;
					if(inverseLookup.containsKey(s)){
						inverseLookup.put(s, inverseLookup.get(s) + 1);
					}else{
						inverseLookup.put(s, 1);
					}
					mp.get(l.userId).remove(0);
				}
				mp.get(l.userId).add(l.path);
			}else{
				List<String> val = new ArrayList<String>();
				val.add(l.path);
				mp.put(l.userId, val);
			}
		}
		
		SortedSet<Map.Entry<String,Integer>> sorted = new TreeSet<Map.Entry<String,Integer>>(
				new Comparator<Map.Entry<String,Integer>>(){
					@Override
					public int  compare(Map.Entry<String, Integer> e1, Map.Entry<String,Integer> e2){
						return e2.getValue().compareTo(e1.getValue());
					}
				});
		
		sorted.addAll(inverseLookup.entrySet());
		
		Iterator it = sorted.iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
	}

	static class LogLine {
		public int userId;
		public String path;
		public LogLine(int userId, String path){
			this.userId = userId;
			this.path=path;
		}
	}

}
