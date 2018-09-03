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


public class CrackingCode76ShuffleLinkedList {


	class ListNode {
		int val;
		ListNode next;
		ListNode prev;
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
	For example, suppose you had a linked list a1->a2->... ->an->b1->b2->... ->bn and
	you wanted to rearrange it into a1->b1->a2->b2->... ->an->bn.You do not know the
	length of the linked list (but you do know that the length is an even number).
		*/
		CrackingCode76ShuffleLinkedList me = new CrackingCode76ShuffleLinkedList();
		
		int[] testcase1 = {0,1,2,3,4,5,6,7,8,9,};
		int[] testcase2 = {10,11,12,13,14,15,16,17,18,19};
		
		ListNode l1 = me.buildLinkedList(testcase1);
		ListNode l2 = me.buildLinkedList(testcase2);
		
		long startTime = System.currentTimeMillis();

		System.out.println(l1.toString());
		me.ShuffleLinkedList(l1);
		System.out.println(l1.toString());

		/*
		System.out.println(l2.toString());
		me.ShuffleLinkedList(l2, l2.next);
		System.out.println(l2.toString());
		*/
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
		
	
	}

	public void ShuffleLinkedList(ListNode head) {  // doubly linked list
		ListNode slow = head;
		ListNode fast = slow.next; //if this throws a null pointer exception, then LinkedList was empty
		
		while(fast.next != null) {  // if this throws a null pointer exception, then LinkedList was odd and sized 1.
			slow = slow.next;
			fast = fast.next.next;  // if this throws a null pointer exception, then linked list was not sized even.
		}  // iterate until fast points to last node.
		
		// break fast and slow into 2 lists
		slow.next = null;
		
		while (slow != null) {
			//System.out.println("b s " + slow + " f " + fast);
			ListNode node = fast;  // remember last step;
			fast = fast.prev; // step back fast
			
			node.next = slow.next; // 
			slow.next = node; // set node to new position
			node.prev = slow;
			
			slow = slow.prev;  // step back slow
			//System.out.println("a s " + slow + " f " + fast);
		}
	}
	
	
	public ListNode buildLinkedList (int[] array) {
		return buildLinkedList (array, 0);	
	}
	public ListNode buildLinkedList (int[] array, int index) {
		if (index >= array.length)
			return null;
		ListNode me = new ListNode(array[index]);
		me.next = buildLinkedList(array, index+1);
		if (me.next != null)
			me.next.prev = me;
		return me;
	}
}
