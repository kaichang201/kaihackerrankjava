package org.kai;

import java.awt.SystemTray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.Scanner;


public class HackerRankNewYearChaos {
// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		HackerRankNewYearChaos me = new HackerRankNewYearChaos();
		int [] testcase1 = {1,2,3,5,4,6,7,8}; // 1
		int [] testcase2 = {2,1,5,3,4}; // 3
		int [] testcase3 = {2,5,1,3,4}; // Too chaotic 
		int [] testcase4 = {2,1,5,4,3}; // 4
		int [] testcase5 = {1,2,5,3,7,8,6,4}; //7
		me.minimumBribes(testcase1);
		me.minimumBribes(testcase2);
		me.minimumBribes(testcase3);
		me.minimumBribes(testcase4);
		me.minimumBribes(testcase5);
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

    void minimumBribes(int[] q) {
    	int rv = 0;

    	for (int i = q.length-1 ; i >= 0; i--) {
    		if (q[i] - (i+1) > 2) {
    			System.out.println ("Too chaotic");
    			return;
    		}
    		for (int j = Math.max(0, q[i] - 2); j<i; j++)
    			if (q[j]> q[i])
    				rv++;
    	}
    	System.out.println (rv);

    }

	
	
}
