package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeCoinChange {

// https://leetcode.com/problems/coin-change/description/
	public static void main(String[] args) {
		LeetCodeCoinChange me = new LeetCodeCoinChange();
		
		int[] testcoins1 = {1,2,5};
		int amount1 = 11; // 3 = 2*5 + 1*1
		int[] testcoins2 = {2};
		int amount2 = 3;  // -1
		int[] testcoins3 = {9, 7, 5};
		int amount3 = 49; // 7 = 7*7
		int[] testcoins4 = {186, 419, 83, 408};
		int amount4 = 6249;
		int[] testcoins5 = {9, 7, 5};
		int amount5 = 51;  // 7 = 1*9 + 6*7
		int[] testcoins6 = {9, 7, 5};
		int amount6 = 53;  // 7 = 2*9 + 5*7
		int[] testcoins7 = {9, 7, 1};
		int amount7 = 63;  // 7 = 7*9

		long startTime = System.currentTimeMillis();
		

//		System.out.println(me.coinChange4(testcoins1, amount1)); // 3 = 2*5 + 1*1
//		System.out.println(me.coinChange4(testcoins2, amount2)); // -1
//		System.out.println(me.coinChange4(testcoins3, amount3)); // 7 
//		System.out.println(me.coinChange4(testcoins4, amount4)); // 20
//		System.out.println(me.coinChange4(testcoins5, amount5)); // 7
//		System.out.println(me.coinChange4(testcoins6, amount6)); // 7
		System.out.println(me.coinChange4(testcoins7, amount7)); // 7
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}


	public int coinChange(int[] coins, int amount) {  // fails tests 3 and 4.
		int remainder = amount, counter = 0;
		Arrays.sort(coins);
		
		for (int i = coins.length-1; i>=0; i--) {
			if (coins[i] <= remainder) {
				counter += Math.floorDiv(remainder,  coins[i]);
				remainder = remainder % coins[i];
				System.out.println("i " + i + " coin " + coins[i] + " counter " + counter + " remainder " +remainder) ;
			}
		}
			if (remainder > 0)
				return -1;
			else
				return counter;	
	}
	
	public int coinChange2(int[] coins, int amount) {
		// I didn't get this. I was thinking dfs with backtrace
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1) min = Math.min(min, dp[i - coins[j]]); 
            }
            if(min == Integer.MAX_VALUE) dp[i] = -1;            //can't get this amount
            else dp[i] = min + 1;
        }
        return dp[amount];
    }
	
    public int coinChange3(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] res = new int[amount+1];
        Arrays.sort(coins);
        int min = Integer.MAX_VALUE;
        for(int j=1;j<amount+1;j++){
            for(int x = 0;x<coins.length;x++){
                if(j<coins[x])
                    break;
                if(j==coins[x]){
                    min = 1;
                    break;
                }
                if(res[j-coins[x]]==0)
                    continue;
                if(res[j-coins[x]]+1<min)
                    min = res[j-coins[x]]+1;
                System.out.println("  x " + x + " coin "  + coins[x] + " min " + min);          
            }
            if(min == Integer.MAX_VALUE)
                res[j] = 0;
            else
                res[j] = min;
            min = Integer.MAX_VALUE;
            System.out.println("j " + j + " res "  + res[j]);
        }
        return res[amount]==0?-1:res[amount];
    }
    

    public int coinChange4(int[] coins, int amount) {  // Dynamic Programming: DFS with memoization
    	// easier to understand. but my intuition on this still needs practice
		return dfs(coins, amount, new HashMap<Integer,Integer>());
    }
    
    public int dfs (int[] coins, int amount, Map<Integer,Integer> amountDict) {

    	System.out.println("Amount " + amount);
        if(amount==0)
            return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount+1;
        for(int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = dfs(coins, amount-coin, amountDict);
                System.out.println("    amount " + amount + " coin "+ coin + " next " + next);
                if(next >= 0)
                    curr = 1+next;
            }
            if(curr > 0)
                n = Math.min(n,curr);
        }
        int finalCount = (n==amount+1) ? -1 : n;
        System.out.println(" Amount " + amount + "  finalCount " + finalCount + " n " + n);
        amountDict.put(amount,finalCount);
        return finalCount;		
    }
}
