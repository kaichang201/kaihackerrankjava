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


public class LeetCodeBestTimeToBuyAndSellStock2 {



public static void main(String[] args) {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
	LeetCodeBestTimeToBuyAndSellStock2 me = new LeetCodeBestTimeToBuyAndSellStock2();
	
	int[] testcase1 = {7,1,5,3,6,4};
	int[] testcase2 = {7,6,4,3,1};
	int[] testcase3 = {1,2,3,4,5};
	int[] testcase4 = {1};
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.maxProfit(testcase1)); //  7
	System.out.println(me.maxProfit(testcase2)); //  0
	System.out.println(me.maxProfit(testcase3)); //  4
	System.out.println(me.maxProfit(testcase4)); //  0
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int maxProfit(int[] prices) {
		int rv=0;
		boolean holding = false;

		for (int i = 0;  i< prices.length; i++) {
			boolean transact = false;
			if (!holding) {  // no position. buy or no buy
				if (i == prices.length-1 || // dont' buy on the last day
						prices[i] >= prices[i+1]) { // if price stays or goes down tomorrow don't bother buying. Only buy if tomorrow's price is higher
					transact = false;
					}
				else 
					transact = true;
			} else { // has position.  sell or no sell
				if (i >= prices.length-1 || // if it is the last day, flatting your position to maximize profit
						prices[i] >= prices[i+1]) { // if price stays or goes down tomorrow, sell today.
					transact = true;
					}
				else 
					transact = false;
			}
			if (transact) {
				if (holding) { // decided to sell
					rv += prices[i];
					holding = false;
				} else {
					rv -= prices[i];
					holding = true;
				}				
			}
		}
		
		return rv;

	}

}
