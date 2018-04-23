package org.kai;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class finallanagrams {
	class Node {
	     public  int data;
	     public  Node left, right;
	}
	
	public static void main(String[] args) {
		finallanagrams me = new finallanagrams();
		System.out.println("[0,6] " + me.findAnagrams("cbaebabacd","abc"));
		System.out.println("[0,1,2] " + me.findAnagrams("abab","ab"));
		System.out.println("[0,3] " + me.findAnagrams("abcab","ab"));
		System.out.println("[1,4] " + me.findAnagrams("habcab","ab"));
	}
	

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> returnValue = new ArrayList<Integer>();
        char[] pChar = p.replaceAll("[\\s]", "").toCharArray();
        for (int i = s.length()-p.length(); i>=0 ;i--) {

        	if (p.indexOf(s.charAt(i)) < 0) { // if character at i is not in p, then skip p length
        		i = i-p.length()+1;
        		System.out.println ("Skipping p.length " + String.valueOf(i) );
        		continue;        		
        	}
        	if (i + p.length() < s.length()  // Not the first iteration
        			&&  s.charAt(i) == s.charAt(i + p.length())  // this character is same as character p .lengths away
        			&& returnValue.contains(i+1)  // last iteration was an anagram
        			) {
            	System.out.println("Adding 2 " + String.valueOf(i));
        		returnValue.add(i);  // if last iteration was an anagram, and this character is same as the character that just rolled off
        		continue;
        	}
        	
            char[] sChar = s.substring(i,i+p.length()).replaceAll("[\\s]", "").toCharArray();
            Arrays.sort(pChar);
            Arrays.sort(sChar);
        	System.out.println(String.valueOf(pChar) + " " + String.valueOf(sChar));

            if (Arrays.equals(pChar, sChar)) {
            	System.out.println("Adding 3 " + String.valueOf(i));
            	returnValue.add(i);
            }
        }
        returnValue.sort(null);
        return returnValue;
    }

}



