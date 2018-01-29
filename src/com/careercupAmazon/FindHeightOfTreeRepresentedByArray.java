package com.careercupAmazon;

/**
 * Created by hverma on 12/13/17.
 *
 * A tree, (NOT NECESSARILY BINARY), has nodes numbered 0 to N-1. An array has indices ranging from 0 to N-1. The indices denote the node ids and values denote the ids of parents. A value of -1 at some index k denotes that node with id k is the root. For ex:


 3 3 3 -1 2
 0 1 2 3 4
 In the above, nodes with ids 0, 1 & 2 have 3 as parent. 3 is the root as its parent = -1 and 2 is the parent of node id 4.

 Given such an array, find the height of the tree.


 */
public class FindHeightOfTreeRepresentedByArray {

    public static void main(String[] args){
        int[] arr = {3,3,3,-1,2};

        System.out.println(calcDepth(-1, arr));

    }

    private static int calcDepth(int parent, int[] tree) {
        int maxDepth = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == parent) {
                int depth = 1 + calcDepth(i, tree);
                if (depth > maxDepth) maxDepth = depth;
            }
        }
        return maxDepth;
    }

}
