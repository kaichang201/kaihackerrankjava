package org.kai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;


public class HackerRankGameOfThrones2 {



public static void main(String[] args) {
	// https://www.hackerrank.com/challenges/game-of-throne-ii/forum
	HackerRankGameOfThrones2 me = new HackerRankGameOfThrones2();
	
	String testcase1 = "aaabbbb";  // 3! / 2! 3
	String testcase2 = "cdcdcdcdeeeef"; // 90  
	String testcase3 = "cdefghmnopqrstuvw"; // 0
	String testcase4 = "c"; // 1
	String testcase5 = "aabbcc"; // 6
	String testcase6 = "" ; // 565288459
	try {
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\coding\\kaihackerrankjava\\testdata\\HackerRankGameofThrones40.txt"));

		testcase6 = bReader.readLine();
		bReader.close();
	} catch (Exception e) {
		System.out.println("Exception " + e);
	}


	long startTime = System.currentTimeMillis();


	System.out.println(me.solve(testcase1)); // 3
	System.out.println(me.solve(testcase2)); // 90
	System.out.println(me.solve(testcase3)); // 0
	System.out.println(me.solve(testcase4)); // 1
	System.out.println(me.solve(testcase5)); // 6
	System.out.println(me.solve(testcase6)); // 	 565288459 // 565288459

	System.out.println("Test Case 1 taken " + (System.currentTimeMillis() - startTime));

	
	startTime = System.currentTimeMillis();
	
	System.out.println(me.solve2(testcase1)); // 3
	System.out.println(me.solve2(testcase2)); // 90
	System.out.println(me.solve2(testcase3)); // 0
	System.out.println(me.solve2(testcase4)); // 1
	System.out.println(me.solve2(testcase5)); // 6
//	System.out.println(me.solve2(testcase6)); // 	 doesn't work

	System.out.println("Test Case 2 taken " + (System.currentTimeMillis() - startTime));

	startTime = System.currentTimeMillis();

	System.out.println(me.solve3(testcase1)); // 3
	System.out.println(me.solve3(testcase2)); // 90
	System.out.println(me.solve3(testcase3)); // 0
	System.out.println(me.solve3(testcase4)); // 1
	System.out.println(me.solve3(testcase5)); // 6
	System.out.println(me.solve3(testcase6)); // 	 565288459 // 9223372036854775807
	
	System.out.println("Test Case 3 taken " + (System.currentTimeMillis() - startTime));

}

	public int solve(String s) {
		Map<Character, Integer> m = new HashMap<>();
		Map<Integer, BigInteger> fac = new HashMap<>();
		int oddCount = 0;
		
		fac.put(0, BigInteger.ONE);
		fac.put(1, BigInteger.ONE);
		
		int numerator = (s.length() & 1) == 1 ? (s.length()-1)/2 : s.length()/2;
		for (int i=2; i<= numerator; i++)   // prime the cache
			fac.put(i, fac.get(i-1).multiply(BigInteger.valueOf(i)));

		for (Character c : s.toCharArray()) {  // count characters
			if (m.containsKey(c))
				m.put(c, m.get(c)+1);
			else
				m.put(c, 1);
		}
		
		BigInteger totalFac = fac.get(numerator);
		BigInteger denominator = BigInteger.ONE;
		for (Character c : m.keySet()) {
			Integer i = m.get(c);
			//System.out.println("c " + c + " i "+ i);
			if ((i & 1) == 1) {
				oddCount++;
				if (oddCount > 1)
					return 0;  // game over.  palindrome can have 0 or 1 odd characters
				denominator = denominator.multiply(fac.get((i-1)/2));
			} else {
				denominator = denominator.multiply(fac.get(i/2));
			}
		}

		return totalFac.divide(denominator).mod(BigInteger.valueOf(1000000007)).intValue();

	}
	
	public BigInteger factorial (Integer num, Map<Integer, BigInteger> fac) {
		BigInteger rv;
        if (fac.containsKey(num))
            rv = fac.get(num);
        else {
        	rv = factorial(num-1, fac).multiply(BigInteger.valueOf(num));
        	fac.put(num, rv);
        }
        return rv;
    }
	
