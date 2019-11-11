package game;

import java.util.ArrayList;
import java.util.List;

public class Creature {
	public String name;
	public int health;
	public int atk;
	public Armor HEAD_ARMOR;
	public Armor CHEST_ARMOR;
	public Armor LEG_ARMOR;
	public Armor FEET_ARMOR;
	public Item ON_HAND;
	public Item OFF_HAND;
	
	public List<Armor> isWearing(Creature creature) {
		List<Armor> wearing = new ArrayList<Armor>();
		wearing.add(HEAD_ARMOR);
		wearing.add(CHEST_ARMOR);
		wearing.add(LEG_ARMOR);
		wearing.add(FEET_ARMOR);
		
		return wearing;
	}
	
	public int getIntProtectValue(Creature creature) {
		int totalProtectValue = HEAD_ARMOR.protection_value + CHEST_ARMOR.protection_value + LEG_ARMOR.protection_value + FEET_ARMOR.protection_value;
		return totalProtectValue;
	}
	
	public Creature(String name, int health, int atk, Armor Head, Armor Chest, Armor Leg, Armor Feet, Item ON_HAND, Item OFF_HAND) {
		this.name = name;
		this.health = health;
		this.atk = atk;
		this.HEAD_ARMOR = Head;
		this.CHEST_ARMOR = Chest;
		this.LEG_ARMOR = Leg;
		this.FEET_ARMOR = Feet;
		this.ON_HAND = ON_HAND;
		this.OFF_HAND = OFF_HAND;
	}
}