package main;

import javax.swing.JFrame;

public class GameWindow {

	public GameWindow(Menu menu,JFrame frame) {
		
		frame = new JFrame("GREEN GECKO");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(menu);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);			
	}

	
}
