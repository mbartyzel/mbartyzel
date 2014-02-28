package pl.bnsit.java.foundations.swing.interaction;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame {

	public Window() {
		super( "Chat-T" );
		Container pane = getContentPane();
		pane.add( buildCenterPanel(), BorderLayout.CENTER);
		pane.add( new JPanel(), BorderLayout.NORTH);
	}

	private JPanel buildCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(2,1) );
		panel.add( buildChatPannel() );
		panel.add( buildMessagePanel() );

		return panel;
	}

	private JPanel buildMessagePanel() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(1, 3) );
		panel.add( new JLabel( "Message:" ) );
		panel.add( new JTextField() );
		panel.add( new JButton( "Send" ) );
	
		return panel;
	}

	private JComponent buildChatPannel() {
		return new JScrollPane( new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	}
}
