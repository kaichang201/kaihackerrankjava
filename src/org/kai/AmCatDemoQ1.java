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
import java.util.stream.Collectors;


public class AmCatDemoQ1 {



public static void main(String[] args) {
	// TestId 23280720391096 Demo I
	// TestId 23280720391096
	/* 
	 * The greatest common divisor (GCD), also called the higest common factor (HCF) of N numers i the largest positive integer
	 * that divides all numbers without giving a remainder
	 * write an algorithim to determine the GCD on N positive integers.
	 * 
	 * Input
	 * the input to the function / method cnonsists of two arguments
	 *  -num - an integer repesenting the number o fintegers
	 *  array - a list of postiive integers
	 *  Output - return an integer representing the GCD of the given postive integers.
	 *  
	 *  Examples
	 *  num = 5
	 *  arr = 2,4,6,8,10
	 *  output = 2
	 *  Explanation: the postitive integer that divides all the positive integers 2,4,6,8,10 without a remainder is 2.
	 *  
	 */
	/* 13 out of 13 passed 20 mins*/


	AmCatDemoQ1 me = new AmCatDemoQ1();
	
	int[] testcase1 = {2,4,6,8,10};  // 2
	int[] testcase2 = {3,6,9,12,33}; // 3
	int[] testcase3 = {20,6,9,12,33}; // 1
	int[] testcase4 = {2,3,4,5,6}; // 1

	
	long startTime = System.currentTimeMillis();

	System.out.println(me.generalizedGCD(0,testcase1)); //  
	System.out.println(me.generalizedGCD(0,testcase2)); //  
	System.out.println(me.generalizedGCD(0,testcase3)); //  
	System.out.println(me.generalizedGCD(0,testcase4)); //  


	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int generalizedGCD(int num, int[] arr) {
		/* Strategy:
		 * look for the lowest number.
		 * decrement from lowest number to 1;
		 * until we find a number that divides all numbers without a remainder.
		 */
		Arrays.sort(arr);
		int lowest = arr[0];
		
		for (int i = lowest; i>1; i--) {
			boolean found = true;
			for (int j = 0; j < arr.length; j++) {
				//System.out.println("Remainder " + arr[j] % i);
				if (arr[j] % i > 0) {
					found = false;
					break;
				}
			}
			if (found) // if found never set to false, then i divides all numbers without a remainder
				return i;
				
		}
		return 1;  // 1 divides all numbers
	}

}
