package org.kai;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class arraymanipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] myArray = new long[n];

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            myArray[a-1] +=k;
            if (b<n) myArray[b]-=k;
        }
        
        for (int j = 0; j<n;j++) {
        	System.out.print(myArray[j] + " ");
        }
        in.close();

        long max = Integer.MIN_VALUE, tmp = 0;
        for (int j = 0; j<n; j++) {
        	tmp += myArray[j];
        	if (max <tmp) max = tmp;
        }

        System.out.println(max);
    }

}
