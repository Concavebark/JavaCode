package game;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Enemy extends Creature {
	//public static List<Weapon> loot_table = new ArrayList<Weapon>();
	

	public Enemy(String name, int health, int atk, Armor Head, Armor Chest, Armor Leg, Armor Feet, Item ON_HAND, Item OFF_HAND) {
		super(name, health, atk, Head, Chest, Leg, Feet, ON_HAND, OFF_HAND);
		// TODO Auto-generated constructor stub
	}
}
