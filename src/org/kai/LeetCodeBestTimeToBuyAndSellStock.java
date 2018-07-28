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


public class LeetCodeBestTimeToBuyAndSellStock {



public static void main(String[] args) {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	LeetCodeBestTimeToBuyAndSellStock me = new LeetCodeBestTimeToBuyAndSellStock();
	
	int[] testcase1 = {7,1,5,3,6,4};
	int[] testcase2 = {7,6,4,3,1};
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.maxProfit(testcase1)); //  5
	System.out.println(me.maxProfit(testcase2)); //  0
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, max = 0;
		int rv=0;

		for (int p: prices) {  // BigO(n)
			if (p < min) {
				min = p;
				continue;
			}
			if (rv < p-min)
				rv = p-min;				
		}
		
		return rv;

	}

}
