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


public class HackerRankSayWhatYouSee {



public static void main(String[] args) {
	// https://www.hackerrank.com/tests/pk30r82a/questions/b14al2ai
	HackerRankSayWhatYouSee me = new HackerRankSayWhatYouSee();
	
	String[] testcase1 = {"12", "21"}; // 1112, 1211
	String[] testcase2 = {"1", "21","2114","11111111111"}; // 11, 1211, 123114, 111
	
	long startTime = System.currentTimeMillis();

	System.out.println(Arrays.toString(say_what_you_see(testcase1))); // 1112, 1211
	System.out.println(Arrays.toString(say_what_you_see(testcase2))); // 11, 1211, 123114, 111

	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	static String[] say_what_you_see(String[] input_strings) {  // recursion
		String[] rv =  new String[input_strings.length];
		
		for (int i = 0; i < input_strings.length; i++)
			rv[i] = dfs (input_strings[i], 0);
		
		return rv;
	}
	
	static String dfs ( String input, int head ) {
		StringBuffer sb = new StringBuffer();
		if (head >= input.length()) {
			return "";
		}
		int counter = 0;
		int tail = head;
		while ( tail < input.length() && input.charAt(head) == input.charAt(tail)) {
			tail++;
			counter++;
		}
		sb.append(String.valueOf(counter));
		sb.append(String.valueOf(input.charAt(head)));
		sb.append(dfs(input, tail));
		return sb.toString();
	}
	
}
