package org.kai;


import java.util.*;


public class LeetCodePartiionLabels {

static LeetCodePartiionLabels me = new LeetCodePartiionLabels();

	public static void main(String[] args) {
		// https://leetcode.com/problems/partition-labels/
		/*
		 * A string S of lower case letters is given.  We want to partition this string into as many parts as possible
		 * so that each letter appears in at most 1 part, and return a list of integers representing the size of thees parts.
		 * Example:
		 * S = "ababcbacadefegdehijhklij"
		 * output [9,7,8]
		 * Because:
		 * Partition is ababcbaca, defegde, hijhklij
		 * each letter appears at most in 1 part
		 * ababcbacadefegde, hijhklij is incorrect because it splits S into less parts
		 * S will have length 1 to 500
		 * S will contain letters a to z.
		 * 
		 */
		String testcase1 = "ababcbacadefegdehijhklij";
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.partitionLabels(testcase1));
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	public List<Integer> partitionLabels(String S) {
		/*
		 * a - all remaining instances of a must be 0
		 * ab - all remaining instances of a or b must be 0
		 * create a int[26]
		 * loop - counts the occurrences of each letter.  O(n)
		 * loop - add letter to set, decrement count.  inner loop through set.  if every letter in set 0, then add to array
		 * return array
		 * a=97, z= 122. char-97 = 0 to 25.
		 */	
		
		int[] charCount = new int[26];
		Set<Character> s = new HashSet<>();
		int setCount = 0;
		List<Integer> rv = new ArrayList<Integer>();
		
		// loop - count the occurrences of each letter. O(n)
		for (char c: S.toCharArray())
			charCount[c-97]++;
		
		// loop - add letter to set, decrement count.
		for (char c: S.toCharArray()) {
			s.add(c);
			setCount++;
			charCount[c-97]--;
			// inner loop through set.
			boolean zeroed = true;
			for (char c2: s) {
				if (charCount[c2-97] != 0) {
					zeroed = false;
					break;
				}				
			}
			if (zeroed) { // if every letter in set 0, then add to array
				rv.add(setCount);
				s.clear();
				setCount = 0;
			}
			
		}
		
		return rv;
		
	}	
}
