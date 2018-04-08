package com.careercupAmazon;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BFSShortestDistance {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        // Complete this function
        ArrayList<HashSet<Integer>> graph = convertToGraph(edges,n);

        return null;
    }

    static ArrayList<HashSet<Integer>> convertToGraph(int[][] edges, int n){

        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<Integer>());
        }
        for(int i=0;i<edges.length; i++){
            for(int j=0; j<2; j++){
                graph.get(i).add(edges[i][j]);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
