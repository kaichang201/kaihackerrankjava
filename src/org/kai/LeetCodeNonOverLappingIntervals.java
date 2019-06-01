package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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


public class LeetCodeNonOverLappingIntervals {



public static void main(String[] args) {
	// https://leetcode.com/problems/non-overlapping-intervals/
	// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping
	LeetCodeNonOverLappingIntervals me = new LeetCodeNonOverLappingIntervals();
	
	int[][] testcase1 = { {1,2}, {2,3}, {3,4}, {1,3} }; // 1.  remove {1,3}
	int[][] testcase2 = { {1,2}, {1,2}, {1,2} }; // 2.. remove 2 {1,2}
	int[][] testcase3 = { {1,2}, {2,3}}; // 0.. remove nothing
	int[][] testcase4 = { {1,4}}; // 0.. remove nothing
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.eraseOverlapIntervals(testcase1)); //  1
	System.out.println(me.eraseOverlapIntervals(testcase2)); //  2
	System.out.println(me.eraseOverlapIntervals(testcase3)); //  0
	System.out.println(me.eraseOverlapIntervals(testcase4)); //  0
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	class myComparator implements Comparator<int[]>{
		public int compare (int[] a, int[] b) {
			if (a.length != 2 || b.length != 2)
				return 0; // both have to be length 0, or else invalid.  return 0
			return a[1] - b[1];  // return the one that has the larger end-point, or int[1]
		}
		
	}

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <1 )
        	return 0;  // for cases of 0 or 1 intervals, no overlap is possible

        // sort the array  O(n log(n))
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i< intervals.length; i++) {  // start loop by comparing 2nd to 1st interval, then iterate
        	if (intervals[i][0] >= end) { // if i-th interval starts after the last end
        		end = intervals[i][1];  // set it as the new end;
        		count++; // include it into the count
        	}        	
        }
    	return intervals.length - count; // total - how many we could include == how many we must remove
       
    }

}
