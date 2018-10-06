package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeWordPattern2 {



public static void main(String[] args) {
	// https://leetcode.com/problems/word-pattern-ii/description/
	LeetCodeWordPattern2 me = new LeetCodeWordPattern2();
	
	String pattern1 = "abab";
	String testcase1 = "redblueredblue"; // true
	String pattern2 = "aaaa";
	String testcase2 = "asdasdasdasd"; // true
	String pattern3 = "aabb";
	String testcase3 = "xyzabcxzyabc"; // false
	String pattern4 = "abba";
	String testcase4 = "redbluebluered"; // true
	String pattern5 = "abba";
	String testcase5 = "redblueredblue"; // false
	String pattern6 = "d";
	String testcase6 = "e"; // true
	String pattern7 = "ab";
	String testcase7 = "aa"; // false


	
	long startTime = System.currentTimeMillis();


	System.out.println(me.wordPatternMatch(pattern1, testcase1));  // true
	System.out.println(me.wordPatternMatch(pattern2, testcase2));  // true
	System.out.println(me.wordPatternMatch(pattern3, testcase3));  // false
	System.out.println(me.wordPatternMatch(pattern4, testcase4));  // true
	System.out.println(me.wordPatternMatch(pattern5, testcase5));  // false
	System.out.println(me.wordPatternMatch(pattern6, testcase6));  // true
	System.out.println(me.wordPatternMatch(pattern7, testcase7));  // false
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public boolean wordPatternMatch(String pattern, String str) {  // did this on HackerRank before as RedBlueBlueRed
		// how much do I remember? :-(
		return dfs(pattern.toCharArray(), str.toCharArray(), 0, 0, new HashMap<Character, String>());
		
	}
	
	public boolean dfs(char[] pat, char[] str, int pi, int si, Map<Character, String> m) {  // 51.15%.
		if(pat.length == pi) { // check for end condition when both pindex and sindex end simultaneously
			if (str.length == si)
				return true;  // win condition
			else
				return false;
		}
		if (si == str.length)  // Only win condition should have returned above
			return false;
		
		char p = pat[pi];
		
		if (m.containsKey(p)) {  // this pattern was previously encountered, then it must re-match exactly or else fail
			String t1 = m.get(p);
			int sright = si + t1.length();
			if (sright > str.length+1) { // not enough characters left to match this word
				//System.out.println ("Ran out of characters "+ sright + " " + str.length);
				return false;
			}
			String t2 = new String (Arrays.copyOfRange(str, si, sright));
			//System.out.println(" Comparing p " + p + " word1 " + t1 + " word2 " + t2);
			if (t1.equals(t2)) { // OMG matches exactly! keep digging} 
				//System.out.println(" Match!! " + (pi+1) + " " + " " +(sright));
				return dfs(pat, str, pi+1, sright, m);
			}
			else
				return false;			
		} else {
			int slength =1, sright;
			while (str.length >= (sright = si + slength)) {  // while loop to try incrementally longer strings
				String t2 = new String (Arrays.copyOfRange(str, si, sright));
				if (!m.containsValue(t2)) { // if key not in map, then value not allowed to be in map. try again.
					m.put(p, t2);
					//System.out.println("Trying " + p + " " + t2);
					boolean attempt = dfs(pat, str, pi+1, sright, m);
					if (attempt)
						return true;
					m.remove(p);  // backtracking
				}
				slength++;  // if attempt is returned false, try again with longer string
			}
			return false;			
		}
	}


}
