package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeMergeTwoSortedLists.TreeNode;


public class LeetCodeMergeTwoSortedLists {
	// https://leetcode.com/problems/merge-two-sorted-lists/description/

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
		LeetCodeMergeTwoSortedLists me = new LeetCodeMergeTwoSortedLists();
	
	    long startTime = System.currentTimeMillis();
	    
		int[] testArray1a = {1,2,4};
		int[] testArray1b = {1,3,4};
		int[] testArray2a = {2,3,4,5,6};
		int[] testArray2b = {1,7,8};
		
		ListNode l1a = me.buildList(testArray1a);
		ListNode l1b = me.buildList(testArray1b);
		ListNode l2a = me.buildList(testArray2a);
		ListNode l2b = me.buildList(testArray2b);
		System.out.println(l1a); // {1,2,4}
		System.out.println(l1b); // {1,3,4}
		System.out.println(l2a); // {2,3,4,5,6}
		System.out.println(l2b); // {2,3,4,5,6}
		System.out.println();
		System.out.println(me.mergeTwoLists(l1a, l1b)); // 1,1,2,3,4,4
		System.out.println(me.mergeTwoLists(l2a, l2b)); // 1,2,3,4,5,6,7,8
	
		 
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	
	public ListNode buildList(int[] inArray) {
		ListNode rv, cur;
		if (inArray.length == 0)
			return null;
		rv = new ListNode(inArray[0]);

		if (inArray.length > 1) {
			cur = rv;
			for (int i=1; i<inArray.length; i++ ) {
				cur.next = new ListNode(inArray[i]);
				cur = cur.next;
			}
		}
		return rv;
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	    
	}
}
