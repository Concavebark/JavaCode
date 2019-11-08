package game;

public class Weapon extends Item {
	public int atkInfluence;
	
	public static int calculateAtk(Creature creature, Weapon equippedWeapon) {
		int influencedAtk = creature.atk + equippedWeapon.atkInfluence;
		return influencedAtk;
	}
	
	public Weapon(String displayName, Item[] recipe, int atkInfluence) {
		super(displayName, recipe);
		this.atkInfluence = atkInfluence;
	}
}