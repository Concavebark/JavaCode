package game;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {
	public List<Item> inv = new ArrayList<>(); 
	/*
	*	Possibly develop method of keeping item stacks, 
	*	possibly with an Item class stored in an array. 
	*	do more research.
	*/
	
	public void setName(String newPlayerName) {
		this.name = newPlayerName;
	}
	
	public void storeInInv(String itemName) {
		inv.add(Item.stringToDisplay(itemName));
	}
	
	public void getInventory() {
		try {
			for (int i = 0; i < inv.size(); i++) {
				System.out.println(inv.get(i).displayName);
			}
		}
		catch (Exception NullPointerException) {
			System.out.println("Inventory Empty");
		}
	}
	
	public static Boolean isCraftable(String itemToCraft) {
		// ex itemToCraft: wood_sword
		//Item.stringToDisplay(itemToCraft);
		if (Item.stringToItem(itemToCraft) == null) {
			System.out.println("IT BROKE AHHHHHHH");
			return false;
		} else {
			System.out.println("Would Craft Now");
			return true;
		}
	}
	
	public int numInInv(String itemName) {
		int itemCount = 0;
		for (int i = 0; i < inv.size();) {
			if (inv.get(i).displayName.equals(itemName)) {
				itemCount = itemCount + 1;
			}
			i = i + 1;
		}
		return itemCount;
	}
	
	public String getSpecificInv(String indexStr) {
		try {
			int index = Integer.parseInt(indexStr);
			index = index - 1;
			return inv.get(index).displayName;
		}	
		catch (Exception IndexOutOfBounds) {
			return "There are no items in that slot.";
		}
	}
	
	public Player(String name, int health) {
		super(name, health);
	}
}