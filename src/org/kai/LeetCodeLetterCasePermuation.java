package org.kai;

import java.security.MessageDigest;
import java.util.*;




public class LeetCodeLetterCasePermuation {
	// https://leetcode.com/problems/letter-case-permutation/description/

	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public static void main(String[] args) {
		LeetCodeLetterCasePermuation me = new LeetCodeLetterCasePermuation();
	
	    long startTime = System.currentTimeMillis();
	    String testcase1 = "a1b2";
	    String testcase2 = "3z4";
	    String testcase3 = "12345";
	    String testcase4 = "a1B2";
	    String testcase5 = "";
	
	
	    System.out.println(me.letterCasePermutation(testcase1)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation(testcase2)); // [3z4, 3Z4]
	    System.out.println(me.letterCasePermutation(testcase3)); // ["12345"]
	    System.out.println(me.letterCasePermutation(testcase4)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation(testcase5)); // []
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	    
	    startTime = System.currentTimeMillis();
	    System.out.println(me.letterCasePermutation2(testcase1)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation2(testcase2)); // [3z4, 3Z4]
	    System.out.println(me.letterCasePermutation2(testcase3)); // ["12345"]
	    System.out.println(me.letterCasePermutation2(testcase4)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation2(testcase5)); // []
	   
	  
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	    
	    startTime = System.currentTimeMillis();
	    System.out.println(me.letterCasePermutation3(testcase1)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation3(testcase2)); // [3z4, 3Z4]
	    System.out.println(me.letterCasePermutation3(testcase3)); // ["12345"]
	    System.out.println(me.letterCasePermutation3(testcase4)); // ["a1b2", "a1B2", "A1b2", "A1B2"]
	    System.out.println(me.letterCasePermutation3(testcase5)); // []
	   
	  
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public List<String> letterCasePermutation(String S) {  // beat 8% of java submissions
		Set<String> s = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		
		s.add(S);
		if ("".equals(S))
			return new ArrayList<String>(s);
		
		for (int i = 0; i < S.length(); i++ ) {
			Character c = S.charAt(i);
			if (Character.isLetter(c)) {
				if (i == S.length()) {
					for (String S2 : s) {
						s2.add(S2.substring(0,i)+Character.toUpperCase(c));
						s2.add(S2.substring(0,i)+Character.toLowerCase(c));
					}
				} else {
					for (String S2 : s) {
						s2.add(S2.substring(0,i)+Character.toUpperCase(c) + S2.substring(i+1,S.length()) );
						s2.add(S2.substring(0,i)+Character.toLowerCase(c) + S2.substring(i+1,S.length()) );
					}
				}
				s.addAll(s2);
				s2.clear();
			}
		}
	
		return new ArrayList<String>(s);
	}
	
	public List<String> letterCasePermutation2(String S) {  // 69.96% 8ms
		Set<String> s = new HashSet<>();
		
		dfs(S.toCharArray(), 0, s);
		return new ArrayList<String>(s);
	}
	
	public void dfs (char[] chars, int i, Set<String> rv ) {
		if (i == chars.length) {  // reached the end
			rv.add(new String(chars));
			return;
		}

		dfs(chars, i+1, rv); // recurse on self;
		if (chars[i] >= 'A') { // array only has alphanumeric. if alpha
			int offset = (chars[i] >'Z') ? -32 : 32;  // lower case shifts back 32 characters for upper and vice versa
			chars[i] += offset;
			dfs(chars, i+1, rv); // recurse on self;
		}
		
	}
	
	public List<String> letterCasePermutation3(String S) {  // 69.96%
		List<String> rv = new ArrayList<>();
		
		dfs3(S.toCharArray(), 0, rv);
		return rv;
	}
	
	public void dfs3 (char[] chars, int i, List<String> rv ) {
		if (i == chars.length) {  // reached the end
			rv.add(new String(chars));
			return;
		}

		dfs3(chars, i+1, rv); // recurse on self;
		if (chars[i] >= 'A') { // array only has alphanumeric. if alpha
			int offset = (chars[i] >'Z') ? -32 : 32;  // lower case shifts back 32 characters for upper and vice versa
			chars[i] += offset;
			dfs3(chars, i+1, rv); // recurse on self;
		}
		
	}
 
}
