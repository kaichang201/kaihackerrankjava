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


public class HackerRankAnagram {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/anagram/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	HackerRankAnagram me = new HackerRankAnagram();
	
	String testcase1 = "aaabbb";  // 3
	String testcase2 = "ab";  // 1
	String testcase3 = "abc";  // -1
	String testcase4 = "mnop";  // 2
	String testcase5 = "xyyx";  // 0
	String testcase6 = "xaxbbbxx";  // 1
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.anagram(testcase1)); // 3
	System.out.println(me.anagram(testcase2)); // 1
	System.out.println(me.anagram(testcase3)); // -1
	System.out.println(me.anagram(testcase4)); // 2
	System.out.println(me.anagram(testcase5)); // 0
	System.out.println(me.anagram(testcase6)); // 1
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int anagram(String s) {  // extend on yesterday's challenge
		if (s.length() % 2 == 1)
			return -1; // if odd, return can't be done
		return (makingAnagrams(s.substring(0, s.length()/2), s.substring(s.length()/2, s.length())))/2;
	}
	
	public int makingAnagrams(String s1, String s2) {  // O(2n) + 26
		// It is guaranteed that  and  consist of lowercase English letters, ascii[a-z]
		int offset = 97; // in ascii a-z is 97 to 122.  so offset of 97 makes it fit into array 0 to 25
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		int rv = 0;
	
		for (char c: s1.toCharArray())  // iterate every character of string and increment its value
			a1[(int)c-offset]++;

		for (char c: s2.toCharArray())
			a2[(int)c-offset]++;
		
		for (int i=0; i < a1.length; i++)  // count the number of differences
			rv+= Math.abs(a1[i]-a2[i]);

		return rv;	
	}
	
	
}
