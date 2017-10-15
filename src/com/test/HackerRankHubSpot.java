package com.test;

import java.util.ArrayList;

public class HackerRankHubSpot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 3, 10, 2, 4, 8, 1 };
	palindromize(null);
	}

	
    static String[] palindromize(String[] words) {
        ArrayList<String> a  = new ArrayList<String>();
        a.add("abc");
        a.add("sdgasd");
        if(words==null || words.length<=0) {
            a.add("-1");
            return  a.toArray(new String[0]) ;
        }
        return  a.toArray(new String[0]) ;
    }
	
	
	
    static int maxDifference(int[] a) {

        if(a==null || a.length<=1){
            return -1;
        }
        Integer maxVal = null;
        for(int i=0;i<a.length; i++){
            for(int j=i;j<a.length; j++){
                int maxTemp = a[j]-a[i];
                if((maxVal==null || maxTemp>=maxVal)&& maxTemp>=0){
                    maxVal = maxTemp;
                }
            }
        }
        if(maxVal!=null && maxVal>=0){
            return maxVal;
        }else{
            return -1;
        }

    }
}
