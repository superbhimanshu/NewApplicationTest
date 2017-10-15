package com.test.trees;

/**
 * Created by hverma on 6/6/17.
 */
public class TreeTestPractice {


    Node root;

    public void addNode(int key, String name){

        Node newNode = new Node(key,name);
        if(root==null){
            root = newNode;
        }else {
            Node focusNode = root;
            Node parent;
            while (true){
                parent = focusNode;
                if(parent.leftChild!=null && parent.rightChild!=null){
                    focusNode=focusNode.leftChild;
                    continue;
                }
                focusNode = focusNode.leftChild;
                if(focusNode==null){
                    parent.leftChild = newNode;
                    return;

                }else {
                    focusNode = focusNode.rightChild;
                    if(focusNode==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    public void addNodeBinarySearch(int key, String name){
        Node newNode = new Node(key, name);
        if(root==null){
            root = newNode;
            return;
        }else {
            Node focusNode = root;
            Node parent;
            while(true){
                parent=focusNode;
                if(key < focusNode.key){
                    focusNode=focusNode.leftChild;
                    if(focusNode==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else{
                    focusNode=focusNode.rightChild;
                    if(focusNode==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }

    }


    public void inOrderTraversal(Node focusNode){

        if(focusNode!=null){
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrder(Node focusNode){
        if(focusNode!=null){
            System.out.println(focusNode);
            preOrder(focusNode.leftChild);
            preOrder(focusNode.rightChild);
        }
    }

    class Node {
        int key;
        String name;
        Node leftChild;
        Node rightChild;

        public Node (int key, String name){
            this.key=key;
            this.name=name;
        }
    }

}


