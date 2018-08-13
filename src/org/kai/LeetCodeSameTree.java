package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeSameTree.TreeNode;


public class LeetCodeSameTree {
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
	LeetCodeSameTree me = new LeetCodeSameTree();

    long startTime = System.currentTimeMillis();
    
	Integer[] testTree1a = {1,2,3};
	Integer[] testTree1b = {1,2,3};
	Integer[] testTree2a = {1,2};
	Integer[] testTree2b = {1,null,2};
	Integer[] testTree3a = {1,2,1};
	Integer[] testTree3b = {1,1,2};
	Integer[] testTreeKai = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

	
	TreeNode tree1a = me.buildBTree(testTree1a, 1);
	TreeNode tree1b = me.buildBTree(testTree1b, 1);
	TreeNode tree2a = me.buildBTree(testTree2a, 1);
	TreeNode tree2b = me.buildBTree(testTree2b, 1);
	TreeNode tree3a = me.buildBTree(testTree3a, 1);
	TreeNode tree3b = me.buildBTree(testTree3b, 1);
	
	System.out.println(me.isSameTree(tree1a, tree1b)); // true
	System.out.println(me.isSameTree(tree2a, tree2b)); // false
	System.out.println(me.isSameTree(tree3a, tree3b)); // false

	System.out.println(me.isSameTree2(tree1a, tree1b)); // true
	System.out.println(me.isSameTree2(tree2a, tree2b)); // false
	System.out.println(me.isSameTree2(tree3a, tree3b)); // false
	
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
    
}



public boolean isSameTree(TreeNode p, TreeNode q) { // 3 ms. 99.07%
	if (p == null && q == null)  // both null, return true
		return true;

	if ((p == null && q != null) || (q == null  && p != null))  // one null, one not null, return false;
		return false;
	
	if (p.val != q.val)
		return false;
	if (!isSameTree(p.left, q.left))
		return false;
	if (!isSameTree(p.right, q.right))
		return false;
	return true;

}

public boolean isSameTree2(TreeNode p, TreeNode q) { // 3 ms. 99.07%
	if (p == null && q == null)  // both null, return true
		return true;

	if (p == null  || q == null )  // if one null, return false;
		return false;
	
	if (p.val != q.val)  // if value doesn't match return false
		return false;
	
	return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));  // both true then return true. either false return false;

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
	
	
}
