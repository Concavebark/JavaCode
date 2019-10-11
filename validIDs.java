package gameBuilds;

import java.util.HashMap;
import java.util.Map;

public class validIDs {
	public static Map<String, String> idList = new HashMap<String, String>() {{
		put("1", "Stick");
		put("2", "Stone");
	}};
	
	/*
	 * This file is just being used for an active list
	 * 1: Stick
	 * 2: Stone
	 */
	public validIDs() {
		//Doesn't do anything, class doesn't need to be constructed yet
	}
	
	public static void printValidIDs() {
		int listSize = idList.size();
		for (int i = 0; i <= listSize;i++) {
			String iToStr = Integer.toString(i);
			System.out.println(idList.get(iToStr));
		}
	}
}
