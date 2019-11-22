package game;

import java.util.List;
import java.util.ArrayList;

public class Armor extends Item {
	public static List<Armor> armorList = new ArrayList<>();
	public int protection_value;
	public String equipSlot; // Head, Chest, Leg, Feet
	
	public static void armorReg(Armor armorToReg) {
		armorList.add(armorToReg);
	}
	
	//currentHp, each armor piece, damage being done 
	public int calculateDamageReduction(Creature attacker, Integer damage, Creature defender) {
		Item attackersWeapon = attacker.ON_HAND;
		int totalDamage = damage + Weapon.calculateAtk(attacker, (Weapon) attackersWeapon);
		int defendersProtectValue = defender.getIntProtectValue(defender);
		int actualDamage = defendersProtectValue - totalDamage;
		return actualDamage;
	}

	public Armor(String displayName, Item[] recipe, int protection_value, String equipSlot) {
		super(displayName, recipe);
		this.protection_value = protection_value;
		this.equipSlot = equipSlot;
	}
}