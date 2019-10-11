package something;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class writeFile {
	public static void main(String[] ars) {
		try {
			PrintWriter writer = new PrintWriter("name.txt", "UTF-8");
			writer.println("Something or other");
			System.out.println("Line 1 written");
			writer.println("Someting else or other");
			System.out.println("Line 2 written");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
