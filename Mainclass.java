package game;

import java.util.Scanner;
import java.util.Random;

public class Mainclass {
	public static Player player = new Player("No Name", 100);
	public static Random randGen = new Random();
	public static String itemOnFloor;

	public static void main(String[] args) {
		System.out.println("Available commands: attack, help, check inventory, pickup, wait, exit");
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
	
	public static void actionParse(String action) {
		String[] splitString = action.split(" ");
		System.out.println(splitString[0]);
		switch(splitString[0]) {
			default:
				System.out.println("Yesn't");
		}
		switch(action) {
			case "attack":
				break;
			case "help":
				System.out.println("Available commands: attack, help, check inventory, pickup, wait, exit");
				break;
			case "check inventory":
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