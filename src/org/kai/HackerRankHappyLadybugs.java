package org.kai;

import java.awt.SystemTray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import java.util.Scanner;


public class HackerRankHappyLadybugs {
// https://www.hackerrank.com/challenges/happy-ladybugs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		HackerRankHappyLadybugs me = new HackerRankHappyLadybugs();
		String testcase1 = "YYR_B_BR";
		String testcase2 = "RBY_YBR";
		String testcase3 = "X_Y__X";
		String testcase4 = "__";
		String testcase5 = "B_RRBR";
		String testcase6 = "_";
		String testcase7 = "B";


		System.out.println(me.happyLadybugs(testcase1));  // Yes
		System.out.println(me.happyLadybugs(testcase2));  // Yes
		System.out.println(me.happyLadybugs(testcase3));  // No
		System.out.println(me.happyLadybugs(testcase4));  // Yes
		System.out.println(me.happyLadybugs(testcase5));  // Yes
		System.out.println(me.happyLadybugs(testcase6)); // Yes
		System.out.println(me.happyLadybugs(testcase7));  // No
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	public String happyLadybugs(String b) {
		// String b length n guaranteed 1<=n<=100, so no need to check for null or empty string
		// String b has 27 different characters, _A-Z.  Store count of each character in array with _ at index 0 and
		// and A-Z in index 1-26
		int[] count = new int[27];
		char[] a = b.toCharArray();
		boolean happy = true;

		
		if (a.length==1)  // if length is 1, then the only happen scenario is blank
			if (a[0] == '_')
				return "YES";
			else
				return "NO";
		
		if (a[0] != a[1] || a[a.length-1] != a[a.length-2]) // check the first and last character
			happy = false;

		for (int i = 0; i<a.length; i++) {
			if (a[i] == '_')
				count[0]++;  // store _ at index 0
			else
				count[a[i]-64]++;  // A=65, Z=90.  So -64 yields 1 to 26
			
			if (happy  		// check if still happy.  once unhappy, no need to check any more
					&& i > 0 && i < a.length-1  		// check if not first or last character. that case taken case of outside the loop.
					&& a[i] != a[i-1] && a[i] != a[i+1])  // left and right character. if both not match, then unhappy
				happy = false;
		}
		//System.out.println ("counts " + Arrays.toString(count));
		
		if (!happy && count[0] == 0)  // if not happy, but no way to move, then not possible to make happy
			return "NO";
		
		// look characters A-Z count. If any of them only has 1, the not possible to make happy
		for (int i = 1; i< count.length; i++ )
			if (count[i] == 1)
				return "NO";
		
		// Default condition
		// 1 - Array already Happy, so HasOne is false
		// 2 - Array is unHappy, but there is a space, so it can be made happy.
		return "YES";
		
	}
	
	
}
