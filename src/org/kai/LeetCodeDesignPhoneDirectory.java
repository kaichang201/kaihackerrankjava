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


public class LeetCodeDesignPhoneDirectory {



public static void main(String[] args) {
	// https://leetcode.com/problems/design-phone-directory/description/
	LeetCodeDesignPhoneDirectory me = new LeetCodeDesignPhoneDirectory();
	PhoneDirectory3 directory = me.new PhoneDirectory3(3);
	
	long startTime = System.currentTimeMillis();
	directory.get();
	directory.get();
	System.out.println(directory.check(2)); // true;
	directory.check(2);  // true
	directory.get();
	System.out.println(directory.check(2)); // false;
	directory.release(2);
	System.out.println(directory.check(2)); // true;
	
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	class PhoneDirectory1 {  //38%. huh?
		boolean n[];
	    /** Initialize your data structure here
	        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	    public PhoneDirectory1(int maxNumbers) {
	    	n = new boolean[maxNumbers];
	    }
	    
	    /** Provide a number which is not assigned to anyone.
	        @return - Return an available number. Return -1 if none is available. */
	    public int get() {
	    	for (int i =0; i<n.length; i++) {
	    		if (!n[i]) {
	    			n[i] = true;
	    			return i;
	    		}
	    	}
	    	return -1;	        
	    }
	    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {
	    	return !n[number];        
	    }
	    
	    /** Recycle or release a number. */
	    public void release(int number) {
	        n[number] = false;
	    }
	}
	
	class PhoneDirectory2 {  //let's try a priority q to improve performance of get() function
		// ugh.. 2%. even worse!
		PriorityQueue<Integer> p;
	    /** Initialize your data structure here
	        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	    public PhoneDirectory2(int maxNumbers) {
	    	p = new PriorityQueue<>();
	    	for (int i =0; i< maxNumbers; i++)  // more efficient to grow priority q in increment because max value at leaf doesn't need to be floated up
	    		p.offer(i);
	    }
	    
	    /** Provide a number which is not assigned to anyone.
	        @return - Return an available number. Return -1 if none is available. */
	    public int get() {
	    	if (p.size() == 0) // nothing in queue
	    		return -1;
	    	else
	    		return p.poll();
	    }
	    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {
	    	return p.contains(number);
	    }
	    
	    /** Recycle or release a number. */
	    public void release(int number) {
	    	if (!p.contains(number))   // only add it if not already contains.
	    		p.offer(number);
	    }
	}
	
	class PhoneDirectory3 {  //try speeding up #1 by remembering free position 61.55%
		boolean n[];
		int free;
	    /** Initialize your data structure here
	        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	    public PhoneDirectory3(int maxNumbers) {
	    	n = new boolean[maxNumbers];
	    	free = 0;
	    }
	    
	    /** Provide a number which is not assigned to anyone.
	        @return - Return an available number. Return -1 if none is available. */
	    public int get() {
	    	if (!n[free]) {  // return the free number, increment free
	    		int rv = free;
	    		n[rv] = true;
	    		incrementFree();
	    		return rv;
	    	}
	    	int counter = 0;
	    	while (counter < n.length) {  // look n.length times for the next free
	    		incrementFree();
	    		if (!n[free]) {
		    		int rv = free;
		    		n[rv] = true;
		    		incrementFree();
		    		return rv;
	    		}
	    		counter++;
	    	}
	    	return -1;	        
	    }
	    
	    public void incrementFree() {
	    	if (free >= n.length-1)
	    		free = 0;
	    	else
	    		free++;
	    }
	    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {
	    	return !n[number];        
	    }
	    
	    /** Recycle or release a number. */
	    public void release(int number) {
	        n[number] = false;
	        if (!n[free]) 
	        	free = number;
	    }
	}


}
