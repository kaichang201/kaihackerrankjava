package org.kai;

import java.security.MessageDigest;
import java.util.*;




public class LeetCodeBinaryWatch {
	// https://leetcode.com/problems/binary-watch/description/

	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public static void main(String[] args) {
	LeetCodeBinaryWatch me = new LeetCodeBinaryWatch();

    long startTime = System.currentTimeMillis();

    System.out.println(me.readBinaryWatch(0)); //["0:00"]
    System.out.println(me.readBinaryWatch(1)); //["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

    // ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48",
    //"1:01","1:02","1:04","1:08","1:16","1:32",
    //"2:01","2:02","2:04","2:08","2:16","2:32"
   //,"3:00",
   //"4:01","4:02","4:04","4:08","4:16","4:32",
   //"5:00","6:00",
   //"8:01","8:02","8:04","8:08","8:16","8:32",
   //"9:00","10:00"]
    System.out.println(me.readBinaryWatch(2));
    System.out.println(me.readBinaryWatch(3));  // 
    System.out.println(me.readBinaryWatch(6)); //

    
  
    System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
}


 public List<String> readBinaryWatch(int num) {
	 List <String> rv = new ArrayList<>();
	 Map <Integer, List<String>> hours = new HashMap<>();
	 Map <Integer, List<String>> mins = new HashMap<>();
	 
	 if (num >= 9)  // 11 59 is 8 lights.  no combo above 8.
		 return rv;
	 
	 String[] blankArray = {};


	 String[] hour0 = {"0"};
	 String[] hour1 = {"1","2","4","8"};
	 String[] hour2 = {"3","5","6","9","10"};
	 String[] hour3 = {"7","11"};

	 String[] min0 = {"00"};
	 String[] min1 = {"01","02","04","08","16","32"};
	 String[] min2 = {"03","05","06","09","10","12","17","18","20","24","33","34","36","40","48"};
	 String[] min3 = {"07","11","13","14","19","21","22","25","26","28","35","37","38","41","42","44","49","50","52","56"};
	 String[] min4 = {"15","23","27","29","30","39","43","45","46","51","53","54","57","58"};
	 String[] min5 = {"31","47","55","59"};

	 hours.put(0, new ArrayList<String>(Arrays.asList(hour0)));
	 mins.put(0, new ArrayList<String>(Arrays.asList(min0)));
	 hours.put(1, new ArrayList<String>(Arrays.asList(hour1)));
	 mins.put(1, new ArrayList<String>(Arrays.asList(min1)));
	 hours.put(2, new ArrayList<String>(Arrays.asList(hour2)));
	 mins.put(2, new ArrayList<String>(Arrays.asList(min2)));
	 hours.put(3, new ArrayList<String>(Arrays.asList(hour3)));
	 mins.put(3, new ArrayList<String>(Arrays.asList(min3)));
	 hours.put(4, new ArrayList<String>(Arrays.asList(blankArray)));
	 mins.put(4, new ArrayList<String>(Arrays.asList(min4)));
	 hours.put(5, new ArrayList<String>(Arrays.asList(blankArray)));
	 mins.put(5, new ArrayList<String>(Arrays.asList(min5)));
	 hours.put(6, new ArrayList<String>(Arrays.asList(blankArray)));
	 mins.put(6, new ArrayList<String>(Arrays.asList(blankArray)));
	 hours.put(7, new ArrayList<String>(Arrays.asList(blankArray)));
	 mins.put(7, new ArrayList<String>(Arrays.asList(blankArray)));
	 hours.put(8, new ArrayList<String>(Arrays.asList(blankArray)));
	 mins.put(8, new ArrayList<String>(Arrays.asList(blankArray)));
	 
	 for (int i = 0; i<=num; i++) {
		 for (String hour: hours.get(i)) {
			 for (String min: mins.get(num-i)) {
				 rv.add(hour+":"+min);
			 }
		 }
	 }
	 return rv;

}
 

}
