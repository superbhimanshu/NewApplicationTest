package com.test.intTests;

public class CalculatePower {

	public static void main(String[] args) {
		System.out.println(power(2,3));
		System.out.println(power(2,4));
	}

	public static int power(int x, int n){
		if(n==0){
			return 1;
		}
		else 
			return x*power(x, n-1);
	}
	
	public static int powerLogN(int x,  int y)
	{
	    int temp;
	    if( y == 0)
	        return 1;
	    temp = powerLogN(x, y/2);
	    if (y%2 == 0)
	        return temp*temp;
	    else
	        return x*temp*temp;
	}
	
	float powerFloatXNegativeY(float x, int y)
	{
	    float temp;
	    if( y == 0)
	       return 1;
	    temp = powerFloatXNegativeY(x, y/2);       
	    if (y%2 == 0)
	        return temp*temp;
	    else
	    {
	        if(y > 0)
	            return x*temp*temp;
	        else
	            return (temp*temp)/x;
	    }
	} 
}
