package pl.bnsit.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class FormSupport extends JPanel {

	private Map<String, JComponent> activeComponents = new HashMap<String, JComponent>();

	@PostConstruct
	protected void buildForm() {
		
	}
}
