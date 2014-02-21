package pl.bnsit.flights;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import pl.bnsit.flights.addingcustomer.AddingCustomerForm;
import pl.bnsit.flights.addingcustomer.AddingCustomerListener;
import pl.bnsit.flights.addingcustomer.AddingCustomerPresenter;
import pl.bnsit.flights.main.MainForm;
import pl.bnsit.flights.main.MainFormListener;
import pl.bnsit.flights.main.MainPresenter;
import pl.bnsit.flights.model.Dao;
import pl.bnsit.flights.model.SerializationDao;


public class ObjectContainer {

	private static class ObjectFactoryHolder {
		private static ObjectContainer instance;
	}

	public static ObjectContainer getInstance() {
		if ( ObjectFactoryHolder. instance == null ) {
			ObjectFactoryHolder.instance = new ObjectContainer();
		}
		
		return ObjectFactoryHolder.instance;
	}
	
	private EventService eventPublisher = new EventService();
	private ApplicationTerminator applicationTerminator;
	private MainForm mainForm;
	private AddingCustomerForm addingCustomerForm;
	private MainPresenter mainPresenter;
	private MainFormListener mainFormListener;
	private AddingCustomerPresenter addingCustomerPresenter;
	private AddingCustomerListener addingCustomerFormListener;
	private Validator validator;
	private Dao dao;
	private FlightService flightService;
	
	public ObjectContainer() {
	}
	
	public JFrame initApplication() {
		validator = new Validator();

		dao = new SerializationDao();
		flightService = new FlightService(dao);
		
		mainForm = new MainForm();
		mainPresenter = new MainPresenter( mainForm, eventPublisher );
		mainFormListener = new MainFormListener(mainPresenter);
		eventPublisher.registerSubscriber(mainPresenter);
		mainForm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainForm.init();

		addingCustomerForm = new AddingCustomerForm();
		addingCustomerPresenter = new AddingCustomerPresenter( addingCustomerForm, eventPublisher );
		addingCustomerFormListener = new AddingCustomerListener( addingCustomerPresenter );
		addingCustomerPresenter.setFlightService(flightService);
		addingCustomerPresenter.setValidator(validator);
		eventPublisher.registerSubscriber( addingCustomerPresenter );
		addingCustomerForm.init();
		
		applicationTerminator = new ApplicationTerminator();
		eventPublisher.registerSubscriber(applicationTerminator);
		
		
		return mainForm;
	}
	
	public JButton createAddingCustomerButton( String caption, String actionCommand ) {
		JButton button = new JButton();
		button.setText(caption);
		button.setActionCommand( actionCommand );
		button.addActionListener( addingCustomerFormListener );
		
		return button;
	}
	
	public JButton createMainFormButton( String caption, String actionCommand ) {
		JButton button = new JButton();
		button.setText(caption);
		button.setActionCommand( actionCommand );
		button.addActionListener( mainFormListener );
		
		return button;
	}
	
	public JTextField createJTextField( String name ) {
		JTextField textField = new JTextField();
		textField.setName( name );
		
		return textField;
	}
}
