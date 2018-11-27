package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeSearchA2DMatrix2.TreeNode;


public class LeetCodeTrappingRainWater {
	// https://leetcode.com/problems/trapping-rain-water/
	/* 
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1
	 * compute how much water it is able to trap after raining
	 * Example: {0,1,0,2,1,0,1,3,2,1,2 ,1}
	 *          {0,1,2,3,4,5,6,7,8,9,10,11}
	 * Output: 6
	 *   - between index 1 and 3 can trap 1
	 *   - between index 4 and 7 can trap 4
	 *   - between index 8 and 10 can trap 1
	 */

public static void main(String[] args) {
	LeetCodeTrappingRainWater me = new LeetCodeTrappingRainWater();

    long startTime = System.currentTimeMillis();
    
	int[] testcase1 =  {0,1,0,2,1,0,1,3,2,1,2 ,1};
	
	System.out.println(me.trap(testcase1)); // 6

	 
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	public int trap(int[] height) {
		/* 
		 * Find the global maximum
		 * - calculate left to right until global maximum
		 * - calculate right to left until global maximum
		 */
		if (height.length == 0)
				return 0;

		// Find the global maximum
		int peak = 0, rv = 0;
		for (int i = 0; i< height.length; i++)
			if (height[peak] < height[i])
				peak = i;

		// calculate left to right until global maximum
		int walker=0, localPeak = 0;
		while (walker < peak && walker < height.length) {
			if (height[localPeak] > height[walker])
				rv += height[localPeak] - height[walker];
			else
				localPeak = walker; // found new local peak against which to measure future valleys
			walker++;
		}
		
		// calculate right to left until global maximum
		localPeak = height.length-1;
		walker = height.length-1;
		while (walker > peak && walker >=0) {
			if (height[localPeak] > height[walker])
				rv += height[localPeak] - height[walker];
			else
				localPeak = walker; // found new local peak against which to measure future valleys
			walker--;
		}
		return rv;

	}	
}
