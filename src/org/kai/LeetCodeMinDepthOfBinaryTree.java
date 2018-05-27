package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class LeetCodeMinDepthOfBinaryTree {

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

	
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        int d =  l>r?(r==0?l:r):(l==0?r:l);
        return d+1;
        
    }
	
	
}
