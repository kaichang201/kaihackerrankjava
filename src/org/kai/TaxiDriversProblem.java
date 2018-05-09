package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TaxiDriversProblem {



	public static void main(String[] args) {
		if (args[0].equals("1")) algo1();
		else if (args[0].equals("2")) algo2();
		else if (args[0].equals("3")) algo3();
		else if (args[0].equals("4")) algo4();
		else if (args[0].equals("5")) algo5();
		else if (args[0].equals("6")) algo6();
		else if (args[0].equals("7")) algo7();
		else if (args[0].equals("8")) algo8();
		else if (args[0].equals("9")) algo9();
		else if (args[0].equals("10")) algo10();
	}
	
	class Junction {
		int x;
		int y;
	}
	class Path {
		int junc1;
		int junc2;
		long h;
		long v;
		long hops;
	}
	
	class Edge {
		int h;
		int v;
		public Edge() {}
		public Edge(int inH, int inV) {
			h = inH; v = inV;
		}
	}
	class LongEdge {
		long h;
		long v;
		public LongEdge(long inH, long inV) {
			h = inH; v = inV;
		}
	}
	class TravelEdge {
		int junc;
		long h;
		long v;
		public TravelEdge(int injunc, long inh, long inv) {
			junc=injunc; h=inh; v=inv;
		}
	}
	static Junction[] myJunc;
	static Path[][] myPath;
	static HashMap<Integer, ArrayList<Path>> myPathHash;
	static HashMap<Integer, HashMap<Integer,Integer>> myTravelledPath;
	static long totalPathsCanTravel = 0;
	
	static HashMap<Integer, HashSet<Integer>> myJuncMap;
	static HashMap<Integer, HashMap<Integer, Edge>> myJuncEdgeMap;
	static ArrayList<HashMap<Integer,Edge>> myJuncArrayMap;
	static ArrayList<HashSet<Integer>> myJuncArraySet;	
	static HashSet<Integer> visited;
	static boolean[] visitedArray;
	static int visitedCounter = 0;

	
	public static void algo10() {  // faster under 2 minutes under 105 seconds
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncArrayMap = new ArrayList<HashMap<Integer,Edge>>(n+1);
		myJuncArraySet = new ArrayList<HashSet<Integer>>(n+1);	
		//visited = new HashSet<Integer>();
		//long walkedPath = 0;
		visitedCounter = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();

		myJuncArrayMap.add(new HashMap<Integer,Edge>());
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncArrayMap.add(new HashMap<Integer,Edge>());
			//System.out.println("10 juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Edge myNewEdge = mytd.new Edge(Math.abs(myJunc[u].x - myJunc[v].x), Math.abs(myJunc[u].y - myJunc[v].y));
			myJuncArrayMap.get(u).put(v, myNewEdge);
			myJuncArrayMap.get(v).put(u, myNewEdge);

			//System.out.println("10 Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			walkPath10(i, carh, carv, new boolean[n+1]);
			//System.out.println ("10 Walked From " + i  + " found paths " + visitedCounter );
		}

		System.out.println("10 possiblePaths " + possiblePaths + " walkedPaths " + (visitedCounter-n)/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (visitedCounter-n)/2); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void walkPath10 (int lastJ, long h, long v, boolean[] boolArray) {
		boolArray[lastJ] = true;
		visitedCounter++;
		HashMap<Integer,Edge> myLastSet;
		Edge myNextEdge;
		long myH, myV;
		for(Integer nextJ: (myLastSet = myJuncArrayMap.get(lastJ)).keySet()) {
			if ( !boolArray[nextJ] 
					&& (myH = (h - (myNextEdge = myLastSet.get(nextJ)).h)) >= 0 
					&& (myV = (v - myNextEdge.v)) >= 0 ) {  // can go from last to next, and next not already visited
				//System.out.println("  10 Found Path from " + lastJ + " to " + nextJ 
				//		+ " remaining h " + h +  " v " + v
				//		+ " next  h " + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x) +  " v " + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y));
				walkPath10(nextJ, myH, myV, boolArray );
			}
		}
	}
	
	public static void algo9() {  // Trading Space for Time
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		ArrayList<HashMap<Integer,Edge>> myArrayMapEdge = new ArrayList<HashMap<Integer,Edge>>(n+1);
		//ArrayList<HashSet<Integer>> myJuncArraySet = new ArrayList<HashSet<Integer>>(n+1);
		visitedCounter = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();
		Deque<Integer> que = new ArrayDeque<Integer>(n+1);
		boolean[] visitedArray;
		long[] visitedH, visitedV;

		myArrayMapEdge.add(new HashMap<Integer,Edge>());
		//myJuncArraySet.add(new HashSet<Integer>());
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			//myJuncArraySet.add(new HashSet<Integer>());
			myArrayMapEdge.add(new HashMap<Integer,Edge>());
			//System.out.println("9 juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			//myJuncArraySet.get(u).add(v);
			//myJuncArraySet.get(v).add(u);
			Edge myNewEdge = mytd.new Edge( Math.abs(myJunc[u].x - myJunc[v].x),  Math.abs(myJunc[u].y - myJunc[v].y));
			myArrayMapEdge.get(u).put(v, myNewEdge);
			myArrayMapEdge.get(v).put(u, myNewEdge);
			//System.out.println("9 Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visitedArray = new boolean[n+1];
			visitedH = new long[n+1];
			visitedV = new long[n+1];
//			visitedCounter = 0;
			que.add(i);
			while (que.size() > 0) {
				Integer lastJ = que.remove();
				visitedCounter++;
				visitedArray[lastJ] = true;
				//for (Integer nextJ: myJuncArraySet.get(lastJ)) {
				for (Integer nextJ: myArrayMapEdge.get(lastJ).keySet()) {
					if (!visitedArray[nextJ] // hasn't visited from i to nextJ
//						&& (visitedH[nextJ] = visitedH[lastJ] + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x)) <= carh // next Step doesn't exceed car's max distance
//						&& (visitedV[nextJ] = visitedV[lastJ] + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y)) <= carv ) {
						&& (visitedH[nextJ] = visitedH[lastJ] + myArrayMapEdge.get(lastJ).get(nextJ).h) <= carh // next Step doesn't exceed car's max distance
						&& (visitedV[nextJ] = visitedV[lastJ] + myArrayMapEdge.get(lastJ).get(nextJ).v) <= carv ) {

						//System.out.println ("9 at " + i +  " from " + lastJ + " to " + nextJ);
						que.add(nextJ);  // add to queue the set of edges for next iteration
					}
				}	
			}

//			walkedPath += visitedCounter - 1; // found all walked paths, except walking to self.  
			//System.out.println ("9 Walked From " + i  + " found paths " + (visitedCounter));
		}

		System.out.println("9 possiblePaths " + possiblePaths + " visitedCounter " + (visitedCounter-n)/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (visitedCounter-n)/2); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void algo8() {  // Without recursion
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncArrayMap = new ArrayList<HashMap<Integer,Edge>>(n+1);
		long walkedPath = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();

		myJuncArrayMap.add(new HashMap<Integer,Edge>());
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncArrayMap.add(new HashMap<Integer,Edge>());
			//System.out.println("8 juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Edge myNewEdge = mytd.new Edge();
			myNewEdge.h = Math.abs(myJunc[u].x - myJunc[v].x);
			myNewEdge.v = Math.abs(myJunc[u].y - myJunc[v].y);
			myJuncArrayMap.get(u).put(v, myNewEdge);
			myJuncArrayMap.get(v).put(u, myNewEdge);
			//System.out.println("8 Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visitedCounter = 0;
			visitedArray = new int[n+1];
			Deque<TravelEdge> que = new ArrayDeque<TravelEdge>();
			que.add(mytd.new TravelEdge(i, carh, carv));
			while (que.size() > 0) {
				TravelEdge lastEdge = que.remove();
				visitedCounter++;
				visitedArray[lastEdge.junc] = 1;
				for (Integer nextJ: myJuncArrayMap.get(lastEdge.junc).keySet()) {
					long myRemainingH = lastEdge.h - myJuncArrayMap.get(lastEdge.junc).get(nextJ).h;
					long myRemainingV = lastEdge.v - myJuncArrayMap.get(lastEdge.junc).get(nextJ).v;
					if ( myRemainingH >= 0 && myRemainingV >= 0 && visitedArray[nextJ] == 0  ) {
						que.add(mytd.new TravelEdge(nextJ, myRemainingH, myRemainingV ));  // add to queue the set of edges for next iteration
					}					
				}
			}

			walkedPath += visitedCounter - 1; // found all walked paths, except walking to self.  
			System.out.println ("8 Walked From " + i  + " found paths " + visited.size() + " total paths " + walkedPath );
		}

		System.out.println("8 possiblePaths " + possiblePaths + " walkedPaths " + walkedPath/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (walkedPath/2)); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	
	public static void algo7() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncArrayMap = new ArrayList<HashMap<Integer,Edge>>(n+1);
		long walkedPath = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();

		myJuncArrayMap.add(new HashMap<Integer,Edge>());
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncArrayMap.add(new HashMap<Integer,Edge>());
			//System.out.println("7 juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Edge myNewEdge = mytd.new Edge();
			myNewEdge.h = Math.abs(myJunc[u].x - myJunc[v].x);
			myNewEdge.v = Math.abs(myJunc[u].y - myJunc[v].y);
			myJuncArrayMap.get(u).put(v, myNewEdge);
			myJuncArrayMap.get(v).put(u, myNewEdge);
			//System.out.println("7 Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visitedCounter = 0;
			visitedArray = new int[n+1];
			visitedArray[i] = 1;
			walkPath7(i, carh, carv);
			walkedPath += visitedCounter; // found all walked paths, except walking to self.  
			//System.out.println ("7 Walked From " + i  + " found paths " + visited.size() + " total paths " + walkedPath );
		}

		System.out.println("7 possiblePaths " + possiblePaths + " walkedPaths " + walkedPath/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (walkedPath/2)); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void walkPath7 (int lastJ, long h, long v) {
		
		for(Integer nextJ: myJuncArrayMap.get(lastJ).keySet()) {
			int myX = myJuncArrayMap.get(lastJ).get(nextJ).h;
			int myY = myJuncArrayMap.get(lastJ).get(nextJ).v;
			if ( myX <= h && myY <=v && visitedArray[nextJ] == 0) {  // can go from last to next, and next not already visited
				//System.out.println("  4 Found Path from " + lastJ + " to " + nextJ 
				//		+ " remaining h " + h +  " v " + v
				//		+ " next  h " + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x) +  " v " + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y));
				visitedArray[nextJ] = 1;
				visitedCounter++;
				walkPath7(nextJ, (h-myX), (v-myY));
			}
		}
	}
	
	public static void algo6() {  // fastest at 145 to 165seconds
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncArrayMap = new ArrayList<HashMap<Integer,Edge>>(n+1);
		visited = new HashSet<Integer>();
		long walkedPath = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();

		myJuncArrayMap.add(new HashMap<Integer,Edge>());
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncArrayMap.add(new HashMap<Integer,Edge>());
			//System.out.println("6 juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Edge myNewEdge = mytd.new Edge();
			myNewEdge.h = Math.abs(myJunc[u].x - myJunc[v].x);
			myNewEdge.v = Math.abs(myJunc[u].y - myJunc[v].y);
			myJuncArrayMap.get(u).put(v, myNewEdge);
			myJuncArrayMap.get(v).put(u, myNewEdge);
			//System.out.println("6 Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visited.clear();
			walkPath6(i, carh, carv);
			walkedPath += visited.size()-1; // found all walked paths, except walking to self.  
			System.out.println ("6 Walked From " + i  + " found paths " + visited.size() + " total paths " + walkedPath );
		}

		System.out.println("6 possiblePaths " + possiblePaths + " walkedPaths " + walkedPath/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - walkedPath/2); // walked path minus  divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void walkPath6 (int lastJ, long h, long v) {
		visited.add(lastJ);		
		for(Integer nextJ: myJuncArrayMap.get(lastJ).keySet()) {
			int myX = myJuncArrayMap.get(lastJ).get(nextJ).h;
			int myY = myJuncArrayMap.get(lastJ).get(nextJ).v;
			if ( myX <= h && myY <=v && !visited.contains(nextJ)) {  // can go from last to next, and next not already visited
				//System.out.println("  4 Found Path from " + lastJ + " to " + nextJ 
				//		+ " remaining h " + h +  " v " + v
				//		+ " next  h " + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x) +  " v " + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y));
				walkPath6(nextJ, (h-myX), (v-myY));
			}
		}
	}
	
	public static void algo5() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncEdgeMap = new HashMap<Integer, HashMap<Integer, Edge>>();
		visited = new HashSet<Integer>();
		long walkedPath = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncEdgeMap.put(i, new HashMap<Integer,Edge>());
			
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Edge myNewEdge = mytd.new Edge();
			myNewEdge.h = Math.abs(myJunc[u].x - myJunc[v].x);
			myNewEdge.v = Math.abs(myJunc[u].y - myJunc[v].y);
			myJuncEdgeMap.get(u).put(v, myNewEdge);
			myJuncEdgeMap.get(v).put(u, myNewEdge);
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visited.clear();
			visited.add(i);
			walkPath5(i, carh, carv);
			walkedPath += visited.size()-1; // found all walked paths, except walking to self.  
			//System.out.println ("5 Walked From " + i  + " found paths " + visited.size() + " total paths " + walkedPath );
		}

		System.out.println("5 possiblePaths " + possiblePaths + " walkedPaths " + walkedPath/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (walkedPath/2)); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void walkPath5 (int lastJ,  long h, long v) {
		
		for(Integer nextJ: myJuncEdgeMap.get(lastJ).keySet()) {
			int myX = myJuncEdgeMap.get(lastJ).get(nextJ).h;
			int myY =  myJuncEdgeMap.get(lastJ).get(nextJ).v;
			if (myX <= h && myY <=v && !visited.contains(nextJ)) {  // can go from last to next, and next not already visited
				//System.out.println("  4 Found Path from " + lastJ + " to " + nextJ 
				//		+ " remaining h " + h +  " v " + v
				//		+ " next  h " + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x) +  " v " + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y));
				visited.add(nextJ);
				walkPath5(nextJ, (h-myX), (v-myY));
			}
		}
	}
	
	
	public static void algo4() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myJuncMap = new HashMap<Integer, HashSet<Integer>>();
		visited = new HashSet<Integer>();
		long walkedPath = 0;
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself, divided by 2 because of unordered pairs
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myJuncMap.put(i, new HashSet<Integer>());
			//System.out.println("4juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			myJuncMap.get(u).add(v);
			myJuncMap.get(v).add(u);
			//System.out.println("4Path loaded " + " "  + u + " to " + v + " h ");
		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			visited.clear();
			visited.add(i);
			walkPath4(i, carh, carv);
			walkedPath += visited.size()-1; // found all walked paths, except walking to self.
			//System.out.println ("4 Walked From " + i  + " found paths " + visited.size() + " total paths " + walkedPath );
		}

		System.out.println("4 possiblePaths " + possiblePaths + " walkedPaths " + walkedPath/2 + " time taken " + (System.currentTimeMillis() - startTime));
		System.out.println (possiblePaths - (walkedPath/2)); // walked path divided by 2 because of unordered pairs
		// Solution 226330206 for problem 5
	}
	
	public static void walkPath4 (int lastJ,  long h, long v) {
		
		for(Integer nextJ: myJuncMap.get(lastJ)) {
			long myX = Math.abs(myJunc[lastJ].x - myJunc[nextJ].x);
			long myY = Math.abs(myJunc[lastJ].y - myJunc[nextJ].y);
			if (myX <= h && myY <=v && !visited.contains(nextJ)) {  // can go from last to next, and next not already visited
				//System.out.println("  4 Found Path from " + lastJ + " to " + nextJ 
				//		+ " remaining h " + h +  " v " + v
				//		+ " next  h " + Math.abs(myJunc[lastJ].x - myJunc[nextJ].x) +  " v " + Math.abs(myJunc[lastJ].y - myJunc[nextJ].y));
				visited.add(nextJ);
				walkPath4(nextJ, (h-myX), (v-myY));
			}
		}
	}
		
	public static void algo3() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myPathHash = new HashMap<Integer, ArrayList<Path>>();
		myTravelledPath = new HashMap<Integer, HashMap<Integer,Integer>>();
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself.

		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myPathHash.put(i, new ArrayList<Path>());
			myTravelledPath.put(i, new HashMap<Integer,Integer>());
			System.out.println("3juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			Path myiPath = mytd.new Path();
			myiPath.junc1 = u;
			myiPath.junc2 = v;
			myiPath.h =  Math.abs(myJunc[u].x - myJunc[v].x);
			myiPath.v = Math.abs(myJunc[u].y - myJunc[v].y);
			myPathHash.get(u).add(myiPath);
			myPathHash.get(v).add(myiPath);
			System.out.println("3Path loaded " + " "  + u + " to " + v + " h ");

		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk n iterations
			walkPaths(myPathHash.get(i), i, i, carh, carv);
			System.out.println("3Found "+myTravelledPath.size() + " paths after "+ i );
		}

		//System.out.println ("3 Possible Paths " + possiblePaths  + " total paths can travel " + totalPathsCanTravel);
		System.out.println (possiblePaths - (myTravelledPath.size()/2));
		// Solution 226330206 for problem 5
	}
	
	public static void walkPaths (ArrayList<Path> myiPaths, int fromJunc, int viaJunc, long h, long v) {
		for (Path myiPath: myiPaths) {  // walk every path
			if (h >= myiPath.h && v >= myiPath.v) { // if you can still get there
				int toJunc;
				if (viaJunc == myiPath.junc1) toJunc = myiPath.junc2;
				else toJunc = myiPath.junc1;
				if (fromJunc == toJunc) {
					System.out.println("Detected loop from " + fromJunc);// loop detection
					continue;
				}
				if (myTravelledPath.get(fromJunc).get(toJunc) == null ) {  // mark this path has been counted
					//System.out.println("3 from "+ fromJunc + " to "  + toJunc + " can travel via " + viaJunc );
					// totalPathsCanTravel++;
					myTravelledPath.get(fromJunc).put(toJunc, 1);
					walkPaths (myPathHash.get(toJunc), fromJunc, toJunc, h - myiPath.h, v-myiPath.v);
				}
			}
		}
	}

		
	public static void algo2() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myPath = new Path[n+1][n+1];
		long possiblePaths = n*n - n; // possible paths is n^2, less the path from node to itself.
		long pathTooLong = 0;
		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			System.out.println("2juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		
		for (int i = 0; i<n-1; i++) {  // represent Path as matrix of nondirectional edges between Junctions 1 and 2
			int u = scanner.nextInt(), v = scanner.nextInt();
			myPath[u][v] = mytd.new Path();
			myPath[u][v].h = Math.abs(myJunc[u].x - myJunc[v].x);
			myPath[u][v].v = Math.abs(myJunc[u].y - myJunc[v].y);
			myPath[u][v].hops = 1;
			myPath[v][u] = myPath[u][v];  // initialize both sides of the diagonal to make discovery easier.
			System.out.println("2Path loaded " + possiblePaths + " "  + u + " to " + v + " h " + myPath[u][v].h + " v " + myPath[u][v].v);

		}
		scanner.close();

		// All junctures are connected to each other.  All junctures have exactly 1 shortest path to each other
		for (int i = 1; i < n+1; i++) {  // walk the 1st dimension
			for (int j = 1; j < i; j++ ) { // walk the 2nd dimension
				if (i == j // node self path. length 0
						|| myPath[i][j] == null  // no path from i to j
						) continue;  
				for (int k = 1; k < n+1 ; k++ ) {
					if (i == k // node self path. length 0 
							|| myPath[j][k] == null  // no path from j to k
							) continue;
					if (myPath[i][k] == null) { // found new Path!
						myPath[i][k] = mytd.new Path();
						myPath[i][k].h = myPath[i][j].h + myPath[j][k].h;
						myPath[i][k].v = myPath[i][j].v + myPath[j][k].v;
						myPath[i][k].hops = myPath[i][j].hops + myPath[j][k].hops;
						myPath[k][i] = myPath[i][k]; // initialize both sides of the diagonal to make discovery easier.
						System.out.println("2Path found " + possiblePaths + " "  + i + " to " + k + " h " + myPath[i][k].h + " v " + myPath[i][k].v + " hops " + myPath[i][k].hops);
					} else if (myPath[i][k] != null  // previous path found
							&& myPath[i][k].hops > myPath[i][j].hops + myPath[j][k].hops) {// found shorter connection
						myPath[i][k].h = myPath[i][j].h + myPath[j][k].h;
						myPath[i][k].v = myPath[i][j].v + myPath[j][k].v;
						myPath[i][k].hops = myPath[i][j].hops + myPath[j][k].hops;
						System.out.println("2Shorter Path found " + possiblePaths + " "  + i + " to " + k + " h " + myPath[i][k].h + " v " + myPath[i][k].v + " hops " + myPath[i][k].hops);
					}
				}
			}
		}
		for (int i = 1; i <n+1; i++) {
			for ( int j = 1; j <i; j++) {
				if (myPath[i][j].h > carh || myPath[i][j].v > carv) {
					pathTooLong++;
					System.out.println ("2Path too long " + i + " to " + j + " " + pathTooLong);
				}
			}
		}
		System.out.println (pathTooLong);
	}

	public static void algo1() {  // brute force
		// TODO Auto-generated method stub
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myPath = new Path[n+1][n+1];
		long possiblePaths = n * (n-1) / 2;
		long pathTooLong = 0;
		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			System.out.println("juncture " + myJunc[i].x + "," + myJunc[i].y);
		} 
		System.out.println("Possible paths " + possiblePaths);
		
		for (int i = 0; i<n-1; i++) {
			int u = scanner.nextInt(), v = scanner.nextInt();
			// initialize both sides of the diagonal
			myPath[u][v] = mytd.new Path();
			myPath[u][v].h = Math.abs(myJunc[u].x - myJunc[v].x);
			myPath[u][v].v = Math.abs(myJunc[u].y - myJunc[v].y);
			myPath[u][v].hops = 1;
			myPath[v][u] = myPath[u][v];  // initialize both sides of the diagonal to make discovery easier.
			possiblePaths--; // count 
			System.out.println("Path loaded " + possiblePaths + " "  + u + " to " + v + " h " + myPath[u][v].h + " v " + myPath[u][v].v);

		}
		scanner.close();
		
		while ( possiblePaths >0 ) {  // loop until all paths found
			for (int i = 1; i<n+1; i++) {
				for (int j = 1; j<n+1; j++) {
						for (int k = 1; k <n+1; k++) {
							if ( i != j && j != k && i != k
									&& myPath[i][j] != null && myPath[j][k] != null
									&& myPath[i][k] == null ) {  // found connection
								// Found new path
								myPath[i][k] = mytd.new Path();
								myPath[i][k].h = myPath[i][j].h + myPath[j][k].h;
								myPath[i][k].v = myPath[i][j].v + myPath[j][k].v;
								myPath[i][k].hops = myPath[i][j].hops + myPath[j][k].hops;
								myPath[k][i] = myPath[i][k]; // initialize both sides of the diagonal to make discovery easier.
								possiblePaths--; // count 
								System.out.println("Path found " + possiblePaths + " "  + i + " to " + k + " h " + myPath[i][k].h + " v " + myPath[i][k].v + " hops " + myPath[i][k].hops);
							} else 	if ( i != j && j != k && i != k
									&& myPath[i][j] != null && myPath[j][k] != null
									&& myPath[i][k] != null
									&& myPath[i][k].hops > myPath[i][j].hops + myPath[j][k].hops ) { // found shorter connection
								myPath[i][k].h = myPath[i][j].h + myPath[j][k].h;
								myPath[i][k].v = myPath[i][j].v + myPath[j][k].v;
								myPath[i][k].hops = myPath[i][j].hops + myPath[j][k].hops;
								myPath[k][i] = myPath[i][k]; // initialize both sides of the diagonal to make discovery easier.
								System.out.println("Shorter Path found " + possiblePaths + " "  + i + " to " + k + " h " + myPath[i][k].h + " v " + myPath[i][k].v + " hops " + myPath[i][k].hops);
							}
						}
				}
			}
		}
		for (int i = 1; i <n+1; i++) {
			for ( int j = i+1; j <n+1; j++) {
				if (myPath[i][j].h > carh || myPath[i][j].v > carv) {
					pathTooLong++;
					System.out.println ("Path too long " + i + " to " + j + " " + pathTooLong);
				}
			}
		}
		System.out.println (pathTooLong);

	}
	

	
}
