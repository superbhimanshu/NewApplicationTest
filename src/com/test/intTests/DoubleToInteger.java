package com.test.intTests;

public class DoubleToInteger {

	public static void main(String[] args) {

		Double a = 4.0;
		System.out.println((int)Math.floor(a));
		String tree = "3 4 5 1 3 # 1";
		String[]  str =tree.split(" ");
	//	String[] str = {"1", "2","#"};
        for(int i =0; i<str.length;i++){
            
            if(str[i]!="#"){
                System.out.println(str[i]);
   //             data[i] = Integer.parseInt(str[i]);
            }else{
    //            data[i]=0;
            }
        }
	}

    static void findRates(String line1, String line2) {

        String[] data = line1.split(" ");
        int p = Integer.parseInt(data[0]);
        double r = Double.parseDouble(data[1])/100.0;
        int t = Integer.parseInt(data[2]);
        int threshold = Integer.parseInt(data[3]);
        int[] values = new int[t];
        data = line2.split(" ");
        for(int i =0; i<t;i++){
            values[i] = Integer.parseInt(data[i]);
        }
    }
}
