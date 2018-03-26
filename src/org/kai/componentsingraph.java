package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class componentsingraph {
    public static void main(String[] args) {
    	Map<Integer, ArrayList<Integer>> myMap = new HashMap<Integer, ArrayList<Integer>>();
        Scanner in = new Scanner(System.in);
        

        // read
        int n = in.nextInt();
       	for (int i =0; i <=n*2 ; i++) {
       		ArrayList<Integer> myList = new ArrayList<Integer>();
       		myList.add(i);
       		myMap.put(i, myList);
       	}
        
        for(int i = 0; i <n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            ArrayList<Integer> s1 = myMap.get(a);
            ArrayList<Integer> s2 = myMap.get(b);
            if (s1!=s2) {
            	s1.addAll(s2);
            	s2.forEach(j -> myMap.put(j, s1));
            }
        }
        int minSize=Integer.MAX_VALUE, maxSize = Integer.MIN_VALUE;
        
        for (ArrayList<Integer> thisSet: myMap.values()) {
        	if (thisSet.size() > 1) {
        		if (minSize > thisSet.size()) minSize = thisSet.size();
        		if (maxSize < thisSet.size()) maxSize = thisSet.size();
        	}
        }      
        System.out.println(minSize + " " + maxSize);
    }
    
}