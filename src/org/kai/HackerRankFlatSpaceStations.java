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


public class HackerRankFlatSpaceStations {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/flatland-space-stations/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	HackerRankFlatSpaceStations me = new HackerRankFlatSpaceStations();
	
	int testcase1n = 5;
	int testcase1a[] = {0,4};

	int testcase2n = 6;
	int testcase2a[] = {0,1,2,3,4,5};

	int testcase3n = 6;
	int testcase3a[] = {0,4};

	int testcase4n = 6;
	int testcase4a[] = {0};

	int testcase5n = 7;
	int testcase5a[] = {6};

	int testcase6n = 100;
	int testcase6a[] = {6, 99};



	
	long startTime = System.currentTimeMillis();

	System.out.println(me.flatlandSpaceStations(testcase1n, testcase1a)); //  2
	System.out.println(me.flatlandSpaceStations(testcase2n, testcase2a)); //  0
	System.out.println(me.flatlandSpaceStations(testcase3n, testcase3a)); //  2
	System.out.println(me.flatlandSpaceStations(testcase4n, testcase4a)); //  5
	System.out.println(me.flatlandSpaceStations(testcase5n, testcase5a)); //  6
	System.out.println(me.flatlandSpaceStations(testcase6n, testcase6a)); //  46


	
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int flatlandSpaceStations(int n, int[] c) { 
		int m = -1, d = -1, l=c.length;
		Arrays.sort(c); // seems silly if all input arrays are sorted.. but HackerRank fails tests without sort.
		for (int i = 0; i< n; i++) {
			d = -1;
			for (int j = 0; j<l && d<0; j++) {
				//System.out.println ("i "+ i + " j " + j + " d "+ d + " c[j] " + c[j]);
				if (j == 0 && i <= c[j])
					d = c[j] - i;
				else if (j == l-1 && i >= c[j])
					d = i - c[j];
				else if (i >= c[j] && i <=c[j+1]) {
					int a = i - c[j];
					int b = c[j+1] - i;
					d = a>b ? b : a;
				}
				//System.out.println (" i "+ i + " j " + j + " d "+ d + " c[j] " + c[j]);

			}
			if (d > m )
				m=d;
		}
		return m;
	}
}
