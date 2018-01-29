package com.test.trees;

/**
 * Created by hverma on 1/15/18.
 */
public class TreeTest2 {


    public static void main(String[] args){

        Node root = new Node(1);

        add(5,root);
        add(7,root);
        add(2,root);
        add(3,root);
        add(8,root);
        add(1,root);
        add(9,root);
        add(6,root);





        System.out.println(5);

    }

    public static void add(int value, Node root ){
        if(root == null){
            root = new Node(value);
        }

        Node parentNode = root;
        while(true){
            if(value < parentNode.val){
                if (parentNode.left == null){
                    parentNode.left = new Node(value);
                    return;
                }else{
                    parentNode = parentNode.left;
                }
            }else{
                if (parentNode.right == null){
                    parentNode.right = new Node(value);
                    return;
                }else{
                    parentNode = parentNode.right;
                }
            }
        }

    }


    public static void addNormalTree(int val, Node root){

        if(root == null){
            root = new Node(val);
            return;
        }

        Node parent  = root;
        Node focusNode =  root;
        while(true){

            if(parent.left!=null && parent.right!=null){
                focusNode = parent.left;
            }else if(parent.left==null){
                focusNode.left = new Node(val);
                return;
            }else{
                focusNode.right = new Node(val);
            }
        }
    }




    static class Node {
        int val;
        Node left;
        Node right;

        Node(){

        }

        Node(int val){

            this();
            this.val = val;
        }

    }

}
