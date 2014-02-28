package pl.bnsit.java.foundations.swing.mvp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	private ViewObserver viewObserver;
	
	public Listener(ViewObserver presenter) {
		this.viewObserver = presenter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		viewObserver.okButtonClicked();
	}

}
