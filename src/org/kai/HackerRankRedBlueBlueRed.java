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
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;


public class HackerRankRedBlueBlueRed {



public static void main(String[] args) {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	HackerRankRedBlueBlueRed me = new HackerRankRedBlueBlueRed();
	
	String testcase1 = "redbluebluered";
	String testpattern1 = "abba";  // 1
	String testcase2 = "redblueredblue";  
	String testpattern2 = "abba";  // 0
	String testcase3 = "asdasdasdasd";  
	String testpattern3 = "aaaa";  // 1
	String testcase4 = "xyzabcxyzabc";  
	String testpattern4 = "aabb";  // 0
	String testcase5 = "redbluebluered";  
	String testpattern5 = "aaaa";  // 0
	String testcase6 = "redbluebluered";  
	String testpattern6 = "a";  // 1
	String testcase7 = "";  
	String testpattern7 = "";  // 0
	String testcase8 = "redbluebluegreen";
	String testpattern8 = "abba";  // 0
	String testcase9 = "redbluebluegreen";
	String testpattern9 = "abbb";  // 0



	
	long startTime = System.currentTimeMillis();

	System.out.println(me.patternMatch(testcase1, testpattern1)); //  1
	System.out.println(me.patternMatch(testcase2, testpattern2)); //  0
	System.out.println(me.patternMatch(testcase3, testpattern3)); //  1
	System.out.println(me.patternMatch(testcase4, testpattern4)); //  0
	System.out.println(me.patternMatch(testcase5, testpattern5)); //  0
	System.out.println(me.patternMatch(testcase6, testpattern6)); //  1
	System.out.println(me.patternMatch(testcase7, testpattern7)); //  0
	System.out.println(me.patternMatch(testcase8, testpattern8)); //  0
	System.out.println(me.patternMatch(testcase9, testpattern9)); //  0
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int patternMatch(String input, String pattern) {  // might be the like the n-queens.  DFS with backtracking
		Map<Character, String> matches = new HashMap<>();
		
		if (input.length() == 0  || pattern.length() == 0)   // if either empty, return 0
			return 0;
		else if (pattern.length() == 1) // return true
			return 1;
		
		return dfs(input, pattern, 0, 0, matches);
	}
	
	public int dfs (String input, String pattern, int inputIndex, int patternIndex, Map<Character, String> matches) {
		int rv = 0;
		if (inputIndex == input.length() && patternIndex == pattern.length()) {
			//System.out.println("##Reached the end.  Happiness");
			return 1;  // both Index went to the end at the same time. True match
		}
		if (inputIndex > input.length() || patternIndex > pattern.length())
			return 0; // if either index exceeds the length, fail
		
		Character c = pattern.charAt(patternIndex);		
		if (matches.containsKey(c)) {  // if I already have a guess word for this pattern
			String storedValue = matches.get(c);
			if (input.length() - inputIndex  < storedValue.length()) {
				return 2;
			}
			String inputValue = input.substring(inputIndex, inputIndex+storedValue.length());

			if (storedValue.equals(inputValue)) { // if this one matches, keep going
				//System.out.println("Matched pattern " + c  + " to word "+ storedValue);
				rv = dfs(input, pattern, inputIndex+storedValue.length(), patternIndex+1, matches);
			}
			else { // if previous match fails, backtrack to pick a new pattern
				rv= 0;		
			}
		} else {
			for (int i = inputIndex+1; i< input.length(); i++ ) {
				String tryValue = input.substring(inputIndex, i);
				matches.put(c, tryValue); // try this value
				int rv2 = dfs(input, pattern, i, patternIndex+1, matches);
				matches.remove(c);
				if (rv2 == 1 ) {  // found happiness.  return it
					return 1;
				}
				if ( rv2 == 2 ) // ran out of letters.  don't bother incrementing;
					break;
			}
		}
		return rv;
		
	}

}
