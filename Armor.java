package game;

public class Armor extends Item {
	public Float protection_value;
	public String equipSlot; // Head, Chest, Leg, Feet
	
	//currentHp, each armor piece, damage being done 
	public Float calculateDamageReduction(Integer currentHp, Integer damage, Creature creature) {
		
		
		return 0.0f;
	}

	public Armor(String displayName, Item[] recipe, Float protection_value, String equipSlot) {
		super(displayName, recipe);
		this.protection_value = protection_value;
		this.equipSlot = equipSlot;
	}
}
