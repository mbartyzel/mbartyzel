package pl.bnsit.java.foundations.swing.layoutmanager;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		Window window = new Window();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize( new Dimension(120, 80) );
		window.pack();
		window.setVisible(true);
	}
}
