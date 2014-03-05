package pl.bnsit.onepieceflow.lane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.inject.Inject;

public class LaneFormEventHander implements ActionListener {

	@Inject
	private LaneViewObserver viewObserver;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		viewObserver.addCardRequested();
	}
}
