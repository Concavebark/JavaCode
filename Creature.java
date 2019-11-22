package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creature {
	private static Random randWeight = new Random();
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
	
	public static Creature generateRandomCreature() {
		int wearingArmor = randWeight.nextInt(2);
		int somethingInOnHand = randWeight.nextInt(2);
		int somethingInOffHand = randWeight.nextInt(2);
		int baseHealth = 10;
		int baseAtk = 2;
		Creature randomCreature = new Creature("Goblin", baseHealth, baseAtk, null, null, null, null, null, null);
		if (wearingArmor == 1) {
			randomCreature.HEAD_ARMOR = validIDs.iron_helm;
			randomCreature.CHEST_ARMOR = validIDs.iron_chest;
			randomCreature.LEG_ARMOR = validIDs.iron_leg;
			randomCreature.FEET_ARMOR = validIDs.iron_boots;
		} 
		if (somethingInOnHand == 1) {
			int weaponListSize = Weapon.weaponList.size();
			//int randomWeapon = randWeight.nextInt(weaponListSize + 1);
			Weapon randomWeapon = Weapon.weaponList.get(randWeight.nextInt(weaponListSize + 1));
			randomCreature.ON_HAND = randomWeapon;
			randomCreature.atk = baseAtk + randomWeapon.atkInfluence;
		}
		if (somethingInOffHand == 1) {
			int shieldListSize = Shield.shieldList.size();
			int randomShield = randWeight.nextInt(shieldListSize + 1);
			randomCreature.OFF_HAND = Shield.shieldList.get(randomShield);
		}
		return randomCreature;
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