package org.kai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import java.util.List;


public class AmCatQ2 {



public static void main(String[] args) {
/*
 * Removed question statement out of respect for Amazon interviewing process
 *  
 *  Example
 *  Input numRows 3, numColumns 3
 *  lot = {{1,0,0},{1,0,0},{1,9,1}}
 *  
 *  Output:
 *  3
 *  Explanation:
 *  Starting from top left corner, the demolition bot traverse cells {0,0},{1,0},{2,0}->{2,1}
 *  the robot traversed 3 distance, so output is 3.
 * 
 */


	AmCatQ2 me = new AmCatQ2();
	
	Integer[][] testcase1 = {{1,0,0},{1,0,0},{1,9,1}};
	List<List<Integer>> t1 = new ArrayList<>();
	for (Integer[] arr: testcase1)
		t1.add(Arrays.asList(arr));


	Integer[][] testcase2 = { {1,1,1,1},
							  {0,1,1,1}
							 ,{0,1,0,1},
							  {1,1,9,1},
							  {0,0,1,1}};	
	List<List<Integer>> t2 = new ArrayList<>();
	for (Integer[] arr: testcase2)
		t2.add(Arrays.asList(arr));

	
	Integer[][] testcase3 = { {1,1,1,1},
			 				  {0,1,1,1},
			 				  {0,1,0,1},
			 				  {1,0,9,0},
			 				  {0,1,0,1}};
	List<List<Integer>> t3 = new ArrayList<>();
	for (Integer[] arr: testcase3)
		t3.add(Arrays.asList(arr));



	long startTime = System.currentTimeMillis();

	System.out.println(me.removeObstacle(3,3,t1)); //  
	System.out.println(me.removeObstacle(5,4,t2)); //  
	System.out.println(me.removeObstacle(5,4,t3)); //  

	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	
}

	class Node {
		int x;
		int y;
		Node (int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public boolean equals (Object inNode) {
			if (inNode instanceof Node) {
				return (((Node) inNode).x==this.x  && ((Node)inNode).y == this.y);
			}
			return false;
		}
		@Override
		public int hashCode() { // hash code is necessary for hash set to function properly
			int prime = 13;
			return x*prime + y;
		}
		@Override
		public String toString () {
			return x + "," +y;
		}
	}

	public int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
	{
		/*
		 * Strategy:convert from List< BFS from 0,0
		 * until value is 9
		 */
	
		int[][] map = new int[numRows][numColumns];
		for (int i = 0; i< numRows; i++) 
			for (int j = 0; j<numColumns; j++)
				map[i][j] = lot.get(i).get(j);

		int steps = 0;
		int currentCount=1, childCount=0;
		Deque<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[numRows][numColumns];

		q.add(new Node(0,0));
		while (!q.isEmpty()) {
			if (currentCount==0) { // I've processed everything in this level. next pop is next level.
				steps++;
				currentCount = childCount;
				childCount=0;
			}
			
			Node n = q.pop();
			currentCount--;
			visited[n.x][n.y] = true;
			//System.out.println("Processing x "+ n.x + " y " + n.y);
			if (map[n.x][n.y] == 9)
				return steps;
			
			// add the next generation to be visited 
			// look up
			if(n.x != 0 && !visited[n.x-1][n.y] && map[n.x-1][n.y] != 0) {
				q.add(new Node(n.x-1, n.y));
				childCount++;
			}
			// look down
			if(n.x < numRows-1 && !visited[n.x+1][n.y] && map[n.x+1][n.y] !=0) {
				q.add(new Node(n.x+1, n.y));
				childCount++;
			}
			// look left
			if(n.y != 0 && !visited[n.x][n.y-1] && map[n.x][n.y-1] != 0) {
				q.add(new Node(n.x, n.y-1));
				childCount++;
			}
			// look right
			if(n.y < numColumns-1 && !visited[n.x][n.y+1] && map[n.x][n.y+1] != 0) {
				q.add(new Node(n.x, n.y+1));
				childCount++;
			}


		}
		

		return -1;
	}


}
