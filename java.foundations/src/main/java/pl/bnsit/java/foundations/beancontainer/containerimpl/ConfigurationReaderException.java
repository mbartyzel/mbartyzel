package pl.bnsit.java.foundations.beancontainer.containerimpl;

public class ConfigurationReaderException extends RuntimeException {

	public ConfigurationReaderException() {
		super();
	}

	public ConfigurationReaderException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ConfigurationReaderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ConfigurationReaderException(String arg0) {
		super(arg0);
	}

	public ConfigurationReaderException(Throwable arg0) {
		super(arg0);
	}
}
