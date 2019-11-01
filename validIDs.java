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
	
	public static Map<String, String> findableItems = new HashMap<String, String>() {
			private static final long serialVersionUID = 2L;
		{
			put("1", "Stick"); 
			put("2", "Stone");
			put("3", "Wood");
		}};
	
	// maybe build a class to deal with a recipe that is then stored in the Item
	
	public static Item iron = new Item("Iron", null);
	public static Item wood = new Item("Wood", null);
	public static Item stone = new Item("Stone", null);
	
	// Craftable items
	public static Item stick = new Item("Stick", new Item[] {wood, wood});
	public static Weapon wood_sword = new Weapon("Wood Sword", new Item[] {wood,wood,stick}, 3);
	public static Item wood_shield = new Item("Wood Shield", new Item[] {wood,wood,wood,iron});
	public static Weapon stone_sword = new Weapon("Stone Sword", new Item[] {stone, stone, stick}, 4);
	public static Item stone_shield = new Item("Stone Shield", new Item[] {stone,stone,stone,iron});
	
	public static void validateItems() {
		Item.itemReg(iron);
		Item.itemReg(wood);
		Item.itemReg(stone);
		Item.itemReg(stick);
		Item.itemReg(wood_sword);
		Item.itemReg(stone_sword);
		Item.itemReg(wood_shield);
		Item.itemReg(stone_shield);
	}
	
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
	
	public static String lookupFindableID(int ID) {
		String IDToStr = Integer.toString(ID);
		return findableItems.get(IDToStr);
	}
	
	public static int returnIDCount() {
		return idList.size();
	}
}