package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeMaximumDepthofBinaryTree.TreeNode;


public class LeetCodeMaximumDepthofBinaryTree {
	// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

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
	LeetCodeMaximumDepthofBinaryTree me = new LeetCodeMaximumDepthofBinaryTree();

    long startTime = System.currentTimeMillis();
    
	Integer[] testArray1 = {3,9,20,null,null,15,7};
	Integer[] testArray2 = {3};
	Integer[] testArray3 = {3,9};
	Integer[] testArray4 = {3,9,20};

	
	TreeNode tree1 = me.buildBTree(testArray1, 1);
	TreeNode tree2 = me.buildBTree(testArray2, 1);
	TreeNode tree3 = me.buildBTree(testArray3, 1);
	TreeNode tree4 = me.buildBTree(testArray4, 1);

	System.out.println(me.maxDepth(tree1));
	System.out.println(me.maxDepth(tree2));
	System.out.println(me.maxDepth(tree3));
	System.out.println(me.maxDepth(tree4));
	 
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


public int maxDepth(TreeNode root) {
	return dfs(root,0);
}

public int dfs (TreeNode root, int depth) {
	if (root == null)
		return depth;
	int left, right;
	
	left = dfs(root.left, depth+1);
	right = dfs(root.right, depth+1);
	return (left > right) ? left : right;
}
	
	
}
