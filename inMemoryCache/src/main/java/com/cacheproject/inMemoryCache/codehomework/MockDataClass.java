package com.cacheproject.inMemoryCache.codehomework;

import java.util.HashMap;

public class MockDataClass {
	HashMap<String, Object> data;
	public MockDataClass(){
	data =new HashMap<String, Object>();
	saveData();
	
	}
		public void saveData(){
			data.put("123", 4676);
			data.put("456", 9898);
			data.put("789", 4565);
			data.put("999", 3339);
		}
		
	public Object getValueWithKey(String key) {
		if(key==null) {
		return -1;
		}else {
			return data.get(key);	
		}	
	}

}
