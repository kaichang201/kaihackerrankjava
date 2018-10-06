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


public class HackerRankFairRations {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/fair-rations/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	HackerRankFairRations me = new HackerRankFairRations();
	
	int[] testcase1 = {4,5,6,7}; // 4
	int[] testcase2 = {1,2};  // NO
	int[] testcase3 = {1,2,1};  // 4
	int[] testcase4 = {1,2,1,1};  // NO
	int[] testcase5 = {2,3,4,5,6};  // 4
	int[] testcase6 = {2,3,4,5,6, 7};  // NO
	int[] testcase7 = {1,1,2};  // 2
	int[] testcase8 = {1,2,2,2,2,1};  // 10

	long startTime = System.currentTimeMillis();

	System.out.println(me.fairRations(testcase1)); // 4
	System.out.println(me.fairRations(testcase2)); // NO
	System.out.println(me.fairRations(testcase3)); // 4
	System.out.println(me.fairRations(testcase4)); // NO
	System.out.println(me.fairRations(testcase5)); // 4
	System.out.println(me.fairRations(testcase6)); // NO
	System.out.println(me.fairRations(testcase7)); // 2
	System.out.println(me.fairRations(testcase8)); // 10

	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int fairRations(int[] B) {
		if (!evenOdds(B)) {
			System.out.println ("NO");
			return -1;
		}
		int breads = 0;
		for (int i = 0; i< B.length-1; i++) {
			if (B[i]%2 == 1) {
				B[i]++;
				B[i+1]++;
				breads+=2;
			}
		}
		return breads;
		
	}
	
	public boolean evenOdds(int[] B) {
		boolean rv = true;
		for (int i: B)
			if (i%2 == 1)
				rv = !rv;
		return rv;
	}

	
}
