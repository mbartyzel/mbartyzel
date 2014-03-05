package pl.bnsit.onepieceflow.lane;

import org.apache.commons.lang.RandomStringUtils;

import com.google.inject.Inject;

public class LanePresenter implements LaneViewObserver {

	@Inject
	private LaneView view;
	
	@Override
	public void ready() {
	}

	@Override
	public void addCardRequested() {
		view.addCard( RandomStringUtils.random(12) );
	}
}
