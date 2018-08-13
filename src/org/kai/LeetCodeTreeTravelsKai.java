package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeTreeTravelsKai.TreeNode;


public class LeetCodeTreeTravelsKai {
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
	LeetCodeTreeTravelsKai me = new LeetCodeTreeTravelsKai();

    long startTime = System.currentTimeMillis();
    
	Integer[] testTreeKai = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

	TreeNode treeKai = me.buildBTree(testTreeKai, 1);
	System.out.println(me.bfs(treeKai));
	System.out.println(me.dfs(treeKai));
	List<String> l = new ArrayList<>();
	me.dfsInOrder(treeKai, l);
	System.out.println(l);
	
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
    
	
}

public String bfs(TreeNode n) {  // Breadth-First Search, Top -> Down, Left -> Right
	ArrayList<String> a = new ArrayList<>();
	Deque<TreeNode> q = new ArrayDeque<>();  // for BFS, use a queue
	  q.add(n);
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

public String dfs(TreeNode n) {  // Depth First Search, Top -> Down, Left -> Right
	ArrayList<String> a = new ArrayList<>();
	Deque<TreeNode> q = new ArrayDeque<>(); // for DFS, use stack
	  q.add(n);
	  while(!q.isEmpty()) {
		  TreeNode t = q.removeLast();  // add to last, remove from last. so like a stack 
		  if (t != null && t.val != null) {
			  a.add(String.valueOf(t.val));
			  
	  		  if (t.right != null)  // push first, so when it pops from stack left pops first
	  			  q.add(t.right);
	  		  else
	  			  q.add(new TreeNode(null)); // deque doesn't like nulls
	
			  
	  		  if (t.left != null)
	  			  q.add(t.left);
	  		  else
	  			  q.add(new TreeNode(null));  // deque doesn't like nulls
		  }
		  else if (t.val == null)
			  a.add("null");

	  }
	  return a.toString();	
}

public void dfsInOrder(TreeNode n, List<String> l) {  // Depth First Search, Top -> Down, Left -> Right
	if (n == null)
		return;
	dfsInOrder(n.left, l);
	l.add(String.valueOf(n.val));
	dfsInOrder(n.right, l);
	
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
