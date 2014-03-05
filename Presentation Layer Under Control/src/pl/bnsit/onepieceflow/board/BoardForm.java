package pl.bnsit.onepieceflow.board;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import pl.bnsit.onepieceflow.DefaultGuiceModule;
import pl.bnsit.onepieceflow.lane.LaneForm;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class BoardForm extends JPanel implements BoardView {

	@Inject
	private BoardViewObserver viewObserver;
	
	@Inject
	private Provider<LaneForm> laneFormInstanceProvider;
	
	@PostConstruct
	public void buildForm() {
		setLayout( new BoxLayout( this, BoxLayout.X_AXIS) );
		add( laneFormInstanceProvider.get() );
		add( laneFormInstanceProvider.get() );
		add( laneFormInstanceProvider.get() );
		
		viewObserver.ready();
	}
	
	public static void main(String[] args) {
		DefaultGuiceModule.runAndShowForm( BoardForm.class );
	}
}
