package game;

import java.util.Scanner;
import java.util.Random;

public class Mainclass {
	public static Player player = new Player("No Name", 100);
	public static Random randGen = new Random();
	public static String itemOnFloor;

	public static void main(String[] args) {
		System.out.println("Available commands: attack, help, check inventory, pickup, wait, exit");
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
			// Select random item to put on ground
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
		//System.out.println("Entered crafting function");
		// 0 = adjective, 1 = noun
		String strItem = splitString[1].toLowerCase() + "_" + splitString[2].toLowerCase();
		//String adjective = splitString[1];
		//String item = splitString[2];
		Player.isCraftable(strItem);
	}

	public static void actionParse(String action) {
		action = action.toLowerCase();
		String[] splitString = action.split(" ");
		switch(splitString[0]) {
			case "craft":
				if (player.inv != null) {
					crafting(splitString);
				} else {
					System.out.println("Your Inventory is Empty!");
				}
				break;
			case "attack":
				break;
			case "help":
				System.out.println("Available commands: attack, help, check inventory, pickup, wait, exit");
				break;
			case "check":
				player.getInventory();
				break;
			case "pickup":
				player.storeInInv(itemOnFloor);
				itemOnFloor = null;
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