package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeTwoSum {

static LeetCodeTwoSum me = new LeetCodeTwoSum();

public static void main(String[] args) {
	// https://leetcode.com/problems/two-sum/description/

	long startTime = System.currentTimeMillis();
	int[] testcase1 = {2, 7, 11, 15};
	int target1 = 9;
	int[] testcase2 = {2, 5, 5, 11};
	int target2 = 10;
	
	//   [["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	System.out.println(Arrays.toString(twoSum(testcase1, target1)));  // [0,1]
	System.out.println(Arrays.toString(twoSum(testcase2, target2)));  // [1,2]
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

static public int[] twoSum(int[] nums, int target) {
	int i, j;
	int[] rv = new int[2];
	
	for (i=0; i<nums.length;i++)
		for (j=i+1;j<nums.length;j++)
			if (nums[i]+nums[j] == target) {
				rv[0]=i;
				rv[1]=j;
				return rv;
			}	
	return rv;

}



	
}
