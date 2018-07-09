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


public class LeetCodeWordPattern {

static LeetCodeWordPattern me = new LeetCodeWordPattern();

public static void main(String[] args) {
	// https://leetcode.com/problems/word-pattern/description/

	long startTime = System.currentTimeMillis();
	
	//   [["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	System.out.println(wordPattern("abba","dog cat cat dog"));  // true
	System.out.println(wordPattern("abba","dog cat cat fish"));  // false
	System.out.println(wordPattern("aaaa","dog cat cat dog"));  // false
	System.out.println(wordPattern("abba","dog dog dog dog"));  // false
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

static public boolean wordPattern(String pattern, String str) {
	String[] words = str.split(" ");
	Map<Character, String> myDict = new HashMap<>();
	
	if (words.length != pattern.length())  // lengths don't match
		return false;  
	
	for (int i = 0; i <words.length; i++) {
		char c = pattern.charAt(i);
		if (myDict.containsKey(c)) {
			if (!myDict.get(c).equals(words[i]))  // dictionary value doesn't match word value.  Mismatch
				return false;
		} else {
			if (myDict.containsValue(words[i]))  // value matches another key.  Mismatch
				return false;
			myDict.put(c, words[i]);
		}
	}
	return true;  // no mismatches found
}



	
}
