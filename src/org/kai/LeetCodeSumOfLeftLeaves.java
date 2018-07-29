package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeZigZagLevelOrderTraversal.TreeNode;


public class LeetCodeSumOfLeftLeaves {
	
	// https://leetcode.com/problems/sum-of-left-leaves/description/

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
		LeetCodeSumOfLeftLeaves me = new LeetCodeSumOfLeftLeaves();
		Integer [] testcase1 = {3,9,20,null,null,15,7};
		TreeNode tree1 = me.buildBTree(testcase1, 1);

		long startTime = System.currentTimeMillis();

		System.out.println(tree1.toString());
		
		System.out.println(me.sumOfLeftLeaves(tree1));   // 24
	
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
    public int sumOfLeftLeaves(TreeNode root) {
        int l = 0;
        int r = 0;
        if (root == null) return 0;
        
        if (root.left != null && root.left.left == null && root.left.right == null)
            l = root.left.val;
        else
            l = sumOfLeftLeaves(root.left);
        r = sumOfLeftLeaves(root.right);
        return r+l;
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
	
	
}
