package com.app.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuTest {
	public static void main(String[] args) {

		Map<String, Double> coupouns = new LinkedHashMap<String, Double>(){{
			put("DISC", 100.0);
			put("MISC", 100.0);
		}
		};
		boolean exit = false;
		String selection = null;
		Double bill = 0.0;
		Double price = 0.0;
		Double discount = 0.0;
		
		int quantity = 0;
		Map<String, Double> selectedItems=  new LinkedHashMap<>();
		Map<String, Double> menu = new LinkedHashMap<String, Double>() {
			{
				put("DOSA", 100.0);
				put("UPMA", 120.0);
				put("POHE", 140.0);
				put("IDLI", 160.0);
				put("SAMOSA", 180.0);
			}

		};
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				System.out.println(
						"enter from the following options:  " + "1. select a dish" + "2. enter a coupoun " +"3. Show selected " +"4. Generate the bill");
				switch (sc.nextInt()) {

				case 1:
					System.out.println("enter the name of the dish: ");
					menu.forEach((k,v)->System.out.println(k+" - "+v));
					System.out.println("discount applied : "+ discount);
					selection = sc.next();
//					System.out.println("enter the quantity : ");
//					quantity = sc.nextInt();
					price = menu.get(selection);
					
					bill += price;
					System.out.println(bill+ " " + price);
					selectedItems.putIfAbsent(selection, price);
					break;
				case 2:
					System.out.println("enter the discount code");
					String code  = sc.next();
					if(coupouns.containsKey(code))
						discount = coupouns.get(code);
					break;
				case 3:
					selectedItems.forEach((k,v)->System.out.println(k+" - "+v));
					break;
					
				case 4:
					bill = bill -discount;
					selectedItems.forEach((k,v)->System.out.println(k+" - "+v));
					System.out.println("discount applied = "+discount);
					System.out.println("total = "+bill);
					System.out.println("thank you for coming here");
					exit = true;
					
					break;
					
					
				case 100:
					exit = true;
					break;

				default:
					break;

				}

			}
		}
	}

}
