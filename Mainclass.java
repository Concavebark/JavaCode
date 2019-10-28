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
			int validItemNum = validIDs.returnIDCount();
			int randItemID = randGen.nextInt(validItemNum) + 1;
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
		System.out.println("Entered crafting function");
		// 0 = adjective, 1 = noun
		String adjective = splitString[1];
		String item = splitString[2];
		if (adjective.equals("wood") || adjective.equals("wooden")) {
			//sword, shield
			if (item.equals("sword")) {
				// check if player has 2 wood and 1 stick
				if (player.numInInv("wood") >= 2 && player.numInInv("stick") >= 1) {
					System.out.println("MAKA SWOOORD");
				}
			} else if (item.equals("shield")) {
				// no clue
				System.out.println("You got here.");
			}
		}
	}
	

	public static void actionParse(String action) {
		String[] splitString = action.split(" ");
		switch(splitString[0]) {
			case "craft":
				if (player.getInventory() != null) {
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
				System.out.println(player.getInventory());
				break;
			case "pickup":
				player.storeInInv(itemOnFloor);
				itemOnFloor = null;
				break;
			case "wait":
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Error...");
		}
	}
}