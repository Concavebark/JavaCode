package game;

public class Mainclass {
	public static void main(String[] args) {
		Player g = new Player("G", 100);
		

		g.addToInventory(1);
		System.out.println(g.getInventory());
		validIDs.printValidIDs();
	}
}
