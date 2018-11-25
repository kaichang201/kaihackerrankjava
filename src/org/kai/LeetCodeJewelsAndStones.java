package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeZigZagLevelOrderTraversal.TreeNode;


public class LeetCodeJewelsAndStones {
	
	// https://leetcode.com/problems/jewels-and-stones/
	/*
	 * You are given Strings J representing the type of stones that are jewels. and S representing the stones.
	 * Each character S is a type of Stone.
	 * You want to know how many of the stones you have are also jewels.
	 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
	 * Letters are case sensitive, so "a" is different from "A"
	 * Example 1: J = "aA", S= "aAAbbb"
	 * Output: 3
	 * Example 2: J = "z", S = "ZZ"
	 * Output:0
	 * S and J will consist of letters and have length at most 50.
	 * characters in J are distinct in J are distinct.
	 */

	  
	public static void main(String[] args) {
		LeetCodeJewelsAndStones me = new LeetCodeJewelsAndStones();

		String testcaseJ1 = "aA";
		String testcaseS1 = "aAAbbb"; // 3
		
		String testcaseJ2 = "z";
		String testcaseS2 = "ZZ";  // 0 
	
		long startTime = System.currentTimeMillis();

		
		System.out.println(me.numJewelsInStones(testcaseJ1, testcaseS1));   // 3
		System.out.println(me.numJewelsInStones(testcaseJ2, testcaseS2));   // 0
	
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
    public int numJewelsInStones(String J, String S) {
    	/*
    	 * Strategy: parse J into an boolean array size 59.  subtract 'A' for Index. A=0, Z= 26, a=33, z=58
    	 * Loop through charArray of S.  If S is in J, the count++
    	 * return count;
    	 */
    	boolean ca[] = new boolean[59];
    	int rv=0;

    	// parse J into an boolean array size 59.  subtract 'A' for Index. A=0, Z= 26, a=33, z=58
    	for (char c: J.toCharArray())
    		ca[c-'A'] = true;

    	//     	 * Loop through charArray of S.  If S is in J, the count++
    	for (char c: S.toCharArray())
    		if (ca[c-'A'])
    			rv++;
    	return rv;    			
    	
    }
	
	
}
