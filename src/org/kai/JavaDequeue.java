package org.kai;

import java.util.ArrayDeque;
import java.util.Deque;

import java.util.Scanner;


public class JavaDequeue {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1"))
			algo1();
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public static void algo1() {  // Assuming that subtree is direct child of tree
        Deque deque = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
           
        }
	

	}
	
	
}
