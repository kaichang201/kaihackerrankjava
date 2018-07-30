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


public class LeetCodeMiddleOfLinkedList {

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	@Override
	public String toString () {
		StringBuffer rv = new StringBuffer();
		rv.append(this.val);
		if (this.next != null)
			rv.append(this.next.toString());
		return rv.toString();
		
	}
}

public static void main(String[] args) {
	// https://leetcode.com/problems/middle-of-the-linked-list/description/
	LeetCodeMiddleOfLinkedList me = new LeetCodeMiddleOfLinkedList();


	int[] testcaseme2 = {1};
	ListNode m2 = me.buildLinkedList (testcaseme2);
	int[] testcaseme3 = {1,2};
	ListNode m3 = me.buildLinkedList (testcaseme3);
	int[] testcaseme4 = {1,2,3};
	ListNode m4 = me.buildLinkedList (testcaseme4);
	int[] testcaseme5 = {1,2,3,4};
	ListNode m5 = me.buildLinkedList (testcaseme5);



	int[] testcase1 = {1,2,3,4,5};
	ListNode l1 = me.buildLinkedList (testcase1);
	int[] testcase2 = {1,2,3,4,5,6};
	ListNode l2 = me.buildLinkedList (testcase2);


	
	
	System.out.println(l1); //12345
	System.out.println(l2); //123456

	System.out.println(me.middleNode(m2)); //1
	System.out.println(me.middleNode(m3)); //2
	System.out.println(me.middleNode(m4)); //23
	System.out.println(me.middleNode(m5)); //34
	System.out.println(me.middleNode(l1)); //345
	System.out.println(me.middleNode(l2)); //456
	
	long startTime = System.currentTimeMillis();

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

public ListNode buildLinkedList (int[] array) {
	return buildLinkedList (array, 0);	
}
public ListNode buildLinkedList (int[] array, int index) {
	if (index >= array.length)
		return null;
	ListNode me = new ListNode(array[index]);
	me.next = buildLinkedList(array, index+1);
	return me;
}

public ListNode middleNode(ListNode head) { // 1ms. 100%  Everybody is 1ms.  Everyone has same ago. https://leetcode.com/submissions/detail/166661289/
	if (head == null)
		return null;
	if (head.next == null)
		return head;
	ListNode slow = head;
	ListNode fast = slow.next;

	
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}
	if (fast == null)  // array is odd length
		return slow;
	return slow.next;  // array is even length
}

}
