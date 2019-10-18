package game;

import java.util.HashMap;
import java.util.Map;

public class validIDs {
	public static Map<String, String> idList = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("1", "Stick"); 
		put("2", "Stone");
		put("3", "Wood");
		put("4", "Wood Sword");
		put("5", "Wood Shield");
		put("6", "Stone Sword");
		put("7", "Stone Shield");
	}};
	
	static String[] a = new String[] {"wood", "wood", "stick"}; 
	// maybe build a class to deal with a recipe that is then stored in the Item
	final static Item woodSword = new Item("wood sword", 4, a);
	
	public static Map<Integer, Item> itemList = new HashMap<Integer, Item>() {
		private static final long serialVersionUID = 2L;

	{
		put(4, woodSword);
	}};
	
	public static void printValidIDs() {
		int listSize = idList.size();
		for (int i = 0; i <= listSize;i++) {
			String iToStr = Integer.toString(i);
			System.out.println(idList.get(iToStr));
		}
	}
	
	public static String lookupID(int ID) {
		String IDToStr = Integer.toString(ID);
		return idList.get(IDToStr);
	}
	
	public static int returnIDCount() {
		return idList.size();
	}
}