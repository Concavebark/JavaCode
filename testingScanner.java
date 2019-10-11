package something;

import java.util.Scanner;

public class testingScanner {
	public static void main(String[] args) {
		System.out.println(userInput());
	}
	
	public static String userInput() {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		s.close();
		return text;
	}
}
