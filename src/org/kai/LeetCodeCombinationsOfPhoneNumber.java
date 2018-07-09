package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class LeetCodeCombinationsOfPhoneNumber {

static LeetCodeCombinationsOfPhoneNumber me = new LeetCodeCombinationsOfPhoneNumber();

public static void main(String[] args) {
	// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

	long startTime = System.currentTimeMillis();
	
	//   [["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	System.out.println(Arrays.toString(letterCombinations("23").toArray()));
	
	System.out.println(Arrays.toString(letterCombinations("123023").toArray()));
	System.out.println(Arrays.toString(letterCombinations("1230230").toArray()));
		
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

static public List<String> letterCombinations(String digits) {
	String[][] keyPad = {{},
			{},{"a","b","c"},{"d","e","f"},
			{"g","h","i"},{"j","k","l"},{"m","n","o"},
			{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};

	Deque<String> q1 = new ArrayDeque<String>();
	Deque<String> q2;
	
	for (int i = 0; i<digits.length(); i++) {
		q2 = new ArrayDeque<String>();
		int digit = Integer.parseInt(digits.charAt(i)+"");
		//System.out.println("charAt " +digits.charAt(i) + " i " + i + " digit " + digit);
		if (keyPad[digit].length > 0) {  // 0 and 1 have no characters, so skip them
			if (q1.isEmpty()) {  // if this still empty
				for (String c: keyPad[digit])
					q2.add(c); // push in every character
			} else {
				Iterator<String> i1 = q1.iterator();
				while (i1.hasNext()) {
					String s = i1.next();
					for (String c: keyPad[digit])
						q2.add(s+c);
				}
			}
			q1 = q2;
		}
	}
	
	return new ArrayList<String>(q1);

}



	
}
