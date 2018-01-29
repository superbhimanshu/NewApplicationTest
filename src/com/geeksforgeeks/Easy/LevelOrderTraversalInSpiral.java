package com.geeksforgeeks.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hverma on 11/30/17.
 */
public class LevelOrderTraversalInSpiral {

    public static void main(String[] args) {
        Node root = new Node();
        root.value = 1;
        root.left = new Node();
        root.left.value = 2;
        root.right = new Node();
        root.right.value = 3;
        root.left.left = new Node();
        root.left.left.value = 4;
        root.left.right = new Node();
        root.left.right.value = 5;
        root.right.left = new Node();
        root.right.left.value = 6;
        root.right.right = new Node();
        root.right.right.value = 7;
        root.left.left.left =new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left =new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);




   //     printSpiralRecurse(root);
        System.out.println();

        printSpiralStackQueue(root);

       // System.out.print(heightOfTree(root));

    }


    static void printSpiralStackQueue(Node root){

        if(root == null){
            System.out.println("No Node found");

        }
        System.out.println(root.value);
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        q.add(root.left);
        q.add(root.right);
        boolean visitQ = true;
        while(!q.isEmpty() || !s.isEmpty()){
            if(visitQ){
                while(!q.isEmpty()){
                    Node tmp = q.poll();
                    System.out.println(tmp.value);
                    if(tmp.left!=null){
                        s.push(tmp.left);
                    }
                    if(tmp.right!=null){
                        s.push(tmp.right);
                    }
                }
            }else{
                recursiveVisitS(s, q);
            }
            visitQ = !visitQ;
        }


    }


    static void recursiveVisitS(Stack<Node> s, Queue<Node> q){
        if(s.isEmpty()){
            return;
        }
        Node x = s.pop();
        System.out.println(x.value);
        recursiveVisitS(s,q);
        if(x.left!=null){
            q.add(x.left);
        }
        if(x.right!=null){
            q.add(x.right);
        }
    }


    static void printSpiralRecurse(Node node){
        int height = heightOfTree(node);
        boolean fromLeft = false;
        for(int i=1; i<=height;i++){
            printGivenLevelNodes(node,i,fromLeft);
            fromLeft=!fromLeft;
        }
    }

    static int heightOfTree(Node node){
        if(node == null){
            return 0;
        }else {
            return Math.max(1 + heightOfTree(node.left) , 1+heightOfTree(node.right));
        }


    }

    static void printGivenLevelNodes(Node node, int level, boolean fromLeft){
        if(node == null){
            return;
        }
        if(level == 1){
            System.out.print("" + node.value + " ");
        }else if(level > 1){
            if(fromLeft){
                printGivenLevelNodes(node.left, level - 1, fromLeft);
                printGivenLevelNodes(node.right, level-1, fromLeft);
            }else{
                printGivenLevelNodes(node.right, level - 1, fromLeft);
                printGivenLevelNodes(node.left, level-1, fromLeft);
            }
        }
    }

    static void printSpiralNonRecursive(Node node) {
        if (node == null)
            return;   // NULL check

        // Create two stacks to store alternate levels
        Stack<Node> s1 = new Stack<Node>();// For levels to be printed from right to left
        Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left to right

        // Push first level to first stack 's1'
        s1.push(node);

        // Keep ptinting while any of the stacks has some nodes
        while (!s1.empty() || !s2.empty()) {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.value + " ");

                // Note that is right is pushed before left
                if (temp.right != null)
                    s2.push(temp.right);

                if (temp.left != null)
                    s2.push(temp.left);

            }

            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.value + " ");

                // Note that is left is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }
}

class Node {

    public Node(){

    }

    public Node(int value){
        this();
        this.value=value;
    }

    int value;

    Node left;

    Node right;
}