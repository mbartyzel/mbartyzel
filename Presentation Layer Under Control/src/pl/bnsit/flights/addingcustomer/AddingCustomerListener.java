package pl.bnsit.flights.addingcustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingCustomerListener implements ActionListener {

	private AddingCustomerViewObserver viewObserver;

	public AddingCustomerListener(AddingCustomerViewObserver viewObserver) {
		this.viewObserver = viewObserver;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (the(actionEvent, isOf(AddingCustomerForm.ADD_CUSTOMER_CANCEL_BTN))) {
			viewObserver.cancelButtonClicked();
		}

		if (the(actionEvent, isOf(AddingCustomerForm.ADD_CUSTOMER_ADD_BTN))) {
			viewObserver.addButtonClicked();
		}
	}

	private String isOf(String str) {
		return str;
	}

	private boolean the(ActionEvent e, String actionCommand) {
		return e.getActionCommand().equals(actionCommand);
	}
}
