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


public class LeetCodeRotateImage {

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	@Override
	public String toString () {
		StringBuffer rv = new StringBuffer();
		rv.append(this.val);
		if (this.next != null)
			rv.append(this.next.toString());
		return rv.toString();
		
	}
}

public static void main(String[] args) {
	// https://leetcode.com/problems/rotate-image/
	/* 
	 * Given a 2D matrix n x n. Rotate the image by 90 degrees (clockwise)
	 * Rotate the image in-place.  modify the 2D matrix directly
	 * Example 1: Input {{1,2,3},{4,5,6},{7,8,9}}
	 * Output {{7,4,1},{8,5,2},{9,6,3}}
	 * 
	 * example 1: Input {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
	 * Output {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}
	 * 
	 */
	LeetCodeRotateImage me = new LeetCodeRotateImage();


	int[][] testcase1 = {{1,2,3},{4,5,6},{7,8,9}};
	int[][] testcase2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
	int[][] testcase3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	// {{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}}
	



	me.rotate(testcase1); //
	for (int[] a: testcase1)
		System.out.println(Arrays.toString(a));

	me.rotate(testcase2); //1
	for (int[] a: testcase2)
		System.out.println(Arrays.toString(a));
	
	me.rotate(testcase3); //1
	for (int[] a: testcase3)
		System.out.println(Arrays.toString(a));


	
	long startTime = System.currentTimeMillis();

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public void rotate(int[][] matrix) {
		/*
		 * Strategy:
		 *  Transpose - flip along the diagonal.  matrix[i][j] = matrix[j][i]
		 *  Swap columns - flip along the vertical.  matrix[*][l] = matrix[*][r]
		 */
		
		// 		 *  Transpose - flip along the diagonal.  matrix[i][j] = matrix[j][i]		
		for (int i = 0; i < matrix.length; i++) { // once for every row
			for (int j = matrix.length - 1; j > i; j--) {  // go from bottom until ith row
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		// 		 *  Swap columns - flip along the vertical.  matrix[*][l] = matrix[*][r]
		for (int l=0, r=matrix.length-1; l<r; l++, r--) {  // left starts from 0. right starts from end.  stop when they cross.
			for (int row = 0; row< matrix.length; row++) {// do every row
				int tmp = matrix [row][l];
				matrix[row][l] = matrix[row][r];
				matrix[row][r] = tmp;
			}
		}
	}

		

}
