package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeetCodeNQueens2 {

static LeetCodeNQueens2 me = new LeetCodeNQueens2();

public static void main(String[] args) {
	// https://leetcode.com/problems/n-queens/description/
	long startTime = System.currentTimeMillis();
	
	System.out.println("1 " + me.totalNQueens(1));
	System.out.println("2 " + me.totalNQueens(2));
	System.out.println("3 " + me.totalNQueens(3));
	System.out.println("4 " + me.totalNQueens(4));
	System.out.println("5 " + me.totalNQueens(5));
	System.out.println("8 " + me.totalNQueens(8));
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

 public int totalNQueens(int n) {
	 List<List<String>> rv = new ArrayList<>();
	 char[][] board = new char[n][n];
	 for (int i=0; i<n; i++)
		 for (int j=0; j<n; j++)
			 board[i][j] = '.';
	 dfs(board,0,rv);
	 return rv.size();

}
 
public void dfs(char[][] board, int row, List<List<String>> rv) {
	if (row == board.length) {  // found a solution
		List<String> solution = new ArrayList<>();
		for (int i = 0 ; i < board.length; i++)
			solution.add(new String(board[i]));
		rv.add(solution);
		return;
	}
	
	for (int i = 0; i < board.length; i++) {
		if (safe(board, i, row)) {
			board[i][row] = 'Q';
			dfs(board,row+1, rv);
			board[i][row] = '.';
		}
	}
	
}

public boolean safe(char[][] board, int x, int y ) {
	for (int i = 0; i<board.length; i++) {
		for (int j = 0; j < y; j++) {
			if (board[i][j] == 'Q' &&
					( x == i || y == j ||  // same row or column
					  x-y == i-j || // difference equality matches same diagonal with negative slope
					  x+y == i+j // sum equality matches same diagonal with positive slope
					)
					)
				return false;
		}
	}
	return true;
}

public void printListOfList(List<List<String>> inValue) {
	for (List<String> l : inValue) {
		for (String s: l)
			System.out.println(s);
		System.out.println();
	}
}

	
}
