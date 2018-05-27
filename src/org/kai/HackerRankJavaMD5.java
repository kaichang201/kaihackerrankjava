package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class HackerRankJavaMD5 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			algo1("HelloWorld"); // 68e109f0f40ca72a15e05cc22786f8e6
			algo1("Javarmi123"); //2da2d1e0ce7b4951a858ed2d547ef485
		}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public static void algo1(String s) {  // Assuming that subtree is direct child of tree
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

//        String s = in.next();
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
        	md.update(s.getBytes());
	        byte[] digest = md.digest();
	        for (byte b : digest) {
	        	sb.append(String.format("%02x", b & 0xff));
	        }
        } catch (Exception e) {}  
        System.out.println(sb.toString());

	}
	
	
}
