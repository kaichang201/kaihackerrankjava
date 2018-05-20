package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class CodeFightpredictiveText {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (args[0].equals("1")) {
			predictiveText1("some very repetitive text, very very repetitive text", "very", 10 );
			predictiveText1("can't always take kai-lan with you, whereever you. may go!", "always", 15 );
			predictiveText1("The last question was asked for the first time, half in jest, on May 21, 2061, at a time when humanity first stepped into the light. The question came about as a result of a five dollar bet over highballs, and it happened this way: Alexander Adell and Bertram Lupov were two of the faithful attendants of Multivac. As well as any human beings could, they knew what lay behind the cold, clicking, flashing face -- miles and miles of face -- of that giant computer. They had at least a vague notion of the general plan of relays and circuits that had long since grown past the point where any single human could possibly have a firm grasp of the whole.  Multivac was self-adjusting and self-correcting. It had to be, for nothing human could adjust and correct it quickly enough or even adequately enough -- so Adell and Lupov attended the monstrous giant only lightly and superficially, yet as well as any men could. They fed it data, adjusted questions to its needs and translated the answers that were issued. Certainly they, and all others like them, were fully entitled to share In the glory that was Multivac's.  For decades, Multivac had helped design the ships and plot the trajectories that enabled man to reach the Moon, Mars, and Venus, but past that, Earth's poor resources could not support the ships. Too much energy was needed for the long trips. Earth exploited its coal and uranium with increasing efficiency, but there was only so much of both.  But slowly Multivac learned enough to answer deeper questions more fundamentally, and on May 14, 2061, what had been theory, became fact.  The energy of the sun was stored, converted, and utilized directly on a planet-wide scale. All Earth turned off its burning coal, its fissioning uranium, and flipped the switch that connected all of it to a small station, one mile in diameter, circling the Earth at half the distance of the Moon. All Earth ran by invisible beams of sunpower.  Seven days had not sufficed to dim the glory of it and Adell and Lupov finally managed to escape from the public function, and to meet in quiet where no one would think of looking for them, in the deserted underground chambers, where portions of the mighty buried body of Multivac showed. Unattended, idling, sorting data with contented lazy clickings, Multivac, too, had earned its vacation and the boys appreciated that. They had no intention, originally, of disturbing it.  They had brought a bottle with them, and their only concern at the moment was to relax in the company of each other and the bottle.  'It's amazing when you think of it,' said Adell. His broad face had lines of weariness in it, and he stirred his drink slowly with a glass rod, watching the cubes of ice slur clumsily about. 'All the energy we can possibly ever use for free. Enough energy, if we wanted to draw on it, to melt all Earth into a big drop of impure liquid iron, and still never miss the energy so used. All the energy we could ever use, forever and forever and forever.'  Lupov cocked his head sideways. He had a trick of doing that when he wanted to be contrary, and he wanted to be contrary now, partly because he had had to carry the ice and glassware. 'Not forever,' he said.  'Oh, hell, just about forever. Till the sun runs down, Bert.'  'That's not forever.'  'All right, then. Billions and billions of years. Twenty billion, maybe. Are you satisfied?'  Lupov put his fingers through his thinning hair as though to reassure himself that some was still left and sipped gently at his own drink. 'Twenty billion years isn't forever.'  'Will, it will last our time, won't it?'  'So would the coal and uranium.'  'All right, but now we can hook up each individual spaceship to the Solar Station, and it can go to Pluto and back a million times without ever worrying about fuel. You can't do THAT on coal and uranium. Ask Multivac, if you don't believe me.'  'I don't have to ask Multivac. I know that.'  'Then stop running down what Multivac's done for us,' said Adell, blazing up. 'It did all right.'  'Who says it didn't? What I say is that a sun won't last forever. That's all I'm saying. We're safe for twenty billion years, but then what?' Lupov pointed a slightly shaky finger at the other. 'And don't say we'll switch to another sun.'  There was silence for a while. Adell put his glass to his lips only occasionally, and Lupov's eyes slowly closed. They rested.  Then Lupov's eyes snapped open. 'You're thinking we'll switch to another sun when ours is done, aren't you?'  'I'm not thinking.'  'Sure you are. You're weak on logic, that's the trouble with you. You're like the guy in the story who was caught in a sudden shower and Who ran to a grove of trees and got under one. He wasn't worried, you see, because he figured when one tree got wet through, he would just get under another one.'  'I get it,' said Adell. 'Don't shout. When the sun is done, the other stars will be gone, too.'  'Darn right they will,' muttered Lupov. 'It all had a beginning "
					, "don't", 40 );
		} else {
			predictiveText2("some very repetitive text, very very repetitive text", "very", 10 );
			predictiveText2("can't always take kai-lan with you, whereever you. may go!", "always", 15 );
			predictiveText2("The last question was asked for the first time, half in jest, on May 21, 2061, at a time when humanity first stepped into the light. The question came about as a result of a five dollar bet over highballs, and it happened this way: Alexander Adell and Bertram Lupov were two of the faithful attendants of Multivac. As well as any human beings could, they knew what lay behind the cold, clicking, flashing face -- miles and miles of face -- of that giant computer. They had at least a vague notion of the general plan of relays and circuits that had long since grown past the point where any single human could possibly have a firm grasp of the whole.  Multivac was self-adjusting and self-correcting. It had to be, for nothing human could adjust and correct it quickly enough or even adequately enough -- so Adell and Lupov attended the monstrous giant only lightly and superficially, yet as well as any men could. They fed it data, adjusted questions to its needs and translated the answers that were issued. Certainly they, and all others like them, were fully entitled to share In the glory that was Multivac's.  For decades, Multivac had helped design the ships and plot the trajectories that enabled man to reach the Moon, Mars, and Venus, but past that, Earth's poor resources could not support the ships. Too much energy was needed for the long trips. Earth exploited its coal and uranium with increasing efficiency, but there was only so much of both.  But slowly Multivac learned enough to answer deeper questions more fundamentally, and on May 14, 2061, what had been theory, became fact.  The energy of the sun was stored, converted, and utilized directly on a planet-wide scale. All Earth turned off its burning coal, its fissioning uranium, and flipped the switch that connected all of it to a small station, one mile in diameter, circling the Earth at half the distance of the Moon. All Earth ran by invisible beams of sunpower.  Seven days had not sufficed to dim the glory of it and Adell and Lupov finally managed to escape from the public function, and to meet in quiet where no one would think of looking for them, in the deserted underground chambers, where portions of the mighty buried body of Multivac showed. Unattended, idling, sorting data with contented lazy clickings, Multivac, too, had earned its vacation and the boys appreciated that. They had no intention, originally, of disturbing it.  They had brought a bottle with them, and their only concern at the moment was to relax in the company of each other and the bottle.  'It's amazing when you think of it,' said Adell. His broad face had lines of weariness in it, and he stirred his drink slowly with a glass rod, watching the cubes of ice slur clumsily about. 'All the energy we can possibly ever use for free. Enough energy, if we wanted to draw on it, to melt all Earth into a big drop of impure liquid iron, and still never miss the energy so used. All the energy we could ever use, forever and forever and forever.'  Lupov cocked his head sideways. He had a trick of doing that when he wanted to be contrary, and he wanted to be contrary now, partly because he had had to carry the ice and glassware. 'Not forever,' he said.  'Oh, hell, just about forever. Till the sun runs down, Bert.'  'That's not forever.'  'All right, then. Billions and billions of years. Twenty billion, maybe. Are you satisfied?'  Lupov put his fingers through his thinning hair as though to reassure himself that some was still left and sipped gently at his own drink. 'Twenty billion years isn't forever.'  'Will, it will last our time, won't it?'  'So would the coal and uranium.'  'All right, but now we can hook up each individual spaceship to the Solar Station, and it can go to Pluto and back a million times without ever worrying about fuel. You can't do THAT on coal and uranium. Ask Multivac, if you don't believe me.'  'I don't have to ask Multivac. I know that.'  'Then stop running down what Multivac's done for us,' said Adell, blazing up. 'It did all right.'  'Who says it didn't? What I say is that a sun won't last forever. That's all I'm saying. We're safe for twenty billion years, but then what?' Lupov pointed a slightly shaky finger at the other. 'And don't say we'll switch to another sun.'  There was silence for a while. Adell put his glass to his lips only occasionally, and Lupov's eyes slowly closed. They rested.  Then Lupov's eyes snapped open. 'You're thinking we'll switch to another sun when ours is done, aren't you?'  'I'm not thinking.'  'Sure you are. You're weak on logic, that's the trouble with you. You're like the guy in the story who was caught in a sudden shower and Who ran to a grove of trees and got under one. He wasn't worried, you see, because he figured when one tree got wet through, he would just get under another one.'  'I get it,' said Adell. 'Don't shout. When the sun is done, the other stars will be gone, too.'  'Darn right they will,' muttered Lupov. 'It all had a beginning "
					, "don't", 40 );
		}

		
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}

	static public String[] predictiveText1(String trainingText, String firstWord, int howManyWords) {
		String[] r = new String[howManyWords];
		String[] tt =  trainingText.replace("' ","").replace(" '", "").split("[()\\.,\\s!;?:\"]+");
		Map<String, Integer> wordCount = new LinkedHashMap<>();
		Map<String, HashMap<String,Integer>> wordCount2 = new HashMap<>();
		String favoriteWord = "";
		Map<String,String> ff  = new HashMap<>();

		wordCount.put(tt[0], 1);
		wordCount2.put(tt[0], new HashMap<>());
		for (int i = 1; i< tt.length; i++) {
			//System.out.println(word);
			if (wordCount.containsKey(tt[i])) {
				wordCount.put(tt[i], wordCount.get(tt[i])+1);
			} else {
				wordCount.put(tt[i], 1);
			}
			if (wordCount2.containsKey(tt[i-1])) {
				if (wordCount2.get(tt[i-1]).containsKey(tt[i])) {
					wordCount2.get(tt[i-1]).put(tt[i],wordCount2.get(tt[i-1]).get(tt[i])+1);
				} else {
					wordCount2.get(tt[i-1]).put(tt[i],1);
				}
			} else {
				wordCount2.put(tt[i-1], new LinkedHashMap<>());
				wordCount2.get(tt[i-1]).put(tt[i], 1);
			}
		}
		int mc = 0;
		for (String word: wordCount.keySet()) {
			if (wordCount.get(word) > mc) {
				mc = wordCount.get(word);
				favoriteWord = word;
				//System.out.println(word + " " + wordCount.get(word));
			}
		}
		
		for (String word: wordCount2.keySet()) {
			mc = 0;
			for (String word2: wordCount2.get(word).keySet()) {
				if (wordCount2.get(word).get(word2) > mc ) {
					mc = wordCount2.get(word).get(word2);
					ff.put(word, word2);
					//System.out.println("word1 " + word 
					//		+ " word2 " + word2 
					//		+ " times " + wordCount2.get(word).get(word2));
				}
			}
		}
		//System.out.println("fw " + favoriteWord );
		
		//for (String word : ff.keySet()) {
		//	System.out.println("favorites " + word +" " + ff.get(word));
		//}
		r[0] = firstWord;
		for (int i = 1; i < howManyWords; i++) {
			if (ff.containsKey(r[i-1])) 
				r[i] = ff.get(r[i-1]);
			else
				r[i] = favoriteWord;
			System.out.println(r[i]);
		}
		
		return r;
	}
	
	static public String[] predictiveText2(String t, String f, int h) {
		String[] r = new String[h];
		String[] s =  t.replace("' ","").replace(" '", "").replace("- ","").replace(" -", "").split("[^A-Za-z0-9'-]+");
		Map<String, Integer> c = new LinkedHashMap<>();
		Map<String, HashMap<String,Integer>> d = new HashMap<>();
		String g = "";
		Map<String,String> a  = new HashMap<>();

		c.put(s[0], 1);
		d.put(s[0], new HashMap<>());
		for (int i = 1; i< s.length; i++) {
			if (c.containsKey(s[i]))
				c.put(s[i], c.get(s[i])+1);
			else
				c.put(s[i], 1);
			
			if (d.containsKey(s[i-1])) {
				if (d.get(s[i-1]).containsKey(s[i])) 
					d.get(s[i-1]).put(s[i],d.get(s[i-1]).get(s[i])+1);
				else
					d.get(s[i-1]).put(s[i],1);
			} else {
				d.put(s[i-1], new LinkedHashMap<>());
				d.get(s[i-1]).put(s[i], 1);
			}
		}
		int j = 0;
		for (String w: c.keySet()) {
			if (c.get(w) > j) {
				j = c.get(w);
				g = w;
			}
		}
		
		for (String w: d.keySet()) {
			j = 0;
			for (String x: d.get(w).keySet()) {
				if (d.get(w).get(x) > j ) {
					j = d.get(w).get(x);
					a.put(w, x);
				}
			}
		}

		r[0] = f;
		for (int i = 1; i < h; i++) {
			if (a.containsKey(r[i-1])) 
				r[i] = a.get(r[i-1]);
			else
				r[i] = g;
			System.out.println(r[i]);
		}
		
		return r;
	}

	
	
}
