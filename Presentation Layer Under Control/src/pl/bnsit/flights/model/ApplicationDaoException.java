package pl.bnsit.flights.model;

public class ApplicationDaoException extends RuntimeException {

	public ApplicationDaoException() {
		super();
	}

	public ApplicationDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ApplicationDaoException(String arg0) {
		super(arg0);
	}

	public ApplicationDaoException(Throwable arg0) {
		super(arg0);
	}

}
