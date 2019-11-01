package game;

import java.util.List;
import java.util.ArrayList;

public class Item {
	public Item[] recipe;
	public String displayName;
	public static List<Item> registeredItems = new ArrayList<>();
	public static List<Item> craftableItems = new ArrayList<>();
	public static List<Item> weapons = new ArrayList<>();

	// If recipe returns Null, there is no way to synthesize the item 
	
	public Item(String displayName, Item[] recipe) {
		this.recipe = recipe;
		this.displayName = displayName;
	}
	
	public static void itemReg(Item newItem) {
		registeredItems.add(newItem);
		if (newItem.recipe != null) {
			craftableItems.add(newItem);
		}
	}
	
	public static Item stringToDisplay(String checkName) {
		for (int i = 0; i < registeredItems.size(); i++) {
			registeredItems.get(i);
			if (registeredItems.get(i).displayName.equals(checkName)) {
				return registeredItems.get(i);
			}
		}
		return null;
	}
	
	public static String displayNameToItemName(String item) {
		String[] splitString = item.split(" ");
		if (item != validIDs.stick.displayName) {
			String strItemName = splitString[0] + "_" + splitString[1];
			return strItemName.toLowerCase();
		} else if (item == validIDs.stick.displayName) {
			return validIDs.stick.displayName.toLowerCase();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	public static Item stringToItem(String checkName) {
		for (int i = 0; i < craftableItems.size(); i++) {
			Item currentItem = craftableItems.get(i);
			String registeredItem = displayNameToItemName(currentItem.displayName);
			if (checkName.equals(registeredItem)) {
				return currentItem;
			}			
		}
		return null;
	}
}