package org.kai;

import java.security.MessageDigest;

import java.util.Scanner;


public class HackerRankInsertANodeAtHeadOfLinkedList {

	  class Node {
		     int data;
		     Node next;
		  }
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			algo1("HelloWorld"); // 68e109f0f40ca72a15e05cc22786f8e6
			algo1("Javarmi123"); //2da2d1e0ce7b4951a858ed2d547ef485
		}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	
	Node Insert(Node head,int x) {
	    Node newNode = new Node();
	    newNode.data = x;
	    if (head != null)
	        newNode.next = head;
	    return newNode;
	    
	}
	
	
}
