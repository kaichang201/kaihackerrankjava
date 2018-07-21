package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class LeetCodeGameOfLife {



public static void main(String[] args) {
	// https://leetcode.com/problems/game-of-life/description/
	LeetCodeGameOfLife me = new LeetCodeGameOfLife();
	int[][] testcase1 =   {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
	int[][] testcase2 =   {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
	//10,01,00,11

	long startTime = System.currentTimeMillis();
	
	//   [0,0,0],  [1,0,1],  [0,1,1],  [0,1,0]
	me.gameOfLife(testcase1);
	for (int[] thisRow: testcase1)
		System.out.println(Arrays.toString(thisRow));
	
	System.out.println();
	me.gameOfLife2(testcase2);
	for (int[] thisRow: testcase2)
		System.out.println(Arrays.toString(thisRow));
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

public void gameOfLife(int[][] board) {  
	int [][] newBoard = new int[board.length][board[0].length];
	
	for (int i = 0; i< board.length; i++ ) {  // setup New board
		for (int j = 0; j < board[i].length; j++) {
			int mySum = sumNeighbors(board, i, j);
			if (board[i][j] == 1) { // currently alive
				if (mySum == 2 || mySum == 3)
					newBoard[i][j] = 1;
				else
					newBoard[i][j] = 0;
			} else {
				if (mySum == 3) 
					newBoard[i][j] = 1;
				else
					newBoard[i][j] = 0;
			}
		}
	}
	
	for (int i = 0; i< board.length; i++ ) {  // update old board
		for (int j = 0; j < board[i].length; j++) {
			board[i][j] = newBoard[i][j];
		}
	}
}

public int sumNeighbors (int[][] board, int i, int j) {
	int rV = 0;
	
	if (j > 0 ) // can sum left of me
		rV += board[i][j-1];
	if (j < board[i].length-1) // can sum right of me
		rV += board[i][j+1];
	
	if (i > 0) { // can sum above me
		rV += board[i-1][j];
		if (j > 0 ) // can sum upper left corner
			rV += board[i-1][j-1];
		if (j < board[i].length-1) // can sum upper right corner
			rV += board[i-1][j+1];
	}
	if (i < board.length-1) {// can sum below me
		rV += board[i+1][j];
		if (j > 0 ) // can sum upper left corner
			rV += board[i+1][j-1];
		if (j < board[i].length-1) // can sum upper right corner
			rV += board[i+1][j+1];
	}
	
	return rV;
}

static int[] myBeforeBoard = new int[50];
static int[] myAfterBoard = new int[50];

public void gameOfLife2(int[][] board) {  // in-place implementation
	myBeforeBoard[1]=1;
	myBeforeBoard[10]=1;
	myBeforeBoard[11]=1;
	myAfterBoard[1]=1;  // set a few 1's, leave remaining 0's
	myAfterBoard[11]=1;
	myAfterBoard[21]=1;
	for (int i = 0; i< board.length; i++ ) {  // setup New board
		for (int j = 0; j < board[i].length; j++) {
			int mySum = sumNeighbors2(board, i, j);
			if (board[i][j] == 1) { // currently alive
				if (mySum == 2 || mySum == 3)
					board[i][j] = 11;
				else
					board[i][j] = 10;
			} else {
				if (mySum == 3) 
					board[i][j] = 21;
				else
					board[i][j] = 20;
			}
		}
	}
	
	
	for (int i = 0; i< board.length; i++ ) {  // update old board
		for (int j = 0; j < board[i].length; j++) {
			board[i][j] = myAfterBoard[board[i][j]];
		}
	}
}

public int sumNeighbors2 (int[][] board, int i, int j) { // in-place implementation
	int rV = 0;

	
	if (j > 0 ) // can sum left of me
		rV += myBeforeBoard[board[i][j-1]];
	if (j < board[i].length-1) // can sum right of me
		rV += myBeforeBoard[board[i][j+1]];
	
	if (i > 0) { // can sum above me
		rV += myBeforeBoard[board[i-1][j]];
		if (j > 0 ) // can sum upper left corner
			rV += myBeforeBoard[board[i-1][j-1]];
		if (j < board[i].length-1) // can sum upper right corner
			rV += myBeforeBoard[board[i-1][j+1]];
	}
	if (i < board.length-1) {// can sum below me
		rV += myBeforeBoard[board[i+1][j]];
		if (j > 0 ) // can sum upper left corner
			rV += myBeforeBoard[board[i+1][j-1]];
		if (j < board[i].length-1) // can sum upper right corner
			rV += myBeforeBoard[board[i+1][j+1]];
	}
	
	return rV;
}

	
}
