package game;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {
	public static List<Item> inv = new ArrayList<>(); 
	public Item inHand;
	/*
	*	Possibly develop method of keeping item stacks, 
	*	possibly with an Item class stored in an array. 
	*	do more research.
	*/
	
	public void equipInHand(Item itemToEquip) {
		if (itemToEquip instanceof Weapon) {
			Mainclass.player.inHand = itemToEquip;
			Mainclass.player.atk = Weapon.calculateAtk(Mainclass.player, (Weapon) itemToEquip);
			removeFromInv(itemToEquip);
		}
	}
	
	public void setName(String newPlayerName) {
		this.name = newPlayerName;
	}
	
	public void storeInInv(String itemName) {
		inv.add(Item.stringToDisplay(itemName));
	}
	
	public static void removeFromInv(Item itemName) {
		for (int i = 0; i < inv.size(); i++) {
			if (inv.get(i).equals(itemName)) {
				inv.remove(i);
			} 
		}
	}
	
	public void getInventory() {
		try {
			for (int i = 0; i < inv.size(); i++) {
				System.out.println(inv.get(i).displayName);
			}
		}
		catch (Exception NullPointerException) {
			
		}
	}
	
	public static Boolean isCraftable(String itemToCraft) {
		// ex itemToCraft: wood_sword
		if (Item.stringToItem(itemToCraft) == null) {
			System.out.println("That item is not craftable");
			return false;
		} else {
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
	
	public Player(String name, int health, int atk, Armor Head, Armor Chest, Armor Legs, Armor Feet, Item onHand, Item offHand) {
		super(name, health, atk, Head, Chest, Legs, Feet, onHand, offHand);
	}
}