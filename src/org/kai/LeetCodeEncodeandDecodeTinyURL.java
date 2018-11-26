package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


public class LeetCodeEncodeandDecodeTinyURL {



public static void main(String[] args) {
	// https://leetcode.com/problems/encode-and-decode-tinyurl/
	/*
	 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/desgin-tinyurl
	 * returns a short URL such as http://tinyurl.com/4e9iAk.
	 * Design the encode and decode methods for the tinyURL service.
	 * No restrictio on how you encode / decode algorithm should work.  You just need to ensure that a URL can be encoded into a tinyURL and tinyURL can be decoded
	 * to original URL
	 */


	LeetCodeEncodeandDecodeTinyURL me = new LeetCodeEncodeandDecodeTinyURL();
	String testcase1 = "https://leetcode.com/problems/design-tinyurl";
	String testcase2 = "https://leetcode.com/aproblems/design-tinyurl";
	

	long startTime = System.currentTimeMillis();
	String result = me.encode(testcase1);
	System.out.println(result);
	System.out.println(me.decode(result));  // 5
	
	result = me.encode(testcase2);
	System.out.println(result);
	System.out.println(me.decode(result));  // 5

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	/* 
	 * Strategy: tinyURL based upon increasing numbers.
	 * keep a map from long to short, so if someone wants to encode the same return the same shortURL
	 * keep a map from short to long for decoding
	 */
	Map<String,String> l2s = new HashMap<>();
	Map<String,String> s2l = new HashMap<>();
	final String baseURL =  "http://tinyurl.com/";
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (l2s.containsKey(longUrl))
			return l2s.get(longUrl);
	    String tinyURL = baseURL+l2s.size();
	    l2s.put(longUrl, tinyURL);
	    s2l.put(tinyURL, longUrl);
	    return tinyURL;
	}
	
	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
	    if (!s2l.containsKey(shortUrl))
	    	return "";
	    return s2l.get(shortUrl);
	}
}
