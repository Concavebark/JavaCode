package game;

import java.util.List;
import java.util.ArrayList;

public class Shield extends Item {
	public static List<Shield> shieldList = new ArrayList<>();
	
	public static void shieldReg(Shield newShield) {
		shieldList.add(newShield);
		Item.itemReg(newShield);
	}
	
	public Shield(String displayName, Item[] recipe) {
		super(displayName, recipe);
	}
}