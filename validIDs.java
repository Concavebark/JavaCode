package game;

import java.util.HashMap;
import java.util.Map;

public class validIDs {
	public static Map<String, String> idList = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("1", "Stick"); 
		put("2", "Stone");
	}};
	
	public static void printValidIDs() {
		int listSize = idList.size();
		for (int i = 0; i <= listSize;i++) {
			String iToStr = Integer.toString(i);
			System.out.println(idList.get(iToStr));
		}
	}
	
	public static String lookupID(int ID) {
		String IDToStr = Integer.toString(ID);
		return idList.get(IDToStr);
	}
	
	public static int returnIDCount() {
		return idList.size();
	}
}
