package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.kai.CrackingCode76ShuffleLinkedList.ListNode;


public class LeetCodeReverseLinkedList {
	
	public class ListNode  {
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
	     /*
	     public int compareTo(ListNode l) {
	    	 return this.val - l.val;  // return positive if this.val is greater, negative if this.val is lesser. else equal
	     }
	     */
	     
	}
	
	static LeetCodeReverseLinkedList me = new LeetCodeReverseLinkedList();
	
	public static void main(String[] args) {
	    int[] test1 = {1,2,3,4,5};
	    ListNode testcase1 = me.buildList(test1);
	    System.out.println(testcase1);
	    long startTime = System.currentTimeMillis();
	    System.out.println(me.reverseList(testcase1));
	
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rv = dfs(head);
		head.next = null;
		return rv;

	}
	public ListNode dfs(ListNode head) {
		System.out.println(head.val);
		if (head.next == null) // success condition
			return head;
		ListNode rv = dfs(head.next);
		head.next.next = head;
		return rv;
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
	
}
