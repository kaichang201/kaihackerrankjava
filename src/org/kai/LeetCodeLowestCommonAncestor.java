package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeInOrderTraversalIterative.TreeNode;


public class LeetCodeLowestCommonAncestor {
	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      public String toString() {
		    	  return String.valueOf(val);
		      }
	}
	static LeetCodeLowestCommonAncestor me = new LeetCodeLowestCommonAncestor();
	static TreeNode zero = me.new TreeNode(0);
	static TreeNode one = me.new TreeNode(1);
	static	TreeNode two = me.new TreeNode(2);
	static	TreeNode three = me.new TreeNode(3);
	static	TreeNode four = me.new TreeNode(4);
	static	TreeNode five = me.new TreeNode(5);
	static	TreeNode six = me.new TreeNode(6);
	static TreeNode seven = me.new TreeNode(7);
	static TreeNode eight = me.new TreeNode(8);
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(lowestCommonAncestor(testCase1(), five , four));  // 5
		System.out.println(lowestCommonAncestor(testCase1(), five , one));  // 3
		System.out.println(lowestCommonAncestor(testCase1(), seven , four));  // 2
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}


	static public TreeNode testCase1 () {
		three.left = five;
		three.right = one;
	
		five.left = six;
		five.right = two;
		
		one.left = zero;
		one.right = eight;

		two.left = seven;
		two.right = four;

		return three;
	}

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode returnValue = null;
    	if (root == null) return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	if (left != null && right != null)
    		returnValue = root;
    	else if (root == p || root == q)
    		returnValue = root;
    	else if (left != null)
    		returnValue = left;
    	else if (right != null)
    		returnValue = right;
    	return returnValue;
    }
	
}
