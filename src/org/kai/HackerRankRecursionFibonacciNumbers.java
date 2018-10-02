package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;


public class HackerRankRecursionFibonacciNumbers {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
	HackerRankRecursionFibonacciNumbers me = new HackerRankRecursionFibonacciNumbers();
	
	
	long startTime = System.currentTimeMillis();

	System.out.println(me.fibonacci(0)); // 0
	System.out.println(me.fibonacci(1)); // 1
	System.out.println(me.fibonacci(2)); // 1
	System.out.println(me.fibonacci(3)); // 2
	System.out.println(me.fibonacci(4)); // 3
	System.out.println(me.fibonacci(5)); // 5
	System.out.println(me.fibonacci(6)); // 8
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int fibonacci(int n) {
		if (n==0)
			return 0;
		if (n==1 || n==2)
			return 1;
		return fibonacci(n-1)+ fibonacci(n-2);
	}	
	
}
