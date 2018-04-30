package org.kai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaxiDriversProblem {



	public static void main(String[] args) {
		if (args[0].equals("1")) algo1();
		else if (args[0].equals("2")) algo2();
		else if (args[0].equals("3")) algo3();
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
	static Junction[] myJunc;
	static Path[][] myPath;
	static HashMap<Integer, ArrayList<Path>> myPathHash;
	static int[][] myTravelledPath;
	static long totalPathsCanTravel = 0;
		
	public static void algo3() {
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Junction[n+1];
		myTravelledPath = new int[n+1][n+1];
		myPathHash = new HashMap<Integer, ArrayList<Path>>();
		long possiblePaths = (n*n - n) / 2; // possible paths is n^2, less the path from node to itself.

		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Junction();
			myJunc[i].x = scanner.nextInt();
			myJunc[i].y = scanner.nextInt();
			myPathHash.put(i, new ArrayList<Path>());
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
			System.out.println("3Found "+totalPathsCanTravel + " paths after "+ i );
		}

		System.out.println ("3 Possible Paths " + possiblePaths  + " total paths can travel " + totalPathsCanTravel);
		System.out.println (possiblePaths - (totalPathsCanTravel/2));
		// Solution 226330206 for problem 5
	}
	
	public static void walkPaths (ArrayList<Path> myiPaths, int fromJunc, int viaJunc, long h, long v) {
		for (Path myiPath: myiPaths) {  // walk every path
			if (h >= myiPath.h && v >= myiPath.v) { // if you can still get there
				int toJunc;
				if (viaJunc == myiPath.junc1) toJunc = myiPath.junc2;
				else toJunc = myiPath.junc1;
				if (myTravelledPath[fromJunc][toJunc] != 1 && fromJunc != toJunc) {  // mark this path has been counted
					System.out.println("3from "+ fromJunc + " to "  + toJunc + " can travel" );
					totalPathsCanTravel++;
					myTravelledPath[fromJunc][toJunc] = 1; 
				}
				walkPaths (myPathHash.get(toJunc), fromJunc, toJunc, h - myiPath.h, v-myiPath.v);
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
