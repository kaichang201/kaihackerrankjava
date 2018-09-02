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


public class CrackingCode14ReplaceSpaceInPlace {



public static void main(String[] args) {
	/*
	Write a method to replace all spaces in a string with'%20'. You may assume that
	the string has sufficient space at the end of the string to hold the additional
	characters, and that you are given the "true" length of the string. (Note: if implementing
	in Java, please use a character array so that you can perform this operation
	in place.)
	*/
	CrackingCode14ReplaceSpaceInPlace me = new CrackingCode14ReplaceSpaceInPlace();
	
	String testcase1 = "Mr John Smith    ";
	String testcase2 = " Mr John Smith      ";
	String testcase3 = "MrJohnSmith";
	
	long startTime = System.currentTimeMillis();

	System.out.println(Arrays.toString(me.ReplaceSpaceInPlace(testcase1.toCharArray()))); //  "Mr%20John%20Smith"
	System.out.println(Arrays.toString(me.ReplaceSpaceInPlace(testcase2.toCharArray()))); //  "Mr%20John%20Smith"
	System.out.println(Arrays.toString(me.ReplaceSpaceInPlace(testcase3.toCharArray()))); //  "MrJohnSmith"
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public char[] ReplaceSpaceInPlace(char[] ca) {
		int spaceCount=0;
		int lastLetter = -1;
		int i = ca.length-1;

		System.out.println("Hello1 " + Arrays.toString(ca));
		while (i >=0) {
			if (lastLetter < 0) {  // iterate through the spaces to initialize lastLetter
				if (ca[i] == ' ') {
					i--;
					continue;
				}
				else
					lastLetter = i;
			}
			if  (ca[i] == ' ')  // iterate through the words to count number of spaces
				spaceCount++;
			i--;
		}
		System.out.println("Hello2");

		i = ca.length-1;

		while (lastLetter >= 0) {
			if (ca[lastLetter] == ' ') {
				ca[i--] = '0';
				ca[i--] = '2';
				ca[i--] = '%';
			} else {
				ca[i--] = ca[lastLetter];
			}
			lastLetter--;
		}
		System.out.println("Hello3");

		return  ca;
	}

}
