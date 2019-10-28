package game;

import java.util.List;
import java.util.ArrayList;

public class Item {
	public Item[] recipe;
	public String displayName;
	public static List<Item> registeredItems = new ArrayList<>();

	// If recipe returns Null, there is no way to synthesize the item 
	
	public Item(String displayName, Item[] recipe) {
		this.recipe = recipe;
		this.displayName = displayName;
	}
	
	public static void itemReg(Item newItem) {
		registeredItems.add(newItem);
	}
	
	public static Item stringToItem(String checkName) {
		for (int i = 0; i < registeredItems.size(); i++) {
			registeredItems.get(i);
			if (registeredItems.get(i).displayName.equals(checkName)) {
				return registeredItems.get(i);
			}
		}
		return null;
	}
}