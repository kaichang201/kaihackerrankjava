package org.kai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class CodeFightPetePickyLunchMenu {

	public static void main(String[] args) {
		CodeFightPetePickyLunchMenu me = new CodeFightPetePickyLunchMenu();
		
		long startTime = System.currentTimeMillis();
		String[][] testcase1 = {{"corn","rice"}, 
				{"rice","corn"}, 
				{"beans","okra"}, 
				{"beans","salad"}, 
				{"pasta","corn"}};

		String[][] testcase2 = {{"pad thai with bean sprouts", "flat noodles in spicy so good sauce"}, 
		        {"grilled eggplant panini", "broad bean stew"}, 
		        {"kidney beans"}, 
		        {"onions"}, 
		        {"seven bean dip", "cereal"}};
		
		String[][] testcase3 = {{"potatoes"}, {"potatoes"}, {"potatoes"}, {"potatoes"}, {"potatoes"}};
		
		String[][] testcase4 = {{"black bean and potato soup","jerk cauliflower","ital stew"}, 
				 {"rice","black bean and potato soup","plantains","coconut quinoa","black cake","cassava leaves","black eyed peas stew"}, 
				 {"plantains","rice","sweet potato pie","cassava leaves","caribbean callaloo","jerk cauliflower"}, 
				 {"plantains","ital stew"}, 
				 {"coconut quinoa","black cake","ital stew","black beans and rice"}};
		String[][] testcase5 = {{"black bean and potato soup","jerk cauliflower","ital stew", "ital stew"}, 
				 {"rice","black bean and potato soup","plantains","coconut quinoa","black cake","cassava leaves","black eyed peas stew"}, 
				 {"plantains","rice","sweet potato pie","cassava leaves","caribbean callaloo","jerk cauliflower"}, 
				 {"plantains","ital stew","ital stew"}, 
				 {"coconut quinoa","black cake","ital stew","black beans and rice"}};


		System.out.println(me.lunchMenu(testcase1));
		System.out.println(me.lunchMenu(testcase2));
		System.out.println(me.lunchMenu(testcase3));
		System.out.println(me.lunchMenu(testcase4));
		System.out.println(me.lunchMenu(testcase5));

		System.out.println("Time taken " + (System.currentTimeMillis() - startTime));
	}


	int lunchMenu(String[][] menu) {
		Set<MealPlan> combos = new HashSet<>();
		
		for (String m1: menu[0]) {  // for Monday, Pete can eat any meal
			String meal = m1.trim();
			MealPlan mp = new MealPlan();
			if (!"".equals(meal)) {
				mp.mealplan.add(meal);
				if (isBean(meal))
					mp.beanCount++;
				combos.add(mp);
			}
		}
		for (int i = 1; i< menu.length; i++) { // for Tuesday to Friday
			Set<MealPlan> newcombos = new HashSet<>();
			for (MealPlan mp : combos) { // for every meal plan so far this week
				for (String m1 : menu[i]) {  // for every item on the menu
					String meal = m1.trim();
					if (!"".equals(meal)) {
						if (!mp.mealplan.contains(meal)) {  // haven't eaten this meal
							if (isBean(meal)) { // meal contains beans
								if (mp.beanCount <2) { // still okay. can eat another bean meal
									MealPlan newMP = mp.clone();
									newMP.beanCount++;
									newMP.mealplan.add(meal);
									newcombos.add(newMP);
								} else {
									// else nothing.. already ate 2 bean meals.  continue.
								}
							} else { // meal does not contain beans
								MealPlan newMP = mp.clone();
								newMP.mealplan.add(meal);
								newcombos.add(newMP);
							}
						}
					}
				}
			}
			combos = newcombos; // replace yesterday's mealplan with new plans after today
		}

		// Print out combos
		for (MealPlan mp : combos) {
			for (String meal : mp.mealplan) {
				System.out.print(meal+",");
			}
			System.out.println();
		}

		return combos.size();
	}
	
	public boolean isBean(String inmeal) {
		String meal = inmeal.trim();
		if (meal == null ||  meal.indexOf("bean") < 0 )
			return false;

		if ("bean".equals(meal) || "beans".equals(meal)
				|| meal.endsWith(" bean")  || meal.endsWith(" beans")
				|| meal.startsWith("bean ")  || meal.startsWith("beans ")
				|| meal.indexOf(" bean ") >= 0  || meal.indexOf(" beans ") >= 0
				)
			return true;			
		return false;

	}
	
	class MealPlan implements Comparable {
		int beanCount;
		Set<String> mealplan;
		
		public MealPlan () {
			mealplan = new TreeSet<>();
		}
		
		@Override
		public MealPlan clone () {
			MealPlan rv = new MealPlan();
			rv.beanCount = this.beanCount;
			rv.mealplan = new TreeSet<>(this.mealplan);
			return rv;
		}
		// implement equals and hashCode so Set will automatically eliminate dups
		@Override
		public boolean equals (Object mp) {
			return mp.hashCode() == this.hashCode();
		}
		
		@Override
		public int hashCode() {
			int hash = 1;
			for (String s : mealplan)
				hash = hash * 13 + s.hashCode();
			return hash;
		}
		
		/*
		public int compareTo(Object obj) {
			String[] thisPlan = mealplan.toArray(new String[mealplan.size()]);
			MealPlan mp = (MealPlan) obj;
			String[] mpPlan = mp.mealplan.toArray(new String[mp.mealplan.size()]);
			
			for (int i = 0 ; i<thisPlan.length; i++) {
				if (i > mpPlan.length) // mpPlan is shorter, so this object is greater
					return 1;
				if (!thisPlan[i].equals(mpPlan[i]))  // found a mismatched meal
					return thisPlan[i].compareTo(mpPlan[i]);  // compare the two meals
			}
			return 0;
		} */
		
	}
	
	
}