	public int solve2(String s) {
		if (s.length() <3)
			return 1;

		Map<Character, Integer> m = new HashMap<>();
		Map<Integer, List<Integer>> factors = new HashMap<>();
		int oddCount = 0;			
		int numerator = (s.length() & 1) == 1 ? (s.length()-1)/2 : s.length()/2;


		factors.put(0, Arrays.asList(Integer.valueOf(1)));
		factors.put(1, Arrays.asList(Integer.valueOf(1)));
		factors.put(2, Arrays.asList(Integer.valueOf(2)));
		for (int i=3; i<= numerator; i++) {   // calculate the factors
			List<Integer> a = new ArrayList<>(factors.get(i-1));
			a.addAll(primeFactors(i));  // add the prime factors
			factors.put(i,a);
			//System.out.println(i + " " + factors.get(i));
		}
		
		for (Character c : s.toCharArray()) {  // count characters
			if (m.containsKey(c))
				m.put(c, m.get(c)+1);
			else
				m.put(c, 1);
		}


		List<Integer> totalFac = factors.get(numerator);
		List<Integer> denominators = new ArrayList<Integer>();
		
		for (Character c : m.keySet()) {
			Integer i = m.get(c);
			if ((i & 1) == 1) {
				oddCount++;
				if (oddCount > 1)
					return 0;  // game over.  palindrome can have 0 or 1 odd characters
				denominators.addAll(factors.get((i-1)/2));
			} else {
				denominators.addAll(factors.get(i/2));
			}
		}
		
		// eliminate common factors
		System.out.println ("numerator before "+ totalFac);
		System.out.println ("denominators before "+ denominators);
		Collections.sort (totalFac);
		Collections.sort (denominators);
		Integer[] numArray = new Integer[totalFac.size()];
		Integer[] denArray = new Integer[denominators.size()];	
		totalFac.toArray(numArray);
		denominators.toArray(denArray);
		int nIndex=0, dIndex=0;
		while (nIndex < numArray.length && dIndex < denArray.length) {
			if (numArray[nIndex] == denArray[dIndex]) {  // eliminate common factors
				numArray[nIndex++] = 1;
				denArray[dIndex++] = 1;
			} else if (numArray[nIndex] > denArray[dIndex])  // else increment index that points to the lesser value
				dIndex++;
			else
				nIndex++;
		}
//		System.out.println ("numerator after "+ Arrays.asList(numArray));
//		System.out.println ("denominators after "+ Arrays.asList(denArray));
		long num1 = product(numArray);
		long den1 = product(denArray);
		System.out.println ("nproduct "+ num1 + " dproduct " + den1);


//		return totalFac.divide(denominator).intValue();
		return (int)((num1/den1) % 1000000007);
		
	}
	
    public List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
    
    public Long product(Integer[] a) {
    	long rv = 1;
    	for (int i : a) {
    		rv *=i;
    	}
    	return rv;
    }
    
	public int solve3(String s) {
		if (s.length() <3)
			return 1;

		int oddCount = 0;			
		int numerator = (s.length() & 1) == 1 ? (s.length()-1)/2 : s.length()/2;

		Map<Character, Integer> m = new HashMap<>();
		IntegerPrimeFactor factors = new IntegerPrimeFactor(numerator);

		for (Character c : s.toCharArray()) {  // count characters
			if (m.containsKey(c))
				m.put(c, m.get(c)+1);
			else
				m.put(c, 1);
		}


		HashMap<Integer, Integer> numfactors = factors.cloneFactors(numerator);
		
		for (Character c : m.keySet()) {
			Integer i = m.get(c);
			if ((i & 1) == 1) {
				oddCount++;
				if (oddCount > 1)
					return 0;  // game over.  palindrome can have 0 or 1 odd characters
				numfactors= factors.divideAndRemainder(numfactors, factors.getFactors((i-1)/2))[0];
			} else {
				numfactors= factors.divideAndRemainder(numfactors, factors.getFactors(i/2))[0];
			}
		}
		

		return factors.toBigInteger(numfactors).mod(BigInteger.valueOf(1000000007)).intValue();
		
	}
	
    class IntegerPrimeFactor {  // storing integer as prime factors
    	HashMap<Integer, Integer>[] factors;   // using HashMap because it implements cloneable


    	@SuppressWarnings("unchecked")
		public IntegerPrimeFactor(int n) {
    		// initial factors from 0 to n
    		factors = new HashMap[n+1];
    		factors[0] = new HashMap<Integer,Integer>();
    		factors[1] = new HashMap<Integer,Integer>();
    		for (int i=2; i<=n; i++) {
    			factors[i] = multiply(factors[i-1], i);
    		}
  		
    	}
    	
