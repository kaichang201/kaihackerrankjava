package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeLRUCache {



public static void main(String[] args) {
	// https://leetcode.com/problems/lru-cache/description/
	LeetCodeLRUCache me = new LeetCodeLRUCache();
	
	int[][] testcase1 = {{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}};
	int[][] testcase2 = {{2},{2,6},{1},{1,5},{1,2},{1},{2}};
	int[][] testcase3 = {{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}};
	
	long startTime = System.currentTimeMillis();
	LRUCache cache11 = me.new LRUCache(2);
	for (int[] a: testcase1) { // 1, -1, -1, 3, 4
		if (a.length==1) {
			System.out.println(cache11.get(a[0]));
		} else {  // 2 numbers
			cache11.put(a[0],a[1]);
		}
	}
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	LRUCache cache12 = me.new LRUCache(2);
	for (int[] a: testcase2) { // 1, -1, -1, 3, 4
		if (a.length==1) {
			System.out.println(cache12.get(a[0]));
		} else {  // 2 numbers
			cache12.put(a[0],a[1]);
		}
	}
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	LRUCache cache13 = me.new LRUCache(2);
	for (int[] a: testcase3) { // 1,-1,-1,3,4
		if (a.length==1) {
			System.out.println(cache13.get(a[0]));
		} else {  // 2 numbers
			cache13.put(a[0],a[1]);
		}
	}
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	LRUCache2 cache21 = me.new LRUCache2(2);
	for (int[] a: testcase1) { // 1, -1, -1, 3, 4
		if (a.length==1) {
			System.out.println(cache21.get(a[0]));
		} else {  // 2 numbers
			cache21.put(a[0],a[1]);
		}
	}
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	LRUCache2 cache22 = me.new LRUCache2(2);
	for (int[] a: testcase2) { // 1, -1, -1, 3, 4
		if (a.length==1) {
			System.out.println(cache22.get(a[0]));
		} else {  // 2 numbers
			cache22.put(a[0],a[1]);
		}
	}
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	LRUCache2 cache23 = me.new LRUCache2(2);
	for (int[] a: testcase3) { // 1,-1,-1,3,4
		if (a.length==1) {
			System.out.println(cache23.get(a[0]));
		} else {  // 2 numbers
			cache23.put(a[0],a[1]);
		}
	}
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	class LRUCache {
		final int maxCapacity;
		Deque<Integer> q = new ArrayDeque<>(); // remove, contains run in linear time
		Map<Integer, Integer> m = new HashMap<>(); // set offers constant time performance
	
	    public LRUCache(int capacity) {
	        this.maxCapacity = capacity;
	    }
	    
	    public int get(int key) {
	    	int rv = -1;
	    	if (m.containsKey(key)) {
	    		rv = m.get(key);
		    	updateLRU(key);
	    	}
	    	return rv;
	    }
	    
	    public void put(int key, int value) {
	    	if (m.size() >= maxCapacity  && !m.containsKey(key))
	    		m.remove(popLRU());
	    	
    		m.put(key, value);

	    	updateLRU(key);
	    }
	    	
	    private void updateLRU (int key) {
	    	q.remove(key); // linear, not constant, time
	    	q.add(key); // constant time
	    }
	    
	    private int popLRU () {
	    	return q.remove();  //constant time
	    }

	}
	
	class LRUCache2 {
		final int maxCapacity;
		Map<Integer, Integer> m ; // LinkedHashMap offers removeEldestEntry for override
	
	    public LRUCache2(int capacity) {
	        this.maxCapacity = capacity;
	        this.m = new LRUCacheHashMap<Integer, Integer>(capacity); // turn on access order
	    }
	    
	    public int get(int key) {
	    	int rv = -1;
	    	if (m.containsKey(key))
	    		rv = m.get(key);
	    	return rv;
	    }
	    
	    public void put(int key, int value) {
    		m.put(key, value);
//			System.out.println(m.toString());
	    }
	    	
	}
	
	class LRUCacheHashMap<K,V> extends LinkedHashMap<K,V> {
		final int maxCapacity;

		public LRUCacheHashMap (int capacity) {
			super(capacity, (float) 0.75, true);  // turn on access ordering
			maxCapacity = capacity;
		}
		@Override
		protected boolean removeEldestEntry (Map.Entry<K,V> eldest) {
			return size() > maxCapacity;
		}
	}
	

}
