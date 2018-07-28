package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeWordBreak {

static LeetCodeWordBreak me = new LeetCodeWordBreak();

public static void main(String[] args) {
	// https://leetcode.com/problems/word-break/description/
	String s1 = "leetcode";
	String[] wordDict1 = {"leet", "code"};
	List<String> l1 = new ArrayList<>();
	for (String w: wordDict1)
		l1.add(w);
	
	String s2= "applepenapple";
	String[] wordDict2 = {"apple", "pen"};	
	List<String> l2 = new ArrayList<>();
	for (String w: wordDict2)
		l2.add(w);
	
	String s3 = "catsandog";
	String[] wordDict3 = {"cats", "dog", "sand", "and", "cat"};
	List<String> l3 = new ArrayList<>();
	for (String w: wordDict3)
		l3.add(w);
	
	String s4 = "abcd";
	String[] wordDict4 = {"a","abc","b","cd"};
	List<String> l4 = new ArrayList<>();
	for (String w: wordDict4)
		l4.add(w);
	
	String s5 = "leetcode";
	String[] wordDict5 = {"code","a","leet"};
	List<String> l5 = new ArrayList<>();
	for (String w: wordDict5)
		l5.add(w);

	long startTime = System.currentTimeMillis();
	

	System.out.println(me.wordBreak(s1, l1)); // true
	System.out.println(me.wordBreak(s2, l2)); // true
	System.out.println(me.wordBreak(s3, l3)); // false
	System.out.println(me.wordBreak(s4, l4)); // true
	System.out.println(me.wordBreak(s5, l5)); // true
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
startTime = System.currentTimeMillis();
	

	System.out.println(me.wordBreak2(s1, l1)); // true
	System.out.println(me.wordBreak2(s2, l2)); // true
	System.out.println(me.wordBreak2(s3, l3)); // false
	System.out.println(me.wordBreak2(s4, l4)); // true
	System.out.println(me.wordBreak2(s5, l5)); // true
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();

	System.out.println(me.wordBreak3(s1, l1)); // true
	System.out.println(me.wordBreak3(s2, l2)); // true
	System.out.println(me.wordBreak3(s3, l3)); // false
	System.out.println(me.wordBreak3(s4, l4)); // true
	System.out.println(me.wordBreak3(s5, l5)); // true
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	public boolean wordBreak(String s, List<String> wordDict) {  // dfs
		List<String> result = dfs(s, wordDict);
		System.out.println("s " + result.toString());
		return (result.size() > 0);
	}

	public List<String> dfs (String s, List<String> wordDict) {  // dfs
		List<String> rv = new ArrayList<>();

		if ("".equals(s)) {
			rv.add("");
			return rv;
		}
		
		for (String w : wordDict) {
			if (s.startsWith(w)) {
				List<String> result = dfs(s.substring(w.length()),wordDict);
				if (result.size() > 0) {
					rv.add(w);
					rv.addAll(result);
				}
			}
		}
		return rv;		
	}
	
	public boolean wordBreak2(String s, List<String> wordDict) {  // dfs with memoization
		List<String> result = dfs2(s, wordDict, new HashMap<String, List<String>>());
		//System.out.println("s " + result.toString());
		return (result.size() > 0);
	}

	public List<String> dfs2 (String s, List<String> wordDict, Map<String, List<String>> map) {  // dfs  with memoization
		List<String> rv = new ArrayList<>();
		
		if (map.containsKey(s))
			return map.get(s);

		if ("".equals(s)) {
			rv.add("");
			return rv;
		}
		
		for (String w : wordDict) {
			if (s.startsWith(w)) {
				List<String> result = dfs2(s.substring(w.length()),wordDict, map);
				if (result.size() > 0) {
					rv.add(w);
					rv.addAll(result);
				}
			}
		}
		map.put(s, rv);
		return rv;		
	}
	
	public boolean wordBreak3(String s, List<String> wordDict) {  // dfs with memoization
		return dfs3(s, wordDict, new HashMap<String, Boolean>());
	}

	public boolean dfs3 (String s, List<String> wordDict, Map<String, Boolean> map) {  // dfs  with memoization
		boolean rv = false;
		
		if (map.containsKey(s))
			return map.get(s);

		if ("".equals(s))
			return true;
		
		for (String w : wordDict) {
			if (s.startsWith(w)) {
				rv = dfs3(s.substring(w.length()),wordDict, map);
				if (rv)
					break;  // once I find a true, no need to keep looking
			}
		}
		map.put(s, rv);
		return rv;		
	}
}
