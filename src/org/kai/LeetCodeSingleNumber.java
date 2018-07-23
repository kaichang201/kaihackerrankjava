package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeSingleNumber {



public static void main(String[] args) {
	// https://leetcode.com/problems/single-number/description/
	LeetCodeSingleNumber me = new LeetCodeSingleNumber();
	int[] testcase1 =   {2,2,1};
	int[] testcase2 = {4,1,2,1,2};
	
	long startTime = System.currentTimeMillis();
	
	System.out.println (me.singleNumber(testcase1)); // 1
	System.out.println (me.singleNumber(testcase2));  // 4
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));


}

	public int singleNumber(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int i: nums) {
			if (s.contains(i))
				s.remove(i);
			else
				s.add(i);
		}
			
		return (int)s.toArray()[0];
		
	}
		
}
