package pl.bnsit.java.foundations.swing.layoutmanager;

import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame {

	public Window() {
		super( "Password" );
		Container pane = getContentPane();
	}
}
