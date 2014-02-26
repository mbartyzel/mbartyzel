package pl.bnsit.java.foundations.beancontainer.containerimpl;

public class AnnotationProcessorExeption extends RuntimeException {

	public AnnotationProcessorExeption() {
		super();
	}

	public AnnotationProcessorExeption(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AnnotationProcessorExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AnnotationProcessorExeption(String arg0) {
		super(arg0);
	}

	public AnnotationProcessorExeption(Throwable arg0) {
		super(arg0);
	}
}
