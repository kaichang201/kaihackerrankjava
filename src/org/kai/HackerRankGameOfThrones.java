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


public class HackerRankGameOfThrones {



public static void main(String[] args) {
	//https://www.hackerrank.com/challenges/game-of-thrones/problem
	HackerRankGameOfThrones me = new HackerRankGameOfThrones();
	
	String testcase1 = "aabbccdd";  // YES
	String testcase2 = "aaabbbb";  // YES
	String testcase3 = "cdefghmnopqrstuvw"; // NO
	String testcase4 = "cdcdcdcdeeeef"; //YES
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.gameOfThrones(testcase1)); // YES
	System.out.println(me.gameOfThrones(testcase2)); // YES
	System.out.println(me.gameOfThrones(testcase3)); // NO
	System.out.println(me.gameOfThrones(testcase4)); // YES
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public String gameOfThrones(String s) {  // BigO(n)
		Set<Character> s1 = new HashSet<>();
		for (Character c : s.toCharArray()) {
			if (s1.contains(c))
				s1.remove(c);
			else
				s1.add(c);
		}
		
		if (s1.size() == 0 || s1.size() == 1)
			return "YES";
		return "NO";

	}
	
	
}
