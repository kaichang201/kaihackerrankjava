package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeReverseWordsInAString {

static LeetCodeReverseWordsInAString me = new LeetCodeReverseWordsInAString();

	public static void main(String[] args) {
		// https://leetcode.com/problems/reverse-words-in-a-string/description/
	
		String testcase1 = "the sky is blue";
		String testcase2 = "  the sky is blue  ";
		String testcase3 = "  the sky   is   blue  ";
		String testcase4 = "the";
		
		long startTime = System.currentTimeMillis();
//		System.out.println(me.reverseWords(testcase1));  //  blue is sky the
//		System.out.println(me.reverseWords(testcase2));  //  blue is sky the
//		System.out.println(me.reverseWords(testcase3));  //  blue is sky the
		
//		System.out.println(me.reverseWords2(testcase1));  //  blue is sky the
//		System.out.println(me.reverseWords2(testcase2));  //  blue is sky the
//		System.out.println(me.reverseWords2(testcase3));  //  blue is sky the
		
		System.out.println(me.reverseWords3(testcase1));  //  blue is sky the
		System.out.println(me.reverseWords3(testcase2));  //  blue is sky the
		System.out.println(me.reverseWords3(testcase3));  //  blue is sky the
		System.out.println(me.reverseWords3(testcase4));  //  the
		
		System.out.println(me.reverseWords4(testcase1));  //  blue is sky the
		System.out.println(me.reverseWords4(testcase2));  //  blue is sky the
		System.out.println(me.reverseWords4(testcase3));  //  blue is sky the
		System.out.println(me.reverseWords4(testcase4));  //  the
		
		System.out.println(me.reverseWords5(testcase1));  //  blue is sky the
		System.out.println(me.reverseWords5(testcase2));  //  blue is sky the
		System.out.println(me.reverseWords5(testcase3));  //  blue is sky the
		System.out.println(me.reverseWords5(testcase4));  //  the
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

    public String reverseWords(String s) { //using collections  5.64%   64ms
    	String rv = "";
    	String[] words = s.trim().split(" +");
    	List<String> l = Arrays.asList(words);
    	Collections.reverse(l);
    	for (String w: l) {
    		if ("".equals(rv))
    			rv=w;
    		else
    			rv += " "+w;
    	}
    	return rv;
	}
    
    public String reverseWords2(String s) { //loop backwards on array 5.22%.  Maybe split() is expensive? 66ms
    	String rv = "";
    	String[] words = s.trim().split(" +");
    	for (int i = words.length-1; i>=0; i--) {
    		if ("".equals(rv))
    			rv=words[i];
    		else
    			rv += " "+words[i];
    	}
    	return rv;
	}	
    
    public String reverseWords3(String s) { // split manually. 12.45% 51ms  to get into 90% I need to beat 10ms??
    	String rv = "";
    	String s2 = s.trim();
    	if (s2.indexOf(" ") == -1)
    		return s2;

    	int right = s2.length();
    	int left = s2.lastIndexOf(" ", right-1);
//		System.out.println("l "+ left + " r " + right);
    	while (left > -1) {
    		String word = s2.substring(left, right);
  //  		System.out.println("l "+ left + " r " + right);
    		if (!" ".equals(word))
    			rv += word;
    		right = left;
    		left = s2.lastIndexOf(" ", right-1);
    	}
    	rv += " " + s2.substring(0,right);
    	return rv.trim();
	}	
    
    public String reverseWords4(String s) { // split manually.  4 worse performance than 3 without the pre-trim.
    	String rv = "";
    	int right = s.length();
    	int left = s.lastIndexOf(" ", right-1);
		System.out.println("l "+ left + " r " + right);
    	while (left > -1) {
    		String word = s.substring(left, right);
    		System.out.println("l "+ left + " r " + right);
    		if (!" ".equals(word))
    			rv += word;
    		right = left;
    		left = s.lastIndexOf(" ", right-1);
    	}
    	rv += " " + s.substring(0,right);
    	return rv.trim();
	}	
    
    public String reverseWords5(String s) { // split manually. Stringbuilder. 1ms 100%. because string allocation is expensive?
    	StringBuilder rv = new StringBuilder();
    	String s2 = s.trim();
    	if (s2.indexOf(" ") == -1)
    		return s2;

    	int right = s2.length();
    	int left = s2.lastIndexOf(" ", right-1);
//		System.out.println("l "+ left + " r " + right);
    	while (left > -1) {
    		String word = s2.substring(left, right);
  //  		System.out.println("l "+ left + " r " + right);
    		if (!" ".equals(word))
    			rv.append(word);
    		right = left;
    		left = s2.lastIndexOf(" ", right-1);
    	}
    	rv.append (" " + s2.substring(0,right));
    	return rv.toString().trim();
	}	
}
