package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import org.kai.LeetCodeBinaryTreeZigZagLevelOrderTraversal.TreeNode;


public class LeetCodeStringToIntegerAtio {
	
	// https://leetcode.com/problems/string-to-integer-atoi/
	/*
	 * Implement ATOI which converts a string to an integer
	 * the function first discovers as many white space characters as necessary until the first non-white character is found.
	 * Then it takes an optional plus or minus sign followed by numerical digits and interprets them as numerical value.
	 * 
	 * The string can contain additional characters after those that form the number, which are ignored
	 *
	 * If the first sequence of non-whitespace characters in string is not a valid integral number,
	 * of i no such sequence exists because either string is empty or contains only white space, no conversion is performed.
	 * 
	 * If no valid conversion can be performed, 0 is returned.
	 * Notes: Only space character ' ' is considered whitespace
	 *  - Assume 32-bit signed.  so -2^31, 2^31-1
	 * -2147483648 to 2147483647
	 * 
	 */

	  
	public static void main(String[] args) {
		LeetCodeStringToIntegerAtio me = new LeetCodeStringToIntegerAtio();

		String testcase1 = "42"; // 42
		String testcase2 = "   -42"; // -42
		String testcase3 = "4193 with words"; // 4193
		String testcase4 = "words and 987"; // 0
		String testcase5 = "-91283472332"; // -2147483648
		String testcase6 = "91283472332"; // 2147483647
		String testcase7 = null; // 0
		String testcase8 = ""; // 0
		String testcase9 = "               "; // 0
		String testcase10 = "-words"; // 0
		String testcase11 = "-2147483648"; // -2147483648
		String testcase12 = "-2147483647"; // -2147483647
		String testcase13 = "-2147483649"; // -2147483648
		String testcase14 = "2147483647"; // 2147483647
		String testcase15 = "2147483646"; // 2147483646
		String testcase16 = "2147483648"; // 2147483647
		String testcase17 = "  0002147483646"; // 2147483646
		String testcase18 = "-"; // 0
		String testcase19 = "000000000000000"; // 0
		String testcase20 = "000000000000001"; // 1
		String testcase21 = "+000000000000001"; // 1
		String testcase22 = "+1"; // 1
		String testcase23 = "+"; // 0


		long startTime = System.currentTimeMillis();

		
		System.out.println(me.myAtoi(testcase1));   // 42
		System.out.println(me.myAtoi(testcase2));   // -42
		System.out.println(me.myAtoi(testcase3));   // 4193
		System.out.println(me.myAtoi(testcase4));   // 0
		System.out.println(me.myAtoi(testcase5));   // -2147483648
		System.out.println(me.myAtoi(testcase6));   // 2147483647
		System.out.println(me.myAtoi(testcase7));   // 0
		System.out.println(me.myAtoi(testcase8));   // 0
		System.out.println(me.myAtoi(testcase9));   // 0
		System.out.println(me.myAtoi(testcase10));   // 0
		System.out.println(me.myAtoi(testcase11));   // -2147483648
		System.out.println(me.myAtoi(testcase12));   // -2147483647
		System.out.println(me.myAtoi(testcase13));   // -2147483648
		System.out.println(me.myAtoi(testcase14));   // 2147483647
		System.out.println(me.myAtoi(testcase15));   // 2147483646
		System.out.println(me.myAtoi(testcase16));   // 2147483647
		System.out.println(me.myAtoi(testcase17));   // 2147483646
		System.out.println(me.myAtoi(testcase18));   // 0
		System.out.println(me.myAtoi(testcase19));   // 0
		System.out.println(me.myAtoi(testcase20));   // 1
		System.out.println(me.myAtoi(testcase21));   // 1
		System.out.println(me.myAtoi(testcase22));   // 1
		System.out.println(me.myAtoi(testcase23));   // 0
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
    public int myAtoi(String str) {
    	/*
    	 * Strategy - trim string.  convert into char array
    	 * point header to index 0.  if -, point header to index 1 and set minus to true
    	 * if header points to 0, keep walking header until non-zero.
     	 * if header points to non-digit, return 0.
     	 * Walk tail from header to first non-0
    	 * if tail to header is greater than 10 digits, then return max_int or min_int
    	 * if tail to header is 10 digits, then compare to see if it exceeds max value
    	 * if tail to header is less than 10 digits, then Integer.parse
    	 */

    	if (str== null)
    		return 0;
    	String s= str.trim();
    	if ("".equals(s) || "-".equals(s) || "+".equals(s))
    		return 0;
    	//  Strategy - trim string.  convert into char array
    	char[] c = str.trim().toCharArray();
    	int header = 0, tail;
    	boolean negative = false;
    	
    	// point header to index 0. if -, point header to index 1 and set minus to true
    	if (c[header] == '-' || c[header] == '+') {
    		if (c[header] == '-')
    			negative = true;
    		header++;
    	}
    	// if header points to 0, keep walking header until non-zero.
    	while (header < c.length-1 && c[header] == '0')
    		header++;
    	
    	// if header points to non-digit, return 0.
    	if(c[header] <'0' || c[header] > '9')  // not a digit
    		return 0;

    	// Walk tail from header to first non-0
    	tail = header;
    	while(tail < c.length-1 // if tail already points at end, no point walking tail no more
    			&& (c[tail+1] >='0' && c[tail+1] <= '9'))  // a digit
    		tail++;

    	//System.out.println(str + "  " + Arrays.toString(c) + " header " +  header + " tail " + tail);

   	  //  if tail to header is greater than 10 digits, then return max_int or min_int
   	  // if tail to header is 10 digits, then compare to see if it exceeds max value
    	if (exceededMax(c, header, tail, negative))
    		return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    	
    	return negative ? Integer.parseInt(String.valueOf(c,header, tail-header+1)) *-1 : Integer.parseInt(String.valueOf(c,header, tail-header+1));
    	        
    }
    
    boolean exceededMax(char[] c, int header, int tail, boolean negative) {
    	if (tail-header < 9)
    		return false;
    	if (tail-header >= 10)
    		return true;
    	
    	// exactly 10 digits
    	if (negative) { // for negative numbers return true if # greater than 2147483648
    		//System.out.println( "  negative  " + String.valueOf(c,header, tail-header+1) + " returns " +  String.valueOf(c,header, tail-header+1).compareTo("2147483648"));
    		return (String.valueOf(c,header, tail-header+1).compareTo("2147483648") >= 0 );
    	}
    	// for positive numbers return true if # greater than 2147483647
    	//System.out.println( "  positive  " + String.valueOf(c,header, tail-header+1) + " returns " +  String.valueOf(c,header, tail-header+1).compareTo("2147483647"));
    	return (String.valueOf(c,header, tail-header+1).compareTo("2147483647") >= 0 );
    }
	
	
}
