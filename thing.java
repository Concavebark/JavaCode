package something;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class thing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		FlowLayout newLayout = new FlowLayout();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,250);
		frame.setLayout(newLayout);
		
		JTextField text = new JTextField(20);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem save = new JMenuItem("Save");
		save.setToolTipText("Save to file");
		save.setMnemonic(KeyEvent.VK_S);
		save.addActionListener((event) -> writeToFile(text.getText()));
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setToolTipText("Exit application");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener((event) -> System.exit(0));
		
		fileMenu.add(save);
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		
		
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(text.getText());
				writeToFile(text.getText());
				text.setText("");
			}
		}); 
		
		JLabel label = new JLabel("Do a thing");
		
		JButton button = new JButton("Submit");
		button.setMnemonic(KeyEvent.VK_S);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(text.getText());
				writeToFile(text.getText());
				text.setText("");
			}
		}); 
		frame.add(label);
		frame.add(text);
		frame.add(button);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	public static void writeToFile(String text) {
		try {
			PrintWriter writer = new PrintWriter("testingstuff.txt", "UTF-8");
			writer.println(text);
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