package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class AmCatQ1 {



public static void main(String[] args) {
    System.out.println("Hello World");
}
/*
 * Test ID 23280666774313
 * Test ID 23280666774313
 * 
 * Removed question statement out of respect for Amazon interviewing process
 * 
 * Example
 *: Input num destinations 3
 * allocations {1,2},{3,4}{1,-1}}
 * numDeliveries = 2
 * Output [ {1,-1}, {1,2}}
 * 22 out of 22 passed.
 */

/*
	AmCatQ1 me = new AmCatQ1();
	
	int[] testcase1 = {{1,2},{3,4}{1,-1}};


	
	long startTime = System.currentTimeMillis();

	System.out.println(me.ClosestXdestinations(3,2)); //  


	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}



	public List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
		/*
		 * Strategy; example explanation seems to imply the truck always returns to warehouse before each delivery.  so distance
		 * always calculated from [0,0]. Let's try this way.
		 * loop across allLocations.  put into a priorityqueue that has custom comparator to calculate distance from 0,0
		 * then pull numDeliveries from pq

		List<List<Integer>> rv = new ArrayList<>();
		Comparator<List<Integer>> myComparator = new Comparator<List<Integer>>() {
			@Override
			public int compare (List<Integer> d1, List<Integer> d2) {
				double distance1 = Math.sqrt(Math.pow(d1.get(0),2) + Math.pow(d1.get(1),2));
				double distance2 = Math.sqrt(Math.pow(d2.get(0),2) + Math.pow(d2.get(1),2));
				if (distance1 > distance2)
					return 1;
				if (distance1 < distance2)
					return -1;
				return 0;							
						
			}
		};
		PriorityQueue<List<Integer>> pq = new PriorityQueue<> (10, myComparator);
		
		// loop across all locations.  add to dq and let it do the sorting
		for (List<Integer> d: allLocations)
			pq.add(d);
		
		// pull up the num of Deliveries
		for (int i = 0; i<numDeliveries; i++)
			rv.add(pq.poll());
		return rv;
	}
	
*/

}
