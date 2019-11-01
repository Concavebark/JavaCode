package game;

import java.util.Scanner;
import java.util.Random;

public class Mainclass {
	public static Player player = new Player("No Name", 100, 1);
	public static Random randGen = new Random();
	public static String itemOnFloor;

	public static void main(String[] args) {
		System.out.println("Available commands: attack, help, check inventory, equip, pickup, wait, exit");
		validIDs.validateItems();
		gameLoop();
	}
	
	public static String peekInv() {
		@SuppressWarnings("resource")
		Scanner userIn = new Scanner(System.in);
		System.out.print("Inv Slot: ");
		String choice = userIn.nextLine();
		return player.getSpecificInv(choice);
	}
	
	public static void chanceCalc() {
		int chance = randGen.nextInt(10);
		if (chance >= 7) {
			int randItemID = randGen.nextInt(validIDs.findableItems.size());
			itemOnFloor = validIDs.lookupID(randItemID);
		} else {
			return;
		}
	}
	
	public static void gameLoop() {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		chanceCalc();
		if (itemOnFloor == null) {
			System.out.print(">>> ");
		} else {
			System.out.println("There is a " + itemOnFloor + " on the floor.");
			System.out.print(">>> ");
		}
		String act = userInput.nextLine();
		actionParse(act);
		gameLoop();
	}
	
	public static void crafting(String[] splitString) {
		try  {
			String strItem = splitString[1].toLowerCase() + "_" + splitString[2].toLowerCase();
			if (Player.isCraftable(strItem)) {
				Item item = Item.stringToItem(strItem);
				Item[] currentRecipe = item.recipe;
				try {
					for (int i = 0; i < currentRecipe.length; i++) {
						Player.removeFromInv(currentRecipe[i]);
					}
					Player.inv.add(item);
				} catch (Exception e) {
					System.out.println(e);
				}
			}			
		} catch (Exception ArrayIndexOutOfBoundsException) {
			String strItem = splitString[1].toLowerCase();
			Player.isCraftable(strItem);
		}
	}

	public static void actionParse(String action) {
		action = action.toLowerCase();
		String[] splitString = action.split(" ");
		switch(splitString[0]) {
			case "craft":
				try {
					if (Player.inv != null) {
						crafting(splitString);
					} else {
						System.out.println("Your Inventory is Empty!");
					}
				} catch (Exception ArrayIndexOutOfBounds) {
					System.out.println("Type out the name of what you want to craft.");
				}
				break;
			case "equip":
				try {
					String sanitize = Item.displayNameToItemName(splitString[1] + " " + splitString[2]);
					Item itemToEquip = Item.stringToItem(sanitize);
					player.equipInHand(itemToEquip);
				} catch (Exception ArrayIndexOutOfBoundsException) {
					System.out.println("Type out the name of what you want to craft.");
				}
				break;
			case "attack":
				System.out.println(player.atk);
				break;
			case "help":
				System.out.println("Available commands: attack, help, check inventory, equip, pickup, wait, exit");
				break;
			case "check":
				player.getInventory();
				break;
			case "pickup":
				if (itemOnFloor != null) {
					player.storeInInv(itemOnFloor);
					itemOnFloor = null;
				} else {
					System.out.println("There's nothing there...");
					itemOnFloor = null;
				}
				break;
			case "wait":
				break;
			case "w":
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Error...");
		}
	}
}