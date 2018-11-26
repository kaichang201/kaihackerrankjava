package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import org.kai.LeetCodeSearchA2DMatrix2.TreeNode;


public class LeetCodeSearchA2DMatrix2 {
	// https://leetcode.com/problems/search-a-2d-matrix-ii/
	/* Write an efficient algorithm that searches for a value in an m x n matrix.
	 * this matrix his the following properties:
	 * Integers in each row are sorted in ascending from left to right
	 * Integers in each column are sorted in asscending from top to bottom
	 * Example:
	 *  { {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}
	 *  Given target 5, return true
	 *  Given target 20, return false
	 * 
	 */

public static void main(String[] args) {
	LeetCodeSearchA2DMatrix2 me = new LeetCodeSearchA2DMatrix2();

    long startTime = System.currentTimeMillis();
    
	int[][] testcase1 =  {{1,4,7,11,15}
						 ,{2,5,8,12,19}
						 ,{3,6,9,16,22}
						 ,{10,13,14,17,24}
						 ,{18,21,23,26,30}};
	
	System.out.println(me.searchMatrix(testcase1, 5)); // true
	System.out.println(me.searchMatrix(testcase1, 20)); // false
	System.out.println(me.searchMatrix2(testcase1, 5)); // true
	System.out.println(me.searchMatrix2(testcase1, 20)); // false

	 
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		 * Strategy - efficient matrix probably means divide and conquer.  Binary search every row
		 * probably not the best, but simplest.
		 */
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 )
			return false;
		
		for (int i = 0; i<matrix.length; i++) {
			if (bSearch(matrix[i], target, 0, matrix[i].length-1))
				return true;
		}
		return false;
	}
	
	public boolean bSearch (int[] arr, int target, int left, int right) {
		if (left > right) // failure condition
			return false;
		
		int mid = (left+right) / 2;
		if (arr[mid] == target)
			return true;
		
		if (arr[mid] < target)
			return bSearch(arr, target, mid+1, right);
		return bSearch(arr, target, left, mid-1);
	}
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		/*
		 * Strategy - Start at top right corner. 
		 * Check column, the row.
		 */
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 )
			return false;

		int row = 0, col = matrix[0].length-1;
		while (row < matrix.length && col >=0 ) {
			if (target == matrix[row][col])
				return true;
			if (target < matrix[row][col])  // find the right column
				col--;
			else if (target > matrix[row][col])  // then find the right row
				row++;
		}
		// if we are here, then failure condition
		return false;
	}
	
}
