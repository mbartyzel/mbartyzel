package pl.bnsit.account.main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import pl.bnsit.account.details.DetailsForm;

import com.google.inject.Inject;

@SuppressWarnings( "serial" )
public class MainWindow extends JFrame {

	private JTabbedPane tabs;
	
	@Inject
	private DetailsForm detailsForm;
	
	@PostConstruct
	public void build() {
		
		setLayout(new GridLayout(1,3));
		tabs = new JTabbedPane();
		tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabs.add("Szczegó³y u¿ytkownika", detailsForm);
		add(tabs);
		
		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		centerJFrame();
	}
	
	private void centerJFrame() {
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		setResizable( false );
	}
}
