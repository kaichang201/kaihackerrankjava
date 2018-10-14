package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.kai.LeetCodeMergeIntervals.TreeNode;


public class LeetCodeMergeIntervals {
	// https://leetcode.com/problems/top-k-frequent-elements/

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		
		@Override
		public String toString() {
			return new StringBuffer()
					.append("{").append(start).append(",")
					.append(end).append("}")
					.toString();
		}
	}

	public static void main(String[] args) {
		LeetCodeMergeIntervals me = new LeetCodeMergeIntervals();
	
	    long startTime = System.currentTimeMillis();
	    
		int[][] testArray1 = {{1,3},{2,6},{8,10},{15,18}}; // {{1,6},{8,10},{15,18}}
		int[][] testArray2 = {{1,4},{4,5}}; // {{1,5}}
		int[][] testArray3 = {{1,3},{5,7},{2,6}}; // {{1,7}}
	
		
		System.out.println(me.merge(me.createIntervals(testArray1)).toString());
		System.out.println(me.merge(me.createIntervals(testArray2)).toString());
		System.out.println(me.merge(me.createIntervals(testArray3)).toString());

		System.out.println(me.merge2(me.createIntervals(testArray1)).toString());
		System.out.println(me.merge2(me.createIntervals(testArray2)).toString());
		System.out.println(me.merge2(me.createIntervals(testArray3)).toString());
		 
	    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	
	public List<Interval> createIntervals (int[][] in) {
		List<Interval> rv = new ArrayList<Interval>();
		for (int[] i : in)
			rv.add(new Interval(i[0], i[1]));
		return rv;
	}
	
	
	public List<Interval> merge(List<Interval> intervals) {
	    int[] res = canMerge(intervals);
	    while (res[0] >= 0 && res[1] >=0) {
	        mergeTwoIntervals(intervals, res[0], res[1]);
	        res = canMerge(intervals);
	    }
	    return intervals;
	}
	
	public int[] canMerge(List<Interval> vals ) {
	    int[] rv = new int[2];
	    rv[0] = -1;
	    rv[1] = -1;
	    for (int i = 0; i < vals.size() -1; i++) {
	        for (int j = i+1; j < vals.size(); j++) {
	        	int iStart = vals.get(i).start, iEnd = vals.get(i).end;
	        	int jStart = vals.get(j).start,	jEnd = vals.get(j).end;
	            if ((iStart <= jStart && iEnd >= jStart)
	            		|| (iStart <= jEnd && iEnd >= jEnd)
	            		|| (jStart <= iStart && jEnd >= iStart)
	            		|| (jStart <= iEnd && jEnd >= iEnd)) {
	            	rv[0] = i;
	            	rv[1] = j;
	            	//System.out.println("can merge " + vals.get(i)+ " " + vals.get(j));
	            	break;
	            }
	        }
	    }
	    return rv;
	}
	public void mergeTwoIntervals(List<Interval> vals, int i, int j) {
		int a[] = new int[4];
		a[0] = vals.get(i).start;
		a[1] = vals.get(i).end;
		a[2] = vals.get(j).start;
		a[3] = vals.get(j).end;
		Arrays.sort(a);
		vals.set(i, new Interval(a[0], a[3]));
		vals.remove(j);
	}
	
	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> rv = new ArrayList<>();
		if (intervals == null || intervals.size() == 0)
			return rv;
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
			
		});
		
		rv.add(intervals.get(0));
		for (int i = 1; i< intervals.size(); i++) {
			Interval next = intervals.get(i), left = rv.get(rv.size() - 1);
			if (next.start > left.end) // this interval greater than others
				rv.add(next);
			else
	 			left.end = Math.max(next.end, left.end);
		}
		
		return rv;
	}
	
}
