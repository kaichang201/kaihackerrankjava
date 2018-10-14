package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class LeetCodeMergeSortedArray {
	// https://leetcode.com/problems/merge-sorted-array/

	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	     @Override
	     public String toString() {
	    	  ArrayList<String> a = new ArrayList<>();
	    	  ListNode cur = this;
	    	  while (cur != null) {
	    		  a.add(String.valueOf(cur.val));
	    		  cur = cur.next;
	    	  }
	    	  return a.toString();
	      }
	}

	public static void main(String[] args) {
		LeetCodeMergeSortedArray me = new LeetCodeMergeSortedArray();
	
	    long startTime = System.currentTimeMillis();
	    
		int[] testArray1a = {1,2,3,0,0,0};
		int[] testArray1b = {2,5,6};
		
		System.out.println(Arrays.toString(testArray1a));
		me.merge(testArray1a, testArray1a.length-testArray1b.length, testArray1b, testArray1b.length); // 1,2,2,3,5,6
		System.out.println(Arrays.toString(testArray1a));
		 
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i = m-1, j = n-1, k = m+n-1;
    	
    	while (k >= 0) {
    		boolean copyI;
    		if (j<0 && i >=0)  // j reached the end, i has not. Not safe to reference J.  Copy I
    			copyI = true;
    		else if ( i<0 && j >=0)  // i reached the end, j has not. Not safe to reference I. Copy J
    			copyI = false;
    		else if (nums1[i] > nums2[j])
    			copyI = true;
    		else copyI = false;
    		
    		if (copyI)
    			nums1[k--] = nums1[i--];
    		else
    			nums1[k--] = nums2[j--];
    	}

	}
}
