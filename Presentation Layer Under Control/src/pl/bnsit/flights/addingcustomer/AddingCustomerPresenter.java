package pl.bnsit.flights.addingcustomer;
import static pl.bnsit.flights.addingcustomer.AddingCustomerForm.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;

import pl.bnsit.flights.EventService;
import pl.bnsit.flights.FlightService;
import pl.bnsit.flights.Validator;
import pl.bnsit.flights.addingcustomer.event.AddingCustomerCancelled;
import pl.bnsit.flights.addingcustomer.event.AddingCustomerFormRequested;
import pl.bnsit.flights.addingcustomer.event.CustomerAdded;

import com.google.common.eventbus.Subscribe;

public class AddingCustomerPresenter implements AddingCustomerViewObserver {

	private AddingCustomerView view;
	
	private DynaBean viewModel;

	private Validator validator;

	private FlightService flightService;
	
	private EventService eventPublisher;

	public AddingCustomerPresenter(AddingCustomerView view,
			EventService eventPublisher) {
		this.view = view;
		this.eventPublisher = eventPublisher;
		
		viewModel = new LazyDynaBean();
		viewModel.set( NAME, "" );
		viewModel.set( LASTNAME, "" );
		viewModel.set( DAYOFBIRTH, new Date());
		viewModel.set( ADDRESS, "" );
	}

	public void updateComponents() {
		view.updateComponent( NAME, viewModel.get(NAME) );
		view.updateComponent( LASTNAME, viewModel.get(LASTNAME) );
		view.updateComponent( DAYOFBIRTH, viewModel.get(DAYOFBIRTH) );
		view.updateComponent( ADDRESS, viewModel.get(ADDRESS) );
	}
	
	@Subscribe
	public void handle(AddingCustomerFormRequested event) {
		view.showView();
		updateComponents();
	}

	@Override
	public void cancelButtonClicked() {
		view.hideView();
		eventPublisher.publish(new AddingCustomerCancelled());
	}

	@Override
	public void addButtonClicked() {
		String name = view.getFirstName();
		String lastName = view.getLastName();
		String address = view.getAddress();
		String dayOfBirth = view.getDayOfBirth();

		AddingCustomerData addingCustomerData = new AddingCustomerData(name,
				lastName, address, dayOfBirth);

		if (!validator.isValid(addingCustomerData)) {
			view.showValidationFailedInfo();
			//AddingCustomerValidationFailed might be published also		
		} else {

			flightService.saveCustomer(name, lastName, address, parseDate(dayOfBirth));
			view.hideView();
			eventPublisher.publish(new CustomerAdded());
		}
	}

	@Override
	public void updateViewModel(String property, Object value) {
		viewModel.set(property, value);
	}
	
	private Date parseDate(String dateStr) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			dateFormat.parse(dateStr);
		} catch (ParseException ex) {
			throw new IllegalArgumentException( "Cannot parse data : " + dateStr, ex );
		}

		return date;
	}
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
}
