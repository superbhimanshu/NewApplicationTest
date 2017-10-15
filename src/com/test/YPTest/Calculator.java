package com.test.YPTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;



/**
 * @author Himanshu Verma
 *Description: Calculator class is a standlone application to evaluate simple expressions. 
 *It also allows us to use string variables(on alphabets) for value assignment and expression evaluation
 */
public class Calculator {

	public static HashMap<String,Integer> variables = new HashMap<String,Integer>();
	public static void main(String[] args) {

		run(System.in, System.out);

	}

	public static int eval(String exp) throws IllegalArgumentException{
		
		//replace spaces with empty strings
		exp = exp.replaceAll(" ", "");
		
		//if exp is just a variable name - return from variable map 
		if(variables.containsKey(exp)){
			return variables.get(exp);
		}else if(isValueInteger(exp)){ //check if it is just an integer
			return Integer.parseInt(exp);
		}else if(exp.indexOf("=")==-1 && exp.indexOf("*")==-1   //check if if there are no operations to perform
												   && exp.indexOf("+")==-1 
												   && exp.indexOf("-")==-1
												   && exp.indexOf("/")==-1){
			throw new IllegalArgumentException("Invalid Expression");
		}
			
		
		//check if expression is assignment (have "=" sign)
		if(expIsAssignment(exp)){
			String[] assign = exp.split("=");
			String lhs = assign[0];
			String rhs = assign[1];
			//checking if rhs is integer or an expression
			if(isValueInteger(rhs) && !isValueInteger(lhs) && validVariableName(lhs)){
				variables.put(lhs, Integer.valueOf(rhs));
			}else if(!isValueInteger(rhs) && !isValueInteger(lhs) && validVariableName(lhs)){
				variables.put(lhs, evaluate(rhs));
			}
			if(variables.containsKey(lhs)){
				return variables.get(lhs);
			}else {
				throw new IllegalArgumentException("Invalid Expression");
			}
			
		}else {
			return evaluate(exp);
		}
		
	}


	//method to check if variable name is valid (allowing only alphabets)
	private static boolean validVariableName(String lhs) {
		
		Pattern p = Pattern.compile("[^a-zA-Z]");
		boolean hasSpecialChar = p.matcher(lhs).find();
		return !hasSpecialChar;
	}

	//check if the value is an integer
	private static boolean isValueInteger(String str) {
		Integer val = null;
		try{
			val = Integer.parseInt(str);
		}catch(NumberFormatException e){
			//ignore if exception occurs
		}
		if(val!=null)
			return true;
		
		return false;
	}

	public static int evaluate(String exp) throws IllegalArgumentException{
	       Stack<Integer> integers = new Stack<Integer>();
	       Stack<Character> operations = new Stack<Character>();
	       char[] inputChars = exp.toCharArray();
	       
	       for(int i=0;i<inputChars.length;i++){
	    	   
	    	   if(inputChars[i]==' '){
	    		   continue;
	    	   }
	    	   if(inputChars[i]>='0' && inputChars[i]<='9'){
	    		   String s="";
	    		   int j=i;
	    		   while(j<inputChars.length 
	    				   && inputChars[j]>='0' && inputChars[j]<='9'){
	    			   s = s + inputChars[j];
	    			   j++;
	    		   }
	    		   i=j-1;
	    		   integers.push(Integer.parseInt(s));
	    	   }else if(inputChars[i] =='+' || inputChars[i]=='-'
	    			   || inputChars[i]=='*' || inputChars[i]=='/'){
	    		   while(!operations.empty() 
	    				   && highPrecendence(inputChars[i], operations.peek())){
	    			   int est = estimate( operations.pop(),integers.pop(), integers.pop());
	    			   integers.push(est);
	    			
	    		   }
	    		   operations.push(inputChars[i]);
	    	   }else if((inputChars[i]>='a' || inputChars[i]>='A') && (inputChars[i]<='z'|| inputChars[i]<='Z')){
	    		   String s= "";
	    		   int j=i;
	    		   while(j<inputChars.length 
	    				   && ((inputChars[j]>='a' || inputChars[j]>='A') && (inputChars[j]<='z' || inputChars[j]<='Z')) ){
	    			   s = s + inputChars[j];
	    			   j++;
	    		   }
	    		   i=j-1;
	    		   if(variables.containsKey(s))
	    			   integers.push(variables.get(s));
	    		   else
	    			   throw new IllegalArgumentException("Invalid Expression");
	    	   }else {
	    		   
	    		   throw new IllegalArgumentException("Invalid Expression");
	    	   }
	    		   
	       }
	       
	       while(!operations.isEmpty()){
			   int est = estimate( operations.pop(), integers.pop(), integers.pop());
			   integers.push(est);    	   
	       }
	       
			return integers.pop();
	}

	private static boolean expIsAssignment(String exp) {
		if(exp.indexOf('=')!=-1){
			return true;
		}
		return false;
	}

	private static boolean highPrecendence(char c, char peek) {
        if ((c == '*' || c == '/') && (peek == '+' || peek == '-'))
            return false;
        else
            return true;
	}

	
	private static void run(InputStream i, PrintStream o){
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);
		
		Scanner sc = new Scanner(i);
		o.print("Calculator>");
		String exp=null;

			while(sc.hasNext()){
				try{
					exp = sc.nextLine();
					int result = eval(exp);
					o.println(result);
					o.print("Calculator>");
				}catch(Exception e){
					o.println("Invalid Expression");
					o.print("Calculator>");
				}
			}
		
	}
	
	public static int estimate(char operator, int b, int a) {
		switch (operator) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)
					//can't divide by 0
					throw new IllegalArgumentException("Invalid Expression");
				return a / b;
		}
		return 0;
	}
}
