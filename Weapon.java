package game;

import java.util.List;
import java.util.ArrayList;

public class Weapon extends Item {
	public static List<Weapon> weaponList = new ArrayList<>();
	public int atkInfluence;
	
	public static void weaponReg(Weapon weaponToRegister) {
		weaponList.add(weaponToRegister);
		Item.itemReg(weaponToRegister);
	}
	
	public static int calculateAtk(Creature creature, Weapon equippedWeapon) {
		int influencedAtk = creature.atk + equippedWeapon.atkInfluence;
		return influencedAtk;
	}
	
	public Weapon(String displayName, Item[] recipe, int atkInfluence) {
		super(displayName, recipe);
		this.atkInfluence = atkInfluence;
	}
}