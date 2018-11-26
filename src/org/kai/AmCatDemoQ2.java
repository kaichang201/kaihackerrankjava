package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class AmCatDemoQ2 {



public static void main(String[] args) {
	// TestId 23280720391096 Demo I
	// TestId 23280720391096
	/* 
	 * Eight houses, represented as cells, are arranged in a straight line. Each day every ell compete with its adjacent
	 * cells (neighbors).
	 *  an Integer value of 1 represents an active cell and 0 represent inactive cell.
	 *  If neighbors on both sides of a cell are either active or inactive, the cell becomes inactive.  Otherwise cell becomes active
	 *  the two cells on each end have a single adjacent cell, so assume that the unoccupied space on the opposite side
	 *  is an inactive cell.
	 *  Even after updating the cell state, conider its previous state when updating the state of other cells.
	 *  The state inforamtion of all cells hsould updatd simultaneously.
	 *  
	 *  Write an algo to output the state of the cells after a given number of days.
	 *  Input: state - list of integers representing the current state. days - # of days
	 *  Output: list of integers representing the state of cells after # of days
	 *  
	 */
	/*
	 * 12 out of 12 passed.  48 mins spent.f
	 */

	AmCatDemoQ2 me = new AmCatDemoQ2();
	
	int[] testcase1 = {0,0,0};
	int testdays1 = 2; // {0,0,0};
	int[] testcase2 = {1,0,0};
	int testdays2 = 1; // {0,1,0};
	int[] testcase3 = {1,0,0};
	int testdays3 = 2; // {1,0,1};
	int[] testcase4 = {1,0,0};
	int testdays4 = 3; // {0,0,0};

	
	long startTime = System.currentTimeMillis();

	System.out.println(me.cellCompete(testcase1, testdays1)); //  
	System.out.println(me.cellCompete(testcase2, testdays2)); //  
	System.out.println(me.cellCompete(testcase3, testdays3)); //  
	System.out.println(me.cellCompete(testcase4, testdays4)); //  
	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	

}

	public List<Integer> cellCompete(int[] states, int days) {
		/* Strategy:
		 * 0 -> 20 or 21 for next dead or alive
		 * 1 -> 10 or 11 for next dead or alive
		 */
		// if days 0, return states
		if (days <1 || states.length == 0)
			return Arrays.stream(states).boxed().collect(Collectors.toList());
		
		// if states array is length 1, then it'll always end up dead after 1 day
		if (states.length == 1) {
			states[0] = 0;
			return Arrays.stream(states).boxed().collect(Collectors.toList());
		}
		
		for (int day = 0; day < days; day++ ) {
			// do the first
			if (states[1] == 0) {
				if (states[0] == 0)
					states[0] = 20;
				else
					states[0] = 10;
			} else  {
				if (states[0] == 0)
					states[0] = 21;
				else
					states[0] = 11;
			}

			// do the last
			if (states[states.length-2] == 0 || states[states.length-2] == 20 || states[states.length-2] == 21) {
				if (states[states.length-1] == 0)
					states[states.length-1] = 20;
				else
					states[states.length-1] = 10;
			} else {
				if (states[states.length-1] == 0)
					states[states.length-1] = 21;
				else
					states[states.length-1] = 11;
			}
			
			// do thing in between
			for (int i = 1; i < states.length-1; i++) {
				boolean willLive = true;
				// check if both neighbors were both dead
				if ((states[i-1] == 0  || states[i-1] == 20 || states[i-1] == 21) &&
						(states[i+1] == 0  || states[i+1] == 20 || states[i+1] == 21))
					willLive = false;
				// check if both neighbors were both alive
				if ((states[i-1] == 1  || states[i-1] == 10 || states[i-1] == 11) &&
						(states[i+1] == 1  || states[i+1] == 10 || states[i+1] == 11))
					willLive = false;
				
				if (states[i] == 0)
					if (willLive)
						states[i] = 21;
					else
						states[i] = 20;
				if (states[i] == 1)
					if (willLive)
						states[i] = 11;
					else
						states[i] = 10;
			}
			
			// reset the days
			for (int i = 0; i< states.length; i++) {
				if (states[i] == 20 || states[i] == 10) 
					states[i] = 0;
				if (states[i] == 21 || states[i] == 11) 
					states[i] = 1;
			}
			
		}
		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}

}
