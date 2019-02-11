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


public class LeetCodeUniqueEmailAddresses {



public static void main(String[] args) {
	// https://leetcode.com/problems/unique-email-addresses/
	
	LeetCodeUniqueEmailAddresses me = new LeetCodeUniqueEmailAddresses();
	
	String[] testcase1 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
	// 2.  testemail@leetcode.com and testemail@lee.tcode.com
	String[] testcase2 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com", "@"};
	// 2.  testemail@leetcode.com, testemail@lee.tcode.com, @

	
	long startTime = System.currentTimeMillis();

	System.out.println(me.numUniqueEmails(testcase1)); //  2

	System.out.println(me.numUniqueEmails(testcase2)); //  3
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public int numUniqueEmails(String[] emails) {
		Set<String> s = new HashSet<>();  // Using a Set to take advantage it can't have dups.
		// nested loop approach.  n emails, m characters each.  O(n*m)
		for (String email: emails) {  // outer loop through n email
			char[] emailChars =  email.toCharArray();
			StringBuffer localName = new StringBuffer();
			String domainName = "";
			boolean parsingLocal = true;
			
			for (int i = 0; i < emailChars.length; i++ ) { // inner loop m letters
				if ( emailChars[i] == '@') { // first time I see a @, switch to parsing domain
					domainName = email.substring(i, email.length());
					break;
				}
				if (emailChars[i] == '.') // skip
					continue;
				if (emailChars[i] == '+')
					parsingLocal = false;
				
				if (parsingLocal)
					localName.append(emailChars[i]);
				
			}
			s.add(localName.toString()+domainName);
		}
		//System.out.println(s.toString());
		return s.size();

	}

}
