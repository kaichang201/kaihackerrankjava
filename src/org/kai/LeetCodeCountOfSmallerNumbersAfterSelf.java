package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.kai.LeetCodeMergeIntervals.TreeNode;


public class LeetCodeCountOfSmallerNumbersAfterSelf {
	// https://leetcode.com/problems/count-of-smaller-numbers-after-self/


	public static void main(String[] args) {
		LeetCodeCountOfSmallerNumbersAfterSelf me = new LeetCodeCountOfSmallerNumbersAfterSelf();
	
	    long startTime = System.currentTimeMillis();
	    
		int[] testArray1 = {5,2,6,1}; // 2,1,1,0
		int[] testArray2 = {5,4,3,2,1,0,-1,-2}; // 7,6,5,4,3,2,1,0
		int[] testArray3 = {-2,-1,0,1,2,3,4,5,6,7}; // 0,0,0,0,0,0,0,0,0,0
	
		
		System.out.println(me.countSmaller(testArray1).toString());
		System.out.println(me.countSmaller(testArray2).toString());
		System.out.println(me.countSmaller(testArray3).toString());
		 
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	

    public List<Integer> countSmaller(int[] nums) {  // time limit exceeded.  That's why it's a hard one. :-(
    	Map<Integer, Integer> m = new HashMap<>();
    	Integer[] rv = new Integer[nums.length];
    	
    	for (int i = nums.length-1; i>=0; i--) {  // iterate backwards
    		int sum = 0;
    		for (int j : m.keySet()) {  // look through map and add all values less than nums[i]
    			if (j < nums[i])
    				sum += m.get(j);
    		}
    		rv[i] = sum;
    		
    		// add num[i] to map
    		if (m.containsKey(nums[i]))
    			m.put(nums[i], m.get(nums[i])+1);
    		else
    			m.put(nums[i], 1);    		
    	}
    	return Arrays.asList(rv);
    }

}
