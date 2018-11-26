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

import org.kai.LeetCodeMergeKSortedLists.ListNode;


public class LeetCodeCopyListWithRandomPointer {
	
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
    @Override
    public String toString() {
   	  ArrayList<String> a = new ArrayList<>();
   	  RandomListNode cur = this;
   	  while (cur != null) {
   		  if (cur.random == null)
   	   		  a.add("{"+cur.label+"}");
   		  else
   	   		  a.add("{"+cur.label+","+cur.random.label+"}");
   		  cur = cur.next;
   	  }
   	  return a.toString();
     }

 };

// https://leetcode.com/problems/copy-list-with-random-pointer/
	public static void main(String[] args) {
		LeetCodeCopyListWithRandomPointer me = new LeetCodeCopyListWithRandomPointer();
		
	    int[] test1 = {1,2,3,4,5};
	    RandomListNode l1 = me.buildList(test1);
	    l1.random = l1.next.next; // 1 random points to 2
	    l1.next.next.random = l1;  // 3 random points to 1

	    System.out.println(l1);
		long startTime = System.currentTimeMillis();
		
		System.out.println(me.copyRandomList(l1)); 
		
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}


    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null )
    		return head;
    	
    	// Create a map to store the nodes relationships
    	Map<RandomListNode, RandomListNode> m = new HashMap<>();
    	RandomListNode node = head;
    	
    	while (node != null) {  // populate the map with the new nodes
    		m.put(node, new RandomListNode(node.label));
    		node = node.next;
    	}
    	
    	node = head;
    	
    	while (node != null) { // now map out the pointers
    		m.get(node).next = m.get(node.next);
    		m.get(node).random = m.get(node.random);
    		node = node.next;
    	}
        
    	return m.get(head);
   }
    
	public RandomListNode buildList(int[] inArray) {
		RandomListNode rv, cur;
		if (inArray.length == 0)
			return null;
		
		rv = new RandomListNode(inArray[0]);
		if (inArray.length > 1) {
			cur = rv;
			for (int i=1; i<inArray.length; i++ ) {
				cur.next = new RandomListNode(inArray[i]);
				cur = cur.next;
			}
		}
		return rv;
	}
}
