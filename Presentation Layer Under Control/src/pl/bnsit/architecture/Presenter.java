package pl.bnsit.architecture;

import org.apache.commons.beanutils.DynaBean;

import pl.bnsit.flights.EventService;

public class Presenter implements ViewObserver {

	private EventService eventService;
	
	private DynaBean viewModel;
	

	@Override
	public void ready() {
		
	}
}
