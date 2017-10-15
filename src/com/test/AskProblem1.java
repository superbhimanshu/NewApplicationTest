package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AskProblem1 {

	public static void main(String[] args) {
		BufferedReader br =null;
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("enter file path");
//		String filePath = sc.next();
		String filePath ="/Users/hverma/Documents/workspace/NewApplicationTest/textInput.txt";
		Map<String, List<Integer>> strLineNumMap = new HashMap<String, List<Integer>>();
		
		Map<Integer, String> lineNumStrMap = new HashMap<Integer, String>();
		
		try {

			String sCurrentLine;
			Integer count = 0;

			br = new BufferedReader(new FileReader(filePath));

			while ((sCurrentLine = br.readLine()) != null) {
				sCurrentLine = sCurrentLine.replaceAll("[^a-zA-Z ]", "").toLowerCase();
				lineNumStrMap.put(count, sCurrentLine);
				String[] words = sCurrentLine.split(" ");
				for (String word : words) {
					if(strLineNumMap.containsKey(word)) {
						strLineNumMap.get(word).add(count);
					}else {
						List<Integer> abc = new ArrayList<Integer>();
						abc.add(count);
						strLineNumMap.put(word, abc);
					}
				}
				count++;
			}
			
			System.out.println("enter text value");
//			sc.nextLine();
			String query = sc.nextLine();
			query = query.replaceAll("[^a-zA-Z ]", "").toLowerCase();
			String[] queries = query.split(" ");
			List<Integer> ls = null;
			List<Integer> ids = null;
			Integer ct=0;
			for (String qr : queries) {
				ids = strLineNumMap.get(qr);
				if(ct == 0 && ids !=null && !ids.isEmpty())
					ls = new ArrayList<Integer>(ids);
				
				if(ct > 0)
					ls.retainAll(ids);
				ct++;

				
			}
			if(ls != null  && !ls.isEmpty()) {
				for(Integer l : ls ) {
					System.out.println(lineNumStrMap.get(l));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
