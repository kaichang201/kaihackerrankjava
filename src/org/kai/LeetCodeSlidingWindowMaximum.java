package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class LeetCodeSlidingWindowMaximum {

static LeetCodeSlidingWindowMaximum me = new LeetCodeSlidingWindowMaximum();

public static void main(String[] args) {
	// https://leetcode.com/problems/sliding-window-maximum/
	/* 
	 * Given an array of nums, with sliding window k
	 * moving from the left of the array to the right
	 * each time the sliding window moves right by one position
	 * return the max of each window
	 * Example: nums = {1,3,-1,3,5,3,6,7} k = 3
	 * Output: {3,3,5,5,6,7}
	 */

	int[] testcase1 = {1,3,-1,3,5,3,6,7};
	int k1 = 3;

	long startTime = System.currentTimeMillis();

	
	System.out.println(Arrays.toString(me.maxSlidingWindow(testcase1,k1)));  // {3,3,5,5,6,7}
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	public int[] maxSlidingWindow(int[] nums, int k) {
		/* 
		 * Strategy: use a reverse PriorityQueue.  It won't give us linear time, but it'll give us O(logN) for add/remove.  So total will be NlogN)
		 * nums.length is 8. k is 3.  resultant output is 6 length
		 */
		
		if (nums.length == 0 || nums.length < k)
			return new int[0];

		int [] rv = new int[nums.length-k+1]; // nums.length is 8. k is 3.  resultant output is 6 length
		Queue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		
		// Initialize the priorityqueue
		for (int i = 0; i<k; i++) {
			pq.add(nums[i]);
		}
		rv[0] = pq.peek(); // insert the first
		for (int i = k; i < nums.length; i++) { // for rest, remove one, add one, peek again.
			pq.remove(nums[i-k]);
			pq.add(nums[i]);
			rv[i-k+1] = pq.peek();
		}
		return rv;		
	}


	
}
