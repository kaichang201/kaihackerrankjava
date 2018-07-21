package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeInOrderTraversalIterative.TreeNode;


public class LeetCodeBinaryTreeInOrderTraversalIterative {
	// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public static void main(String[] args) {
	LeetCodeBinaryTreeInOrderTraversalIterative me = new LeetCodeBinaryTreeInOrderTraversalIterative();

    long startTime = System.currentTimeMillis();
  
    System.out.println(me.inorderTraversal(me.testCase1())); //Output: [1,3,2]

  
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

 public TreeNode testCase1 () {  // Input: [1,null,2,3]  Output: [1,3,2]
	TreeNode one = new TreeNode(1);
	TreeNode two = new TreeNode(2);
	TreeNode three = new TreeNode(3);
	one.right = two;
	two.left = three;
	return one;
}

 public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> returnValue = new ArrayList<>();
	Deque<TreeNode> q = new ArrayDeque<>();
	TreeNode current=root;
	
		while (!q.isEmpty() || current != null) {
			if (current != null) {
				q.push(current);
				current = current.left;
			} else {
				TreeNode outNode = q.pop();
				returnValue.add(outNode.val);
				current = outNode.right;
			}
	}
	return returnValue;
    
}
	
	
}
