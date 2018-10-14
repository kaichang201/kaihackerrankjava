package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.kai.LeetCodeTopKFrequentElements.TreeNode;


public class LeetCodeTopKFrequentElements {
	// https://leetcode.com/problems/top-k-frequent-elements/

	  class TreeNode {
	      Integer val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(Integer x) { val = x; }
	      @Override
	      public String toString() { // BFS
	    	  ArrayList<String> a = new ArrayList<>();
	    	  Deque<TreeNode> q = new ArrayDeque<>();
	    	  q.add(this);
	    	  while(!q.isEmpty()) {
	    		  TreeNode t = q.remove();
	    		  if (t != null && t.val != null) {
	    			  a.add(String.valueOf(t.val));
	    			  
		    		  if (t.left != null)
		    			  q.add(t.left);
		    		  else
		    			  q.add(new TreeNode(null));  // deque doesn't like nulls
	
		    		  if (t.right != null)
		    			  q.add(t.right);
		    		  else
		    			  q.add(new TreeNode(null)); // deque doesn't like nulls
	    		  }
	    		  else if (t.val == null)
	    			  a.add("null");

	    	  }
	    	  return a.toString();
	      }
	  }

public static void main(String[] args) {
	LeetCodeTopKFrequentElements me = new LeetCodeTopKFrequentElements();

    long startTime = System.currentTimeMillis();
    
	int[] testArray1 = {1,1,1,2,2,3};
	int testcase1 = 2;
	int[] testArray2 = {1};
	int testcase2 = 1;
	int[] testArray3 = {1,2};
	int testcase3 = 2;


	
	System.out.println(me.topKFrequent(testArray1, testcase1).toString()); // [1,2]
	System.out.println(me.topKFrequent(testArray2, testcase2).toString()); // [1]
	System.out.println(me.topKFrequent(testArray3, testcase3).toString()); // [1,2]

	 
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

public TreeNode buildBTree (Integer[] inArray, int root) {  // given an arraylist, build a binarytree
	TreeNode rv = null;
	int leftIndex = root * 2;
	int rightIndex = root * 2 +1;
	
	if (inArray.length >= root  && inArray[root-1] != null) { // if root points to a valid value
		rv = new TreeNode(inArray[root-1]);
		if (inArray.length >= leftIndex && inArray[leftIndex-1] != null)
			rv.left = buildBTree(inArray,leftIndex);
		if (inArray.length >= rightIndex && inArray[rightIndex-1] != null)
			rv.right = buildBTree(inArray,rightIndex);
	}
	
	return rv;
}


public List<Integer> topKFrequent(int[] nums, int k) {
	Map<Integer, Integer> m = new HashMap<>();
	for (int i: nums) 
		if (m.containsKey(i))
			m.put(i,m.get(i)+1);
		else
			m.put(i,1);
	
	List<Integer> al = new ArrayList<>(m.values());
	Collections.sort(al, Collections.reverseOrder());
	
	Integer[] rv = new Integer[k];
	
	for (Integer i: m.keySet()) {
		int count = m.get(i);
		for (int j=0; j<k; j++)
			if (al.get(j) == count) {
				rv[j] = i;
				al.set(j, -1);
				break;
			}
	}
	return Arrays.asList(rv);
}
	
	
}
