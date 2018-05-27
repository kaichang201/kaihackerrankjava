package org.kai;

import java.awt.SystemTray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.Scanner;


public class HackerRankJavaPrimalityTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1"))
			algo1();
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	private static final Scanner scanner = new Scanner(System.in);
	public static void algo1() {  // Assuming that subtree is direct child of tree
        String n = scanner.nextLine();
        BigInteger bd = new BigInteger(n);
        System.out.println(bd.isProbablePrime(1) ? "prime" : "not prime");
        scanner.close();
	

	}
	
	
}
