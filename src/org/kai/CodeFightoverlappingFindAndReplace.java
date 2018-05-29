package org.kai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CodeFightoverlappingFindAndReplace {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			overlappingFindAndReplace1("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace1("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace1("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("1a")) {
			overlappingFindAndReplace1a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace1a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace1a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("2")) {
			overlappingFindAndReplace2("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace2("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace2("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("2a")) {
			overlappingFindAndReplace2a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace2a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace2a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("3")) {
			overlappingFindAndReplace3("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace3("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace3("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("3a")) {
			overlappingFindAndReplace3a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace3a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace3a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("4")) {
			overlappingFindAndReplace4("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace4("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace4("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace4("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("4a")) {
			overlappingFindAndReplace4a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace4a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace4a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("5")) {
			overlappingFindAndReplace5("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace5("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace5("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace5("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("5a")) {
			overlappingFindAndReplace5a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace5a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace5a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace5a("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("6")) {
			overlappingFindAndReplace6("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace6("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace6("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace6("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("6a")) {
			overlappingFindAndReplace6a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace6a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace6a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace6a("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("7")) {
			overlappingFindAndReplace7("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace7("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace7("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace7("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace7("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("7a")) {
			overlappingFindAndReplace7a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace7a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace7a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace7a("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace7a("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
		}  else if (args[0].equals("8")) {
			overlappingFindAndReplace8("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace8("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace8("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace8("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace8("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("8a")) {
			overlappingFindAndReplace8("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace8("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace8("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace8("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace8("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
		}  else if (args[0].equals("9a")) {
			overlappingFindAndReplace9a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace9a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace9a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace9a("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace9a("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("10a")) {
			overlappingFindAndReplace10a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace10a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace10a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace10a("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace10a("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace10a("abra abracadabra the hottest spot north of Havana.","abra","best"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace10a("abracadabraabraabracadabra the hottest spot north of Havana.","abracadabra","dbracadabr "); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("11a")) {
			overlappingFindAndReplace11a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace11a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace11a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace11a("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace11a("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace11a("abra abracadabra the hottest spot north of Havana.","abra","best"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace11a("abracadabraabraabracadabra the hottest spot north of Havana.","abracadabra","dbracadabr "); // "change nothing, it's perfect the way it is"
		} else if (args[0].equals("12a")) {
			overlappingFindAndReplace12a("abababababa","ababa","great"); // grgrgrgreat"
			overlappingFindAndReplace12a("just ordinary find and replace","just ","extra"); // "extraordinary find and replace"
			overlappingFindAndReplace12a("change nothing, it's perfect the way it is","",""); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace12a("eeeeeeeeeeeeee","ee","tt"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace12a("he restores stores. restorestores.","restores","destroys"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace12a("abra abracadabra the hottest spot north of Havana.","abra","best"); // "change nothing, it's perfect the way it is"
			overlappingFindAndReplace12a("abracadabraabraabracadabra the hottest spot north of Havana.","abracadabra","dbracadabr "); // "change nothing, it's perfect the way it is"
		}


		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	static String overlappingFindAndReplace1(String text, String pattern, String replacement) {  // time limit exceeded
		int k = 0;
		int y = text.length();
		int z = pattern.length();
		char[] c = new char[y];
		char[] a = replacement.toCharArray();

		for (int i=0; i< y; i++) {
			if (z>0 && i+z <= y  && text.substring(i, i+z).equals(pattern)) {
				//System.out.println("searching i "+ i + " y " + y + " z " + z + " substring " + text.substring(i, i+z) + " pattern " + pattern);
				for (int j = 0; j < a.length; j++) {
					c[i+j] = a[j];
				}
				k = z-1;
			} else if (k > 0)
				k--;				
			else 
				c[i]=text.charAt(i);
		}
		System.out.println(new String(c));
		return new String(a);
	}
	
	static String overlappingFindAndReplace1a(String t, String p, String r) {
		int k = 0;
		int y = t.length(), z = p.length();
		char[] c = new char[y], a = r.toCharArray();

		for (int i=0; i< y; i++) {
			if (z>0 && i+z <= y  && t.substring(i, i+z).equals(p)) {
				for (int j = 0; j < a.length; j++) {
					c[i+j] = a[j];
				}
				k = z-1;
			} else if (k > 0)
				k--;				
			else 
				c[i]=t.charAt(i);
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace2(String text, String pattern, String replacement) {  // still too long
		int k = 0;
		int y = text.length();
		int z = pattern.length();
		char[] c = text.toCharArray();

		for (int i=0; i< y; i++) {
			if (z>0 && i+z <= y  && text.substring(i, i+z).equals(pattern)) {
				System.out.println("searching i "+ i + " y " + y + " z " + z + " substring " + text.substring(i, i+z) + " pattern " + pattern);
				for (int j = 0; j < replacement.length(); j++) {
					c[i+j] = replacement.charAt(j);
				}
				k = z-1;
			} else if (k > 0)
				k--;				
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace2a(String t, String p, String r) {
		int k = 0;
		int y = t.length(), z = p.length();
		char[] c = t.toCharArray();

		for (int i=0; i< y; i++) {
			if (z>0 && i+z <= y  && t.substring(i, i+z).equals(p)) {
				for (int j = 0; j < r.length(); j++) {
					c[i+j] = r.charAt(j);
				}
				k = z-1;
			} else if (k > 0)
				k--;				
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace3(String text, String pattern, String replacement) {
		int y = text.length();
		int z = pattern.length();
		char[] c = text.toCharArray();

		if (z>0) {
			for (int i=0; i< y; i++) {
				int j = text.indexOf(pattern, i);
				if (j >=0) {
					System.out.println("found pattern " + pattern + " matching " + text.substring(j, j+z));
					for (int k = 0; k < replacement.length(); k++)
						c[j+k] = replacement.charAt(k);
					
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace3a(String t, String p, String r) {
		char[] c = t.toCharArray();

		if (p.length()>0)
			for (int i=0; i< t.length(); i++) {
				int j = t.indexOf(p, i);
				if (j >=0)
					for (int k = 0; k < r.length(); k++)
						c[j+k] = r.charAt(k);
			}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace4(String text, String pattern, String replacement) {
		char[] c = text.toCharArray(), a = replacement.toCharArray();
		int z = text.length();

		if (pattern.length()>0) {
			int s = pattern.indexOf(pattern.charAt(0),1)-1; // find where first character repeats
			s = s>0 ? s:0;
			for (int i=0; i<  z; i++) {
				int j = text.indexOf(pattern, i);
				if (j >=0) {
					System.out.println("found pattern " + pattern + " matching " + text.substring(j, j+pattern.length()) + " s " + s);
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					if (i+s < z) i+=s;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace4a(String t, String p, String r) {
		char[] c = t.toCharArray(), a = r.toCharArray();
		int z = t.length();

		if (p.length()>0) {
			int s = p.indexOf(p.charAt(0),1)-1; // find where first character repeats
			s = s>0 ? s:0;
			for (int i=0; i<  z; i++) {
				int j = t.indexOf(p, i);
				if (j >=0) {
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					if (i+s < z) i+=s;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}

	static String overlappingFindAndReplace5(String text, String pattern, String replacement) {
		char[] c = text.toCharArray(), a = replacement.toCharArray();
		int z = text.length(), y = pattern.length();

		if (pattern.length()>0) {
			int s = pattern.indexOf(pattern.charAt(0),1)-1; // find where first character repeats
			s = s>0 ? s:0;
			for (int i=0; i<=  z-y; i++) {
				int j = text.indexOf(pattern, i);
				if (j >=0) {
					System.out.println("found pattern " + pattern + " matching " + text.substring(j, j+pattern.length()) + " s " + s);
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					if (j+s < z) i = j+s;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace5a(String t, String p, String r) {
		char[] c = t.toCharArray(), a = r.toCharArray();
		int z = t.length(), y = p.length();

		if (y>0) {
			int s = p.indexOf(p.charAt(0),1)-1; // find where first character repeats
			s = s>0 ? s:0;
			for (int i=0; i<=  z-y; i++) {
				int j = t.indexOf(p, i);
				if (j >=0) {
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					if (j+s < z) i = j+s;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace6(String text, String pattern, String replacement) {
		char[] c = text.toCharArray(), a = replacement.toCharArray();
		int z = text.length(), y = pattern.length();

		if (pattern.length()>0) {
			int s = pattern.indexOf(pattern.charAt(0),1); // find where first character repeats
			s = s>0 ? s:1;
			for (int i=0; i<=  z-y; i+=s) {
				int j = text.indexOf(pattern, i);
				if (j >=0) {
					System.out.println("found pattern " + pattern + " matching " + text.substring(j, j+pattern.length()) + " s " + s);
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					i = j;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	static String overlappingFindAndReplace6a(String t, String p, String r) {
		char[] c = t.toCharArray(), a = r.toCharArray();
		int z = t.length(), y = p.length();

		if (p.length()>0) {
			int s = p.indexOf(p.charAt(0),1); // find where first character repeats
			s = s>0 ? s:1;
			for (int i=0; i<=  z-y; i+=s) {
				int j = t.indexOf(p, i);
				if (j >=0) {
					for (int k = 0; k < a.length; k++)
						c[j+k] = a[k];
					i = j;
				}
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace7(String text, String pattern, String replacement) {
		char[] c = text.toCharArray(), a = replacement.toCharArray();

		if (pattern.length()>0) {
			int s = pattern.indexOf(pattern.charAt(0),1); // find where first character repeats
			s = s>0 ? s:replacement.length();
			int i = 0;
			while ((i = text.indexOf(pattern,i)) >= 0) {
				System.out.println(" found pattern " + pattern + " matching " + text.substring(i, i+pattern.length()) + " s " + s);
				for (int k = 0; k < replacement.length(); k++)
					c[i+k] = replacement.charAt(k);
				i+=s;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace7a(String t, String p, String r) {
		char[] c = t.toCharArray();

		if (p.length()>0) {
			int s = p.indexOf(p.charAt(0),1); // find where first character repeats
			s = s>0 ? s:r.length();
			int i = 0;
			while ((i = t.indexOf(p,i)) >= 0) {
				for (int k = 0, l=r.length(); k < l; k++)
					c[i+k] = r.charAt(k);
				i+=s;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static int[] l;
	static String overlappingFindAndReplace8(String text, String pattern, String replacement) {
		char[] c = text.toCharArray();

		if (pattern.length()>0) {
			l = c(pattern);
			int s = pattern.indexOf(pattern.charAt(0),1); // find where first character repeats
			s = s>0 ? s:replacement.length();
			int i,j = 0;
			while ((i = s(pattern,text.substring(j))) >= 0) {  // KMP
				j+=i;
				System.out.println(" found pattern " + pattern + " matching " + text.substring(i, i+pattern.length()) + " s " + s + " i" + i + " j " + j);
				for (int k = 0; k < replacement.length(); k++)
					c[j+k] = replacement.charAt(k);
				j+=s;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace8a(String t, String p, String r) {
		char[] c = t.toCharArray();

		if (p.length()>0) {
			l = c(p);
			int s = p.indexOf(p.charAt(0),1); // find where first character repeats
			s = s>0 ? s:r.length();
			int i,j = 0;
			while ((i = s(p,t.substring(j))) >= 0) {  // KMP
				j+=i;
				for (int k = 0; k < r.length(); k++)
					c[j+k] = r.charAt(k);
				j+=s;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static int s(String p, String t) {
		int[] l = c(p);
	    int j = 0;  
	    for (int i = 0; i < t.length(); i++) {
	        while (j > 0 && t.charAt(i) != p.charAt(j)) {
	            j = l[j - 1];
	        }
	        if (t.charAt(i) == p.charAt(j)) {
	            j++;
	            if (j == p.length())
	                return i - (j - 1);
	        }
	    }
	    return -1;  
	}
	
	static int[] c(String p) {
		int[] l = new int[p.length()];
	    l[0] = 0; 
	    for (int i = 1; i < p.length(); i++) {
	        int j = l[i - 1];
	        while (j > 0 && p.charAt(i) != p.charAt(j))
	            j = l[j - 1];
	        if (p.charAt(i) == p.charAt(j))
	            j++;
	        l[i] = j;
	    }
	    return l;
	}
	
	static String overlappingFindAndReplace9a(String t, String p, String r) {
		char[] c = t.toCharArray();

		if (p.length()>0) {
			int s = p.indexOf(p.charAt(0),1); // find where first character repeats
			s = s>0 ? s:r.length();
			int i,j = 0;
			while ((i = s(p,t.substring(j))) >= 0) {  // KMP
				j+=i;
				for (int k = 0; k < r.length(); k++)
					c[j+k] = r.charAt(k);
				j++;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace10a(String t, String p, String r) {
		char[] c = t.toCharArray();
		Pattern e = Pattern.compile(p);
		Matcher m = e.matcher(t);
		
		if (r.length() >0) {
			int i = 0;
			while (m.find(i)) {
				i = m.start();
				System.out.println ("i " + i);
				for (int k =0; k<r.length(); k++)
						c[i+k] = r.charAt(k);
				i++;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace11a(String t, String p, String r) {
		char[] c = t.toCharArray();
		Pattern e = Pattern.compile(p);
		Matcher m = e.matcher(t);
		
		if (r.length() >0) {
			int s = p.indexOf(p.charAt(0),1); // find where first character repeats
			s = s>0 ? s:r.length();
			int i = 0;
			while (m.find(i)) {
				i = m.start();
				for (int k =0; k<r.length(); k++)
						c[i+k] = r.charAt(k);
				i+=s;
			}
		}
		System.out.println(new String(c));
		return new String(c);
	}
	
	static String overlappingFindAndReplace12a(String t, String p, String r) {
		char[] c = t.toCharArray();
		Pattern e = Pattern.compile(p);
		Matcher m = e.matcher(t);
		StringBuffer s = new StringBuffer();
		
		if (r.length() >0) {
			int u = p.indexOf(p.charAt(0),1); // find where first character repeats
			u = u>0 ? u:r.length();
			int i = 0;
			m.replaceAll(r);
			 m.appendTail(s);
		}
		System.out.println(s.toString());
		return new String(c);
	}
	
	

	

}