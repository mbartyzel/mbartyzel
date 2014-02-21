package pl.bnsit.flights.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.View;

import pl.bnsit.flights.EventService;
import pl.bnsit.flights.TerminationRequested;
import pl.bnsit.flights.addingcustomer.event.AddingCustomerFormRequested;

public class MainFormListener implements ActionListener {

	private MainViewObserver viewObserver;

	public MainFormListener(MainViewObserver viewObserver) {
		this.viewObserver = viewObserver;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (the(actionEvent, isOf(MainForm.MAIN_TERMINATE_BTN))) {
			viewObserver.terminateButtoClicked();
		}

		if (the(actionEvent, isOf(MainForm.MAIN_ADD_CUSTOMER_BTN))) {
			viewObserver.addCustomerButtonClicked();
		}
	}

	private String isOf(String str) {
		return str;
	}

	private boolean the(ActionEvent e, String actionCommand) {
		return e.getActionCommand().equals(actionCommand);
	}

}
