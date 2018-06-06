package org.kai;

import java.util.Arrays;

public class LeetCodeShortestUnsortedContinuousSubarray {
	//https://stackoverflow.com/questions/1938101/how-to-initialize-an-array-in-java

	  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})); // 5
		System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 4, 5})); // 0
		System.out.println(findUnsortedSubarray(new int[] {1, 3, 2, 2, 2})); // 4
		System.out.println(findUnsortedSubarray(new int[] {10, 11, 12, 12, 13, 2, 17, 14, 15, 16})); // 10
	
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
    static public int findUnsortedSubarray(int[] nums) {
        int left, right;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        for (left = 0 ; left < nums.length; left++) {
        	if (nums[left] != copy[left])
        		break;
        }
        if (left == nums.length)
        	return 0;

        for (right = nums.length-1 ; right > left; right--) {
        	if (nums[right] != copy[right])
        		break;
        }

        System.out.println ("left " + left + "right "+ right);
        
        return right-left+1;
    }
	
    static public int findUnsortedSubarray2(int[] nums) {  // brute force.. for demo only. not completed
        int left, right;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        for (left = 0 ; left < nums.length; left++) {
        	for (int j = left; j < nums.length; j++) {
        		// check if left > j if yes
        		break;
        	}
        }

        for (right = nums.length-1 ; right > left; right--) {
        	if (nums[right] != copy[right])
        		break;
        }

        System.out.println ("left " + left + "right "+ right);
        
        return right-left+1;
    }
	
	
}
