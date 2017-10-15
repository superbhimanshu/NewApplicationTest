package com.test.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TrieSolution {

    public static Trie contacts = new Trie();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of operations :");
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<String> lstOperations = new ArrayList<String>();
        for(int i=0;i<N;i++){
            System.out.println("Enter operation :");
            String operation = sc.nextLine();
            lstOperations.add(operation);
            
        }
        
        for (int  i=0;i<N;i++){
        	String operation = lstOperations.get(i);
            String methodName = operation.substring(0,operation.indexOf(' ')); 
            String name = operation.substring(operation.indexOf(' ')+1);
            
            switch(methodName){
            	case "add" :
            		addWord(name);
            		break;
            	case "search" :
            		ArrayList<String> lst = search(name);
					if (lst != null && lst.size() > 0) {
						for (int j = 0; j < lst.size(); j++) {
							System.out.print(lst.get(j) + " ");
						}
					}
					System.out.println();
            		break;
            	default :
            		System.out.println("Invalid Operation");
            		break;
            }
            
        }
    }
    
    public static void addWord(String s){
        HashMap<Character, Trie> children = contacts.children;
        
        for(int i=0; i<s.length();i++){
            Character c = s.charAt(i);
            Trie t;
            if(children.containsKey(c)){
                t= children.get(c);
            }else {
                t = new Trie();
                children.put(c,t);
            }
            
            children= t.children;
            if(i==s.length()-1){
                t.isWord = true;
                t.word=s;
            }
        }
        
    }
    
    public static ArrayList<String> search(String queryString){
        ArrayList<String> lst = new ArrayList<String>();
        HashMap<Character, Trie> children= contacts.children;
        for(int i=0;i<queryString.length();i++){
            Character c  = queryString.charAt(i);
            Trie t;
            if(!children.containsKey(c)){
                return lst;
            }else {
                t = children.get(c);
                children = t.children;
            }
            
            if(i==queryString.length()-1){
                dfs(t, lst);
            }
        }
        return lst;
    }
    
    public static void dfs(Trie t, ArrayList<String> lst){
        if(t==null){
            return;
        }
        if(t.isWord){
            lst.add(t.word);
        }
        
        if(t.children!=null && t.children.size()>0){
            Iterator it = t.children.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair =  (Map.Entry)it.next();
                Trie temp = (Trie)pair.getValue();
                dfs(temp, lst);
            }
        }
    }
    static class Trie {
        char c;
        HashMap<Character, Trie> children = new HashMap<Character, Trie>();
        boolean isWord;
        String word;
 
        public Trie() {}
 
        public Trie(char c){
            this.c = c;
        }
        
    }
}
