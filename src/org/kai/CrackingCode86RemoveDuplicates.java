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
		
		@Override
		public ListNode clone() {
			ListNode rv = new ListNode(this.val);
			if (this.next != null)
				rv.next = this.next.clone();
			return rv;
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
		int[] testcase3 = {2,0,1,2,3,4,5,6,7,8,3,9,10};
		int[] testcase4 = {2,0,1,2,3,4,6,7,8,3,9,0};
		int[] testcase5 = {0,1};
		int[] testcase6 = {2,0,0,2};
		int[] testcase7 = {2,0,1,0,2};
		
		ListNode l1 = me.buildLinkedList(testcase1);
		ListNode l2 = me.buildLinkedList(testcase2);
		
		long startTime = System.currentTimeMillis();

		System.out.println(l1.toString());
		System.out.println(me.RemoveDuplicates(l1));

		System.out.println(l2.toString());
		System.out.println(me.RemoveDuplicates(l2));

		System.out.println("Remove node by index");
		l1 = me.buildLinkedList(testcase1);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyIndex(l1, 4));
		
		l1 = me.buildLinkedList(testcase3);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyIndex(l1, 12));  // remove last element

		l1 = me.buildLinkedList(testcase3);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyIndex(l1, 30));  // index exceeds list size. should return original list
		
		System.out.println("Remove node by value");
		l1 = me.buildLinkedList(testcase1);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyValue(l1, 4));

		l1 = me.buildLinkedList(testcase3);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyValue(l1, 10));  // remove last element

		l1 = me.buildLinkedList(testcase3);
		System.out.println(l1.toString());
		System.out.println(l1=me.RemoveNodebyValue(l1, 30));  // val not in list. return original list


		System.out.println("Parition around value");
		l1 = me.buildLinkedList(testcase1);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, 5));  // partition exists
		
		l1 = me.buildLinkedList(testcase4);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, 5));  // partition does not exist
		
		l1 = me.buildLinkedList(testcase4);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, 0));  // partition smallest value in list

		l1 = me.buildLinkedList(testcase4);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, 9));  // partition largest value in list

		l1 = me.buildLinkedList(testcase4);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, -1));  // partition smaller than entire list
		
		l1 = me.buildLinkedList(testcase4);
		System.out.println(l1.toString());
		System.out.println(me.partitionAroundValue(l1, 300));  // partition larger than entire list

		
		System.out.println("Reverse linked list");	

		l1 = me.buildLinkedList(testcase5);
		System.out.println(l1.toString());
		System.out.println( me.reverseList(l1, 0));  
		
		l1 = me.buildLinkedList(testcase6);
		System.out.println(l1.toString());
		System.out.println( me.reverseList(l1, 0));  

		l1 = me.buildLinkedList(testcase7);
		System.out.println(l1.toString());
		System.out.println( me.reverseList(l1, 0));  

		l1 = me.buildLinkedList(testcase1);
		System.out.println(l1.toString());
		System.out.println( me.reverseList(l1, 0));  
		
		System.out.println("Clone linked list");	
		l1 = me.buildLinkedList(testcase1);
		l2 = l1.clone();
		System.out.println( me.reverseList(l1, 0));  // reverse l1
		System.out.println( l2);    // l2 remain unchanged

		System.out.println("isPalindrom linked list");	
		l1 = me.buildLinkedList(testcase1);
		System.out.println(l1.toString());
		System.out.println( me.isPalindrome(l1));  

		l1 = me.buildLinkedList(testcase5);
		System.out.println(l1.toString());
		System.out.println( me.isPalindrome(l1));  

		l1 = me.buildLinkedList(testcase6);
		System.out.println(l1.toString());
		System.out.println( me.isPalindrome(l1));  

		l1 = me.buildLinkedList(testcase7);
		System.out.println(l1.toString());
		System.out.println( me.isPalindrome(l1));  


		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	}


	public boolean isPalindrome (ListNode head) {  // a linked list is palindrome if it matches its reverse
		ListNode reverse = reverseList(head.clone(),0);
		ListNode ptr1 = head;
		ListNode ptr2 = reverse;
		while (ptr1 != null && ptr2 != null) {  // exit condition
			if (ptr1.val != ptr2.val)
				return false;
			ptr1 = ptr1.next;  // increment
			ptr2 = ptr2.next;
		}
		if (ptr1 == null && ptr2 == null ) {  // they both reached end at the same time
			return true;
		}
		return false;
		
	}
	
	public ListNode reverseList(ListNode head, int lvl) {
		ListNode rv;
		if (head == null || head.next == null)  // found tail. typical linked list recursion success condition
			return head;

		rv = reverseList(head.next, lvl+1); // reverse the next lvl
		
		head.next.next = head; // point the child to me.
		
		if (lvl == 0)
			head.next = null;  // null the tail
		return rv;
	}
	public ListNode partitionAroundValue (ListNode head, int val) {
		ListNode lessHead= null, lessTail=null, equalsHead =null, equalsTail=null, moreHead=null, moreTail=null;
		ListNode pointer = head;
		ListNode rv;
		while (pointer != null) {  // walk the list from head  BigO(n)
			if (pointer.val == val) { // equals partition
				if (equalsHead == null) {  
					equalsHead = pointer;
					equalsTail = pointer;
				} else {
					equalsTail.next = pointer;  // link new tail
					equalsTail = pointer;  // point to new tail
				}
				pointer = pointer.next;  // move the pointer
				equalsTail.next = null; // sever the link
				
			} else if (pointer.val < val) {  // less than partition
				if (lessHead == null) {
					lessHead = pointer;
					lessTail = pointer;
				} else {
					lessTail.next = pointer;  // link new tail
					lessTail = pointer;  // point to new tail
				}
				pointer = pointer.next; // move the pointer
				lessTail.next = null; // sever the link
				
			} else   {  // greater than partition
				if (moreHead == null) {
					moreHead = pointer;
					moreTail = pointer;
				} else {
					moreTail.next = pointer;  // link new tail
					moreTail = pointer;  // point to new tail;
				}
				pointer = pointer.next; // move the pointer
				moreTail.next = null; // sever the link
			}
				
		}
		rv = (lessHead != null) ? lessHead: (  // pick the first head that's not null
				(equalsHead != null) ? equalsHead: moreHead);
		
		if (lessTail != null)
			lessTail.next = (equalsHead != null) ? equalsHead: moreHead;

		if (equalsTail != null)
			equalsTail.next = moreHead;

		return rv;
		
	}

		
	public ListNode RemoveNodebyIndex (ListNode head, int index) {  // assuming 0 based index
		ListNode pointer = head;

		if (index < 0)  // not a valid case. but just in case;
			return head;

		if (index==0) // for the special case where index=0, return reference to index 1;
			return head.next;

		for (int i = 1; i < index && pointer.next != null; i++)  // increment pointer until it points to the parent of the node to remove
			pointer = pointer.next;
		if (pointer.next != null)
			pointer.next = pointer.next.next;
			
		return head;
	}
	
	public ListNode RemoveNodebyValue (ListNode head, int val) {  // assuming 0 based index
		ListNode pointer = head;

		if (head.val == val) // for the special case where value is the head of the list.
			return head.next;

		while (pointer.next != null && pointer.next.val != val )  // increment pointer until it points to the parent of the node to remove
			pointer = pointer.next;

		if (pointer.next != null)
			pointer.next = pointer.next.next;
			
		return head;
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
		ListNode[] rv = new ListNode[3];  // enhance so that it return head, mid and tail.
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
		rv[2] = fast;
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
