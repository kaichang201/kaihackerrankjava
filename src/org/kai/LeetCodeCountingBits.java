package org.kai;


import java.util.Arrays;


public class LeetCodeCountingBits {

// https://leetcode.com/problems/counting-bits/description/
	
	public static void main(String[] args) {
		LeetCodeCountingBits me = new LeetCodeCountingBits();
		long startTime = System.currentTimeMillis();
		
		System.out.println(Arrays.toString(me.countBits(0))); // 0
		System.out.println(Arrays.toString(me.countBits(1))); // 0,1
		System.out.println(Arrays.toString(me.countBits(2))); // 0,1,1
		System.out.println(Arrays.toString(me.countBits(3))); // 0,1,1,2
		System.out.println(Arrays.toString(me.countBits(4))); // 0,1,1,2,1
		System.out.println(Arrays.toString(me.countBits(5))); // 0,1,1,2,1,2
		System.out.println(Arrays.toString(me.countBits(6))); // 0,1,1,2,1,2,2
		System.out.println(Arrays.toString(me.countBits(7))); // 0,1,1,2,1,2,2,3
		System.out.println(Arrays.toString(me.countBits(8))); // 0,1,1,2,1,2,2,3,1
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}


	public int[] countBits(int num) { // O (n *30), or O(n). beats 9.5% of java submissions. 6ms.  to get faster would require bitshifting
		int[] rv = new int[num+1];
		int[] ints = {1,2,4,8,16,32,64,128,256,
				512,1024,2048,4096,8192,16384,32768,65536,
				131072,262144,524288,1048576,2097152,4194304,8388608,16777216,
				33554432,67108864,134217728,268435456,536870912,1073741824};

		if (num==0)
			return rv;
		
		for (int i=1; i<=num; i++) {
			int j=ints.length-1;
			int temp = i;
			int counter=0;
			while (ints[j] > i)  // quietly j ahead to where num > ints[j]
				j--;
			while (j >= 0) {
				//System.out.println("Hello World2 temp " + temp + " ints[j] " + ints[j]);
				if (ints[j] <= temp) {  // count and reduce
					counter++;
					temp -= ints[j]; 
				}
				j--;
			}
			rv[i] = counter;
		}
	
		return rv;
	}
}
