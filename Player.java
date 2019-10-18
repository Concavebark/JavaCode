package game;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {
	public List<String> inv = new ArrayList<>(); 
	/*
	*	Possibly develop method of keeping item stacks, 
	*	possibly with an Item class stored in an array. 
	*	do more research.
	*/
	
	public void setName(String newPlayerName) {
		this.name = newPlayerName;
	}
	
	public void storeInInv(String itemName) {
		inv.add(itemName);
	}
	
	public List<String> getInventory() {		
		return inv;
	}
	
	public int numInInv(String itemName) {
		int itemCount = 0;
		for (int i = 0; i < inv.size();) {
			if (inv.get(i).equals(itemName)) {
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
			return inv.get(index);
		}	
		catch (Exception IndexOutOfBounds) {
			return "There are no items in that slot.";
		}
	}
	
	public Player(String name, int health) {
		super(name, health);
	}
}