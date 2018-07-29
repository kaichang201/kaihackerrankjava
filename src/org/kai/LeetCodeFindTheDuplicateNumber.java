package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;



public class LeetCodeFindTheDuplicateNumber {
	// https://leetcode.com/problems/find-the-duplicate-number/description/


public static void main(String[] args) {
	LeetCodeFindTheDuplicateNumber me = new LeetCodeFindTheDuplicateNumber();

    long startTime = System.currentTimeMillis();
    
    int[] testArray1 = {1,3,4,2,2};
    int[] testArray2 = {3,1,3,4,2};
    int[] testArray3 = {3,1,3,4,2,3,4,5,6,7,8,9,3};
    int[] testArray4 = {9,8,7,6,5,4,3,2,1,7,7,7,7};

    System.out.println(me.findDuplicate(testArray1));  // 2
    System.out.println(me.findDuplicate(testArray2));  // 3
    System.out.println(me.findDuplicate(testArray3));  // 3
    System.out.println(me.findDuplicate(testArray4));  // 7	
 
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}


	public int findDuplicate(int[] nums) {  // not sure I completed understand this one.  something about finding the loop, then finding the value
		int slow = nums[0], fast = nums[nums[0]];
		
		while (slow != fast) {  // when they both match, they found the loop
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		
		fast =0; // reset fast
		
		while (slow != fast) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;

	}
	
	
}
