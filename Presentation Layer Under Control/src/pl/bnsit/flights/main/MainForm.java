package pl.bnsit.flights.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.bnsit.flights.ObjectContainer;

public class MainForm extends JFrame implements MainView {

	public static final String MAIN_ADD_CUSTOMER_BTN = "main.addCustomerBtn";

	public static final String MAIN_TERMINATE_BTN = "main.terminateBtn";
	
	public void init() {
		setTitle( "System biletów lotniczych" );
		add( new JPanel(), BorderLayout.NORTH );
		add( buildCenterPanel(), BorderLayout.CENTER );
		add( new JPanel(), BorderLayout.EAST );
		add( new JPanel(), BorderLayout.WEST );
		pack();

		centerJFrame();
	}

	private JPanel buildCenterPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(7, 1));
		panel.add( new JButton( "Wyszukaj lot" ) );
		panel.add( new JButton( "Wyszukaj klienta" ) );
		
		JButton dodajKlientaButton = ObjectContainer
			.getInstance()
			.createMainFormButton( "Dodaj klienta", MainForm.MAIN_ADD_CUSTOMER_BTN );
		panel.add( dodajKlientaButton );
		
		panel.add( new JPanel() );
		panel. add( ObjectContainer.getInstance().createMainFormButton( "Zakoñcz", MainForm.MAIN_TERMINATE_BTN ) );
		panel.add( new JPanel() );
		
		return panel;
	}
	
	private void centerJFrame() {
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		setResizable( false );
	}

	@Override
	public void hideView() {
		setVisible(false);
	}

	@Override
	public void showView() {
		setVisible(true);
	}
}
