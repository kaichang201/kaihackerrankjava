package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeZigZagLevelOrderTraversal.TreeNode;


public class LeetCodeBinaryTreeZigZagLevelOrderTraversal {
	// https://leetcode.com/problems/merge-two-binary-trees/description/

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
	LeetCodeBinaryTreeZigZagLevelOrderTraversal me = new LeetCodeBinaryTreeZigZagLevelOrderTraversal();

    long startTime = System.currentTimeMillis();
    
    Integer[] testArray1 = {3,9,20,null,null,15,7};
    Integer[] testArray2 = {3,9,20,1,2,15,7};
    Integer[] testArray3 = {1,2,3,4,null,null,5};
	
	TreeNode tree1 = me.buildBTree(testArray1, 1); 
	System.out.println(tree1.toString());
	List<List<Integer>> result = me.zigzagLevelOrder(tree1); //  [3],[20,9],[15,7]
	System.out.println(result.size());
	for (List<Integer> l : result )
		System.out.println(l.toString());
	
	TreeNode tree2 = me.buildBTree(testArray2, 1); 
	System.out.println(tree2.toString());
	result = me.zigzagLevelOrder(tree2); // [1],[20,9],[1,2,15,7]
	System.out.println(result.size());
	for (List<Integer> l : result )
		System.out.println(l.toString());
	
	TreeNode tree3 = me.buildBTree(testArray3, 1); 
	System.out.println(tree3.toString());
	result = me.zigzagLevelOrder(tree3); // [1],[3,2],[4,5]
	System.out.println(result.size());
	for (List<Integer> l : result )
		System.out.println(l.toString());


	 
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	public TreeNode buildBTree (Integer[] inArray, int root) { 
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


	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 List<List<Integer>> rv = new ArrayList<List<Integer>>();
		 Deque<TreeNode> q1 = new ArrayDeque<>();
		 Deque<TreeNode> q2 = new ArrayDeque<>();
	 
		 if (root != null)
			 q1.add(root);
		 
		 while (!q1.isEmpty()  || !q2.isEmpty()) {
			 Deque<Integer> l = new ArrayDeque<>();
			 while (!q1.isEmpty()) {  //  queue next level right to left
				 TreeNode n = q1.removeLast();  // addLast and removeLast acts likes a stack
				 if (n.left != null)
					 q2.add(n.left);
				 if (n.right != null)
					 q2.add(n.right);
				 l.add(n.val);
			 }
			 if (l.size() > 0)
				 rv.add(new ArrayList<Integer>(l));
			 l = new ArrayDeque<>();
			 while (!q2.isEmpty()) {  //  queue next level left to right
				 TreeNode n = q2.removeLast();
				 if (n.right != null)
					 q1.add(n.right);
				 if (n.left != null)
					 q1.add(n.left);

				 l.add(n.val);
			 }
			 if (l.size() > 0)
				 rv.add(new ArrayList<Integer>(l));
		 }
	 
	     return rv;
	}
	
	
}
