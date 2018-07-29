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


public class LeetCodeReverseInteger {

static LeetCodeReverseInteger me = new LeetCodeReverseInteger();

	public static void main(String[] args) {
		// https://leetcode.com/problems/reverse-integer/description/
	
		int testcase1 = 123;
		int testcase2 = -123;
		int testcase3 = 120;
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.reverse(testcase1));  // 321
		System.out.println(me.reverse(testcase2));  // -321
		System.out.println(me.reverse(testcase3));  // 21
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	public int reverse(int x) {
		int rv = 0;
		StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
		String reverse = sb.reverse().toString();
		
		try {
			rv = Integer.valueOf(reverse);
		} catch (Exception e) {
		    // Would normally do exception handling
			rv = 0;
		}
				
		return (x>0? rv: rv*-1);
		
	}



	
}
