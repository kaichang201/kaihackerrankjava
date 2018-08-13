package org.kai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
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


public class HackerRankGameOfThrones2 {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/game-of-throne-ii/forum
	HackerRankGameOfThrones2 me = new HackerRankGameOfThrones2();
	
	String testcase1 = "aaabbbb";  // 3
	String testcase2 = "cdcdcdcdeeeef"; // 90
	String testcase3 = "cdefghmnopqrstuvw"; // 0
	String testcase4 = "c"; // 0
	String testcase5 = "aabbcc"; // 6
	String testcase6 = "" ; // 565288459

	
	long startTime = System.currentTimeMillis();

	System.out.println(me.solve(testcase1)); // 3
	System.out.println(me.solve(testcase2)); // 90
	System.out.println(me.solve(testcase3)); // 0
	System.out.println(me.solve(testcase4)); // 1
	System.out.println(me.solve(testcase5)); // 6

	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	startTime = System.currentTimeMillis();
	try {
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\coding\\kaihackerrankjava\\testdata\\HackerRankGameofThrones40.txt"));

		testcase6 = bReader.readLine();
		bReader.close();
	} catch (Exception e) {
		System.out.println("Exception " + e);
	}
	System.out.println("size of string " + testcase6.length());
	System.out.println(me.solve(testcase6)); // 	 565288459

	System.out.println("kai  " + me.factorial(1000)); // 	 
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
w
}

	public int solve(String s) {
		Map<Character, Integer> m = new HashMap<>();
		Map<Character, BigInteger> m2 = new HashMap<>();
		
		int oddCount = 0;
		BigInteger totalFac;
		
		if ((s.length() & 1) == 1)
			totalFac = factorial((s.length()-1)/2);
		else
			totalFac = factorial(s.length()/2);

		for (Character c : s.toCharArray()) {  // count characters
			if (m.containsKey(c))
				m.put(c, m.get(c)+1);
			else
				m.put(c, 1);
		}
		
		for (Character c : m.keySet()) {
			Integer i = m.get(c);
			if ((i & 1) == 1) {
				oddCount++;
				if (oddCount > 1)
					return 0;  // game over.  palindrome can have 0 or 1 odd characters
				totalFac = totalFac.divide(factorial((i-1)/2));
			} else {
				totalFac = totalFac.divide(factorial(i/2));
			}
		}
		

		
	//	System.out.println("totalFac " + totalFac);
			
		return totalFac.intValue();

	}
	
	public BigInteger factorial (Integer n) {
		System.out.println(" n " + n);
		BigInteger result = BigInteger.ONE;
	    for (int i = 1; i <= n; i++)
	    	result = result.multiply(BigInteger.valueOf(i));
		System.out.println(" fact " + result);
	    return result;
	}
	
	
}
