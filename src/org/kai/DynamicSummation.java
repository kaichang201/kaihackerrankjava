package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DynamicSummation {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1"))
			algo1();
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	static double[] storedValues;
	static ArrayList<ArrayList<Integer>> Edges ;
	
	public static void algo1() {  // Assuming that subtree is direct child of tree
		DynamicSummation mySol = new DynamicSummation();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int answer = 0;
		Edges = new ArrayList<>();
		storedValues = new double[n+1];
		
		for (int i = 0; i < n+1 ; i++) {  // Initialize Edges 2D Array
			Edges.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n-1 ; i++) {  // Build bi-directional graph
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			Edges.get(n1).add(n2);
			Edges.get(n2).add(n1);
		}
		
		int q = scanner.nextInt();

		for (int i = 0; i < q ; i++) {
			String O = scanner.next();
			int r = scanner.nextInt();
			int t = scanner.nextInt();
			
			if ("U".equals(O)) {
				long a = scanner.nextLong();
				long b = scanner.nextLong();
				double updateSum =  Math.pow(a,(b)) + Math.pow(a+1,b)  + Math.pow(b+1, a);
				updateAllChildren(r, t, updateSum);
				
			} else if ("R".equals(O)) {
				int m = scanner.nextInt();
				double sumChildren = sumAllChildren(r, t, m);
				System.out.println(" answer " + ++answer + " sum " + sumChildren + " answer " + (int)(sumChildren % m));
				//System.out.println((int)(sumChildren % m));
			}

		}
		scanner.close();

	}
	
	public static void updateAllChildren(int r, int t, double updateSum) {
		storedValues[t] += updateSum;
		for (int nextT: Edges.get(t)) {
			if (nextT != r) {
				updateAllChildren (t, nextT, updateSum);
			}
			
		}
	}
	
	public static double sumAllChildren(int r, int t, int m) {
		double returnValue = storedValues[t] % m;
		for (int nextT: Edges.get(t)) {
			if (nextT != r) {
				returnValue += sumAllChildren (t, nextT, m);
			}			
		}
		//System.out.println("  stored " + storedValues[t] + " return " + returnValue );
		return returnValue;
	}
	
}
