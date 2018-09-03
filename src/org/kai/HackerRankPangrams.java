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


public class HackerRankPangrams {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/pangrams/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	HackerRankPangrams me = new HackerRankPangrams();
	
	String testcase1 = "The quick brown fox jumps over the lazy dog"; // panagram
	String testcase2 = "We promptly judged antique ivory buckles for the next prize"; // panagram
	String testcase3 = "We promptly judged antique ivory buckles for the prize"; // not panagram
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.pangrams(testcase1)); // pangrams
	System.out.println(me.pangrams(testcase2)); // pangrams
	System.out.println(me.pangrams(testcase3)); // not pangrams

	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public String pangrams(String s) {
		// A-Z is 65 to 90. a-z is 97 to 122
		boolean[] a = new boolean[26];

		for (char c : s.toCharArray()) {
			if (c>=65 && c<=90)
				a[c-65] = true;   // set the corresponding letter to true
			 else if (c>=97 && c<=122)
				a[c-97] = true;  // set the corresponding letter to true
		}
		
		for (boolean b : a)
			if (!b)	// if any letter was not found
				return "not pangram";
		return "pangram";

	}
	

	
}
