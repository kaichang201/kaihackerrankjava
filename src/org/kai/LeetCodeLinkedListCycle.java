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


public class LeetCodeLinkedListCycle {

static LeetCodeLinkedListCycle me = new LeetCodeLinkedListCycle();

public static void main(String[] args) {

}

public boolean hasCycle(ListNode head) {
	// https://leetcode.com/problems/linked-list-cycle/
	if (head == null || head.next == null || head.next.next == null)
		return false;
	ListNode slow = head, fast = head.next;
	
	while (fast != null && fast.next != null) {
		if (fast == slow)
			return true;
		slow = slow.next;
		fast = fast.next.next;
	}
	return false;
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
