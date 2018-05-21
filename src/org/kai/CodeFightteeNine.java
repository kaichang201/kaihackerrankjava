package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class CodeFightteeNine {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			teeNine1("cat" );
			teeNine1("a cup of tea");
			teeNine1("Oh noooooo!!" );
			teeNine1("hii badelkjiggedtvted ghion zwymnout" );
			teeNine1("I aaaaa have 2 1111 0 3333  1234567890 out of 		 ideas. # @ *." );
			teeNine1("a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa" );


		} else {
			teeNine2("cat" );
			teeNine2("a cup of tea");
			teeNine2("Oh noooooo!!" );
			teeNine2("hii badelkjiggedtvted ghion zwymnout" );
			teeNine2("I aaaaa have 2 1111 0 3333  1234567890 out of 		 ideas. # @ *." );
		}
		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	enum z {
		a(2),b(2),c(2),
		d(3),e(3),f(3),
		g(4),h(4),i(4),
		j(5),k(5),l(5),
		m(6),n(6),o(6),
		p(7),q(7),r(7),s(7),
		t(8),u(8),v(8),
		w(9),x(9),y(9),z(9);

		int A;
		
		z(int a) {A=a;}
	}
	static public String teeNine1(String s) {
		String returnString="";
		int n = s.length();
		char[] myChars = new char[n];
		Map<Integer,ArrayList<Character>> myMap = new HashMap<>();
		myMap.put(2, new ArrayList(Arrays.asList('a','b','c')));
		myMap.put(3, new ArrayList(Arrays.asList('d','e','f')));
		myMap.put(4, new ArrayList(Arrays.asList('g','h','i')));
		myMap.put(5, new ArrayList(Arrays.asList('j','k','l')));
		myMap.put(6, new ArrayList(Arrays.asList('m','n','o')));
		myMap.put(7, new ArrayList(Arrays.asList('p','q','r','s')));
		myMap.put(8, new ArrayList(Arrays.asList('t','u','v')));
		myMap.put(9, new ArrayList(Arrays.asList('w','x','y','z')));
		myMap.put(0, new ArrayList(Arrays.asList('y')));
		myMap.put(1, new ArrayList(Arrays.asList('z')));
		
		for (int i=0; i<s.length();i++) {
			if (Character.isLetter(s.charAt(i))) {
				myChars[i] = Character.forDigit(z.valueOf(String.valueOf(s.charAt(i)).toLowerCase()).A,10);
			} else if (Character.isDigit(s.charAt(i)))
				myChars[i] = myMap.get(Character.digit(s.charAt(i),10)).get(0);
			 else
				myChars[i] = s.charAt(i);
		}

		//System.out.println("chars " + Arrays.toString(myChars));

		int x=1;
		for (int i=0; i<myChars.length; i++) {
			if (Character.isDigit(myChars[i])) {
				if (i == myChars.length-1 || myChars[i] != myChars[i+1]) {  // doesn't match next number
					List<Character> c = myMap.get(Character.digit(myChars[i],10));
					if (x > c.size()) {
						x = x % c.size();
						if (x==0) x = c.size();
					}
					returnString = returnString + c.get(x-1);
					x=1;
				} else
					x++;
			} else if (Character.isLetter(myChars[i])) {
				if (myChars[i] == 'y')
					returnString = returnString + "0";
				else if (myChars[i] == 'z')
					returnString = returnString + "1";
				else
					returnString = returnString + z.valueOf(String.valueOf(myChars[i])).A;
				x=1;
			}
			else
				returnString = returnString + myChars[i];
		
		}

		System.out.println(returnString);
		return returnString;
	}
	
	static public String teeNine2(String s) {
		String r="";
		int n = s.length();
		char[] q = new char[n];
		Map<Integer,ArrayList<Character>> m = new HashMap<>();
		m.put(2, new ArrayList(Arrays.asList('a','b','c')));
		m.put(3, new ArrayList(Arrays.asList('d','e','f')));
		m.put(4, new ArrayList(Arrays.asList('g','h','i')));
		m.put(5, new ArrayList(Arrays.asList('j','k','l')));
		m.put(6, new ArrayList(Arrays.asList('m','n','o')));
		m.put(7, new ArrayList(Arrays.asList('p','q','r','s')));
		m.put(8, new ArrayList(Arrays.asList('t','u','v')));
		m.put(9, new ArrayList(Arrays.asList('w','x','y','z')));
		m.put(0, new ArrayList(Arrays.asList('y')));
		m.put(1, new ArrayList(Arrays.asList('z')));
		
		for (int i=0; i<s.length();i++) {
			if (Character.isLetter(s.charAt(i))) {
				q[i] = Character.forDigit(z.valueOf(String.valueOf(s.charAt(i)).toLowerCase()).A,10);
			} else if (Character.isDigit(s.charAt(i)))
				q[i] = m.get(Character.digit(s.charAt(i),10)).get(0);
			 else
				q[i] = s.charAt(i);
		}

		int x=1;
		for (int i=0; i<q.length; i++) {
			if (Character.isDigit(q[i])) {
				if (i == q.length-1 || q[i] != q[i+1]) {  // doesn't match next number
					List<Character> c = m.get(Character.digit(q[i],10));
					if (x > c.size())
						x = x % c.size();
						r = r + c.get(x-1);
						x=1;
				} else
					x++;
			} else if (Character.isLetter(q[i])) {
				if (q[i] == 'y')
					r = r + "0";
				else if (q[i] == 'z')
					r = r + "1";
				else
					r = r + z.valueOf(String.valueOf(q[i])).A;
				x=1;
			}
			else
				r = r + q[i];
		
		}

		System.out.println(r);
		return r;
	}
}