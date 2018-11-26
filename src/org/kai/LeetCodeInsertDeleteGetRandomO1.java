package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


public class LeetCodeInsertDeleteGetRandomO1 {

	
	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
	class RandomizedSet {
		Map <Integer, Integer> m;  // using 2 data structures to complement the weakness of both
		List<Integer> l;
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        m = new HashMap<>();
	        l = new ArrayList<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if (m.containsKey(val))
	    		return false;
	    	l.add(val);  // Add the value to the end of the ArrayList
	    	m.put(val,l.size()-1);  // Map the value to the index of where it was stored in ArrayList, so we don't have to spend O(n) looking for it.	    	
	    	return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if (!m.containsKey(val))
	    		return false;

	    	
	    	// where the magic happens.
	    	int index = m.get(val);  // get the index of the value we want
	    	int lastVal = l.get(l.size()-1);   // remember the value at the end of the list.
	    	Collections.swap(l, index, l.size()-1);   // swap the value to the end of the list with the value we want to remove.
	    	m.put(lastVal, index);  // update the map with the new index
	    	
	    	// do the removal
	    	l.remove(l.size()-1); // removing from the end of the list means we don't have to pay the cost of shifting subsequent elements to the left
	    	m.remove(val);  // and finally clean up the mapping to say we don't got that val no more
	    	return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	// get the linear distribution over the size of the set
	    	// (int) (Math.random() * (max - min) + min);
	    	/* casting double to int drops decimal. so if list.size() is 5, then
	    	* 0.0 to 0.19 goes to 0
	    	* 0.2 to 0.39 goes to 1
	    	* 0.8 to 0.99 goes to 4
	    	*/ 
	    	int randomIndex = (int) (Math.random() * (l.size()-0) + 0);
	    	return l.get(randomIndex);
	        
	    }
	}

public static void main(String[] args) {
	// https://leetcode.com/problems/insert-delete-getrandom-o1/
	/*
	 * Design a data structure that supports all of the following operations in average O(1) time.
	 * insert(val): Inserts an item val to the set if not already present
	 * remove(val): removes an item val from set if not present
	 * getRandom(): returns a random elements from the current set of elements.  Each element must have the same probability of being returned.
	 */


	LeetCodeInsertDeleteGetRandomO1 me = new LeetCodeInsertDeleteGetRandomO1();
	RandomizedSet test1 = me.new RandomizedSet();

	long startTime = System.currentTimeMillis();
	System.out.println(test1.insert(1));  // returns true
	System.out.println(test1.remove(2));  // returns false
	System.out.println(test1.insert(2));  // returns true
	System.out.println(test1.insert(3));  // returns true
	System.out.println(test1.insert(4));  // returns true
	System.out.println(test1.insert(5));  // returns true
	System.out.println(test1.getRandom());  // returns 1 to 5 with equal probability
	System.out.println(test1.getRandom());  // returns 1 to 5 with equal probability
	System.out.println(test1.getRandom());  // returns 1 to 5 with equal probability
	System.out.println(test1.getRandom());  // returns 1 to 5 with equal probability
	System.out.println(test1.getRandom());  // returns 1 to 5 with equal probability
	System.out.println(test1.remove(1));  // returns true
	System.out.println(test1.insert(2));  // returns false
	System.out.println(test1.remove(3));  // returns true
	System.out.println(test1.remove(4));  // returns true
	System.out.println(test1.remove(5));  // returns true
	System.out.println(test1.getRandom());  // returns 2
	System.out.println(test1.getRandom());  // returns 2
	System.out.println(test1.getRandom());  // returns 2
	System.out.println(test1.getRandom());  // returns 2

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, max = 0;
		int rv=0;

		for (int p: prices) {  // BigO(n)
			if (p < min) {
				min = p;
				continue;
			}
			if (rv < p-min)
				rv = p-min;				
		}
		
		return rv;

	}

}
