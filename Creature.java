package game;

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
	
	public List<Item> isWearing(Creature creature) {
		
		
		return null;
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