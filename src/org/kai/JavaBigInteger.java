package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class JavaBigInteger {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1"))
			algo1();
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public static void algo1() {  // Assuming that subtree is direct child of tree
		//JavaBigInteger mySol = new JavaBigInteger();
		Scanner scanner = new Scanner(System.in);
		BigInteger a = new BigInteger(scanner.next());
		BigInteger b = new BigInteger(scanner.next());
		scanner.close();

		
		System.out.println (a.add(b).toString());
		System.out.println (a.multiply(b).toString());
	

	}
	
	
}
