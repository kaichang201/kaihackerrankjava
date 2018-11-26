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


public class LeetCodeKthLargestElementInAnArray {



public static void main(String[] args) {
	// https://leetcode.com/problems/kth-largest-element-in-an-array/
	/*
	 * Find the kth largest element in an unsorted array.
	 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * Example 1: {3,2,1,5,6,4} and k = 2 
	 * Output:  5
	 * 
	 * Example 2: {3,2,3,1,2,4,5,5,6} and k = 4
	 * Output: 4
	 * 
	 * Assuming k is always valid, 1 K=k <= array.length
	 */


	LeetCodeKthLargestElementInAnArray me = new LeetCodeKthLargestElementInAnArray();
	int[] testcase1 = {3,2,1,5,6,4};
	int testk1 = 2; // 5
	int[] testcase2 = {3,2,3,1,2,4,5,5,6};
	int testk2 = 4; // 4
	

	long startTime = System.currentTimeMillis();
	System.out.println(me.findKthLargest(testcase1, testk1));  // 5
	System.out.println(me.findKthLargest(testcase2, testk2));  // 4
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int findKthLargest(int[] nums, int k) {
		/* Strategy: sort array
		 * for array of size 6, the 2nd largest element is array.size - 2
		 * for array of size 9, the 4th largest element is array.size - 4
		 */
	    Arrays.sort(nums);
	    return nums[nums.length-k];
	    
	}
}
