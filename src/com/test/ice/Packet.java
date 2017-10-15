package com.test.ice;

import java.lang.System;

/**
 * @author Himanshu Verma
 *
 */

public class Packet {

	//identifier for type of data (management or user)
	private boolean isManagementData = false;
	//identifier for size of packet (large or small)
	private boolean isLarge = false;
	//timestamp is needed to maintain the priority based on time (it is only needed when priority is same, based on above two flags)
	private long timestamp;
	
	//constructor
	public Packet(boolean isManagementData, boolean isLarge){
		this.isManagementData= isManagementData;
		this.isLarge = isLarge;
		this.timestamp = System.nanoTime();
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isManagementData() {
		return isManagementData;
	}
	public void setManagementData(boolean isManagementData) {
		this.isManagementData = isManagementData;
	}
	public boolean isLarge() {
		return isLarge;
	}
	public void setLarge(boolean isLarge) {
		this.isLarge = isLarge;
	}
	
	public String toString(){
		return "management packet " + this.isManagementData + " isLarge " + this.isLarge + " timestamp " + this.timestamp; 
	}
	
}
