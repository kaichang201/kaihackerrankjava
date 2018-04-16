package org.kai;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class insertanodeattail {
	
	  class Node {
		     int data;
		     Node next;
		  }
	  
    public static void main(String[] args) {
    	insertanodeattail myInstance = new insertanodeattail();
    	Node myHead = myInstance.new Node();
    	myHead = myInstance.Insert(null, 2);
    }
    
    /*
    Insert Node at the end of a linked list 
    head pointer input could be NULL as well for empty list
    Node is defined as 
    class Node {
       int data;
       Node next;
    }
  */
    Node Insert(Node head,int data) {
    	// This is a "method-only" submission. 
    	// You only need to complete this method. 
        Node newNode = new Node();
        if (head == null) {
        	newNode.data = data;
        	newNode.next = null;
        	return newNode;
        } else {
        	newNode = Insert(head.next, data);
        	head.next= newNode;
        	return head;
        }
    }
    
    /*
    Print elements of a linked list on console 
    head pointer input could be NULL as well for empty list
    Node is defined as 
    class Node {
       int data;
       Node next;
    }
  */

    void Print(Node head) {
    	  if (head == null) return;
    	    System.out.println(head.data);
    	    Print(head.next);
    	  
    	}

}
