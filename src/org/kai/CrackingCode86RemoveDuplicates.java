package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.kai.LeetCodeMiddleOfLinkedList.ListNode;


public class CrackingCode86RemoveDuplicates {


	class ListNode {
		int val;
		ListNode next;
//		ListNode prev;  don't need double-linked for this example
		ListNode(int x) { val = x; }
		
		@Override
		public String toString () {
			StringBuffer rv = new StringBuffer();
			rv.append(this.val+",");
			if (this.next != null)
				rv.append(this.next.toString());
			return rv.toString();
		}
		
	}

	public static void main(String[] args) {
		/*
		2.1 Write code to remove duplicates from an unsorted linked list.
		FOLLOW UP
		How would you solve this problem if a temporary buffer is not allowed?
		*/
		CrackingCode86RemoveDuplicates me = new CrackingCode86RemoveDuplicates();
		
		int[] testcase1 = {2,0,1,2,3,4,5,6,7,8,3,9,0};
		int[] testcase2 = {2,2,2,2,2,2,2,3,3,3,3,3,1,1,1,1,1};
		
		ListNode l1 = me.buildLinkedList(testcase1);
		ListNode l2 = me.buildLinkedList(testcase2);
		
		long startTime = System.currentTimeMillis();

		System.out.println(l1.toString());
		System.out.println(me.RemoveDuplicates(l1));

		System.out.println(l2.toString());
		System.out.println(me.RemoveDuplicates(l2));

			
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
		
	
	}

	public ListNode RemoveDuplicates(ListNode head) {
		// removing dups in-place could be bigO(n^2).
		// Sort first for cost of BigO(nLogN), then iterate for cost of BigO(N)
		head = mergesort(head);
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast!= null) {
			if (fast.val == slow.val) {
				slow.next = fast.next;  // drop the reference to the dup.  slow stays still
			} else {
				slow = slow.next;  // slow moves forward
			}
			fast = fast.next; // iterate fast pointer
			
		}
		return head;
	}
	
	public ListNode mergesort(ListNode head) {  // Merge Sort divide and conquer.  Break it down and build it back up.
		if (head == null  ||head.next == null)  // end condition.  this already sorted
			return head;  // spent hours on this bug.  return head, not return null.
		ListNode[] rv= splitList (head);
		ListNode r1 = mergesort(rv[0]);
		ListNode r2 = mergesort(rv[1]);
		return sortmerge(r1, r2);
	}
	
	public ListNode[] splitList (ListNode head) {
		ListNode[] rv = new ListNode[2];
		if (head == null)  // if head null, return list of nulls
			return rv;
		ListNode slow = head;
		ListNode fast = slow.next;
		while (fast != null && fast.next != null) {
			// if fast is null, reached the end and list is odd
			// if fast.next is null, reached the end and list is even
			slow = slow.next;
			fast = fast.next.next;
		}
		rv[0] = head;
		rv[1] = slow.next;
		slow.next = null;  // really split them.. like remove the reference between slow and fast half
		//System.out.println ("Split l1 "+ rv[0] + " l2 "+ rv[1]);
		return rv;
	}

	public ListNode sortmerge (ListNode l1, ListNode l2) {
		// get 2 sorted lists.  Return 1 sorted list.
		//System.out.println("merging l1 "+ l1 + " l2 " + l2);		
		if (l1 == null)  // if one of them is null, return the other
			return l2;
		if (l2 == null )
			return l1;
		
		ListNode rv;
		if (l1.val <= l2.val) {  		// recursive, because.. why not?
			rv = l1;
			rv.next = sortmerge(l1.next, l2);
		} else {
			rv = l2;
			rv.next = sortmerge(l1, l2.next);
		}

		//System.out.println("merged "+ rv);
		return rv;
	}
	
	public ListNode buildLinkedList (int[] array) {
		return buildLinkedList (array, 0);	
	}
	public ListNode buildLinkedList (int[] array, int index) {
		if (index >= array.length)
			return null;
		ListNode me = new ListNode(array[index]);
		me.next = buildLinkedList(array, index+1);
	//	if (me.next != null) 
	//		me.next.prev = me;
		return me;
	}
}
