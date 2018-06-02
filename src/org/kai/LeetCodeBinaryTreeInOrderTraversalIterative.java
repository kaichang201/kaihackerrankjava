package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeInOrderTraversalIterative.TreeNode;


public class LeetCodeBinaryTreeInOrderTraversalIterative {

	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	  static LeetCodeBinaryTreeInOrderTraversalIterative me = new LeetCodeBinaryTreeInOrderTraversalIterative();
public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	
	System.out.println(inorderTraversal(testCase1()));

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

static public TreeNode testCase1 () {
	TreeNode one = me.new TreeNode(1);
	TreeNode two = me.new TreeNode(2);
	TreeNode three = me.new TreeNode(3);
	one.right = two;
	two.left = three;
	return one;
}

static public List<Integer> inorderTraversal(TreeNode root) {
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
