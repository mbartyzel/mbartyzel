package pl.bnsit.onepieceflow.card;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pl.bnsit.onepieceflow.DefaultGuiceModule;
import pl.bnsit.onepieceflow.RoundedPanel;
import pl.bnsit.util.ValueSetter;

import com.google.inject.Inject;

public class CardForm extends RoundedPanel implements CardView {

	@Inject
	private CardViewObserver viewObserver;
	
	@Inject
	private CardListener cardListener;
	
	private Map<String, JComponent> activeComponents = new HashMap<String, JComponent>();

	@PostConstruct
	public void buildForm() {
		add(new JTextField( "new item" ), BorderLayout.CENTER);
		
		setBackground(Color.YELLOW);
		
		Dimension dimension = new Dimension( 180, 120 );
		setMaximumSize( dimension );
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		
		addMouseListener( cardListener );
		addMouseMotionListener( cardListener );
		
		viewObserver.ready();
	}
	
	protected void updateComponent(String id, Object value) {
		JComponent component = activeComponents.get(id);
		ValueSetter valueSetter = ValueSetter.get( component.getClass() );
		valueSetter.set(component, value);
	}
	
	protected <T extends JComponent> T asActive( String property, T component) {
		activeComponents.put(property, component);
		return component;
	}
	
	public static void main(String[] args) {
		DefaultGuiceModule.runAndShowForm(CardForm.class);
	}

	@Override
	public void draggAndDropp(int x, int y) {
		setLocation(x, y);
	}
}
