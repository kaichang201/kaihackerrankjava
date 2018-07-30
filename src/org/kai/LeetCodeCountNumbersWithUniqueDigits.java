package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class LeetCodeCountNumbersWithUniqueDigits {
	
	// https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/153229/Java-Recursion-Solution

	  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		LeetCodeCountNumbersWithUniqueDigits me = new LeetCodeCountNumbersWithUniqueDigits(); 
		long startTime = System.currentTimeMillis();
		
		System.out.println(me.countNumbersWithUniqueDigits(2));
		System.out.println(me.countNumbersWithUniqueDigits(3));
		System.out.println(me.countNumbersWithUniqueDigits(4));

		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	

	public int countNumbersWithUniqueDigits(int n) {  // I would need more work to understand this.
		// really good explanation on https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83041/JAVA-DP-O(1)-solution.
		if (n==0) {return 1;}
		if (n==1) {return 10;}
		int temp = 9;
		int fac = 9;
		for (int i=1; i<n; i++) {
			temp *= fac;
			fac--;
			System.out.println("n " + n + " i " + i + " temp " + temp + " fac " + fac);
		}
		
		return countNumbersWithUniqueDigits(n-1)+temp;
    }
    
	
	
}
