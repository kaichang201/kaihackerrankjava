package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlaguesInc2 {



HashMap<Integer, HashMap<Integer,Integer>> myPaths;

int plagueInc(int[][] people) {
    int leastMaxDegrees = 10000;
    int personLeastDegrees = 0;
    int possiblePaths = people.length * people.length; // possible path is node squared
    int pathsFound = 0;
    int maxIterations = 1;
    myPaths = new HashMap<Integer, HashMap<Integer,Integer>>();
    ArrayList<Integer> newI = new ArrayList<Integer>();
    ArrayList<Integer> newK = new ArrayList<Integer>();
    ArrayList<Integer> newDegree = new ArrayList<Integer>();

    
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
       for (int i = 0; i < people.length; i++) {
          if (myPaths.get(i).size() == people.length) continue; // already have all connections. skip
          newI.clear();
          newK.clear(); 
          newDegree.clear();

          for (Integer j : myPaths.get(i).keySet()) {
              if (i == j ) continue;
              for (Integer k : myPaths.get(j).keySet()) {
                  if (i != k && myPaths.get(i).get(k) == null) {
                      newI.add(i);
                      newK.add(k);
                      newDegree.add(myPaths.get(i).get(j) + myPaths.get(j).get(k));
                      pathsFound+=2;
                  } else if (i != k && myPaths.get(i).get(k) > myPaths.get(i).get(j) + myPaths.get(j).get(k)) {
                      newI.add(i);
                      newK.add(k);
                      newDegree.add(myPaths.get(i).get(j) + myPaths.get(j).get(k));
                  }
              }
           }
           for (int l=0; l < newI.size(); l++) {
                   myPaths.get(newI.get(l)).put(newK.get(l), newDegree.get(l));
                   myPaths.get(newK.get(l)).put(newI.get(l), newDegree.get(l));
           } 

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
