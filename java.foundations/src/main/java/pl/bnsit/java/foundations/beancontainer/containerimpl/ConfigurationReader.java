package pl.bnsit.java.foundations.beancontainer.containerimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Set;

import com.thoughtworks.xstream.XStream;

public class ConfigurationReader {

	public static class BeanEntry implements Serializable {
		private static final long serialVersionUID = -6247527344582306724L;

		public String name;
		public String type;
		
		public BeanEntry(String name, String type) {
			this.name = name;
			this.type = type;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Set<BeanEntry> readFrom( File file ) {
		XStream stream = createXStream();
		Set<BeanEntry> beans = null;
		try {
			beans = (Set<BeanEntry>) stream.fromXML( new FileReader(file) );
		} catch (FileNotFoundException e) {
			throw new ConfigurationReaderException(
					"Cannot read configuration from " + file.getAbsolutePath(), e);
		}
		
		System.out.println( beans );
		
		return beans;
	}
	
	private XStream createXStream() {
		XStream stream = new XStream();
		stream.alias("beans", Set.class);
		stream.alias("bean", BeanEntry.class);
		stream.useAttributeFor(BeanEntry.class, "name");
		stream.useAttributeFor(BeanEntry.class, "type");
		
		return stream;
	}
}
