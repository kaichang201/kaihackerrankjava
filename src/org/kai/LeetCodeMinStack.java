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
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeMinStack {



public static void main(String[] args) {
	// https://leetcode.com/problems/min-stack/
	// Design a stack that supports push(), pop(), top() and retrieving the minimum element in constant time.
	// push(x)  - push element x onto stack
	// pop() - Removes the element from the top of the stack.
	// top() - get the top element
	// getMin()  -- retrieve the minium element in the stack
	// Example
	// push(-2); push(0); push(-3) getMin() // returns -3
	// pop(); top(); -- returns 0
	// getMin(); returns -2
	LeetCodeMinStack me = new LeetCodeMinStack();
	
	long startTime = System.currentTimeMillis();

	me.push(-2);
	me.push(0);
	me.push(-3);
	System.out.println(me.getMin()); // returns -3
	me.pop();
	System.out.println(me.top()); // returns 0
	System.out.println(me.getMin()); // returns -2
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	Deque<Integer> dq;
	PriorityQueue<Integer> pq; 
	/** initialize your data structure here. */
	public LeetCodeMinStack() {
	    dq = new ArrayDeque<>();
	    pq = new PriorityQueue<>();
	}
	
	public void push(int x) {
		dq.addFirst(x);
		pq.add(x);
	}
	
	public void pop() {
		pq.remove(dq.removeFirst());    
	}
	
	public int top() {
		return (int)dq.peek();
	}
	
	public int getMin() {
		return (int)pq.peek();
	}
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/


