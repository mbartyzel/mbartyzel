package pl.bnsit.architecture;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import pl.bnsit.flights.ValueSetter;

@SuppressWarnings( "serial" )
public class Form extends JPanel implements View {

	private ViewObserver viewObserver;
	
	private Map<String, JComponent> activeComponents = new HashMap<String, JComponent>();
	
	public void buildForm() {
		
		viewObserver.ready();
	}
	
	@Override
	public void updateControl(String componentId, Object value) {
		JComponent component = activeComponents.get(componentId);
		ValueSetter.get(component.getClass()).set(component, value);
	}

}
