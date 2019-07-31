package com.cacheproject.inMemoryCache.codehomework;

public class FrameworkClass {
		
		Service l1; //l1 cache
		Service l2; // l2 cache
		MockDataClass dataClass; //Mock Data class
		
		public FrameworkClass(Service l1, Service l2, MockDataClass dataClass) {
			this.l1 = l1;
			this.l2 = l2;
			this.dataClass = dataClass;
		}		
		public Object search(String key) {  // This method searches for the value with the key
			if(l1.get(key) != null) { 		// First it checks in l1 cache if exits it returns the value back.
				return l1.get(key);
			}else if(l2.get(key)!=null) {	// Second it checks in l2 cache if exits it returns the value back.
				return l2.get(key);
			}else {
				Object value=dataClass.getValueWithKey(key); // Third it checks in DB 
				if(value!=null) {				// If value exists then it inserts into L2 cache
					l2.put(key, value);
				}
				return value;
			}
		}
}
