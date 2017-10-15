package com.test.graph.practice;

public class GraphPractice2 {

	static  Vertex[] adjList;
	static boolean[] isVisited = new boolean[adjList.length];
	public static void main(String[] args) {

	}

	public static void dfs(int index, boolean[] isVisited) {
		System.out.println(adjList[index].name);
		isVisited[index] = true;
		Neighbour temp = adjList[index].n;
		while(temp!=null){
			if(!isVisited[temp.vertIndex])
				dfs(temp.vertIndex, isVisited);
			temp = temp.next;
		}
		
	}
	
}

class Vertex {
	String name;
	Neighbour n;
}

class Neighbour {
	int vertIndex;
	Neighbour next;
}
