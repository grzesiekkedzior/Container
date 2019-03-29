package grzesiek.collection.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import grzesiek.collection.map.LinkedMap;
import grzesiek.collection.map.Map;

class LinkedMapTest {

	@Test
	public void testCeateObject() {
		Map<String, Integer> linkedmap = new LinkedMap<>(); 
		assertNotNull(linkedmap);
	}
	
	@Test
	public void testConstructorWithParam() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>("key", 1);
		assertNotNull(linkedmap);
	}
	
	@Test
	public void testConstructorWithStringGetValue() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>("key", 1);
		assertEquals(1, linkedmap.get("key").intValue());
	}
	
	
	@Test
	public void testConstructorWithIntegerGetValue() {
		Map<Integer, Integer> linkedmap = new LinkedMap<Integer, Integer>(1,1);
		assertEquals(1,linkedmap.get(1).intValue());
	}
	
	@Test
	public void testConstructorWithDoubleGetValue() {
		Map<Double, Double> linkedmap = new LinkedMap<Double, Double>(1.0,1.0);
		assertEquals(1.0, linkedmap.get(1.0).doubleValue());
		
	}

	@Test
	public void testPutMethod() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>();	
		linkedmap.put("key2", 2);
		linkedmap.put("key3", 8);
		assertEquals(2, linkedmap.get("key2").intValue());
		assertEquals(8, linkedmap.get("key3").intValue());
		
	}
	
	@Test
	public void testPutNullValue() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>();
		linkedmap.put("key",null);
		assertEquals(null, linkedmap.get("key"));
		
	}
	
	@Test
	public void testSize() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>();
		linkedmap.put("key1", 10);
		linkedmap.put("key2", 20);
		assertEquals(2, linkedmap.size());
	}
	
	@Test
	public void testIsEmpty() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>();
		assertEquals(true, linkedmap.isEmpty());
	}
	
	
	@Test
	public void testTheSameKeyOverride() {
		Map<String, Integer> linkedmap = new LinkedMap<String, Integer>();
		linkedmap.put("key1", 10);
		linkedmap.put("key1", 20);
		linkedmap.put("key1", 30);
		linkedmap.put("key1", 40);
		assertEquals(40, linkedmap.get("key1").intValue());
		assertEquals(1, linkedmap.size());
	}
}
