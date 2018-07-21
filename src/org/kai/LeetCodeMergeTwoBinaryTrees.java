package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeMergeTwoBinaryTrees.TreeNode;


public class LeetCodeMergeTwoBinaryTrees {
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
	LeetCodeMergeTwoBinaryTrees me = new LeetCodeMergeTwoBinaryTrees();

    long startTime = System.currentTimeMillis();
    
	Integer[] testArray1a = {1,3,2,5,null,null,null};
	Integer[] testArray1b = {2,1,3,null,4,null,7};
	
	TreeNode tree1a = me.buildBTree(testArray1a, 1);
	TreeNode tree1b = me.buildBTree(testArray1b, 1); 
	System.out.println(tree1a); // {1, 3, 2, 5, null, null, null};
	System.out.println(tree1b); // {2, 1, 3, null, 4, null, 7};
	System.out.println(me.mergeTrees(tree1a, tree1b)); // 3, 4, 5, 5, 4, null, 7
	System.out.println(me.mergeTrees(tree1b, tree1b)); // 4, 2, 6, null, 8, null, 14
	System.out.println(me.mergeTrees(tree1a, tree1a)); // 2, 6, 4, 10, null, null, null

	 
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


public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	 TreeNode rv;
	 
	 if (t1 == null)
		 return t2;
	 if (t2 == null)
		 return t1;
     rv = new TreeNode(t1.val+t2.val);
     rv.left = mergeTrees(t1.left, t2.left);
     rv.right = mergeTrees(t1.right, t2.right);
     return rv;
}
	
	
}
