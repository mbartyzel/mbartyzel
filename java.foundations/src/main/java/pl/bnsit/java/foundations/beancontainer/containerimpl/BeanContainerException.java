package pl.bnsit.java.foundations.beancontainer.containerimpl;

public class BeanContainerException extends RuntimeException {

	public BeanContainerException() {
	}

	public BeanContainerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BeanContainerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanContainerException(String message) {
		super(message);
	}

	public BeanContainerException(Throwable cause) {
		super(cause);
	}
}
