package pl.bnsit.java.foundations.beancontainer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import pl.bnsit.java.foundations.beancontainer.containerimpl.BeanContainer;
import pl.bnsit.java.foundations.beancontainer.containerimpl.ConfigurationReader.BeanEntry;

import com.thoughtworks.xstream.XStream;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		
		final String FILENAME = "src/main/java/pl/bnsit/java/foundations/beancontainer/config.xml";
		
		BeanContainer container = new BeanContainer(FILENAME);
		container.readConfiguration();
		container.initBeans();
		container.resolveAnnotations();
		
		ShopService service = container.getBean("myShopService", ShopService.class);
		service.businessMethod();
	}
	
	public static void createSampleConfig() throws IOException {
		Set<BeanEntry> beans = new HashSet<>();
		beans.add(new BeanEntry("myShopService", "pl.bnsit.java.foundations.beancontainer.ShopService"));
		beans.add(new BeanEntry("secondShopService", "pl.bnsit.java.foundations.beancontainer.ShopService"));
		beans.add(new BeanEntry("myUserDao", "pl.bnsit.java.foundations.beancontainer.UserDao"));
		
		XStream stream = new XStream();
		stream.alias("beans", Set.class);
		stream.alias("bean", BeanEntry.class);
		stream.useAttributeFor(BeanEntry.class, "name");
		stream.useAttributeFor(BeanEntry.class, "type");
		
		stream.toXML(beans, new FileWriter("config.xml") );
	}
}
