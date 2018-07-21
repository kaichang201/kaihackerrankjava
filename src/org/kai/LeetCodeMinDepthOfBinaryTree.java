package org.kai;

import java.security.MessageDigest;
import java.util.Deque;
import java.util.*;


public class LeetCodeMinDepthOfBinaryTree {

	  class TreeNode {
		      int val;
		      TreeNode left, right;
		      TreeNode(int x) { val = x; }
		      
		      @Override
		      public String toString() { // BFS
		    	  String rv = "";
		    	  Deque<TreeNode> q = new ArrayDeque<>();
		    	  q.add(this);
		    	  while(!q.isEmpty()) {
		    		  TreeNode t = q.remove();
		    		  rv += String.valueOf(t.val)+", ";
		    		  if (t.left != null)
		    			  q.add(t.left);
		    		  else
		    			  rv += "ln, ";
		    		  if (t.right != null)
		    			  q.add(t.right);
		    		  else
		    			  rv += "rn, ";
		    		  rv += "\n";
		    	  }
		    	  return rv.replaceAll(", $","");
		      }
		  }
	public static void main(String[] args) {
		// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
		long startTime = System.currentTimeMillis();
		LeetCodeMinDepthOfBinaryTree me = new LeetCodeMinDepthOfBinaryTree();

		System.out.println("\ntest1");
		Integer[] testArray1 = {3,9,20,null,null,15,7};
		TreeNode root1 = me.buildBTree(testArray1, 1);
		System.out.println(root1); // 3,9,20,null,null,15,7
		System.out.println(String.valueOf(me.minDepth(root1))); // 2

		System.out.println("\ntest2");
		Integer[] testArray2 = {3,9,20,1,null,15,7};
		TreeNode root2 = me.buildBTree(testArray2, 1);
		System.out.println(root2); // 3,9,20,1,null,15,7
		System.out.println(String.valueOf(me.minDepth(root2))); // 3

		System.out.println("\ntest3");
		Integer[] testArray3 = {3,9,20,null,1,15,7};
		TreeNode root3 = me.buildBTree(testArray3, 1);
		System.out.println(root3); // 3,9,20,null,1,15,7
		System.out.println(String.valueOf(me.minDepth(root3))); // 3


		
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
