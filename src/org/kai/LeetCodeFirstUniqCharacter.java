package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeFirstUniqCharacter {



public static void main(String[] args) {
	// https://leetcode.com/problems/first-unique-character-in-a-string/description/
	LeetCodeFirstUniqCharacter me = new LeetCodeFirstUniqCharacter();
	String testcase1 = "leetcode";
	String testcase2 = "loveleetcode";
	String testcase3 = "";
	String testcase4 = "lleeiitt";
	String testcase5 = "lllllllllllllllllllllllllllllllllllllllllllllllleeeeeeeeeeeeeeeeeeeeeeeeeeeeeiiiiiiiiiiiiiiiiiiiiiiit";
	
	long startTime = System.currentTimeMillis();
	
	System.out.println (me.firstUniqChar(testcase1)); // 0
	System.out.println (me.firstUniqChar(testcase2));  // 2
	System.out.println (me.firstUniqChar(testcase3));  // -1
	System.out.println (me.firstUniqChar(testcase4));  // -1
	System.out.println (me.firstUniqChar(testcase5));  // 100
	System.out.println (me.firstUniqChar2(testcase1)); // 0
	System.out.println (me.firstUniqChar2(testcase2));  // 2
	System.out.println (me.firstUniqChar2(testcase3));  // -1
	System.out.println (me.firstUniqChar2(testcase4));  // -1
	System.out.println (me.firstUniqChar2(testcase5));  // 100
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));


}

	public int firstUniqChar(String s) {  // BigO(n). but container contains() add() and remove() could be expensive.
		Set<Character> tfound = new LinkedHashSet<>();
		Set<Character> tuniq = new LinkedHashSet<>();
		char[] a = s.toCharArray();
		for (char c: a ) {
			if (tfound.contains(c))
				tuniq.remove(c);
			else {
				tfound.add(c);
				tuniq.add(c);
			}
		}
		if (tuniq.size() == 0)
			return -1;
		return (int)s.indexOf((char)tuniq.toArray()[0]);
	}	
	
	public int firstUniqChar2(String s) { // BigO(n) + BigO(26).  But operation on int[26] much faster than containers
		int[] map = new int[26];
		int lowest = Integer.MAX_VALUE;
		int i=0;
		char[] a = s.toCharArray();
		for (char c: a ) {
			map[(int)c-97]++;  // a-z is ranges 97 to 122
		}
		for (; i<map.length ; i++) {  // loop over int[26] rather than loop over char c:a gives gives BigO(26) instead of BigO(N)
			if (map[i] == 1) {
				if ((int)s.indexOf((char)i+97) < lowest)
					lowest = (int)s.indexOf((char)i+97);
			}
		}
		if (lowest==Integer.MAX_VALUE)
			return -1;
		return lowest;
	}	
		
}
