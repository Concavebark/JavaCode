package gameBuilds;

public class Player extends Creature {
	private static int[] inventory = new int[15];
	public Player(String name, int health) {
		super(name, health);
	}
	
	public int getInventory() {
		for (int i = 0; i < inventory.length;) {
			return inventory[i];
		}
		return 0; // Return Value of 0 expresses empty inventory
	}
	
	public void addToInventory(int itemID) {
		if (inventory.length <= 15) {
			int endOfInv = inventory.length - 1;
			inventory[endOfInv] = itemID;
		} else if (inventory.length > 15) {
			System.out.println("Inventory Full!");
			//Drop statement would go here
		} else {
			System.out.println("I have no idea what happenend, how'd you get here");
		}
	}
}