package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlaguesInc3 {

	// Winning answer. I didn't write this. but I want to keep a copy to learn from it

	int plagueInc(int[][] P) {
	    int n=P.length, m=999, r=-1,x,z,l,i;
	    for (int[] p: P) {
	        Set S = new HashSet();
	        Deque<Integer> Q = new ArrayDeque();
	        System.out.println ("queuing p0 "+ p[0]);
	        Q.add(p[0]);
	        z=0;
	        while (Q.size()>0 & S.size()<n) {
	            l=Q.size();
	            for (i=0; i<l; i++) {
	                S.add(x=Q.remove());
	                System.out.println (" x is " + x);
	                for (int y: P[x])
	                    if (!S.contains(y)) {
	                        Q.add(y);
	                        System.out.println ("queuing y "+ y);
	                    }
	            }
	            z++;
	        }
	        if (S.size()==n & z<m) {
	            m = z;
	            r = p[0];
	        }
	    }
	    return r;
	}



	
}
