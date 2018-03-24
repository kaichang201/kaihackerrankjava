package org.kai;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class sparsearrays {

    /*
     * Complete the findSuffix function below.
     */
    static int findSuffix(String[] collections, String queryString) {
    	int returnMe = 0;
    	for (int i = 0; i <collections.length; i++) {
    		//System.out.println (collections[i] + " " + queryString);
    		if (queryString.equals(collections[i])) {
    			returnMe++;
    		}
    	}
    	return returnMe;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        String[] strings = new String[n];

        for (int stringsItr = 0; stringsItr < n; stringsItr++) {
            String stringsItem = scanner.nextLine();
            strings[stringsItr] = stringsItem;
        }

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String queryString = scanner.nextLine();

            int res = findSuffix(strings, queryString);

       //     bufferedWriter.write(String.valueOf(res));
         //   bufferedWriter.newLine();
            System.out.println(res);
        }

       // bufferedWriter.close();
    }
}
