package org.kai;


import java.util.*;


public class LeetCodeMostCommonWord {

static LeetCodeMostCommonWord me = new LeetCodeMostCommonWord();

	public static void main(String[] args) {
		// https://leetcode.com/problems/most-common-word/
		// punctuations !?',;.
		String testcase1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned1 = {"hit"};
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.mostCommonWord(testcase1, banned1));
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		Map <String, Integer> m = new HashMap<>();
		Set<String> s = new HashSet<>(Arrays.asList(banned));
		int maxCount = -1;
		String returnValue = null;
		
		// iterate through paragraph to count the occurrence of each word
		// since words only consist of letters, split by space and non-letters
		for (String word : paragraph.split("\\s*[^a-zA-Z]+")) { 
			String w = word.toLowerCase(); 
			if (!s.contains(w)) {  // Only process if not in banned list
				if (m.keySet().contains(w))
					m.put(w, m.get(w)+1); // previous found. increment by 1
				else
					m.put(w, 1); // first occurrence.  Initialize to 1					
			}
		}
		
		// iterate through the words to find the one with max Count
		for (String word : m.keySet()) {
			if (maxCount < m.get(word)) { // found new max count
				maxCount = m.get(word);
				returnValue = word;
			}
		}
		return returnValue;
	}	
}
