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
		inv.add(Item.stringToItem(itemName));
	}
	
	public List<Item> getInventory() {		
		return inv; // change to return display name of the items in the inventory
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