package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlaguesInc {

	int[][] degreesOfSeparation;
	int unsetValue = 10000;

	int plagueInc(int[][] people) {
	    degreesOfSeparation  = new int[people.length][people.length];
	    int leastMaxDegrees = unsetValue ;
	    int personLeastDegrees = 0;
	    int maxDegreeOfSeparationToCheck = 80;

	    
	    for (int i = 0; i<people.length; i++) {
	        for (int j = 0; j<people.length;j++) {
	            degreesOfSeparation[i][j] = unsetValue;
	        }
	    }

	    for (int i = 0; i < people.length; i++) {
	        
	        if (people[i].length == 1) return -1;  // if this guy don't know noone, he can't be infected. game over man.
	        
	        degreesOfSeparation[people[i][0]][people[i][0]] = 0;  // set distance to self as 0

	        for (int j = 1; j<people[i].length ; j++) { // set distance to friend as 1
	            degreesOfSeparation[people[i][0]][people[i][j]] = 1; 
	            degreesOfSeparation[people[i][j]][people[i][0]] = 1;
	        }

	    }
	    
	    for (int i = 0; i < people.length; i++) { // look for i -> j -> k such that i -> k can be derived from i->j j->k
	        for (int j = 0; j < people.length; j++) {
	            if (i == j || degreesOfSeparation[i][j] == unsetValue ) continue; // i to j undefined. skip for now
	            for (int k = 0; k < people.length; k++) {
	                if (i == k || degreesOfSeparation[j][k] == unsetValue ) continue; // j to k undefined. skip for now
	                if ( degreesOfSeparation[i][k] > degreesOfSeparation[i][j] + degreesOfSeparation[j][k])  {// found shorter path
	                    degreesOfSeparation[i][k] = degreesOfSeparation[i][j] + degreesOfSeparation[j][k];
	                    degreesOfSeparation[k][i] = degreesOfSeparation[i][k];
	                }
	            }
	        }  
	    }
	    
	   for (int i = 0; i<people.length; i++) {
	       int myMaxDegrees = 0;
	        for (int j = 0; j<people.length;j++) {
	            if (degreesOfSeparation[i][j] > myMaxDegrees) {
	                myMaxDegrees = degreesOfSeparation[i][j];
	                //System.out.println ("from " + i + " to " + j + " degreeness " + myMaxDegrees);
	            }
	        }


	       if (myMaxDegrees == unsetValue) return -1;
	       if (leastMaxDegrees > myMaxDegrees ) {
	           leastMaxDegrees = myMaxDegrees;
	           personLeastDegrees = i;
	       }
	    }
	    return personLeastDegrees;
	}

	
}
