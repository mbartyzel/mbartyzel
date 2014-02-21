package pl.bnsit.flights.viewmodel;

import org.apache.commons.beanutils.DynaBean;

import pl.bnsit.flights.EventService;

public class Presenter implements ViewObserver {

	private EventService eventService;
	
	private DynaBean viewModel;
	
	@Override
	public void updateViewModel(String property, Object value) {
		viewModel.set(property, value);
	}
}
