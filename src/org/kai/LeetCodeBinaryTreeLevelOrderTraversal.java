package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.kai.LeetCodeMergeTwoBinaryTrees.TreeNode;


public class LeetCodeBinaryTreeLevelOrderTraversal {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      @Override
		      public String toString() { // BFS
		    	  ArrayList<String> a = new ArrayList<>();
		    	  Deque<TreeNode> q = new ArrayDeque<>();
		    	  q.add(this);
		    	  while(!q.isEmpty()) {
		    		  TreeNode t = q.remove();
		    		  if (t != null && t.val != Integer.MAX_VALUE) {
		    			  a.add(String.valueOf(t.val));
		    			  
			    		  if (t.left != null)
			    			  q.add(t.left);
			    		  else
			    			  q.add(new TreeNode(Integer.MAX_VALUE));  // deque doesn't like nulls
		
			    		  if (t.right != null)
			    			  q.add(t.right);
			    		  else
			    			  q.add(new TreeNode(Integer.MAX_VALUE)); // deque doesn't like nulls
		    		  }
		    		  else if (t.val == Integer.MAX_VALUE)
		    			  a.add("null");

		    	  }
		    	  return a.toString();
		      }
	}
	

public static void main(String[] args) {
	// https://leetcode.com/problems/binary-tree-level-order-traversal/
	/*
	 * Given a binary tree, reurn the level order traversal of its nodes values (from left to right, level by level)
	 * For example given binary tree: {3,9,20,null,null,15,7}
	 * return its level order traversal as
	 * {3},{9,20},{15,7}
	 */


	LeetCodeBinaryTreeLevelOrderTraversal me = new LeetCodeBinaryTreeLevelOrderTraversal();
	Integer [] testdata1 = {3,9,20,null,null,15,7};
	TreeNode test1 = me.buildBTree(testdata1,1);
	System.out.println(test1.toString());
	
	System.out.println(me.levelOrder(test1));
	

	long startTime = System.currentTimeMillis();
	
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

public List<List<Integer>> levelOrder(TreeNode root) {
	/*
	 * Strategy - BFS
	 * keep count of children at this level
	 * Everytime this level runs out of kids, start a new list
	 */

	List<List<Integer>> rv = new ArrayList<>();
	if (root == null)
		return rv;

	List<Integer> currentList = new ArrayList<>();
	rv.add(currentList);

	Deque<TreeNode> q = new ArrayDeque<>();
	int thisLevel=1, nextLevel=0;

	
	q.add(root);
	while (!q.isEmpty()) {
		TreeNode n = q.pop();
		currentList.add(n.val);
		
		// now process the children into the q.
		if (n.left != null) {  // from left to right,
			q.add(n.left);
			nextLevel++;
		}
		if (n.right != null) {
			q.add(n.right);
			nextLevel++;
		}
		
		thisLevel--;
		// level by level
		if (thisLevel <= 0) { // starting a new list
			thisLevel=nextLevel;
			nextLevel=0;
			currentList = new ArrayList<>();
			rv.add(currentList);
		}
	}
	if (rv.get(rv.size()-1).size() == 0) 
		rv.remove(rv.size()-1); // if the last list is empty, drop it.
    return rv;
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
