package org.kai;

import java.security.MessageDigest;
import java.util.*;




public class LeetCodeUncommonWordsFromTwoSentences {
	// https://leetcode.com/problems/uncommon-words-from-two-sentences/description/

	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public static void main(String[] args) {
		LeetCodeUncommonWordsFromTwoSentences me = new LeetCodeUncommonWordsFromTwoSentences();
	
	    long startTime = System.currentTimeMillis();
	    String testcase1a = "this apple is sweet";
	    String testcase1b = "this apple is sour";
	    String testcase2a = "apple apple";
	    String testcase2b = "banana";

	
	    System.out.println(Arrays.toString(me.uncommonFromSentences(testcase1a, testcase1b))); // ["sweet","sour"]
	    System.out.println(Arrays.toString(me.uncommonFromSentences(testcase2a, testcase2b))); // ["banana"]
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	    
	  
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public String[] uncommonFromSentences(String A, String B) { // 6ms.  not enough entries to show runtime distribution. BigO(n+m)
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		
		for (String word:  A.split(" ") ) {
			if (s1.contains(word)) {  // if not first time seeing word, it is a dup and remove from s2
				if (s2.contains(word))
					s2.remove(word);				
			} else {
				s1.add(word);  // if first time seeing word, add it to both s1 and s2.
				s2.add(word);
			}

		}
		for (String word:  B.split(" ") ) {
			if (s1.contains(word)) {  // if not first time seeing word, it is a dup and remove from s2
				if (s2.contains(word))
					s2.remove(word);				
			} else {
				s1.add(word);  // if first time seeing word, add it to both s1 and s2.
				s2.add(word);
			}

		}
		return (String[]) s2.toArray(new String[s2.size()]);
		
	}
 
}
