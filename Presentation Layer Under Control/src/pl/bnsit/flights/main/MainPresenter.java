package pl.bnsit.flights.main;

import pl.bnsit.flights.EventService;
import pl.bnsit.flights.TerminationRequested;
import pl.bnsit.flights.addingcustomer.event.AddingCustomerCancelled;
import pl.bnsit.flights.addingcustomer.event.AddingCustomerFormRequested;
import pl.bnsit.flights.addingcustomer.event.CustomerAdded;

import com.google.common.eventbus.Subscribe;

public class MainPresenter implements MainViewObserver {

	private MainView view;
	
	private EventService eventPublisher;
	
	public MainPresenter(MainView view, EventService eventPublisher) {
		this.view = view;
		this.eventPublisher = eventPublisher;
	}

	@Subscribe
	public void handle( AddingCustomerCancelled event ) {
		view.showView();
	}
	
	@Subscribe
	public void handle(CustomerAdded event) {
		view.showView();
	}
	
	@Override
	public void terminateButtoClicked() {
		view.hideView();
		eventPublisher.publish(new TerminationRequested());
	}

	@Override
	public void addCustomerButtonClicked() {
		view.hideView();
		eventPublisher.publish( new AddingCustomerFormRequested() );
	}
	
}
