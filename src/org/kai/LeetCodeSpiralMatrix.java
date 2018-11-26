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


public class LeetCodeSpiralMatrix {

	static LeetCodeSpiralMatrix me = new LeetCodeSpiralMatrix();


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
		// https://leetcode.com/problems/spiral-matrix/
		/*
		 * Given a matrix of m x n elements (m rows, n columns) return all elements of the matrix in spiral order
		 * example1 {{1,2,3},{4,5,6},{7,8,9}}
		 * output: {1,2,3,6,9,8,7,4,5}
		 * example2 {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
		 * output: {1,2,3,4,8,12,11,10,9,5,6,7}
		 */
	
		
		int[][] testcase1 = {{1,2,3},{4,5,6},{7,8,9}}; // {1,2,3,6,9,8,7,4,5}
		int[][] testcase2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; // {1,2,3,4,8,12,11,10,9,5,6,7}
	
		
		long startTime = System.currentTimeMillis();
		System.out.println(me.spiralOrder(testcase1));  //   {1,2,3,6,9,8,7,4,5}
		System.out.println(me.spiralOrder(testcase2));  //   {1,2,3,4,8,12,11,10,9,5,6,7}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		/* Strategy: 4 cardinal directions in sequence of East, South, West, North
		 *  keep boolean[m][n] for visited
		 * End Condition: size of array is m * n
		 * Turn Conditions:
		 *  - Going East - Hit visited or n-counter reached n.size-1
		 *  - Going South - Hit visited or m-counter reached m.size-1
		 *  - Going West - Hit visited or n-counter reached 0
		 *  - Going North - Hit visited or m-counter reached 0
		 */
		List<Integer> rv = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) // if either dimension is 0, then empty list
			return rv;
		
		// keep boolean[m][n] for visited
		int mSize = matrix.length, nSize = matrix[0].length;
		boolean[][] visited = new boolean [mSize][nSize];
	
		Direction myDir = Direction.East;  // start off going east
		int m=0, n=0;  // start at 0,0
		
		// End Condition: size of array is m * n
		while (rv.size()< mSize*nSize) {
			rv.add(matrix[m][n]);
			visited[m][n] = true;

			// turn if appropriate
			if (Direction.edgeCondition(myDir, m, n, mSize,nSize )  // check if at the edge of this direction
					|| visited[m+Direction.mStep(myDir)][n+Direction.nStep(myDir)] == true  // check if next Step takes us to a visited node
					)
				myDir = Direction.turnClockwise(myDir);
			
			// take a step
			m+=Direction.mStep(myDir);
			n+=Direction.nStep(myDir);
		}
		return rv;
	}
}



