package pl.bnsit.flights.viewmodel;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import pl.bnsit.util.ValueSetter;

@SuppressWarnings( "serial" )
public class Form extends JPanel implements View {

	private ViewObserver viewObserver;
	
	private Map<String, JComponent> activeComponents = new HashMap<String, JComponent>();
	
	@Override
	public void updateComponent(String componentId, Object value) {
		JComponent component = activeComponents.get(componentId);
		ValueSetter.get(component.getClass()).set(component, value);
	}

}
