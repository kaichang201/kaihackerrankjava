package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class HackerRankJavaMD5 {

	public static void main(String[] args) {
		HackerRankJavaMD5 me = new HackerRankJavaMD5();
		long startTime = System.currentTimeMillis();
		
		me.MD5("HelloWorld"); // 68e109f0f40ca72a15e05cc22786f8e6
		me.MD5("Javarmi123"); //2da2d1e0ce7b4951a858ed2d547ef485
		me.MD5("askjf3l4r3mandsf,masrnl3kjr4n3qlkasndfl,mwan4rkl3j4rn3kf3njfnqalm,sdfnljkn33lfn34knaselfk3n4rflas krj2lkjnalkdsnfl324 "); //2da2d1e0ce7b4951a858ed2d547ef485
	
		me.SHA256("HelloWorld"); // 68e109f0f40ca72a15e05cc22786f8e6
		me.SHA256("Javarmi123"); //2da2d1e0ce7b4951a858ed2d547ef485
		me.SHA256("askjf3l4r3mandsf,masrnl3kjr4n3qlkasndfl,mwan4rkl3j4rn3kf3njfnqalm,sdfnljkn33lfn34knaselfk3n4rflas krj2lkjnalkdsnfl324 "); //2da2d1e0ce7b4951a858ed2d547ef485
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	public void MD5(String s) {  // Assuming that subtree is direct child of tree
//        Scanner in = new Scanner(System.in);
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
	
	public void SHA256(String s) {  // Assuming that subtree is direct child of tree
//      Scanner in = new Scanner(System.in);
      StringBuffer sb = new StringBuffer();

//      String s = in.next();
      try {
      	MessageDigest md = MessageDigest.getInstance("SHA-256");
      	md.update(s.getBytes());
	        byte[] digest = md.digest();
	        for (byte b : digest) {
	        	sb.append(String.format("%02x", b & 0xff));
	        }
      } catch (Exception e) {}  
      System.out.println(sb.toString());

	}
	
	
}
