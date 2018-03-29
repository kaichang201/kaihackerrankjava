package org.kai;

import java.util.Scanner;

public class MaximumIndexProduct {

	public static void main(String[] args) {
		algo2();
	}
	
	public static void algo1() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long[] myArray = new long[n];
		long maxIndexProduct = Integer.MIN_VALUE;
		
		for (int i = 0; i<n; i++) {
			myArray[i] = scanner.nextInt();
		} 
		
		for (int i = 0; i<n-1; i++) {
			int lefteye = 0, righteye = 0;
			if (i == 0) 
				maxIndexProduct=0;

			for (int j = i-1; j>=0; j--) { 				// go left
				if (myArray[j] > myArray[i]) {
					lefteye=j+1;
					break;
				}
			}
			for (int k = i+1; k<n; k++) { 				// go right
				if (myArray[k] > myArray[i]) {
					righteye=k+1;
					break;
				}
			}
			System.out.println (myArray[i] +" " + lefteye + " " + righteye);
			if (lefteye * righteye > maxIndexProduct)
				maxIndexProduct = lefteye * righteye;
		} 
		System.out.println(maxIndexProduct);
	}
	
	public static void algo2() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long[] myArray = new long[n];
		int[] myLeft = new int[n], myRight = new int [n];
		long maxIndexProduct = 0;
		
		for (int i = 0; i<n; i++) {
			myArray[i] = scanner.nextInt();
			if (myArray[i] == 0) 
		System.out.println (myArray[i] +" " + i);
		} 
		myLeft[0] = 0;
		myRight[n-1] = 0;
		
		for (int i = 1; i<n; i++) {
			int j = i-1; 
			while (true) {  // go left
				if (myArray[i] < myArray[j]) {  // the j-ptr is bigger.  Point to J.
					myLeft[i] = j+1;
					break;
				} else if (myLeft[j] == 0) {  // if left already set 0, then every number to left is smaller
					myLeft[i] = 0;
					break;
				} else if (myArray[i] < myArray[myLeft[j]-1]) {  // the j-ptr's Left is bigger.
					myLeft[i] = myLeft[j];
					break;	
				} else {  // skip ahead past jptr's Left
					j = myLeft[j] - 1;
				}
			}
			for (int k = i+1; k<n; k++) { 				// go right
				if (myArray[k] > myArray[i]) {
					myRight[i]=k+1;
					break;
				}
			}
			if (myArray[i] == 0) 
				System.out.println (myArray[i] +" " + myLeft[i] + " " + myRight[i]  + " " + (long)myLeft[i] * myRight[i]) ;
			if ((long)myLeft[i] * myRight[i] > maxIndexProduct)
				maxIndexProduct = (long)myLeft[i] *  myRight[i];
		} 
		System.out.println(maxIndexProduct);
	}

}
