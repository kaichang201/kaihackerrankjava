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
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeDesignHitCounter {



public static void main(String[] args) {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	LeetCodeDesignHitCounter me = new LeetCodeDesignHitCounter();
	HitCounter3 counter = me.new HitCounter3();
	
	long startTime = System.currentTimeMillis();
	counter.hit(1);
	counter.hit(2);
	counter.hit(3);
	System.out.println(counter.getHits(4)); // 3
	counter.hit(300);
	System.out.println(counter.getHits(300)); // 4
	System.out.println(counter.getHits(301)); // 3

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	class HitCounter1 {  // doesn't work unless if I allocate alot of heap.. Memory expensive.
		int counter[];
	    /** Initialize your data structure here. */
	    public HitCounter1() {
	        counter = new int[Integer.MAX_VALUE-5];
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	    	counter[timestamp]++;
	        
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	    	int rv = 0;
	    	int start = (timestamp <300) ? 1: timestamp -299;
	    	for (int i = start; i <=timestamp; i++ )
	    		rv+=counter[i];
	    	return rv;
	    		
	    }
	}

	class HitCounter2 { // beat 28%. :-(
		Map <Integer, Integer> counter;
	    /** Initialize your data structure here. */
	    public HitCounter2() {
	        counter = new HashMap<>();
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	    	if (counter.containsKey(timestamp))
	    		counter.put(timestamp, counter.get(timestamp)+1);
	    	else
	    		counter.put(timestamp, 1);
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	    	int rv = 0;
	    	int start = (timestamp <300) ? 1: timestamp -299;
	    	for (int i = start; i <=timestamp; i++ )
	    		if (counter.containsKey(i))
	    			rv+=counter.get(i);
	    	return rv;
	    		
	    }
	}
	
	class HitCounter3 { // Priority Queue implementation
		// takes advantage of " calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing)"
		// because getHits() are also chronological, it is safe to pop up any values less than 5 minutes old
		// advantage in that every "getHits()" does a clean-up of queue more than 5 minutes old by popping them off.
		// so sizeOf heap doesn't exceed 5 minutes old, more than necessary to answer the question.
		// Conceptually Priority Queue may be implemented as a Binary Tree
		// Internally Priority Queue can be implemented as an Array where
		// 1-rooted = parent = 1, leftchild = parent * 2, rightchild = parent * 2 + 1
		// 0-rooted = parent = 0, leftchild = parent * 2 + 1, rightchild = parent * 2 + 2
		// so relatively space efficient.
		PriorityQueue<Integer> cache;
	    /** Initialize your data structure here. */
	    public HitCounter3() {
	        this.cache = new PriorityQueue();
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        cache.offer(timestamp);
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        while (cache.size() != 0) {
	            if (timestamp - 300 < cache.peek()) break;
	            else cache.poll();
	        }
	        
	        return cache.size();
	    }
	}


}
