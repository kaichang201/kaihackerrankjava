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


public class LeetCodeGroupAnagram {

static LeetCodeGroupAnagram me = new LeetCodeGroupAnagram();

	public static void main(String[] args) {
		// https://leetcode.com/problems/group-anagrams/description/
	
		String[] testcase1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.groupAnagrams(testcase1));  //   ["ate","eat","tea"],		  ["nat","tan"],		  ["bat"]
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

    public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> m = new HashMap<>();
		
		for (String s: strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String ss = new String(ca);
			if (!m.containsKey(ss))
				m.put(ss, new ArrayList<String>());
			m.get(ss).add(s);			
		}
		return new ArrayList<List<String>>(m.values());
	}



	
}
