package pl.bnsit.onepieceflow.board;

import com.google.inject.Inject;


public class BoardPresenter implements BoardViewObserver {

	@Inject
	private BoardView view;

	@Override
	public void ready() {
		
	}
}
