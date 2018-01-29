package com.careercupAmazon;

/**
 * Created by hverma on 12/6/17.
 * https://www.careercup.com/question?id=16306671
 *
 * You are given an integer array, where all numbers except for TWO numbers appear even number of times.

 Q: Find out the two numbers which appear odd number of times.

 */
public class UsingXorToFindNumberWithOddFrequency {

    public static void main(String[] args){
        int[] a = {2,2,3,1,4,1,4,1,1,1,9,3};

        int xor = a[0];
        for(int i=1;i<a.length;i++){
            xor ^= a[i];
        }
        System.out.println(xor);

        int position = findPositionOfFirstSetBit(xor);

        Integer XOR0=null, XOR1=null;
        for(int i=0;i<a.length;i++){
            if(getBitAtPosition(a[i], position)==0){
                if(XOR0==null)
                    XOR0=a[i];
                else
                    XOR0^=a[i];
            }else{
                if(XOR1==null)
                    XOR1=a[i];
                else
                    XOR1^=a[i];
            }
        }

        System.out.println(XOR0);
        System.out.println(XOR1);

    }

    public static int getBitAtPosition(int x, int position){
        return (x>>position)&1;
    }

    public static int findPositionOfFirstSetBit(int x){
        int position =0;
        while((x&1) != 1){
            position++;
            x=x>>1;
        }
        return position;
    }

}
