package com.geeksforgeeks.Easy;

import java.util.Stack;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Created by hverma on 11/13/17.
 */
public class SortStack {

    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(14);
        s.push(2);
        s.push(5);
        s.push(11);
        sortStack(s);
        System.out.println(s);
    }

    public static void sortStack(Stack<Integer> s){
        if(CollectionUtils.isNotEmpty(s)){
            Integer temp = s.pop();
            sortStack(s);
            insertSorted(s,temp);
        }
    }

    public static void insertSorted(Stack<Integer> s, Integer temp){
        if(s.isEmpty() || s.peek() <= temp){
            s.push(temp);

        }else{
            Integer temp1 = s.pop();
            insertSorted(s, temp);
            s.push(temp1);
        }
    }

}
