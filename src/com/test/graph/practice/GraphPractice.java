package com.test.graph.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class GraphPractice {

	static Vertex[] adjList = new Vertex[6];
	static boolean[] trackVisit = new boolean[adjList.length];
	
	public static void main(String[] args) {
		
		adjList[0]=new Vertex();
		adjList[0].setVertexName("A");
		adjList[0].N = new Neighbour();
		adjList[0].N.setVertIndex(1);
		adjList[0].N.next = new Neighbour();
		adjList[0].N.next.setVertIndex(2);
		
		adjList[1]=new Vertex();
		adjList[1].setVertexName("B");
		adjList[1].N = new Neighbour();
		adjList[1].N.setVertIndex(0);
		adjList[1].N.next = new Neighbour();
		adjList[1].N.next.setVertIndex(4);
		adjList[1].N.next.next = new Neighbour();
		adjList[1].N.next.next.setVertIndex(3);
		
		
		adjList[2]=new Vertex();
		adjList[2].setVertexName("C");
		adjList[2].N = new Neighbour();
		adjList[2].N.setVertIndex(0);
		adjList[2].N.next = new Neighbour();
		adjList[2].N.next.setVertIndex(5);
		
		adjList[3]=new Vertex();
		adjList[3].setVertexName("D");
		adjList[3].N = new Neighbour();
		adjList[3].N.setVertIndex(1);
		adjList[3].N.next = new Neighbour();
		adjList[3].N.next.setVertIndex(4);
		adjList[3].N.next.next = new Neighbour();
		adjList[3].N.next.next.setVertIndex(5);
		
		adjList[4]=new Vertex();
		adjList[4].setVertexName("E");
		adjList[4].N = new Neighbour();
		adjList[4].N.setVertIndex(1);
		adjList[4].N.next = new Neighbour();
		adjList[4].N.next.setVertIndex(3);
		
		adjList[5]=new Vertex();
		adjList[5].setVertexName("F");
		adjList[5].N = new Neighbour();
		adjList[5].N.setVertIndex(2);
		adjList[5].N.next = new Neighbour();
		adjList[5].N.next.setVertIndex(3);
		
	//	dfs(0,trackVisit);
		System.out.println();
		boolean[] trackVisit1 = new boolean[adjList.length];
//		dfsCopiedFromWeb(0,trackVisit1);
	//	nonRecursiveDfs(adjList[0]);
		bfs(adjList[0]);
		
		
	}

	public static void dfs(int vIndex, boolean[] trackVisit){
		
		trackVisit[vIndex] = true;
		System.out.print(adjList[vIndex].vertexName);
		Neighbour temp = adjList[vIndex].getN();
		while(temp!=null){
			if(!trackVisit[temp.getVertIndex()]){
				dfs(temp.getVertIndex(), trackVisit);
			}
			temp = temp.getNext();
		}
	}
	
	public static void nonRecursiveDfs(Vertex v){
		
		Stack<Vertex> st = new Stack<Vertex>();
		HashMap<String,Boolean> mp = new HashMap<String,Boolean>();		
		st.push(v);
		while(!st.isEmpty()){
			Vertex temp = st.pop();
			System.out.println(temp.vertexName);
			mp.put(temp.vertexName, true);
			if(mp.size()==adjList.length){
				break;
			}
			Neighbour vN = temp.getN();
			while(vN!=null){
				if(!mp.containsKey(adjList[vN.vertIndex].vertexName)){
					st.push(adjList[vN.vertIndex]);
				}
				vN = vN.getNext();
			}
		}
	}
	
	public static void dfsCopiedFromWeb(int i, boolean[] trackVisit) {
		
		Vertex temp = adjList[i];

		trackVisit[i] = true;
		System.out.print(temp.vertexName);

		Neighbour tempN = temp.getN();
		while (tempN != null) {
			
			if(!trackVisit[tempN.vertIndex]) {
				dfsCopiedFromWeb(tempN.vertIndex, trackVisit);
			}
			tempN = tempN.next;
		}
	}
	
	public void bfs(int i) {
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(adjList[i]);
		
		while(!q.isEmpty()) {
			
			Vertex temp = q.poll();
			System.out.println("visited " + temp.vertexName);
			while(temp.getN() != null ) {
				q.add(adjList[temp.getN().vertIndex]);
				temp = adjList[temp.getN().vertIndex] ;
			}
		}
		
	}
	
	public static void bfs(Vertex v){
		Queue<Vertex> q =  new LinkedList<Vertex>();
		
		HashMap<String, Boolean> visited = new HashMap<String,Boolean>();
		
		q.add(v);
		while(!q.isEmpty()){
			
			Vertex temp = q.poll();
			visited.put(temp.vertexName, true);
			System.out.println(temp.vertexName);
			if(visited.size() == adjList.length){
				break;
			}
			Neighbour tmp = temp.getN();
			while(tmp!=null){
				if(!visited.containsKey(adjList[tmp.vertIndex].vertexName)){
					q.add(adjList[tmp.vertIndex]);
				}
				tmp = tmp.getNext();
			}
			
		}
		
		
	}
	
	static class Vertex {
		String vertexName;
		Neighbour N;
		public String getVertexName() {
			return vertexName;
		}
		public void setVertexName(String vertexName) {
			this.vertexName = vertexName;
		}
		public Neighbour getN() {
			return N;
		}
		public void setN(Neighbour n) {
			N = n;
		}
		
		
	}
	
	
	static class Neighbour{
		int vertIndex;
		Neighbour next;
		public int getVertIndex() {
			return vertIndex;
		}
		public void setVertIndex(int vertIndex) {
			this.vertIndex = vertIndex;
		}
		public Neighbour getNext() {
			return next;
		}
		public void setNext(Neighbour next) {
			this.next = next;
		}
		
	}
	

}
