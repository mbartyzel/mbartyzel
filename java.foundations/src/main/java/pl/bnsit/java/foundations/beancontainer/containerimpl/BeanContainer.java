package pl.bnsit.java.foundations.beancontainer.containerimpl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pl.bnsit.java.foundations.NotImplementedYetException;
import pl.bnsit.java.foundations.beancontainer.containerimpl.ConfigurationReader.BeanEntry;

public class BeanContainer {

	private File cfgFile;
	
	private Set<ConfigurationReader.BeanEntry> definedBeans; 

	private Map<String, Object> instances;
	
	private ConfigurationReader configurationReader;
	
	private AnnotationProcessor annotationProcessor;
	
	public BeanContainer(String cfgFilename) {
		this.cfgFile = new File(cfgFilename);
		configurationReader = new ConfigurationReader();
		instances = new HashMap<>();
		annotationProcessor = new AnnotationProcessor();
	}
	
	public void readConfiguration() {
		definedBeans = configurationReader.readFrom(cfgFile);
	}
	
	public void initBeans() {
		for( BeanEntry beanEntry : definedBeans ) {
			Object beanInstance = null;
			try {
				Class<?> clazz = Class.forName( beanEntry.type );
				beanInstance = clazz.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new BeanContainerException( 
						"Cannot instantize bean of " + beanEntry.type, e );
			}
			
			instances.put(beanEntry.name, beanInstance);
		}
	}
	
	public void resolveAnnotations() {
		for (Object bean : instances.values()) {
			annotationProcessor.process(bean);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean( String name, Class<T> type ) {
		if ( ! instances.containsKey(name) ) {
			throw new BeanContainerException( "Bean '" + name + "' was not defined in the container." );
		}
		
		return (T) instances.get(name);
	}
}
