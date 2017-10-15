package com.test.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	Vertex[] adjList;
	boolean[] trackVisit = new boolean[adjList.length];

	class Vertex {
		
		String name;
		Neighbour n;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Neighbour getN() {
			return n;
		}
		public void setN(Neighbour n) {
			this.n = n;
		}
		
		
	}
	
	class Neighbour {
		
		int vertexInd;
		Neighbour n;
		public int getVertexInd() {
			return vertexInd;
		}
		public void setVertexInd(int vertexInd) {
			this.vertexInd = vertexInd;
		}
		public Neighbour getN() {
			return n;
		}
		public void setN(Neighbour n) {
			this.n = n;
		}
	}
	
	
	public void dfs(int i, boolean[] trackVisit) {
		
		Vertex temp = adjList[i];

		trackVisit[i] = true;
		System.out.println("vertex name " + temp.getName());

		Neighbour tempN = temp.getN();
		while (tempN != null) {
			
			if(!trackVisit[tempN.vertexInd]) {
				dfs(tempN.vertexInd, trackVisit);
			}
			tempN = tempN.getN();
		}
	}
	
	public void bfs(int i) {
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(adjList[i]);
		
		while(!q.isEmpty()) {
			
			Vertex temp = q.poll();
			System.out.println("visited " + temp.name);
			while(temp.getN() != null ) {
				q.add(adjList[temp.getN().vertexInd]);
				temp = adjList[temp.getN().vertexInd] ;
			}
		}
		
	}
	
}
