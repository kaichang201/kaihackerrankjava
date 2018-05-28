package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class CodeFighthelpTom {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			helpTom1(1,1,0); // 0
			helpTom1(2,1,0); // 1
			helpTom1(2,4,0); // 2
			helpTom1(3,4,5); // 4
			helpTom1(1000,1000,0); // 0
		} else {
			helpTom2(1,1,0); // 0
			helpTom2(2,1,0); // 1
			helpTom2(2,4,0); // 2
			helpTom2(3,4,5); // 4
			helpTom2(1000,1000,0); // 0
		}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	static int helpTom1(int row, int col, int startNumber) {
		int [][] a = new int[row+1][col+1];
		for (int i = 1; i<=row; i++) {
			for (int j = 1; j<=col; j++) {
				if (i==j && i == 1)
					a[i][j]=startNumber;
//				else if (i > j)
//					a[i][j]=a[j][i]; // matrix mirror along diagonal
				else {
					int[] b = new int[2001];
					//System.out.println("Processing i " + i + " j " + j);
					for (int k=1; k<i; k++) {
						//System.out.println(" Adding k " + k + " j " + j + " value" + a[k][j]);
						b[a[k][j]] = 1;
					}
					for (int k=1; k<j; k++) {
						//System.out.println(" Adding i " + i + " k " + k + " value" + a[i][k]);
						b[a[i][k]] = 1;
					}
					for (int k=0; k<row+col; k++) {
						//System.out.println(" k " + k + " value" + b[k]);
						if (b[k] == 0 ) {
							a[i][j] = k;
							break;
						}
					}
				}
			}
		}
		//System.out.println("Matrix");
		//for (int i = 1; i<=row; i++) {
		//	for (int j = 1; j<=col; j++) {
		//		System.out.print(String.valueOf(a[i][j]));
		//	}
		//	System.out.println();
		//}
		System.out.println("Answer: " + String.valueOf(a[row][col]));
		return a[row][col];
	}
	

	static int helpTom2(int r, int c, int s) {
		int [][] a = new int[r+1][c+1];
		for (int i = 1; i<=r; i++) {
			for (int j = 1; j<=c; j++) {
				if (i==j && i == 1)
					a[i][j]=s;

				else {
					int[] b = new int[2001];
					for (int k=1; k<i; k++) {
						b[a[k][j]] = 1;
					}
					for (int k=1; k<j; k++) {
						b[a[i][k]] = 1;
					}
					for (int k=0; k<r+c; k++) {
						if (b[k] == 0 ) {
							a[i][j] = k;
							break;
						}
					}
				}
			}
		}
		return a[r][c];
	}


}