package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class LeetCodeConvertBSTToGreaterTree {

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

	
    int a = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        if (root.right != null)
            convertBST(root.right);
        a +=root.val;
        root.val = a;
        if (root.left != null)
            convertBST(root.left);
        return root;
    }
    
	
	
}
