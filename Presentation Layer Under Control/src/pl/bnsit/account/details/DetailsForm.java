package pl.bnsit.account.details;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.bnsit.flights.ValueSetter;

import com.google.inject.Inject;

@SuppressWarnings( "serial" )
public class DetailsForm extends JPanel implements DetailsView {

	@Inject
	private DetailsViewObserver viewObserver;
	
	private Map<String, JComponent> activeControls = new HashMap<String, JComponent>();
	
	@PostConstruct
	public void buildForm() {
		add(new JPanel(), BorderLayout.NORTH);
		add(buildCenterPanel(), BorderLayout.CENTER);
		add(new JPanel(), BorderLayout.EAST);
		add(new JPanel(), BorderLayout.WEST);
		
		viewObserver.viewIsReady();
	}
	
	private JPanel buildCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout( 3, 2 ));
		
		panel.add( new JLabel( "Login" ) );
		panel.add( asActive( "login", new JTextField() ) );

		panel.add( new JLabel( "Email" ) );
		panel.add( asActive( "email", new JTextField() ) );
		
		panel.add( new JButton("Zapisz") );
		
		return panel;
	}

	@Override
	public void updateControl(String id, Object value) {
		JComponent component = activeControls.get(id);
		ValueSetter valueSetter = ValueSetter.get( component.getClass() );
		valueSetter.set(component, value);
	}
	
	private <T extends JComponent> T asActive( String property, T component) {
		activeControls.put(property, component);
		return component;
	}
}
