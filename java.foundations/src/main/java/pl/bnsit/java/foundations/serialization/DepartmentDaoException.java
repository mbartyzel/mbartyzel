package pl.bnsit.java.foundations.serialization;

public class DepartmentDaoException extends RuntimeException {

	public DepartmentDaoException() {
		super();
	}

	public DepartmentDaoException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DepartmentDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DepartmentDaoException(String arg0) {
		super(arg0);
	}

	public DepartmentDaoException(Throwable arg0) {
		super(arg0);
	}
}
