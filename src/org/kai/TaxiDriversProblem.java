package org.kai;

import java.util.Scanner;

public class TaxiDriversProblem {

	public static void main(String[] args) {
		algo1();
	}
	
	class Juncture {
		int x;
		int y;
	}
	class Path {
		long h;
		long v;
		long hops;
	}
	
	static Juncture[] myJunc;
	static Path[][] myPath;

	public static void algo1() {  // brute force
		// TODO Auto-generated method stub
		TaxiDriversProblem mytd = new TaxiDriversProblem();
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		long carh = scanner.nextLong(), carv = scanner.nextLong();
		myJunc = new Juncture[n+1];
		myPath = new Path[n+1][n+1];
		long possiblePaths = n * (n-1) / 2;
		long pathTooLong = 0;
		
		for (int i = 1; i<n+1; i++) {
			myJunc[i] = mytd.new Juncture();
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
