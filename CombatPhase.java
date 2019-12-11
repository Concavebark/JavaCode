package game;

import java.util.Scanner;

public class CombatPhase {	
	private static Creature creatureRef;
	private static Player playerRef;
	
	@SuppressWarnings("resource")
	public static void phaseLoop(Creature combatCreature, Player currentPlayer) {
		creatureRef = combatCreature;
		playerRef = currentPlayer;
		
		if (creatureRef.health <= 0) {
			System.out.println("The " + creatureRef.name + " has fallen!");
			
		}
			
		System.out.println("Creature HP: " + combatCreature.health + " Your HP: " + currentPlayer.health);
		System.out.print(">>> ");
		Scanner input = new Scanner(System.in);
		inputCheck(input.nextLine());
	}
	public static boolean inputCheck(String input) {
		switch(input) {
			case "attack":
				playerAttack();
				break;
			case "run":
				//random number gen to depict if you get away
				break;
		}
		
		return false;
	}
	public static void playerAttack() {
		int playerAtkVal = playerRef.atk;
		int creatureHP = creatureRef.health;
		creatureRef.health = creatureHP - playerAtkVal;
		System.out.println("You attack the creature, dealing: " + playerAtkVal + " damage.");
		phaseLoop(creatureRef, playerRef);
	}
}