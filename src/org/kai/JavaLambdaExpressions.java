package org.kai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


interface PerformOperation {
	 boolean check(int a);
}

class MyMath {
	 public static boolean checker(PerformOperation p, int num) {
	  return p.check(num);
	 }
	 
	 public PerformOperation isOdd () {
		 return new PerformOperation() {
			 public boolean check (int a) {
				 return (a % 2 == 1) ? true: false;
			 }
		 };
	 }
	 
	 public PerformOperation isPrime () {
		 return new PerformOperation() {
			public boolean check (int a) {
				int sqrtA = (int) Math.sqrt(a) + 1;
				for (int i = 2; i < sqrtA; i++) {
					if (a % i == 0) { 
						return false;
					}
				}
				return true;
			}
		 };
	 }
	 
	 public PerformOperation isPalindrome () {
		 return new PerformOperation() {
			 public boolean check (int a) {
				String stringA = String.valueOf(a);
				String reverseA = "";
				
				for (int i = stringA.length()-1; i >=0 ; i--) {
					reverseA = reverseA + stringA.charAt(i);
				}
				if (reverseA.equals(stringA))
					return true;
				else
					return false;
			 }
		 };
	 }
}

public class JavaLambdaExpressions {


	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1"))
			algo1();
		if (args[0].equals("2"))
			algo2();
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}
	
	public static void algo2() throws IOException {
		  MyMath ob = new MyMath();
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int T = Integer.parseInt(br.readLine());
		  PerformOperation op;
		  boolean ret = false;
		  String ans = null;
		  while (T--> 0) {
		   String s = br.readLine().trim();
		   StringTokenizer st = new StringTokenizer(s);
		   int ch = Integer.parseInt(st.nextToken());
		   int num = Integer.parseInt(st.nextToken());
		   if (ch == 1) {
		    op = ob.isOdd();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "ODD" : "EVEN";
		   } else if (ch == 2) {
		    op = ob.isPrime();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PRIME" : "COMPOSITE";
		   } else if (ch == 3) {
		    op = ob.isPalindrome();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

		   }
		   System.out.println(ans);
		  }

	}

	
	public static void algo1() {  // Assuming that subtree is direct child of tree
		//JavaBigInteger mySol = new JavaBigInteger();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String ans = "";
		
		for (int i = 0; i< n; i++) {
			int operation = scanner.nextInt();
			int checkMe = scanner.nextInt();
			if (operation == 1)
				ans = isOdd(checkMe) ? "ODD" : "EVEN";
			else if (operation == 2) 
				ans = isPrime(checkMe) ? "PRIME" : "COMPOSITE";
			else if (operation == 3) 
				ans = isPalindrome(checkMe) ? "PALINDROME" : "NOT PALINDROME";
			System.out.println(ans);
		}
		scanner.close();
	}
	
	public static boolean isOdd (int a) {
		return (a % 2 == 1) ? true: false;
	}
	
	public static boolean isPrime (int a) {
		int sqrtA = (int) Math.sqrt(a) + 1;
		for (int i = 2; i < sqrtA; i++) {
			if (a % i == 0) { 
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome (int a) {
		String stringA = String.valueOf(a);
		String reverseA = "";
		
		for (int i = stringA.length()-1; i >=0 ; i--) {
			reverseA = reverseA + stringA.charAt(i);
		}
		if (reverseA.equals(stringA))
			return true;
		else
			return false;
	}
	
	
}
