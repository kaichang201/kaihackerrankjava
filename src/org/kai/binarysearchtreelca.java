package org.kai;

public class binarysearchtreelca {
	class Node {
	     public  int data;
	     public  Node left, right;
	}
	
	public static void main(String[] args) {
		binarysearchtreelca  hd = new binarysearchtreelca();
		Node myTree = initTree(hd);
		Node myNode = algo1 (myTree, 1, 7);
		System.out.println("Found " + myNode.data );
		
	}
	
	public static Node initTree (binarysearchtreelca hd) {
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

	static Node algo1(Node root, int v1, int v2) {  // doesn't account for case where v1 is parent of v2 or v2 is parent of v1.
		if (root != null) {
			if (v1 == root.data || v2 == root.data) return root;
			else {
				Node left = algo1(root.left, v1, v2);
				Node right = algo1(root.right, v1, v2);
				if (left != null && right != null )
					return root;  // if both returned not null, then this is LCA
				else if (left != null)
					return left;  // otherwise if left is not null return left
				else if (right != null)
					return right;  // otherwise if right is not null return right
			}
		}
		return null;  // otherwise return null
	}
	

}



