package com.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dto.Address;
import com.dto.AirBookRequest;
import com.dto.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ObjectToKeyValueString {

	public static void main(String[] args) {

		AirBookRequest bkr = new AirBookRequest();
		List<Customer> cms = new ArrayList<Customer>();
		Customer cm = new Customer();
		Customer cm2 = new Customer();
		cm2.setAreaCode(1234);
		cm2.setEmail("abc@gmail.com2");
		cm2.setName("Hello2");
			
		
		cm.setAreaCode(123);
		cm.setEmail("abc@gmail.com");
		cm.setName("Hello");
		cms.add(cm);
		cms.add(cm2);
		bkr.setCustomers(cms);
		bkr.setAllowSimilarTravel(true);
		bkr.setOfferNumber(123456L);
		bkr.setValidateOnly(true);
		bkr.setOfferType("retail");
		bkr.setCust(cm);
		
		List<String> addrLine = new ArrayList<String>();
		addrLine.add("800 connecticut Ave");
		addrLine.add("Norwalk CT");
		Address ad = new Address();
		ad.setAddressLine(addrLine);
		ad.setCountry("US");
//		cm.setAdd(ad);
		
		constructPlainKeyValueFromJson(bkr);
		try {
			System.out.println(mapToJsonString(introspect(bkr)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	
	private static void constructPlainKeyValueFromJson(AirBookRequest bookReq) {
		ObjectMapper om = new ObjectMapper();
		StringBuilder sb = new StringBuilder();
		HashMap<String,Serializable> resultMap = new HashMap<String,Serializable>();
		JsonNode root = null;
		
		try {
			root = om.readTree(om.writeValueAsString(bookReq));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(root!=null){
			traverse(root, resultMap);
		}
		if(resultMap!= null){
			sb.append("{");
			Iterator it = resultMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Map.Entry) it.next();
				sb.append("\"").append(pair.getKey()).append("\"").append(":").append(pair.getValue()).append(",");
	//			System.out.println(pair.getKey() + ":" + pair.getValue());
				it.remove();
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
			System.out.println(sb.toString());
		}
		return;
	}
	
	public static void traverse(JsonNode node, Map<String, Serializable> result) {
		Iterator<Map.Entry<String, JsonNode>> it = node.fields();
		while (it.hasNext()) {
			Map.Entry<String, JsonNode> entry = it.next();
			JsonNode n = entry.getValue();
			if (n.isObject()) { // if JSON object, traverse recursively
				traverse(n, result);
			} else { // if not, just add as String
				result.put(entry.getKey(), n.toString());
			}
		}
	}
	
	public static String mapToJsonString(Map<String,Object> resultMap){
		StringBuilder sb = new StringBuilder();
		if(resultMap!= null){
			sb.append("{");
			Iterator it = resultMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Map.Entry) it.next();
				sb.append("\"").append(pair.getKey()).append("\"").append(":").append(pair.getValue().toString()).append(",");
	//			System.out.println(pair.getKey() + ":" + pair.getValue());
				it.remove();
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
			System.out.println(sb.toString());
		}
		return sb.toString();
	}
	
	public static Map<String, Object> introspect(Object obj) throws Exception {
	    Map<String, Object> result = new HashMap<String, Object>();
	    BeanInfo info = Introspector.getBeanInfo(obj.getClass());
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null)
	            result.put(pd.getName(), reader.invoke(obj));
	    }
	    return result;
	}
//	public static void useJsonParser(AirBookRequest bookReq) {
//		
//		JSONParser parser = new JSONParser();
//
//	    try {
//
//	        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("c:\\sample.json"));
//
//	        String name = (String) jsonObject.get("name");
//	        long age = (Long) jsonObject.get("age");
//	        JSONArray msg = (JSONArray) jsonObject.get("messages");
//	        System.out.println("Name:"+name);
//	        System.out.println("Age:"+age);
//	        System.out.println("Messages:");
//	        Iterator<String> iterator = msg.iterator();
//	        while (iterator.hasNext()) {
//	        System.out.println(iterator.next());
//	        }
//
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    } catch (ParseException e) {
//	        e.printStackTrace();
//	    }
//		
//	}
}
