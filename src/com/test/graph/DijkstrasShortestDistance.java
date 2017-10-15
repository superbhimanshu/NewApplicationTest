package com.test.graph;

public class DijkstrasShortestDistance {

	public static final int V=9;
	public static void main(String[] args) {

	}
	public static int minDistance(int dist[], Boolean sptSet[]){
		//initialize min value
		int min = Integer.MAX_VALUE, min_index=-1;
		for(int v=0;v<V;v++){
			if(sptSet[v]==false && dist[v]<=min){
				min = dist[v];
				min_index=v;
			}
		}
		return min_index;
	}
	
	public static void printSolution(int[] dist, int n){
		System.out.println("Vertex Distance from source");
		for(int i=0;i<V;i++)
			System.out.println(i+"\t\t " + dist[i]);
	}
	
	public static void dijkstra(int[][] graph, int src){
		int[] dist = new int[V];
		Boolean sptSet[] = new Boolean[V];
		for(int i=0;i<V;i++){
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] =0;
		
	}

}
