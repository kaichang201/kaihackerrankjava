package org.kai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class swapsandsum {

	public static void main(String[] args) {
		algo3();

	}
	
	public static void algo3 () {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt(), q = scanner.nextInt();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int[] myArraySum = new int[n];

		for (int i = 0; i<n; i++) {
			int input = scanner.nextInt();
			myList.add(input);
			if (i > 0) myArraySum[i] = myArraySum[i-1] + input;
			else myArraySum[i] = input;
		}

		for (int i = 0; i<q; i++) {
			int tp = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
			if (tp == 1) {
				for (int j = l-1; j <r; j+=2) {  // swapping x and y
					//myArray[j] += myArray[j+1]; // x = x + y
					//myArray[j+1] = myArray[j] - myArray[j+1]; // y = x - y  because ( x + y - y) = x
					//myArray[j] = myArray[j] - myArray[j+1]; // x = x - y (x + y - (x + y - y)) = y
					Collections.swap(myList, j, j+1);
					myArraySum[j] = myArraySum[j] + myList.get(j) - myList.get(j+1);
	
					System.out.println("algo3 " + myList.toString());  // debug
					System.out.println("algo3 " + Arrays.toString(myArraySum));  // debug
				}
			} else if (tp == 2) {
				if (l==1)
					System.out.println(myArraySum[r-1]);
				else
					System.out.println(myArraySum[r-1] - myArraySum[l-2]);
			}
		} 

		scanner.close();
	}
	
	public static void algo2 () {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String[] smallStringParts = new String[5];
		
		int n = 0, q = 0;
		try {
			String line = bi.readLine();
			smallStringParts = line.split(" ");
			n = Integer.parseInt(smallStringParts[0]);
			q = Integer.parseInt(smallStringParts[1]);
		} catch (Exception e ) {
			System.out.println(e);
		}
		//int n = scanner.nextInt(), q = scanner.nextInt();

		long[] myArray = new long[n], myArraySum = new long[n];
		String[] bigStringParts = new String[n];

		try {
			String line = bi.readLine();
			bigStringParts = line.split(" ");
			for (int i = 0; i<n; i++) {
				myArray[i] = Integer.parseInt(bigStringParts[i]);
				if (i > 0) myArraySum[i] = myArraySum[i-1] + myArray[i];
				else myArraySum[i] = myArray[i];
			}
		} catch (Exception e ) {
			System.out.println(e);
		}
		
		try {
			for (int i = 0; i<q; i++) {
				String line = bi.readLine();
				smallStringParts = line.split(" ");
				int tp = Integer.parseInt(smallStringParts[0]), l = Integer.parseInt(smallStringParts[1])
						,r = Integer.parseInt(smallStringParts[2]);
				if (tp == 1) {
					for (int j = l-1; j <r; j+=2) {  
						myArray[j] = myArray[j] ^ myArray[j+1];
						myArray[j+1] = myArray[j] ^ myArray[j+1];
						myArray[j] = myArray[j] ^ myArray[j+1];
						myArraySum[j] = myArraySum[j] + myArray[j] - myArray[j+1];
		
						System.out.println(Arrays.toString(myArray));  // debug
						System.out.println(Arrays.toString(myArraySum));  // debug
					}
				} else if (tp == 2) {
					if (l==1)
						System.out.println(myArraySum[r-1]);
					else
						System.out.println(myArraySum[r-1] - myArraySum[l-2]);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void algo1 () {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt(), q = scanner.nextInt();
		int[] myArray = new int[n], myArraySum = new int[n];

		for (int i = 0; i<n; i++) {
			myArray[i] = scanner.nextInt();
			if (i > 0) myArraySum[i] = myArraySum[i-1] + myArray[i];
			else myArraySum[i] = myArray[i];
		}

		for (int i = 0; i<q; i++) {
			int tp = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
			if (tp == 1) {
				for (int j = l-1; j <r; j+=2) {  // swapping x and y
					//myArray[j] += myArray[j+1]; // x = x + y
					//myArray[j+1] = myArray[j] - myArray[j+1]; // y = x - y  because ( x + y - y) = x
					//myArray[j] = myArray[j] - myArray[j+1]; // x = x - y (x + y - (x + y - y)) = y
					myArray[j] = myArray[j] ^ myArray[j+1];
					myArray[j+1] = myArray[j] ^ myArray[j+1];
					myArray[j] = myArray[j] ^ myArray[j+1];
					myArraySum[j] = myArraySum[j] + myArray[j] - myArray[j+1];
	
					System.out.println(Arrays.toString(myArray));  // debug
					System.out.println(Arrays.toString(myArraySum));  // debug
				}
			} else if (tp == 2) {
				if (l==1)
					System.out.println(myArraySum[r-1]);
				else
					System.out.println(myArraySum[r-1] - myArraySum[l-2]);
			}
		} 

		scanner.close();
	}
}
