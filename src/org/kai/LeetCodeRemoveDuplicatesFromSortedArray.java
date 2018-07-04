package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeRemoveDuplicatesFromSortedArray.TreeNode;


public class LeetCodeRemoveDuplicatesFromSortedArray {

	//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
	
	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	int[] testcase1 = {1,1,2};
	int[] testcase2 = {0,0,1,1,1,2,2,3,3,4};
	int[] testcase3 = {1,2,2,3,3,4,4,5,5,5};
	int[] testcase4 = {1,2,2,2,2,3,3,3,4,5,6};
	int[] testcase5 = {1,2,2,2,2};
	int[] testcase6 = new int[11000];
	
	for (int i = 0; i < 11000; i++)
		testcase6[i] = i-1000;
	
	
	System.out.println(removeDuplicates2(testcase1));  // 2
	System.out.println(Arrays.toString(testcase1)); // 1,2

	System.out.println(removeDuplicates2(testcase2));  // 5
	System.out.println(Arrays.toString(testcase2)); // 0,1,2,3,4
	
	System.out.println(removeDuplicates2(testcase3));  // 2
	System.out.println(Arrays.toString(testcase3)); // 1,2
	
	System.out.println(removeDuplicates2(testcase4));  // 2
	System.out.println(Arrays.toString(testcase4)); // 1,2
	
	System.out.println(removeDuplicates2(testcase5));  // 2
	System.out.println(Arrays.toString(testcase5)); // 1,2
	
	System.out.println(removeDuplicates2(testcase6));  // 1
	System.out.println(Arrays.toString(testcase6)); // 1


	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}


  static public int removeDuplicates(int[] nums) {
	  int rv = 1;
	  if (nums.length == 0) return 0;
  
	  for (int i = 1; i < nums.length; i++) {
		  boolean replaceme = hasDupBeforeI(i, nums);  // find out if ith value needs replacing
		  
		  if (replaceme) {
			  for (int j = i+1; j < nums.length; j++) {  // look for a non-dup
				  if (!hasDupBeforeI(j, nums)) {  // found a good replacement
					  nums[i] = nums[j];
					  rv=i+1;  // means i-th value has been replaced with non-dup
					  break;
				  }
			  }
		  } else // means ith value didn't need replacing
			  rv=i+1;
	  }
	  return rv;
  }
  
  static public boolean hasDupBeforeI (int i, int[] nums) {
	  if (i >= nums.length) return false;
	  for (int j = 0; j<i; j++) {
		  if (nums[i] == nums[j]) {
			  return true;
		  }
	  }
	  return false;
  }
  
  static public int removeDuplicates2(int[] nums) { // assume nums in sorted order
	  if (nums.length == 0) return 0;
	  int tail=0, head=0;
	  
	  for (head = 0;head<nums.length; head++) {
		  if (nums[head] != nums[tail]) { // j points at next uniq number;
			  nums[tail+1] = nums[head]; 
			  tail++;
		  }
	  }
	  return tail+1;
	  
  }
}
	
	

