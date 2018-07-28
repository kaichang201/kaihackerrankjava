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


public class LeetCodeWordBreak2 {

static LeetCodeWordBreak2 me = new LeetCodeWordBreak2();

public static void main(String[] args) {
	// https://leetcode.com/problems/word-break-ii/description/
	List<String> testDict1 = new ArrayList<>();
	testDict1.add("cat");
	testDict1.add("cats");
	testDict1.add("and");
	testDict1.add("sand");
	testDict1.add("dog");
	String testString1 = "catsanddog";
	
	List<String> testDict2 = new ArrayList<>();
	testDict2.add("apple");
	testDict2.add("pen");
	testDict2.add("applepen");
	testDict2.add("pine");
	testDict2.add("pineapple");
	String testString2 = "pineapplepenapple";
	
	List<String> testDict3 = new ArrayList<>();
	testDict3.add("cats");
	testDict3.add("dog");
	testDict3.add("sand");
	testDict3.add("and");
	testDict3.add("cat");
	String testString3 = "catsandog";

	List<String> testDict4 = new ArrayList<>();
	testDict4.add("a");
	testDict4.add("aa");
	testDict4.add("aaa");
	testDict4.add("aaaa");
	testDict4.add("aaaaa");
	testDict4.add("aaaaaa");	
	testDict4.add("aaaaaaa");	
	testDict4.add("aaaaaaaa");	
	testDict4.add("aaaaaaaaa");	
	testDict4.add("aaaaaaaaaa");	
	String testString4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

	long startTime = System.currentTimeMillis();
	
	//s = "catsanddog"
	//wordDict = ["cat", "cats", "and", "sand", "dog"]
	System.out.println(Arrays.toString(wordBreak(testString1,testDict1).toArray()));
	System.out.println(Arrays.toString(wordBreak(testString2,testDict2).toArray()));
	System.out.println(Arrays.toString(wordBreak(testString3,testDict3).toArray()));
	//System.out.println(Arrays.toString(wordBreak(testString4,testDict4).toArray())); // too long
	
	System.out.println(Arrays.toString(wordBreak2(testString1,testDict1).toArray()));
	System.out.println(Arrays.toString(wordBreak2(testString2,testDict2).toArray()));
	System.out.println(Arrays.toString(wordBreak2(testString3,testDict3).toArray()));
	System.out.println(Arrays.toString(wordBreak2(testString4,testDict4).toArray()));
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

static public List<String> wordBreak(String s, List<String> wordDict) {
	List<String> rv = new ArrayList<>();
	
	if ("".equals(s)) {
		rv.add("");
		return rv;
	}
	
	for (String word: wordDict) {
		if (s.startsWith(word)) {
			List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
			for (String subWord: sublist)
				rv.add(word + (subWord.isEmpty()? "" : " ") + subWord);
		}
	}
	return rv;
}

static public List<String> wordBreak2 (String s, List<String> wordDict) {
	return process(s, wordDict, new HashMap<String, List<String>>());
}

static public List<String> process(String s, List<String> wordDict, Map<String,List<String>> map) {
	List<String> rv = new ArrayList<>();
	
	if (map.containsKey(s))
		return map.get(s);
	
	if ("".equals(s)) {
		rv.add("");
		return rv;
	}
	
	for (String word: wordDict) {
		if (s.startsWith(word)) {
			List<String> sublist = process(s.substring(word.length()), wordDict, map);
			for (String subWord: sublist)
				rv.add(word + (subWord.isEmpty()? "" : " ") + subWord);
		}
	}
	map.put(s,rv);
	return rv;
}

	
}
