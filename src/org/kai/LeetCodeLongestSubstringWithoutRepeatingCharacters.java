package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeLongestSubstringWithoutRepeatingCharacters {

static LeetCodeLongestSubstringWithoutRepeatingCharacters me = new LeetCodeLongestSubstringWithoutRepeatingCharacters();

	public static void main(String[] args) {
		// https://leetcode.com/problems/group-anagrams/description/
	
		String testcase1 = "abcabcbb";
		String testcase2 = "bbbbb";
		String testcase3 = "pwwkew";
		String testcase4 = "";
		String testcase5 = " ";
		String testcase6 = "aa";
		String testcase7 = "aaaaaa";
		String testcase8 = "au";
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.lengthOfLongestSubstring(testcase1));  //  3
		System.out.println(me.lengthOfLongestSubstring(testcase2));  //  1
		System.out.println(me.lengthOfLongestSubstring(testcase3));  //  3
		System.out.println(me.lengthOfLongestSubstring(testcase4));  //  0
		System.out.println(me.lengthOfLongestSubstring(testcase5));  //  1
		System.out.println(me.lengthOfLongestSubstring(testcase6));  //  1
		System.out.println(me.lengthOfLongestSubstring(testcase7));  //  1
		System.out.println(me.lengthOfLongestSubstring(testcase8));  //  2
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

    public int lengthOfLongestSubstring(String s) {  // simple case n^3 2.35%
    	int rv=1;
    	if (s.length() < 2)
    		return s.length();
    	char[] ca = s.toCharArray();
    	
    	for (int i = 0; i < ca.length; i++) {
    		for (int j = i+1; j < ca.length; j++) {
    			boolean dup = false;
    			for ( int k = j-1; k >= i; k--) {
    				if (ca[j] == ca[k]) {
    					dup = true;
    					break;
    				} else {
		    			if (rv < j - k+1) {
	    					//System.out.println("non-dup " + j + " " + k);
		    				rv = j-k+1;
		    			}
    				}
    			}
    			if (dup)
    				break;
    		}
    	}

    	return rv;
	}



	
}
