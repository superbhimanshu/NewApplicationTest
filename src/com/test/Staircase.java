package com.test;
import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		System.out.println("Enter n : \n");
		int test=0;
		if (args.length > 0) {
			try {
				test = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0] + " must be an integer.");
				System.exit(1);
			}
			System.out.println(test);
		}
		int n = test;
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		if(n<1 || n>100) {
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i=1; i<=n;i++){
			StringBuilder temp = new StringBuilder();
			for(int j=n-i; j>0; j--){
				temp.append(" ");
			}
			for(int k=i; k>0; k--){
				temp.append("#");
			}
			temp.append("\n");
			str.append(temp);
		}
		
		str.deleteCharAt(str.length() -1);
		System.out.println(str);
	}

}
