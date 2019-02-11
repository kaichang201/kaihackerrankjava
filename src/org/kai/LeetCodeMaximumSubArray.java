package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeMaximumSubArray.TreeNode;


public class LeetCodeMaximumSubArray {
	// https://leetcode.com/problems/maximum-subarray/



public static void main(String[] args) {
	LeetCodeMaximumSubArray me = new LeetCodeMaximumSubArray();

    
	int[] testArray1 = {-2,1,-3,4,-1,2,1,-5,4}; // 6.  [4, -1, 2, 1]
	int[] testArray2 = {-2,-11,-1,-2,-3}; // -1 [-1]

    long startTime = System.currentTimeMillis();

	System.out.println(me.maxSubArray(testArray1));
	System.out.println(me.maxSubArray(testArray2));
	
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}


	public int maxSubArray(int[] nums) {
		/* if sum was negative, set it to the current number
		 * Else add current number to sum
		 * if sum > max; set max to sum
		 */
		// don't have to check the case of empty array, because problem statement guarantees at least 1 number
		
		int max=Integer.MIN_VALUE, sum=0;
		
		for (int num: nums) {
			if (sum < 0 ) // if sum is currently negative, start over by setting current number
				sum = num;
			else  // other wise add this number
				sum+=num;
			if (sum > max)  // if we find a new max
				max = sum; // set the new max
		}
		return max;
	}


	
}
