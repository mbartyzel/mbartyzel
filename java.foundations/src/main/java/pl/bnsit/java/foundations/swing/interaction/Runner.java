package pl.bnsit.java.foundations.swing.interaction;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		Window window = new Window();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
}
