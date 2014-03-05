package pl.bnsit.onepieceflow.lane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import pl.bnsit.onepieceflow.DefaultGuiceModule;
import pl.bnsit.onepieceflow.card.CardForm;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class LaneForm extends JPanel implements LaneView {

	@Inject
	private LaneViewObserver viewObserver;
	
	@Inject
	private LaneFormEventHander formListener;
	
	@Inject
	private Provider<CardForm> cardFormInstanceProvide;
	
	private Map<String, JComponent> activeComponents = new HashMap<String, JComponent>();
	
	private JPanel cardPanel;

	@PostConstruct
	public void buildForm() {
		
		Dimension dimension = new Dimension( 220, 500 );
		setMaximumSize( dimension );
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		
		JButton addCardButton = new JButton("Add card");
		addCardButton.addActionListener(formListener);
		setLayout( new BorderLayout() );
		add( addCardButton, BorderLayout.NORTH );
		
		cardPanel = createCardPanel();
		add( cardPanel, BorderLayout.CENTER );
		
		viewObserver.ready();
	}
	
	private JPanel createCardPanel() {
		GridLayout gridLayout = new GridLayout(5, 1);

		JPanel panel = new JPanel();
		panel.setLayout(gridLayout);
		panel.setBorder( BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK) );
		
		return panel;
	}

	@Override
	public void addCard( String id ) {
		cardPanel.add( asActive(id, cardFormInstanceProvide.get() ) );
		cardPanel.revalidate();
	}
	
	protected <T extends JComponent> T asActive( String property, T component) {
		activeComponents.put(property, component);
		return component;
	}

	public static void main(String[] args) {
		DefaultGuiceModule.runAndShowForm(LaneForm.class);
	}
}