        public HashMap<Integer, Integer> primeFactors(int n) {
            HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();

            if (n < 1)
    			return factors;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    if (factors.containsKey(i))
                    	factors.put(i, factors.get(i)+1);
                    else
                    	factors.put(i, 1);
                    n /= i;
                }
            }  
            return factors;
        }
        
    	public int toInt (int n) {
    		if (n > factors.length)
    			return 0;
    		Double rv = 1.0;
    		for (Integer i : factors[n].keySet()) {
    			if (i > 1  && factors[n].get(i) > 0) {
    				rv =  rv * Math.pow(i, factors[n].get(i));
    			}
    		}
    		return (int) Math.round(rv);
    	}
    	
    	public int toInt (HashMap<Integer, Integer> n) {
    		Double rv = 1.0;
    		for (Integer i : n.keySet()) {
    			if (i > 1  && n.get(i) > 0) {
    				rv =  rv * Math.pow(i, n.get(i));
    			}
    		}
    		return (int) Math.round(rv);
    	}
    	
    	public long toLong (HashMap<Integer, Integer> n) {
    		Double rv = 1.0;
    		for (Integer i : n.keySet()) {
    			if (i > 1  && n.get(i) > 0) {
    				rv =  rv * Math.pow(i, n.get(i));
    			}
    		}
    		return (long) Math.round(rv);
    	}
    	
    	public BigInteger toBigInteger (HashMap<Integer, Integer> n) {
    		BigInteger rv = BigInteger.ONE;
    		for (Integer i : n.keySet()) {
    			if (i > 1  && n.get(i) > 0) {
    				rv =  rv.multiply(BigInteger.valueOf((long) Math.pow(i, n.get(i))));
    			}
    		}
    		return rv;
    	}
    	
    	

    	public String toString (int n) {
    		if (n > factors.length)
    			return "NaN";
    		StringBuffer sb = new StringBuffer();
    		for (int i : factors[n].keySet())
    			sb.append("{" + i + ":" + factors[n].get(i)+"},");
    		if (sb.length() > 3)
    			sb.deleteCharAt(sb.length()-1); // drop last ,
    		return sb.toString();
    	}
    	
    	public String toString (HashMap<Integer, Integer> n) {
    		StringBuffer sb = new StringBuffer();
    		for (int i : n.keySet())
    			sb.append("{" + i + ":" + n.get(i)+"},");
    		if (sb.length() > 3)
    			sb.deleteCharAt(sb.length()-1); // drop last ,
    		return sb.toString();
    	}
    	
    	public HashMap<Integer, Integer> getFactors(int n) {
    		if (n > factors.length)
    			return new HashMap<Integer,Integer>();
    		return factors[n];
    	}
    	
    	@SuppressWarnings("unchecked")
		public HashMap<Integer, Integer> cloneFactors(int n) {
    		if (n > factors.length)
    			return new HashMap<Integer,Integer>();
    		return (HashMap<Integer, Integer>) factors[n].clone();
    	}
    	
    	public HashMap<Integer, Integer> multiply (HashMap<Integer, Integer> f, int n ) {  // multiplication is factor addition
    		HashMap<Integer,Integer> rv = primeFactors(n);  // create new, so parameters are not changed
    		
    		for (Integer i: f.keySet()) {  // iterate through this factors and add it to rv's
    			if (rv.containsKey(i))
    				rv.put(i, rv.get(i) + f.get(i));
    			else
    				rv.put(i, f.get(i));
    		}
    		return rv;
    	}

    	@SuppressWarnings("unchecked")
		public HashMap<Integer, Integer>[] divideAndRemainder (HashMap<Integer, Integer> n, HashMap<Integer, Integer> d ) {  // division is factor subtraction
			HashMap<Integer, Integer>[] rv = new HashMap[2];
    		rv[0] = (HashMap<Integer, Integer>) n.clone();  // clone a hashmap for numerator, so parameters are not changed
    		rv[1] = (HashMap<Integer, Integer>) d.clone();  // clone a hashmap for denominator, so parameters are not changed
   		
    		for (Integer i: d.keySet()) {  // for each factor
    			if (rv[0].containsKey(i)) {  // if the numerator has the same factor
    				int minpow = rv[0].get(i) > rv[1].get(i) ? rv[1].get(i) : rv[0].get(i);  // find out which factor has the lower power
    				if (rv[0].get(i) == minpow) // decrement both by the same lower power
    					rv[0].remove(i);
    				else
    					rv[0].put(i, rv[0].get(i)-minpow); 
    				
    				if (rv[1].get(i) == minpow)
    					rv[1].remove(i);
    				else
    					rv[1].put(i, rv[1].get(i)-minpow); 

    			} // else don't touch.. leave in denominator as remainder
    		}
    		return rv;
    	}
    	

    }
	
}
