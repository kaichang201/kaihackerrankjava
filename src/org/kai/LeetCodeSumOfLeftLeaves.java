package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class LeetCodeSumOfLeftLeaves {

	  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		
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
	
	
}
