package com.cacheproject.inMemoryCache.codehomework;

import java.util.HashMap;

public class Level2Cache implements Service{
	HashMap<String, Object> map;
	public Level2Cache(){
		map= new HashMap<String, Object>();
	}
	//this methods gets the value based on key	
	public Object get(String key) {
		if(key==null) { // this is making sure that we are not checking for null
			return -1;
		}
		// add node to the head
		return map.get(key);
	}
	//this method put the value into the map	
	public void put(String key, Object value) {
		map.put(key, value);	
	}
}
