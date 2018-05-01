package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlaguesInc2 {


HashMap<Integer, HashMap<Integer,Integer>> myPaths;
HashMap<Integer, HashMap<Integer,Integer>> newPaths;

int plagueInc(int[][] people) {
    int leastMaxDegrees = 10000;
    int personLeastDegrees = 0;
    int possiblePaths = people.length * people.length; // possible path is node squared
    int pathsFound = 0;
    int maxIterations = 6;
    myPaths = new HashMap<Integer, HashMap<Integer,Integer>>();

    
    for (int i = 0; i < people.length; i++) {
        if (people[i].length == 1) return -1;  // if this guy don't know noone, he can't be infected. game over man.
        myPaths.put(people[i][0], new HashMap<Integer,Integer>()); // initialize this person's HashMap
        myPaths.get(people[i][0]).put(people[i][0], 0);
        pathsFound++;

        for (int j = 1; j<people[i].length ; j++) { // set distance to friend as 1
            if (myPaths.get(people[i][0]).get(people[i][j]) == null) {
                myPaths.get(people[i][0]).put(people[i][j],1);
                pathsFound++;
            }
        }
    }
    
    //System.out.println ("pathsfound " + pathsFound + " possible paths " + possiblePaths);
    int looper=0;
    while (pathsFound < possiblePaths && looper < maxIterations) { // if we found n^2 paths, then no point to keep looking.
       for (int i = 0; i < people.length; i++) {
          newPaths = new HashMap<Integer, HashMap<Integer,Integer>>();
          for (Integer j : myPaths.get(i).keySet()) {
              for (Integer k : myPaths.get(j).keySet()) {
                  if (i != k && myPaths.get(i).get(k) == null) {
                     if (newPaths.get(i) == null) newPaths.put(i, new HashMap<Integer,Integer>());
                     newPaths.get(i).put(k, myPaths.get(i).get(j) + myPaths.get(j).get(k));
                  }
              }
          }
            for (Integer l : newPaths.keySet()) {
                for (Integer m : newPaths.get(l).keySet()) {
                    myPaths.get(l).put(m, newPaths.get(l).get(m));
                    pathsFound++;
                }
            }
          //System.out.println ("Paths found " + pathsFound);
        }
        looper++;
    }
    
   for (int i = 0; i<people.length; i++) {
       int myMaxDegrees = 0;
        for (int j = 0; j<people.length;j++) {
            if (myPaths.get(i).get(j) == null) {
                //System.out.println ("from " + i + " to " + j + " unreachable ");
                return -1; // a path was unreachable.
            }
            if (myPaths.get(i).get(j) > myMaxDegrees) {
                myMaxDegrees = myPaths.get(i).get(j) ;
                //System.out.println ("from " + i + " to " + j + " degreeness " + myMaxDegrees);
            }
        }

       if (leastMaxDegrees > myMaxDegrees ) {
           leastMaxDegrees = myMaxDegrees;
           personLeastDegrees = i;
       }
    }
    return personLeastDegrees;
}

	
}
