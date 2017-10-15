package com.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class StringToDoubleParser {

	public static void main(String[] args) {

		int[] arl =new int[2];
		String x = "asnd asd ((00";
		x= x.replaceAll(" ", "");
		Pattern p = Pattern.compile("[^a-zA-Z0-9*/-+]");
		boolean hasSpecialChar = p.matcher(x).find();
		System.out.println(hasSpecialChar);
		Boolean f =true;
		if(f){
			System.out.println(arl[0]);
		}
		long ga = 0;
		String a = "0e537d111e6f473ebdea1dbcad4a3754";
		Map<String,Integer> abc = new HashMap<String,Integer>();
		List<String> strList = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		Stack<String> st = new Stack<String>();
		System.out.println("2CNEFZF0UDFRX75FD6O7S4YR".toLowerCase());
		
		strList.add(null);
		strList.add("asb");
		
		System.out.println(strList.toArray().toString());
		
		abc.put("a", 1);
		abc.put("b", 2);
		
		JSONObject js = new JSONObject(abc);
		Calendar fltr = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
	//	calendar.getTimeInMillis();
		
		Calendar c = Calendar.getInstance();
		
		c.set(fltr.get(Calendar.YEAR), fltr.get(Calendar.MONTH), fltr.get(Calendar.DATE), fltr.get(Calendar.HOUR_OF_DAY), fltr.get(Calendar.MINUTE));
		
	//	ExecutorService executorService = new ThreadPoolExecutor(0, 0, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(0), new ThreadPoolExecutor.DiscardPolicy());
		
	
		
		String[] z  = a.split("\\?");
//		s = s.replaceAll("^[^a-zA-Z\\s]+|[^a-zA-Z\\s]+$", "");
//		Double  d = Double.parseDouble(a);
		System.out.println("gmt time " + fltr.getTimeZone() + "   local time " + c.getTimeZone()) ;
		
		System.out.println(" a " + fltr.getTimeInMillis() + "  as " + c.getTimeInMillis());
	}
	
	public static enum ItineraryType {
		ONE_WAY("OW"),
		ROUND_TRIP("RT"),
		MULTI_DESTINATION("MD");
		
		private final String code;
		private ItineraryType(String _code) {
			code = _code;
		}
	
		public String code() {
			return code;
		}
		
	}
}
