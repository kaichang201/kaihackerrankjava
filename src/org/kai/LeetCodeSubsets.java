package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


public class LeetCodeSubsets {



public static void main(String[] args) {
	// https://leetcode.com/problems/subsets/
	/*
	 *  Given a set of distinct integers, nums.
	 *  return all possible subsets (the power set)
	 *  Note: the solution set much not contain duplicate subsets.
	 *  
	 *  Example:  Input nums = {1,2,3}
	 *  Output: {{},{3},{2},{1},{1,2},{1,3},{2,3},{1,2,3}}
	 */


	LeetCodeSubsets me = new LeetCodeSubsets();
	int[] testcase1 = {1,2,3};
	/* {{}
		,{1},          {2}      ,{3}
		,{1,2},{1,3}  ,{2,3}
		,{1,2,3}
		} n=3 size 8
		0,0,0
		1,0,0
		0,1,0
		0,0,1
		1,1,0
		1,0,1
		0,1,1
		1,1,1	
		
		*/	
	int[] testcase3 = {};  // {{}} n=0, size 1
	int[] testcase4 = {1}; // {{},{1}} n=1, size 2
	int[] testcase5 = {1,2}; // {{},{1},{2},{1,2}} n=2, size 4
	int[] testcase2 = {1,2,3,4};  // n=4, size 15 2^n
	/*
	 * 	{ {},
	 * 	  {1},                                      {2},            {3},     {4},
	 *    {1,2}                     ,{1,3},  {1,4}, {2,3},   {2,4}, {3,4}
	 *    {1,2,3}   ,{1,2,4},       ,{1,3,4}        {2,3,4}
	 *    {1,2,3,4}
	 *    } 
	 *    size 16  - generalized return size should be 2^n?
	 */

	System.out.println(me.subsets(testcase1));
	System.out.println(me.subsets(testcase2));
	System.out.println(me.subsets(testcase3));
	System.out.println(me.subsets(testcase4));
	System.out.println(me.subsets(testcase5));

	long startTime = System.currentTimeMillis();
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}


	public List<List<Integer>> subsets(int[] nums) {
		/*
		 * Strategy
		 * Result includes set with 0 elements
		 * Result includes set with nums.length elements
		 * Result always includes set with # of elements from 0 to num.lengths
		 * Use DFS with backtracking
		 */
		// Create List<List<Integer>>.
		List<List<Integer>> rv = new ArrayList<>();
		dfs(nums, new ArrayList<>(), rv, 0);
		return rv;
		
	}
	
	public void dfs (int[] nums, List<Integer> list, List<List<Integer>> rv, int index ) {
		rv.add(new ArrayList<>(list));  // clone the incoming list and add it to resultset
		if (index == nums.length)
			return;  // if already at the end, can't add any more
		
		for (int i=index; i<nums.length; i++) { //start from index and work to the end;
			list.add(nums[i]);
			dfs(nums, list, rv, i+1);  // 1 -> 1,2 -> 1,2,3, 1,2,3,4
			list.remove(list.size()-1);
			/* {} add 1, remove 1, add 2, remove 2, add 3, remove 3, add 4, remove 4
			 *  {1} add 2, remove 2, add 3, remove 3, add 4, remove 4
			 *  {2} add 3, remove 3, add 4, remove 4
			 *  {1,2} add 3, remove 3, add 4, remove 4
			 */
		}
		
	}
}
