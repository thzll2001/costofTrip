package com.david.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {


		System.out.println("Please copy the test json file to path(default is:d:/interchanes.json)");

		String filepath ="";
		CostofTrip costOfTrip = new CostofTrip();
		Scanner sc = new Scanner(System.in);
		String input = "";
		Pattern pattern = Pattern.compile("(\".*\"),(\".*\")");
		System.out.print(">");
		while(sc.hasNext()) {
			//input  = sc.next("costofTrip(.*)");
			input = sc.nextLine();
			Matcher matcher = pattern.matcher(input);
			try {
				if (matcher.find()) {

					String startPointName = matcher.group(1).replace("\"", "");
					String endPointName = matcher.group(2).replace("\"", "");
					double distance = costOfTrip.caculateDistance(startPointName, endPointName);
					double cost = costOfTrip.caculateCost(startPointName, endPointName);
					System.out.println("distance: " + distance);
					System.out.println("cost:" + cost);
				}
			} catch (Exception e)
			{
				System.out.println(e.getStackTrace());
			}
			System.out.print(">");
		}

    }
}
