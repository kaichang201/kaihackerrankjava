package org.kai;

import java.util.Scanner;

public class twodarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowSize = 6, columnSize=6, maxSum=Integer.MIN_VALUE;
		int a[][] = new int[rowSize][columnSize];
		Scanner scanner = new Scanner (System.in);
		try {
			for (int i = 0; i<rowSize; i++) {
				for (int j = 0; j<columnSize; j++) {
					a[i][j] = scanner.nextInt();
				}	
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			scanner.close();
		}
		for (int i = 0; i<rowSize-2; i++) {
			for (int j = 0; j<columnSize-2; j++) {
				int thisSum = a[i][j] + a[i][j+1] + a[i][j+2]  // top bar
						+ a[i+1][j+1] // middle number
						+ a[i+2][j] + a[i+2][j+1] + a[i+2][j+2]; // bottom bar
				if (thisSum > maxSum) {
					maxSum = thisSum;
					System.out.println (maxSum);
					System.out.println(a[i][j] +" " + a[i][j+1] + " " + a[i][j+2]);
					System.out.println("  "+a[i+1][j+1]);
					System.out.println(a[i+2][j] +" " + a[i+2][j+1] + " " + a[i+2][j+2]);
				}
			}
		}
		System.out.println (maxSum);
	}

}
