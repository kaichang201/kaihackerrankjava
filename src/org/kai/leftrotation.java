package org.kai;

import java.util.Scanner;

public class leftrotation {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scan.nextLine().split(" ");

        int n = Integer.parseInt(nd[0].trim());

        int d = Integer.parseInt(nd[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }
        for (int i = 0; i<d; i++) {
        	leftrotate(a);
        }
        for (int i = 0; i <n ;i++) {
        	System.out.print(a[i] + " ");
        }
    }
    
    public static void leftrotate(int[] inArray) {
    	int firstIndex = inArray[0];
    	for (int i=0; i<inArray.length-1; i++) {
    		inArray[i] = inArray[i+1];
    	}
    	inArray[inArray.length-1] = firstIndex;
     }
}
