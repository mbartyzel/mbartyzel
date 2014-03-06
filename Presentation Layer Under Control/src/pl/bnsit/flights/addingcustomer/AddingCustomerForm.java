package pl.bnsit.flights.addingcustomer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.bnsit.flights.DateConverter;
import pl.bnsit.flights.ObjectContainer;
import pl.bnsit.flights.TypeConverter;
import pl.bnsit.flights.ValueSetter;

public class AddingCustomerForm extends JFrame implements AddingCustomerView {

	private Map<String, JComponent> components = new HashMap<String, JComponent>();
	
	private Map<Class, TypeConverter> converters = new HashMap<Class, TypeConverter>();
	
	public static final String ADDRESS = "addCustomer.addressTf";

	public static final String DAYOFBIRTH = "addCustomer.dayOfBirthTf";

	public static final String LASTNAME = "addCustomer.lastnameTf";

	public static final String NAME = "addCustomer.nameTf";

	public static final String ADD_CUSTOMER_ADD_BTN = "addCustomer.addBtn";

	public static final String ADD_CUSTOMER_CANCEL_BTN = "addCustomer.cancelBtn";

	public void init() {
		setTitle("Dodaj klienta");
		add(new JPanel(), BorderLayout.NORTH);
		add(buildCenterPanel(), BorderLayout.CENTER);
		add(new JPanel(), BorderLayout.EAST);
		add(new JPanel(), BorderLayout.WEST);
		pack();

		centerJFrame();
		
		DateConverter dateConverter = new DateConverter();
		converters.put(dateConverter.type(), dateConverter);
	}

	private Component buildCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JPanel top = new JPanel();
		top.setLayout(new GridLayout(4, 2));
		top.add(new JLabel("Imiê:"));
		top.add(toMap(ObjectContainer.getInstance().createJTextField(
				AddingCustomerForm.NAME)));
		top.add(new JLabel("Nazwisko:"));
		top.add(toMap(ObjectContainer.getInstance().createJTextField(
				AddingCustomerForm.LASTNAME)));
		top.add(new JLabel("Data ur.:"));
		top.add(toMap(ObjectContainer.getInstance().createJTextField(
				AddingCustomerForm.DAYOFBIRTH)));
		top.add(new JLabel("Adres:"));
		top.add(toMap(ObjectContainer.getInstance().createJTextField(
				AddingCustomerForm.ADDRESS)));
		panel.add(top);

		Panel bottom = new Panel();
		bottom.add(ObjectContainer.getInstance().createAddingCustomerButton(
				"Dodaj", AddingCustomerForm.ADD_CUSTOMER_ADD_BTN));
		bottom.add(ObjectContainer.getInstance().createAddingCustomerButton(
				"Anuluj", AddingCustomerForm.ADD_CUSTOMER_CANCEL_BTN));
		panel.add(bottom);

		return panel;
	}

	@Override
	public void showView() {
		setVisible(true);
	}

	@Override
	public void hideView() {
		setVisible(false);
	}

	@Override
	public String getLastName() {
		return getJTextFieldValue(AddingCustomerForm.LASTNAME);
	}

	@Override
	public String getAddress() {
		return getJTextFieldValue(AddingCustomerForm.ADDRESS);
	}

	@Override
	public String getDayOfBirth() {
		return getJTextFieldValue(AddingCustomerForm.DAYOFBIRTH);
	}

	@Override
	public String getFirstName() {
		return getJTextFieldValue(AddingCustomerForm.NAME);
	}

	@Override
	public void showValidationFailedInfo() {
		JOptionPane.showMessageDialog( this, "Popraw dane klienta, pliz." );
	}
	
	private String getJTextFieldValue(String name) {

		if (components.containsKey(name)) {
			return ((JTextField)(components).get(name)).getText();
		}

		return null;
	}

	private JTextField toMap(JTextField textField) {
		components.put(textField.getName(), textField);
		return textField;
	}

	private void centerJFrame() {
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);

		setResizable(false);
	}

	@Override
	public void updateComponent(String id, Object value) {
		Object convertedValue = convert(value);
		JComponent component = components.get(id);
		ValueSetter.get(component.getClass()).set(component, convertedValue);
		
	}

	private Object convert(Object value) {
		Object converterValue = value;
		if( converters.containsKey(value.getClass()) ) {
			TypeConverter converter = converters.get(value.getClass());
			converterValue = converter.toString(value);
		}
		return converterValue;
	}
}
