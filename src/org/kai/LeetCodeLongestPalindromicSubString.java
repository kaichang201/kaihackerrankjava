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


public class LeetCodeLongestPalindromicSubString {

static LeetCodeLongestPalindromicSubString me = new LeetCodeLongestPalindromicSubString();

	public static void main(String[] args) {
		// https://leetcode.com/problems/longest-palindromic-substring/
	
		String testcase1 = "babad"; // aba
		String testcase2 = "cbbd"; // bb
		String testcase3 = ""; // ""
		String testcase4 = "a";  // "a"
		String testcase5 = "aa"; // "aa"
		String testcase6 = "aba";  // "aba"
		String testcase7 = "abba";  // "abba"
		String testcase8 = "babba"; // "abba"
		String testcase9 = "babbac"; // "abba"
		String testcase10 = "babac"; //"aba"
		String testcase11 = "aaa"; //"aaa"
		String testcase12 = "aaaa"; //"aaaa"
		String testcase13 = "aaaaa"; //"aaaaa"
		String testcase14 = "aaaaaa"; //"aaaaaa"



		
		long startTime = System.currentTimeMillis();
		
		startTime = System.currentTimeMillis();
		System.out.println(me.longestPalindrome(testcase1));  //  aba or bab
		System.out.println(me.longestPalindrome(testcase2));  //  bb
		System.out.println(me.longestPalindrome(testcase3));  //  ""
		System.out.println(me.longestPalindrome(testcase4));  //  "a"
		System.out.println(me.longestPalindrome(testcase5));  //  aa
		System.out.println(me.longestPalindrome(testcase6));  //  aba
		System.out.println(me.longestPalindrome(testcase7));  //  abba
		System.out.println(me.longestPalindrome(testcase8));  //  abba
		System.out.println(me.longestPalindrome(testcase9));  //  abba
		System.out.println(me.longestPalindrome(testcase10));  //  aba or bab
		System.out.println(me.longestPalindrome(testcase11));  //  aaa
		System.out.println(me.longestPalindrome(testcase12));  //  aaaa
		System.out.println(me.longestPalindrome(testcase13));  //  aaaaa
		System.out.println(me.longestPalindrome(testcase14));  //  aaaaaa

		
		System.out.println("2Time taken " + (System.currentTimeMillis() - startTime));
	}

    public String longestPalindrome2(String s) {
    	// if s is null, empty or 1 character, then just return itself. Simple case.
    	if (s == null || s.length() <=1) 
    		return s;
    	char[] c = s.toCharArray();
    	if (c.length == 2  && c[0] == c[1])  // speical case for when character is like "aa", because left will be quickly -1
    		return s;

    	// for non-empty string, the shortest palindrome is 1 character. let's start there
    	String rv = String.valueOf(c[0]);
    	   	
    	for (int i = 0; i < c.length; i++) { // loop through every character. probably some room for optimization later.
    		String cPali = String.valueOf(c[i]); // 1 character is always a Palindrome.
    		boolean isPali= true;
    		int left = i-1, right = i+1;  // look left, look right
    		while (isPali && left >= 0 && right <c.length ) {
    			if (cPali.length() == 1 && c[i] == c[right]) { // specific case. if current Palidrome is 1 character, can grow into even palindrome
				cPali = String.copyValueOf(c, i, 2);
					if (cPali.length() > rv.length()) {
						System.out.println("2New " + cPali + " Old " + rv);
						rv = cPali;
					}
					right++;
    			} else  if (c[left] == c[right]) { // general case. grow palindrome left and right simultaneously
    				cPali = String.copyValueOf(c, left, right-left+1);
    				if (cPali.length() > rv.length()) {
    					System.out.println("1New " + cPali + " Old " + rv);
    					rv = cPali;
    				}
    				left--;
    				right++;
    			} else { // opps. stop growing Palindrom
    				isPali = false;
    			}
    		}
    		
    	}
    	return rv;
    }
    
    public String longestPalindrome(String s) {
    	// if s is null, empty or 1 character, then just return itself. Simple case.
    	if (s == null || s.length() <=1) 
    		return s;
    	char[] c = s.toCharArray();
    	if ( (c.length == 2  && c[0] == c[1])  // special case for when String is like "aa"
    			|| (c.length == 3  && c[0] == c[2])) // special case for when String is like "aba"
    		return s;

    	// for non-empty string, the shortest palindrome is 1 character. let's start there
    	String rv = String.valueOf(c[0]);
    	
    	for (int i = 0; i < c.length; i++) {
    		// Look odd
    		String cPali = dfs (c, String.valueOf(c[i]), i-1, i+1);
    		if (cPali.length() > rv.length()) {
    			//System.out.println("Odd i " + i + " cPali " + cPali);
    			rv = cPali;
    		}
    		// Look even
    		if (i < c.length-1 && c[i] == c[i+1]) {
    			cPali = dfs (c, String.copyValueOf(c, i, 2), i-1, i+2);
        		if (cPali.length() > rv.length()) {
        			//System.out.println("Even i " + i + " cPali " + cPali);
        			rv = cPali;
        		}
    		}
    	}
    	return rv;
    		
    }

    public String dfs (char[] c, String cPali, int left, int right) {
    	if (left < 0 || right >= c.length || c[left] != c[right])  // end condition
    		return cPali;
    	else
    		return dfs (c, String.copyValueOf(c, left, right-left+1), left-1, right+1);
    }
	
}
