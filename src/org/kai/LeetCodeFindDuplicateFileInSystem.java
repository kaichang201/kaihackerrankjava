package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class LeetCodeFindDuplicateFileInSystem {

	
static LeetCodeFindDuplicateFileInSystem me = new LeetCodeFindDuplicateFileInSystem();

public static void main(String[] args) {
	// https://leetcode.com/problems/find-duplicate-file-in-system/description/
	String[] testcase1 = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
	String[] testcase2 = {"root/a 1.txt(FB) 2.txt(a)","root/c 3.txt(Ea)","root/c/d 4.txt(b)","root 4.txt(c)"};

	long startTime = System.currentTimeMillis();
	
	// [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
	System.out.println(findDuplicate(testcase1));  
	System.out.println(findDuplicate(testcase2));  
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}


static public List<List<String>> findDuplicate(String[] paths) {
	List<List<String>> returnValue = new ArrayList<List<String>>();
	HashMap<String,List<String>> myDict = new HashMap<String,List<String>>();
	
	for (String path: paths ) {  // build up dictionary
		HashMap<String,List<String>> myNewDict = processPath (path);
		for (String content: myNewDict.keySet()) {  
			if (!myDict.containsKey(content))  // initialize it if new
				myDict.put(content, new ArrayList<String>());
			myDict.get(content).addAll(myNewDict.get(content));  // dump this directory into master list
		}
	}
	
	for (String content : myDict.keySet()) {  // for debug switched from myDict.values to myDict.keySet
		if (myDict.get(content).size() > 1 ) {  // more than 1 file with this content
			System.out.println(content + " " + Arrays.toString(myDict.get(content).toArray()));
			returnValue.add(myDict.get(content));
		}
	}
	return returnValue;
}
	
static public HashMap<String,List<String>> processPath (String path) {
	String[] tokens = path.split(" ");
	String dirname = tokens[0];
	HashMap<String,List<String>> myDict = new HashMap<String,List<String>>();
	
	for (int i = 1; i<tokens.length; i++) {
		String filename = tokens[i].substring(0, tokens[i].indexOf("("));
		String content = tokens[i].substring(tokens[i].indexOf("(")+1, tokens[i].indexOf(")"));
		if (!myDict.containsKey(content))  // initialize it if new
			myDict.put(content, new ArrayList<String>());
		myDict.get(content).add(dirname+"/"+filename);
	}
	return myDict;
}	
	
}
