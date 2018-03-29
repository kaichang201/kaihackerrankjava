package org.kai;

public class huffmandecoding {
	
	public static void main(String[] args) {
		huffmandecoding  hd = new huffmandecoding();
		Node myHuff = initHuffman(hd);
		decode ("1001011",myHuff);
		
	}
	
	public static Node initHuffman (huffmandecoding hd) {
		Node rootNode = hd.new Node();
		Node twoNode = hd.new Node();
		Node aNode = hd.new Node(), bNode = hd.new Node(), cNode = hd.new Node();
		
		aNode.data = 'A';
		bNode.data = 'B';
		cNode.data = 'C';
		
		twoNode.left = bNode;
		twoNode.right = cNode;
		rootNode.left = twoNode;
		rootNode.right = aNode;
		
		return rootNode;
		
	}
	static void decode(String S ,Node root) {
		char[] myChars = S.toCharArray();
		Node myPtr = root;
		
		for (int i = 0; i<myChars.length; i++) {
			if ('1' == myChars[i]) myPtr = myPtr.right;
			else myPtr = myPtr.left;
			
			if (myPtr.left == null && myPtr.right == null) {
				System.out.print(myPtr.data);
				myPtr = root;
			}
		}
	}
	
	private class Node {
	    public  int frequency; // the frequency of this tree
	     public  char data;
	     public  Node left, right;
	}

}



