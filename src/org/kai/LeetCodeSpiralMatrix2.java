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

import org.kai.CrackingCode76ShuffleLinkedList.ListNode;


public class LeetCodeSpiralMatrix2 {

	static LeetCodeSpiralMatrix2 me = new LeetCodeSpiralMatrix2();


	enum Direction {
		// 4 cardinal directions in sequence of East, South, West, North
		East, South, West, North;
		public static Direction turnClockwise (Direction last ) {
			if (last == East)
				return South;
			if (last == South)
				return West;
			if (last == West)
				return North;
			return East;
		}
		
		public static int mStep (Direction towards) {
			if (towards == South)
				return 1;
			if (towards == North)
				return -1;
			// y doesn't step for east/west
			return 0;
		}
		
		public static int nStep (Direction towards) {
			if (towards == East)
				return 1;
			if (towards == West)
				return -1;
			// y doesn't step for north/south
			return 0;
		}
	
		/* 
		 *  - Going East - Hit visited or n-counter reached n.size-1
		 *  - Going South - Hit visited or m-counter reached m.size-1
		 *  - Going West - Hit visited or n-counter reached 0
		 *  - Going North - Hit visited or m-counter reached 0
		 */
		public static boolean edgeCondition (Direction towards, int m, int n, int mSize, int nSize) {
			if ((towards == East && n == nSize-1) 
					|| (towards == South && m == mSize-1) 
					|| (towards == West && n == 0) 
					|| (towards == North && m == 0)
					)
				return true;
			return false;
		}
	}
	
	public static void main(String[] args) {
		// https://leetcode.com/problems/spiral-matrix-ii/
		/*
		 * Given a positive integer n, generate a square matrix filled with elements 1 to n^2 in spiral order
		 * example: 3
		 * Output: {{1,2,3},{8,9,4},{7,6,5}}
		 */
	
		
		int testcase1 = 3; // {{1,2,3},{8,9,4},{7,6,5}}
		int testcase2 = 2; // {{1,2},{4,3}}
	
		
		long startTime = System.currentTimeMillis();
		int[][] result = me.generateMatrix(testcase1);
		for (int[] arr: result)
			System.out.println(Arrays.toString(arr));  //   {{1,2,3},{8,9,4},{7,6,5}}

		result = me.generateMatrix(testcase2);
		for (int[] arr: result)
			System.out.println(Arrays.toString(arr));  //   {{1,2},{4,3}}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	}
	
    public int[][] generateMatrix(int n) {
    	int [][] rv = new int[n][n];
    	boolean [][] visited = new boolean [n][n];
    	int m = 0, o=0;
    	Direction myDirection = Direction.East;
    	
    	for (int i =1; i<=n*n; i++) {  // iterate exactly n^2 times
    		rv[m][o] = i;
    		visited[m][o] = true;
    		
    		// check if I should turn
    		if (Direction.edgeCondition(myDirection, m, o, n, n) // check if I should turn because I am at edge
    				|| visited[m+Direction.mStep(myDirection)][o+Direction.nStep(myDirection)] == true)  // I should turn because next step is visited
    			myDirection = Direction.turnClockwise(myDirection);
    		
    		// take another step
    		m+=Direction.mStep(myDirection);
    		o+=Direction.nStep(myDirection);
    	}
    	return rv;
    	
	}
}



