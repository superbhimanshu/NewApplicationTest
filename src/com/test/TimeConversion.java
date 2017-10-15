package com.test;

import java.util.Scanner;

public class TimeConversion {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String[] newstr = time.split(":");
        int value=0;
        int min=0, sec=0;
        String temp = null;
        if(newstr!= null && newstr.length==3){
            try{
                value = Integer.parseInt(newstr[0]);
                min = Integer.parseInt(newstr[1]);
               
                    if(newstr[2].contains("PM") && value>=01 && value <=12) {
                        if(value<12)
                            value = value +12;
                        temp = newstr[2].replace("PM","");
                        sec = Integer.parseInt(temp);
                        if(sec<0 || sec >=60){
                            System.out.println("Error");
                            return;
                        }
                    }else if(newstr[2].contains("AM")&& value>=01 && value <=12){
                         temp = newstr[2].replace("AM","");
                        if(value==12)
                            value=00;
                        sec = Integer.parseInt(temp);
                        if(sec<0 || sec >60){
                            System.out.println("Error");
                            return;
                        }
                    }else {
                        System.out.println("INvalid date entered");
                        return;
                    }

            }catch(Exception e){
                System.out.println("INvalid date entered");
                return;
            }
        } else {
                System.out.println("INvalid date entered");
                return;
        }
        if(value>=10)
            System.out.println("" + value + ":" + newstr[1] +":"+ temp );
        if(value <10){
            System.out.println("0" + value + ":" + newstr[1] +":"+ temp );
        }
    }

}
