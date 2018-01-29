package com.geeksforgeeks.Basic;

import java.util.Arrays;

/**
 * Created by hverma on 11/5/17.
 * http://practice.geeksforgeeks.org/problems/shuffle-integers/0
 *
 * The idea is to use Divide and Conquer Technique. Divide the given array into half (say arr1[] and arr2[]) and swap second half element of arr1[] with first half element of arr2[]. Recursively do this for arr1 and arr2.

 Let us explain with the help of an example.

 Let the array be a1, a2, a3, a4, b1, b2, b3, b4
 Split the array into two halves: a1, a2, a3, a4 : b1, b2, b3, b4
 Exchange element around the center: exchange a3, a4 with b1, b2 correspondingly.
 you get: a1, a2, b1, b2, a3, a4, b3, b4
 Recursively spilt a1, a2, b1, b2 into a1, a2 : b1, b2
 then split a3, a4, b3, b4 into a3, a4 : b3, b4.
 Exchange elements around the center for each subarray we get:
 a1, b1, a2, b2 and a3, b3, a4, b4.
 */
public class ShuffleIntegers {

    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5, 6};
        bruteForceShuffleArray(a, a.length/2);

        System.out.println(Arrays.toString(a));
    }

    // method to shuffle an array of size 2n
    static void bruteForceShuffleArray(int a[], int n)
    {
        // Rotate the element to the left
        for (int i = 0, q = 1, k = n; i < n; i++, k++, q++)
            for (int j = k; j > i + q; j--){
                // swap a[j-1], a[j]
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
            }
    }

    static void doRecurseAttempted(int[] arr, int start, int mid, int end){

        if(start==mid || mid == end || arr.length==1){
            return;
        }

        for(int i= (start+mid)/2; i<mid; i++){
            int temp = arr[(mid+end)/2];
            arr[(mid+end)/2] = arr[i];
            arr[i] = temp;
        }

        doRecurseAttempted(arr, start, (start+ mid)/2, mid);
        doRecurseAttempted(arr, mid+1, (mid+end)/2, end );

    }

    // method to shuffle an array of size 2n
    static void shufleArraySolution(int a[], int f, int l)
    {
        // If only 2 element, return
        if (l - f == 1)
            return;

        // finding mid to divide the array
        int mid = (f + l) / 2;

        // using temp for swapping first half of second array
        int temp = mid + 1;

        // mmid is use for swapping second half for first array
        int mmid = (f + mid) / 2;

        // Swapping the element
        for (int i = mmid + 1; i <= mid; i++)
        {
            // swap a[i], a[temp++]
            int temp1 = a[i];
            a[i] = a[temp];
            a[temp++] = temp1;
        }

        // Recursively doing for first half and second half
        shufleArraySolution(a, f, mid);
        shufleArraySolution(a, mid + 1, l);
    }

}
