package com.cacheproject.inMemoryCache;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cacheproject.inMemoryCache.codehomework.FrameworkClass;
import com.cacheproject.inMemoryCache.codehomework.InMemoryCache;
import com.cacheproject.inMemoryCache.codehomework.Level2Cache;
import com.cacheproject.inMemoryCache.codehomework.MockDataClass;

import junit.framework.Assert;

public class TestFrameworkClass {
	
	FrameworkClass frameworkClass;
	MockDataClass  mockDataClass;
	Level2Cache level2Cache;
	InMemoryCache inMemoryCache;
	
	@Before
	public void testSetUp() {
		mockDataClass = new MockDataClass();
		level2Cache= new Level2Cache();
		inMemoryCache= new InMemoryCache(3);
		frameworkClass = new FrameworkClass(inMemoryCache,level2Cache,mockDataClass);
	
	}
	
	@Test
	public void testL2CacheAndDB() {
		//this key="999" exits in MockDataClass.
		String key="999";
		//this is the first search call to the FrameWork Class so thats the reason checks are against MockDataClass.
		//It also put the key and value into L2 Cache
		Assert.assertEquals(mockDataClass.getValueWithKey(key), frameworkClass.search(key)); 
		// when second time it makes a search call to the FrameWork Class.
		// assuming first call inserted key and value into L2 cache so this Assert makes sure that value is from L2 cache.
		Assert.assertEquals(level2Cache.get(key), frameworkClass.search(key));		
	}
	
	@Test
	public void testL1Cache() {
		inMemoryCache.put("20", "200"); // here we are inserting value into l1 cache
		String key ="20";  
		// here we are doing assert to make sure that even call from framworkClass search method gets us the same 200 value.
		Assert.assertEquals(inMemoryCache.get(key), frameworkClass.search(key)); 
	}

}
