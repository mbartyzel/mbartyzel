package pl.bnsit.onepieceflow.card;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.annotation.PostConstruct;
import javax.swing.JTextField;

import pl.bnsit.onepieceflow.DefaultGuiceModule;
import pl.bnsit.onepieceflow.RoundedPanel;

import com.google.inject.Inject;

public class CardForm extends RoundedPanel implements CardView {

	@Inject
	private CardViewObserver viewObserver;
	
	@Inject
	private CardFormEventHandler formListener;
	
	@PostConstruct
	public void buildForm() {
		add(new JTextField( "what to do?" ), BorderLayout.CENTER);
		
		setBackground(Color.YELLOW);
		
		Dimension dimension = new Dimension( 180, 120 );
		setMaximumSize( dimension );
		setMinimumSize(dimension);
		setPreferredSize(dimension);

		addMouseListener( formListener );
		addMouseMotionListener( formListener );
		
		viewObserver.ready();
	}
	
	@Override
	public void draggAndDropp(int x, int y) {
		setLocation(x, y);
	}

	public static void main(String[] args) {
		DefaultGuiceModule.runAndShowForm(CardForm.class);
	}

}
