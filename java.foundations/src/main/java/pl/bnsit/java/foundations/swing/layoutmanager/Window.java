package pl.bnsit.java.foundations.swing.layoutmanager;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame {

	public Window() {
		super( "Password" );
		Container pane = getContentPane();
		JButton button = new JButton();
		
		button.setToolTipText( "Text tooltio" );
		button.addMouseMotionListener( new ButtonMouseListener(button) );
		pane.add(button);
	}
	
	private class ButtonMouseListener implements MouseMotionListener {

		private JButton button;
		
		public ButtonMouseListener(JButton button) {
			this.button = button;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			button.setToolTipText( "x = " + x + ", y = " + y );
		}
	}
}
