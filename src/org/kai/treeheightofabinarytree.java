package org.kai;

public class treeheightofabinarytree {
	class Node {
	     public  int data;
	     public  Node left, right;
	}
	
	public static void main(String[] args) {
		treeheightofabinarytree  hd = new treeheightofabinarytree();
		Node myTree = initTree(hd);
		Node myNode = algo1 (myTree, 1, 7);
		System.out.println("Found " + myNode.data );
		
	}
	
	public static Node initTree (treeheightofabinarytree hd) {
		Node node1 = hd.new Node(), node2 = hd.new Node(), node3 = hd.new Node(), node4 = hd.new Node(),
				node5 = hd.new Node(), node6 = hd.new Node(), node7 = hd.new Node();
		
		node1.data = 1;
		node2.data = 2;
		node3.data = 3;
		node4.data = 4;
		node5.data = 5;
		node6.data = 6;
		node7.data = 7;

		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		
		return node4;
		
	}

	static int height(Node root) {
      	// Write your code here.
        if (root == null) {return -1;}
        int myRight = height(root.right);
        int myLeft = height(root.left);
        if (myRight >= myLeft) {return myRight + 1;}
        return myLeft + 1;
    }

	

}



