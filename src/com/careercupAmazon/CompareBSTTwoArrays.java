package com.careercupAmazon;

/**
 * Created by hverma on 12/11/17.
 *
 * Given 2 arrays.Imagine you are making bst from each array.u need to tell whether 2 bsts will be identical or not without actually constructing the tree.
 Ex:
 2 3 1
 2 1 3
 will construct the same tree
 A1[]={2,1,3}
 2
 1 3

 A2[]={2,3,1}
 2
 1 3


 */
public class CompareBSTTwoArrays {

    public static void main(String[] args){
        int[] A = {3,2,1,4,5};
        int[] B = {3,4,2,5,1};

        //all left numbers from the root should appear in the same order same for right numbers
        if(A[0] != B[0]){
            System.out.println(false);
        }else{



            int i=1, j=1, k=1, l=1;
            while(true){

                i = findnextBig(A, A[0],i);
                j = findnextBig(B, B[0], j);
                k = findnextSmall(A,A[0],k);
                l = findnextSmall(B, B[0], l);

                if(i<A.length && j<B.length && k < A.length && l <B.length){
                    if(A[i] != B[j] || A[k] != B[l]){
                        System.out.print(false);
                        System.exit(1);
                    }
                }else{
                    break;
                }
            }
            System.out.print(true);

        }
    }

    public static int findnextBig(int[] a, int val, int index){

        int temp = index + 1;
        for(int i=index+1; i<a.length; i++){
            if(a[i] > val){
                temp = i;
                break;
            }
        }
        return temp;
    }


    public static int findnextSmall(int[] a, int val, int index){

        int temp = index + 1;
        for(int i=index+1; i<a.length; i++){
            if(a[i] < val){
                temp = i;
                break;
            }
        }
        return temp;
    }
}
