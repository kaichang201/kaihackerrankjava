package org.kai;

import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LeetCodeNumberOfIslands {

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


public static void main(String[] args) {
	// https://leetcode.com/problems/number-of-islands/description/
	LeetCodeNumberOfIslands me = new LeetCodeNumberOfIslands();
	char[][] testcase1 =   {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
	char[][] testcase2 =   {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
	char[][] testcase3 =   {{'1'},{'1'}};

	long startTime = System.currentTimeMillis();
	
	Node node1 = me.new Node(1,1);
	Node node2 = me.new Node(1,1);
	Node node3 = me.new Node(2,1);
	
	Set<Node> s = new HashSet<>();
	
	System.out.println(node1.equals(node2));  // true
	System.out.println(node1.equals(node3)); // false
	
	System.out.println(s.size()); // 0
	s.add(node1);
	System.out.println(s.size()); // 1
	s.add(node3);
	System.out.println(s.size()); // 2
	s.add(node2);
	System.out.println(s.size()); // 2
	
	s.clear();
	s.add(node1);
	System.out.println(s.contains(node2));  // returning false
	System.out.println(s.contains(node1));  // returning false

	System.out.println(me.numIslands(testcase1)); // 1
	System.out.println(me.numIslands(testcase2)); // 3
	System.out.println(me.numIslands(testcase3)); // 1

	
	System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}

public int numIslands(char[][] grid) {
	List<Set<Node>> islands = new ArrayList<>();
	for (int i=0; i<grid.length; i++) {
		for (int j=0; j<grid[0].length; j++) {
			// did we find land?
			if (grid[i][j] == '1' ) {
				boolean found = false;
				if (islands.size() > 0) {
					for (int k = 0 ; k < islands.size() && found == false; k++) {
						if (islands.get(k).contains(new Node(i,j)))
							found = true;
					}
				}
				if (found == false) {  // did not match previously discovered island.  start mapping out this island.
					System.out.println("Mapping new Island");
					islands.add(mapIsland(i, j, grid));
				}
			}
		}
	}
	return islands.size();
}

public Set<Node> mapIsland(int i, int j, char[][] grid) { //BFS
	Set<Node> rv = new HashSet<>();
	Deque<Node> q = new ArrayDeque<>();
	Node foundLand;
	q.add(new Node(i,j));
		
	while (!q.isEmpty()) {
		Node n = q.remove();
		if (n.x >0 && grid[n.x-1][n.y] == '1') {  			// land to the west
			foundLand = new Node(n.x-1,n.y);
			if (!rv.contains(foundLand) && !q.contains(foundLand))  // not already mapped && queued
				q.add(foundLand);
		}
		
		if (n.x <grid.length-1 && grid[n.x+1][n.y] == '1') {  			// land to the east
			foundLand = new Node(n.x+1,n.y);
			if (!rv.contains(foundLand) && !q.contains(foundLand))  // not already mapped && queued
				q.add(foundLand);
		}
		
		if (n.y >0 && grid[n.x][n.y-1] == '1') {  			// land to the north
			foundLand = new Node(n.x,n.y-1);
			if (!rv.contains(foundLand) && !q.contains(foundLand))  // not already mapped && queued
				q.add(foundLand);
		}
		
		if (n.y <grid[0].length-1 && grid[n.x][n.y+1] == '1') {  			// land to the south
			foundLand = new Node(n.x,n.y+1);
			if (!rv.contains(foundLand) && !q.contains(foundLand))  // not already mapped && queued
				q.add(foundLand);
		}

		rv.add(n);  // add this land to the set.
		System.out.println("Added " + n.toString() + " size " + rv.size());

	}
	return rv;
	
}
	
}
