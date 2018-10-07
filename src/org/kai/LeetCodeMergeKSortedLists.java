package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCodeMergeKSortedLists  {

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

	public static void main(String[] args) {
		LeetCodeMergeKSortedLists me = new LeetCodeMergeKSortedLists();
	
	    long startTime = System.currentTimeMillis();

	    int[] test11 = {1,4,5};
	    int[] test12 = {1,3,4};
	    int[] test13 = {2,6};
/*	    
		int[] testArray1a = {1,2,4};
		int[] testArray1b = {1,3,4};
		int[] testArray2a = {2,3,4,5,6};
		int[] testArray2b = {1,7,8};
*/		
		ListNode l11 = me.buildList(test11);
		ListNode l12 = me.buildList(test12);
		ListNode l13 = me.buildList(test13);
		ListNode[] l1 = {l11, l12, l13};

		System.out.println(me.mergeKLists(l1)); // 1,1,2,3,4,4,5,6
		
		l11 = me.buildList(test11);
		l12 = me.buildList(test12);
		l13 = me.buildList(test13);
		ListNode[] l3 = {l11, l12, l13};
		System.out.println(me.mergeKLists3(l3)); // 1,1,2,3,4,4,5,6	
		
		l11 = me.buildList(test11);
		l12 = me.buildList(test12);
		l13 = me.buildList(test13);
		ListNode[] l4 = {l11, l12, l13};
		System.out.println(me.mergeKLists4(l4)); // 1,1,2,3,4,4,5,6	
		 
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
    public ListNode mergeKLists(ListNode[] lists) {  //n-log-n? 9.97%
    	ListNode rv = null;
    	for (int i=0; i<lists.length; i++)
    		rv = merge(rv, lists[i]);
    	return rv;    	
    }
    
    public ListNode merge (ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	if (l2 == null)
    		return l1;
    	
    	if (l1.val < l2.val) {
    		l1.next = merge(l1.next, l2);
    		return l1;
    	} else {
    		l2.next = merge(l1, l2.next);
    		return l2;
    	}
    		
    }
    
    public ListNode mergeKLists2(ListNode[] lists) {
    	PriorityQueue<ListNode> p = new PriorityQueue<>();
    	ListNode rv = new ListNode(100), tail = rv;
    	for (ListNode n: lists)
    		while ( n != null) {
    			p.add(n);
    			n = n.next;
    		}
    	
    	while (!p.isEmpty()) {
    		tail.next = p.poll();
    		tail = tail.next;
    	}
    	return rv.next;
    }
    
    public ListNode mergeKLists3(ListNode[] lists) {  // memory limit exceeded. OPPS!

    	PriorityQueue<ListNode> p = new PriorityQueue<>(new Comparator<ListNode> () {
    		@Override
    		public int compare(ListNode l1, ListNode l2) {
    			return l1.val - l2.val;
    		}
    	});
    	ListNode rv = new ListNode(100), tail = rv;
    	for (ListNode n: lists)
    		while ( n != null) {
    			p.add(n);
    			n = n.next;
    		}
    	
    	while (!p.isEmpty()) {
    		tail.next = p.poll();
    		tail = tail.next;
    	}
    	return rv.next;
    }

    public ListNode mergeKLists4(ListNode[] lists) {  // Add the first node of each array. sip memory instead of slurp
    	PriorityQueue<ListNode> p = new PriorityQueue<>(new Comparator<ListNode> () {
    		@Override
    		public int compare(ListNode l1, ListNode l2) {
    			return l1.val - l2.val;
    		}
    	});
    	ListNode rv = new ListNode(100), tail = rv;
    	for (ListNode n: lists)
    		if (n != null)
    			p.add(n);
    	
    	while (!p.isEmpty()) {
    		tail.next = p.poll();
    		tail = tail.next;
    		
    		if (tail.next != null)
    			p.offer(tail.next);  // add the next one
    	}
    	return rv.next;
    }

}
