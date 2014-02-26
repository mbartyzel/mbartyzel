package pl.bnsit.java.foundations.backup;

public class BackupperException extends RuntimeException {

	public BackupperException() {
		super();
	}

	public BackupperException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BackupperException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BackupperException(String arg0) {
		super(arg0);
	}

	public BackupperException(Throwable arg0) {
		super(arg0);
	}
}
